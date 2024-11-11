
package Model;

public class Libro {
    //VARIABLES
    private String titulo;
    private final int isbn;
    private Autor autor;
    private String descript;
    private String genero;

    //GETTERS SETTERS
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }
    
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    //CONSTRUCTORES

    public Libro(String titulo, int isbn, Autor autor, String descript, String genero) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.descript = descript;
        this.genero = genero;
    }

    public Libro(int isbn) {
        this.isbn = isbn;
    }
    
    //EQUALS
    //Un libro solo es el mismo si tienen el mismo isbn
    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

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
        final Libro other = (Libro) obj;
        return this.isbn == other.isbn;
    }
    
    //TO STRING
    @Override
    public String toString() {
        String autorIdentidad = autor.getNombre()+" "+autor.getApe1()+" "+autor.getApe2();
        return "Libro" + "\t\t"+ titulo + "\t\t" + isbn + "\t\t" + autorIdentidad +"\t\t" + descript + "\t\t" + genero;
    }
    
    
    
}
