/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import Exceptions.DAO_Excep;
import Exceptions.LibroException;
import Model.Autor;
import Model.Libro;
import java.util.List;

/**
 *
 * @author st2022270
 */
public interface ILibroController {
    public abstract List<Libro> readAllLibro() throws DAO_Excep, LibroException;
    public abstract Libro readLibro(int isbn)  throws DAO_Excep, LibroException;
    public abstract List<Libro> readLibroFiltro(Autor au, String genero) throws DAO_Excep, LibroException;
    public abstract void insertLibros(Libro lib)  throws DAO_Excep, LibroException;
    public abstract void updateLibros(Libro lib)  throws DAO_Excep, LibroException;
    public abstract void deleteLibros(Libro lib)  throws DAO_Excep, LibroException;
//    public abstract void deleteAllLibros();
}
