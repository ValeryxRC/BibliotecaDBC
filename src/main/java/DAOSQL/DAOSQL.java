package DAOSQL;

import Exceptions.DAO_Excep;
import Model.Autor;
import Model.Libro;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author st2022270
 */
public class DAOSQL implements IDAO {

    //Variables para la conexión segura contra el servidor (sin especificar DDBB)
    private final String JDBC_URL = "jdbc:mysql://localhost:3305";
    private final String JDBC_COMMU_OPT = "?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private final String JDBC_USER = "root";
    private final String JDBC_PASSWORD = "";

    //Especificamos la base de Datos
    private final String JDBC_DDBB = "biblioteca";
    private final String JDBC_TABLE1 = "autores";
    private final String JDBC_TABLE2 = "libros";
    private final String JDBC_DDBB_TABLE1 = JDBC_DDBB + "." + JDBC_TABLE1;
    private final String JDBC_DDBB_TABLE2 = JDBC_DDBB + "." + JDBC_TABLE2;

    /*Variables de Consultas:*/
//Select All:
    private final String SQL_SELECT_ALL_Autores = "SELECT * FROM " + JDBC_DDBB_TABLE1 + ";";
    private final String SQL_SELECT_ALL_Libros = "SELECT * FROM " + JDBC_DDBB_TABLE2 + ";";

//SELECT LIBRO por PARAMETRO 
    private final String SQL_SELECT_LIBRO = "SELECT * FROM " + JDBC_DDBB_TABLE2 + " WHERE (isbn = ?);";
    private final String SQL_SELECT_LIBRO_by_AUTOR = "SELECT * FROM " + JDBC_DDBB_TABLE2 + " WHERE (idAutor = ?);";
    private final String SQL_SELECT_LIBRO_by_GENERO = "SELECT * FROM " + JDBC_DDBB_TABLE2 + " WHERE (genero = ?);";
    private final String SQL_SELECT_LIBRO_by_AUTOR_and_GENERO = "SELECT * FROM " + JDBC_DDBB_TABLE2 + " WHERE (idAutor = ? AND genero = ? );";

//SELECT ID AUTOR BY NAME COMPLETE
    private final String SQL_SELECT_ID_AUTOR = "SELECT * FROM " + JDBC_DDBB_TABLE1 + " WHERE (nombre = ? AND ape1 = ? AND ape2 = ?)";
// SELECT AUTOR BY ID
    private final String SQL_SELECT_AUTOR = "SELECT * FROM " + JDBC_DDBB_TABLE1 + " WHERE(id = ?);";
//INSERT
    private final String SQL_INSERT_AUTOR = "INSERT INTO " + JDBC_DDBB_TABLE1 + " (nombre, ape1, ape2, lugarNac) VALUES (?, ?, ?, ?);";
    private final String SQL_INSERT_LIBRO = "INSERT INTO " + JDBC_DDBB_TABLE2 + " (isbn, titulo, idAutor, genero, descript) VALUES (?, ?, ?, ?, ?);";

//UPDATE
    /*-----Autor-------*/
    private final String SQL_UPDATE_AUTOR = "UPDATE " + JDBC_DDBB_TABLE1 + " SET nombre = ? , ape1 = ? , ape2= ? , lugarNac = ? WHERE (id = ?); ";
    private final String SQL_UPDATE_AUTOR_lugar = "UPDATE " + JDBC_DDBB_TABLE1 + " SET lugarNac = ? WHERE (id = ?); ";
    /*-----Libro-------*/
    private final String SQL_UPDATE_LIBRO = "UPDATE " + JDBC_DDBB_TABLE2 + " SET titulo = ? , idAutor= ? , genero = ? , descript = ? WHERE (isbn = ?); ";

//DELETE
    /*-----AUTOR------*/
    private final String SQL_DELETE_AUTOR = "DELETE FROM " + JDBC_DDBB_TABLE1 + " WHERE (id = ?)";
    /*-----LIBRO------*/
    private final String SQL_DELETE_LIBRO = "DELETE FROM " + JDBC_DDBB_TABLE2 + " WHERE (isbn = ?)";

