
package Model;

import java.util.ArrayList;
import java.util.Objects;

public class Autor {
    //Caracteristicas
    private String nombre;
    private String ape1;
    private String ape2;
    private String lugarNac;
    private ArrayList<Libro>libros = new ArrayList<>();

    //GETTERS SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
    
    //CONSTRUCTORES
    public Autor(String nombre, String ape1, String ape2, String lugarNac) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.lugarNac = lugarNac;
    }

    public Autor(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }
    
    //EQUALS 
    //Un autor solo sera el mismo si tienen el nombre y los apellidos iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if(Objects.equals(this.nombre, other.nombre) && Objects.equals(this.ape1, other.ape1) && Objects.equals(this.ape2, other.ape2)) return true;
        else return false;
    }
    
    //TO STRING
    @Override
    public String toString() {
        return "Autor" +"\t\t" + nombre + "\t\t" + ape1 + "\t\t" + ape2 + "\t\t" + lugarNac;
    }
    
    
    
}
