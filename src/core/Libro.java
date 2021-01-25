package core;

public class Libro {

    private String titulo;
    private String isbn;
    private String autor;
    private Estados estado;

    enum Estados {
        DISPONIBLE,
        PRESTADO
    }

    public Libro(){}
    public Libro(String titulo, String isbn, String autor){
        this.setTitulo(titulo);
        this.setIsbn(isbn);
        this.setAutor(autor);
        this.estado = Estados.DISPONIBLE;
    }


    public void prestamo(){
        this.estado = Estados.PRESTADO;
    }

    public void devolucion(){
        this.estado = Estados.DISPONIBLE;
    }

    @Override
    public String toString(){
        if(this.titulo == null && this.autor == null && this.isbn == null && this.estado == null){
            return "Los datos del libro no fueron completados";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(this.titulo);
            sb.append(", ");
            sb.append(this.isbn);
            sb.append(", ");
            sb.append(this.autor);
            sb.append(", ");
            sb.append(this.estado);

            return sb.toString();
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }
}