    private void createDB(Connection conn) throws SQLException {
        //Sentencia SQL que crea la BBDD si no existe en el servidor
        String instruction = "create database if not exists " + JDBC_DDBB + ";";
        Statement stmt = null;
        stmt = conn.createStatement();
        //La clase Statemen nos permite ejecutar sentencias SQL
        stmt.executeUpdate(instruction);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTable1(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE1 + "("
                + "id int primary key auto_increment, "
                + "nombre varchar(50), "
                + "ape1 varchar(50),"
                + "ape2 varchar(50),"
                + "lugarNac varchar(50)) ENGINE = InnoDB;";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    private void createTable2(Connection conn) throws SQLException {
        String query = "create table if not exists " + JDBC_DDBB + "." + JDBC_TABLE2 + "("
                + "isbn int primary key, "
                + "titulo varchar(50), "
                + "idAutor int ,"
                + "genero varchar(50),"
                + "descript varchar(1000),"
                + "CONSTRAINT FK_Hacia_Autores FOREIGN KEY (idAutor) REFERENCES " + JDBC_DDBB + "."+JDBC_TABLE1 + "(id) ON DELETE CASCADE) ENGINE = InnoDB;";
        Statement stmt = null;
        stmt = conn.createStatement();
        stmt.executeUpdate(query);
        //Liberamos los recursos de la comunicación   
        stmt.close();
    }

    public Connection connect() throws DAO_Excep {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_URL + JDBC_COMMU_OPT, JDBC_USER, JDBC_PASSWORD);
            createDB(conn);
            createTable1(conn);
            createTable2(conn);
        } catch (SQLException ex) {
            System.out.println("Error");
            ex.printStackTrace();
            throw new DAO_Excep("Can not connect or create database with tables: " + JDBC_DDBB);
        }
        return conn;
    }

