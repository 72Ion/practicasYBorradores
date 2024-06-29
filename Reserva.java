package cochera;

public class Reserva {
    private String fecha;
    private Integer motivo;
    private String nombre;

    private Estado estado;


    public Reserva() {
        this.estado = new Abierto();
        this.fecha = "";
        this.motivo = 0;
        this.nombre = "";
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMotivo(Integer motivo) {
        this.motivo = motivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return this.fecha;
    }

    public Integer getMotivo() {
        return this.motivo;
    }

    public Reserva cerrar() {
        return this.estado.checkClosure(this);
    }

    public String privateName() {
        return this.nombre;
    }

    public String getNombre() {
        this.estado.checkNombre(this);
        return this.nombre;
    }

    public Reserva addOnClosure() {
        this.estado.addOnClosure(this);
        return this;
    }

    public Reserva readyCompare(Reserva reserva) {
        if (this.getMotivo() < reserva.getMotivo()) {
            this.setMotivo(reserva.getMotivo());
            this.setNombre(reserva.privateName());
        }
        return this;

    }
}
