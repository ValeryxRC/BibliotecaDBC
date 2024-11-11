/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAOSQL.DAOSQL;
import DAOSQL.IDAO;
import Exceptions.AutorException;
import Exceptions.DAO_Excep;
import Model.Autor;
import java.util.ArrayList;
import java.util.List;

public class AutorController implements IAutorController {

    private IDAO dao;

    @Override
    public List<Autor> readAllAutors() throws DAO_Excep, AutorException {
        dao = new DAOSQL();
        List<Autor> aus = dao.readALL_Autor();
        return aus;
    }

    @Override
    public Autor readAutor(String credencial) throws DAO_Excep, AutorException {
        dao = new DAOSQL();
        String[] ident = credencial.split(" ");
        Autor a = new Autor(ident[0], ident[1], ident[2]);
        Autor au = null;
        if (!dao.readAutor(a).isEmpty()) {
            au = dao.readAutor(a).get(0);
        }
        return au;
    }

    @Override
    public void insertAutors(Autor au) throws DAO_Excep, AutorException {
        dao = new DAOSQL();
        if (dao.readAutor(au).isEmpty()) {
            int registeredAutors = dao.insert_Autor(au);
        } else {
            throw new AutorException("El autor con ese nombre, ya esta registrado en la base de datos");
        }

    }

    @Override
    public void updateAutors(Autor auAnt, Autor auAct) throws DAO_Excep, AutorException {
        dao = new DAOSQL();
        if(dao.update_Autor(auAnt, auAct) == 0){
            throw new AutorException("Error de actualizacion, ya existe un autor registrado con ese nombre");
        }
    }

    @Override
    public void deleteAutors(Autor au) throws DAO_Excep, AutorException {
        dao = new DAOSQL();
        int registros  = dao.delete_Autor(au);
        if(registros == 0){
            throw new AutorException("Error: no se a podido eliminar autor");
        }
    }
}
