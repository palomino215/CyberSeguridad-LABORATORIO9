package model;

public class Incidente {

    private int id;
    private String titulo;
    private String descripcion;
    private String severidad;
    private String estado;
    private int usuarioId;

    public Incidente() {}

    public Incidente(String titulo, String descripcion, String severidad, int usuarioId) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.severidad = severidad;
        this.usuarioId = usuarioId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getSeveridad() { return severidad; }
    public void setSeveridad(String severidad) { this.severidad = severidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }
}