    public void disconnect(Connection conn) throws SQLException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new SQLException("No se puede desconectar con la base de Datos" + JDBC_DDBB);
            }
        }
    }

    /*METODOS */
    @Override
    public List<Libro> readALL_Libro() throws DAO_Excep {
        List<Libro> libs = new ArrayList<>();
        Connection conn = null;
        Statement instruction = null;
        ResultSet rs = null;
        PreparedStatement instructionAu = null;
        ResultSet rsAu = null;
        try {
            conn = connect();
            instruction = conn.createStatement();
            rs = instruction.executeQuery(SQL_SELECT_ALL_Libros);
            while (rs.next()) {
                int isbn = rs.getInt("isbn");
                String titulo = rs.getString("titulo");
                String descript = rs.getString("descript");
                String genero = rs.getString("genero");
                int id_autor = rs.getInt("idAutor");
                //------SUBCONSULTA PARA OBTENER AUTOR------//
                instructionAu = conn.prepareStatement(SQL_SELECT_AUTOR);
                instructionAu.setInt(1, id_autor);
                rsAu = instructionAu.executeQuery();
                if (rsAu.next()) {
                    String nombre = rsAu.getString("nombre");
                    String ape1 = rsAu.getString("ape1");
                    String ape2 = rsAu.getString("ape2");
                    /*INSERCION A LA LISTA*/
                    Autor au = new Autor(nombre, ape1, ape2);
                    libs.add(new Libro(titulo, isbn, au, descript, genero));
                    instructionAu.close();
                    rsAu.close();
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new DAO_Excep("error de lectura");
        } finally {
            try {
                rs.close();
                instruction.close();
                disconnect(conn);
            } catch (SQLException e) {
                throw new DAO_Excep("Error de cierre de Base de Datos");
            }
        }
        return libs;
    }

    @Override
    public List<Autor> readALL_Autor() throws DAO_Excep {
        List<Autor> aus = new ArrayList<>();
        Connection conn = null;
        Statement instruction = null;
        ResultSet rs = null;
        try {
            conn = connect();
            instruction = conn.createStatement();
            rs = instruction.executeQuery(SQL_SELECT_ALL_Autores);
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String ape1 = rs.getString("ape1");
                String ape2 = rs.getString("ape2");
                String lugarNac = rs.getString("lugarNac");

                aus.add(new Autor(nombre, ape1, ape2, lugarNac));
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("error de lectura");
        } finally {
            try {
                rs.close();
                instruction.close();
                disconnect(conn);
            } catch (SQLException e) {
                throw new DAO_Excep("Error de cierre de Base de Datos");
            }
        }
        return aus;
    }

    @Override
    public List<Libro> read_Libro_by_Autor(Autor au) throws DAO_Excep {
        List<Libro> libs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        PreparedStatement instructionAu = null;
        ResultSet rsAu = null;
        try {
            conn = connect();
            instructionAu = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            instructionAu.setString(1, au.getNombre());
            instructionAu.setString(2, au.getApe1());
            instructionAu.setString(3, au.getApe2());
            rsAu = instructionAu.executeQuery();
            if (rsAu.next()) {
                int id = rsAu.getInt("id");
                instruction = conn.prepareStatement(SQL_SELECT_LIBRO_by_AUTOR);
                instruction.setInt(1, id);
                rs = instruction.executeQuery();
                while (rs.next()) {
                    int isbn = rs.getInt("isbn");
                    String titulo = rs.getString("titulo");
                    String descript = rs.getString("descript");
                    String genero = rs.getString("genero");
                    /*INSERCION A LA LISTA*/
                    libs.add(new Libro(titulo, isbn, au, descript, genero));
                }
                rs.close();
                instruction.close();
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("error de lectura");
        } finally {
            try {
                rsAu.close();
                instructionAu.close();
                disconnect(conn);
            } catch (SQLException e) {
                throw new DAO_Excep("Error de cierre de Base de Datos");
            }
        }
        return libs;
    }
    
    @Override
    public List<Libro> read_Libro_by_Autor_Genero(Autor au, String genero) throws DAO_Excep {
                List<Libro> libs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet rs = null;
        PreparedStatement instructionAu = null;
        ResultSet rsAu = null;
        try {
            conn = connect();
            instructionAu = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            instructionAu.setString(1, au.getNombre());
            instructionAu.setString(2, au.getApe1());
            instructionAu.setString(3, au.getApe2());
            rsAu = instructionAu.executeQuery();
            if (rsAu.next()) {
                int id = rsAu.getInt("id");
                instruction = conn.prepareStatement(SQL_SELECT_LIBRO_by_AUTOR_and_GENERO);
                instruction.setInt(1, id);
                instruction.setString(2, genero);
                rs = instruction.executeQuery();
                while (rs.next()) {
                    int isbn = rs.getInt("isbn");
                    String titulo = rs.getString("titulo");
                    String descript = rs.getString("descript");
                    String generoL = rs.getString("genero");
                    /*INSERCION A LA LISTA*/
                    libs.add(new Libro(titulo, isbn, au, descript, generoL));
                }
                rs.close();
                instruction.close();
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("error de lectura");
        } finally {
            try {
                rsAu.close();
                instructionAu.close();
                disconnect(conn);
            } catch (SQLException e) {
                throw new DAO_Excep("Error de cierre de Base de Datos");
            }
        }
        return libs;
    }

    @Override
    public int insert_Libro(Libro lib) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        PreparedStatement instruc2 = null;
        ResultSet resp = null;
        int id = 0;
        int registeres = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_LIBRO);
            //(isbn, titulo, idAutor, genero, descript) VALUES (?, ?, ?, ?, ?);";
            instruction.setInt(1, lib.getIsbn());
            instruction.setString(2, lib.getTitulo());
            //ID AUTOR
            instruc2 = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            instruc2.setString(1, lib.getAutor().getNombre());
            instruc2.setString(2, lib.getAutor().getApe1());
            instruc2.setString(3, lib.getAutor().getApe2());
            resp = instruc2.executeQuery();
            while (resp.next()) {
                id = resp.getInt("id");
            }
            instruction.setInt(3, id);
            instruction.setString(4, lib.getGenero());
            instruction.setString(5, lib.getDescript());
            registeres = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Error, no se a podido insertar los datos correctamente");
        } finally {
            try {
                instruction.close();
                instruc2.close();
                disconnect(conn);
            } catch (SQLException er) {
                throw new DAO_Excep("Error de cierre de base de datos");
            }
        }
        return registeres;
    }

    @Override
    public int insert_Autor(Autor au) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registeres = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_INSERT_AUTOR);
            /* " (nombre, ape1, ape2, lugarNac) VALUES (?, ?, ?);";*/
            instruction.setString(1, au.getNombre());
            instruction.setString(2, au.getApe1());
            instruction.setString(3, au.getApe2());
            instruction.setString(4, au.getLugarNac());
            registeres = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Error, no se a podido insertar los datos correctamente");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException er) {
                throw new DAO_Excep("Error de cierre de base de datos");
            }
        }
        return registeres;
    }

    @Override
    public int update_Libro(Libro lib) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruc = null;
        PreparedStatement instruc2 = null;
        ResultSet resp = null;
        int id = 0;
        int registers = 0;
        try {
            conn = connect();
            instruc = conn.prepareStatement(SQL_UPDATE_LIBRO);
            instruc2 = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            /*OBTENER ID Autor anterior*/
            instruc2.setString(1, lib.getAutor().getNombre());
            instruc2.setString(2, lib.getAutor().getApe1());
            instruc2.setString(3, lib.getAutor().getApe2());
            resp = instruc2.executeQuery();
            while (resp.next()) {
                id = resp.getInt("id");
            }
            /*titulo autor genero descripcion*/
            instruc.setString(1, lib.getTitulo());
            instruc.setInt(2, id);
            instruc.setString(3, lib.getGenero());
            instruc.setString(4, lib.getDescript());
            instruc.setInt(5, lib.getIsbn());
            registers = instruc.executeUpdate();
        } catch (SQLException e) {
            throw new DAO_Excep("Nose pude actualizar fallo en el DAOSQL controller " + e.getMessage());
        } finally {
            try {
                instruc.close();
                instruc2.close();
                disconnect(conn);
            } catch (SQLException er) {
                throw new DAO_Excep("Error de cierre de base de datos");
            }
        }
        return registers;
    }

    @Override
    public int update_Autor(Autor auAnt, Autor auAct) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruc = null;
        PreparedStatement instruc2 = null;
        PreparedStatement instruction = null;
        ResultSet resp = null;
        int id = 0;
        int registers = 0;
        try {
            conn = connect();
            instruc = conn.prepareStatement(SQL_UPDATE_AUTOR);
            instruc2 = conn.prepareStatement(SQL_UPDATE_AUTOR_lugar);
            /*OBTENER ID Autor anterior*/
            instruction = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            instruction.setString(1, auAnt.getNombre());
            instruction.setString(2, auAnt.getApe1());
            instruction.setString(3, auAnt.getApe2());
            resp = instruction.executeQuery();
            while (resp.next()) {
                id = resp.getInt("id");
            }

            if (auAnt.equals(auAct)) {
                instruc2.setString(1, auAct.getLugarNac());
                instruc2.setInt(2, id);
                registers = instruc2.executeUpdate();
            } else {
                if (readAutor(auAct).isEmpty()) {
                    instruc.setString(1, auAct.getNombre());
                    instruc.setString(2, auAct.getApe1());
                    instruc.setString(3, auAct.getApe2());
                    instruc.setString(4, auAct.getLugarNac());
                    instruc.setInt(5, id);
                    registers = instruc.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new DAO_Excep("Nose pude actualizar fallo en el DAOSQL controller " + e.getMessage());
        } finally {
            try {
                instruction.close();
                instruc.close();
                instruc2.close();
                disconnect(conn);
            } catch (SQLException er) {
                throw new DAO_Excep("Error de cierre de base de datos");
            }
        }
        return registers;
    }

    @Override
    public int delete_Autor(Autor au) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        PreparedStatement instruction2 = null;
        ResultSet resp = null;
        int id = 0;
        int registeres = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_DELETE_AUTOR);
            /*OBTENER ID Autor anterior*/
            instruction2 = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            instruction2.setString(1, au.getNombre());
            instruction2.setString(2, au.getApe1());
            instruction2.setString(3, au.getApe2());
            resp = instruction2.executeQuery();
            while (resp.next()) {
                id = resp.getInt("id");
            }
            instruction.setInt(1, id);
            registeres = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Error, no se a podido eliminar los datos correctamente");
        } finally {
            try {
                instruction.close();
                instruction2.close();
                disconnect(conn);
            } catch (SQLException er) {
                throw new DAO_Excep("Error de cierre de base de datos");
            }
        }
        return registeres;
    }

    @Override
    public int delete_Libro(Libro lib) throws DAO_Excep {
        Connection conn = null;
        PreparedStatement instruction = null;
        int registeres = 0;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_DELETE_LIBRO);
            instruction.setInt(1, lib.getIsbn());
            registeres = instruction.executeUpdate();
        } catch (SQLException ex) {
            throw new DAO_Excep("Error, no se a podido eliminar los datos correctamente");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException er) {
                throw new DAO_Excep("Error de cierre de base de datos");
            }
        }
        return registeres;
    }

    @Override
    public List<Libro> readLibro(Libro lib) throws DAO_Excep {
        ArrayList<Libro> libs = new ArrayList<>();
        Connection conn = null;
        PreparedStatement instruction = null;
        PreparedStatement idAuInstruc = null;
        ResultSet resp = null;
        ResultSet respAu = null;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_LIBRO);
            idAuInstruc = conn.prepareStatement(SQL_SELECT_AUTOR);
            instruction.setInt(1, lib.getIsbn());
            resp = instruction.executeQuery();
            while (resp.next()) {
                /*String titulo, int isbn, Autor autor, String descript, String genero*/
                String titulo = resp.getString("titulo");
                int isbn = resp.getInt("isbn");
                /*BUSCAR AUTOR*/
                idAuInstruc.setInt(1, resp.getInt("idAutor"));
                respAu = idAuInstruc.executeQuery();
                Autor au = null;
                while (respAu.next()) {
                    String nombre = respAu.getString("nombre");
                    String ape1 = respAu.getString("ape1");
                    String ape2 = respAu.getString("ape2");
                    au = new Autor(nombre, ape1, ape2);
                }
                String descript = resp.getString("descript");
                String genero = resp.getString("genero");
                libs.add(new Libro(titulo, isbn, au, descript, genero));
               idAuInstruc.close();
               respAu.close();
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Error de lectura en la base de datos");
        } finally {
            try {
                instruction.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Error de cierre conecion con la base de datos");
            }
        }
        return libs;
    }

    @Override
    public List<Autor> readAutor(Autor au) throws DAO_Excep {
        ArrayList<Autor> aus = new ArrayList<>();
        Autor autor = null;
        Connection conn = null;
        PreparedStatement instruction = null;
        ResultSet resp = null;
        try {
            conn = connect();
            instruction = conn.prepareStatement(SQL_SELECT_ID_AUTOR);
            instruction.setString(1, au.getNombre());
            instruction.setString(2, au.getApe1());
            instruction.setString(3, au.getApe2());
            resp = instruction.executeQuery();
            while (resp.next()) {
                String nombre = resp.getString("nombre");
                String ape1 = resp.getString("ape1");
                String ape2 = resp.getString("ape2");
                String lugarNac = resp.getString("lugarNac");
                autor = new Autor(nombre, ape1, ape2, lugarNac);
                aus.add(autor);
            }
        } catch (SQLException ex) {
            throw new DAO_Excep("Error de lectura en la base de datos");
        } finally {
            try {
                instruction.close();
                resp.close();
                disconnect(conn);
            } catch (SQLException ex) {
                throw new DAO_Excep("Error de cierre conecion con la base de datos");
            }
        }
        return aus;
    }
}
