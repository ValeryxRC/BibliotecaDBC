/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

import Exceptions.AutorException;
import Exceptions.DAO_Excep;
import Model.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author st2022270
 */
public interface IAutorController {
    public abstract  List<Autor> readAllAutors() throws DAO_Excep, AutorException;
    public abstract Autor readAutor( String credencial) throws DAO_Excep, AutorException;
    public abstract void insertAutors(Autor au) throws DAO_Excep, AutorException;
    public abstract void updateAutors(Autor auAnt, Autor auAct) throws DAO_Excep, AutorException;
    public abstract void deleteAutors(Autor au) throws DAO_Excep, AutorException;
}
