package Controller;

import DAOSQL.DAOSQL;
import DAOSQL.IDAO;
import Exceptions.DAO_Excep;
import Exceptions.LibroException;
import Model.Autor;
import Model.Libro;
import java.util.List;

/**
 *
 * @author valer
 */
public class LibroController implements ILibroController {
    
    private IDAO dao;
    
    @Override
    public List<Libro> readAllLibro() throws DAO_Excep, LibroException {
        dao = new DAOSQL();
        List<Libro> libs = dao.readALL_Libro();
        return libs;
    }

    @Override
    public Libro readLibro(int isbn) throws DAO_Excep, LibroException {
        dao = new DAOSQL();
        Libro lib = new Libro(isbn);
        Libro lib2 = null;
        if (!dao.readLibro(lib).isEmpty()) {
            lib2 = dao.readLibro(lib).get(0);
        }
        return lib2;
    }

    @Override
    public void insertLibros(Libro lib) throws DAO_Excep, LibroException {
        dao = new DAOSQL();
        if (dao.readLibro(lib).isEmpty()) {
            int registeredLibro = dao.insert_Libro(lib);
        } else {
            throw new LibroException("El Libro con ese isbn ya esta registrado en la base de datos");
        }
    }

    @Override
    public void updateLibros(Libro lib) throws DAO_Excep, LibroException {
       dao = new DAOSQL();
       if(dao.update_Libro(lib) == 0){
            throw new LibroException("Error de actualizacion del libro");
        }
    }

    @Override
    public void deleteLibros(Libro lib) throws DAO_Excep, LibroException {
        dao = new DAOSQL();
        if(dao.delete_Libro(lib) == 0){
             throw new LibroException("Error de eliminacion del libro");
        }
    }

    @Override
    public List<Libro> readLibroFiltro(Autor au, String genero) throws DAO_Excep, LibroException {
        dao = new DAOSQL();
        List<Libro> libs = null;
       if(genero .equals("Todos los Generos")){
           libs = dao.read_Libro_by_Autor(au);
       }else {
           libs = dao.read_Libro_by_Autor_Genero(au, genero);
       }
       return libs;
    }
    
}
