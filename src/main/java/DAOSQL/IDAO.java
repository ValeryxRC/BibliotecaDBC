package DAOSQL;

import Exceptions.DAO_Excep;
import Model.Autor;
import Model.Libro;
import java.util.List;

public interface IDAO {
    
    public abstract List<Libro> readALL_Libro() throws DAO_Excep;
    
    public abstract List<Libro> readLibro (Libro lib) throws DAO_Excep;
    
    public abstract List<Autor> readALL_Autor() throws DAO_Excep;
    
    public abstract List<Autor> readAutor (Autor aut)throws DAO_Excep;
    
    public abstract List<Libro> read_Libro_by_Autor(Autor au) throws DAO_Excep;
    
    public abstract List<Libro> read_Libro_by_Autor_Genero(Autor au, String genero) throws DAO_Excep;
    
    public abstract int insert_Libro(Libro lib) throws DAO_Excep;
    
    public abstract int insert_Autor(Autor au) throws DAO_Excep;
    
    public abstract int update_Libro(Libro lib) throws DAO_Excep;
    
    public abstract int update_Autor(Autor auAnt, Autor auAct) throws DAO_Excep;
    
    public abstract int delete_Autor(Autor au) throws DAO_Excep;
    
    public abstract  int delete_Libro(Libro lib) throws DAO_Excep;
    
    
}
