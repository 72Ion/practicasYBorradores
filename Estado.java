package cochera;

public abstract class Estado {

    public abstract void checkNombre(Reserva reserva);
    public abstract Reserva checkClosure(Reserva reserva);
    public  abstract void addOnClosure(Reserva reserva);
}

class Abierto extends Estado {
    public void checkNombre(Reserva Reserva) {
        throw new RuntimeException("No se puede obtener el nombre de una reserva abierta");
    }
    public Reserva checkClosure(Reserva reserva) {
        if (reserva.privateName().equals("")) {
            reserva.setEstado(new SinSolicitudCerrada());
            return reserva;
        }
        reserva.setEstado(new Cerrado());
        return reserva;
    }

    public void addOnClosure(Reserva reserva) {
        return;
    }
}

class Cerrado extends Estado {
    public void checkNombre(Reserva Reserva) {
        return;
    }
    public Reserva checkClosure(Reserva reserva) {
        return reserva;
    }
    public void addOnClosure(Reserva reserva) {
        throw new RuntimeException("No se puede agregar un postulante a una reserva cerrada");
    }
}

class SinSolicitudCerrada extends Estado {
    public void checkNombre(Reserva Reserva) {
        throw new RuntimeException("No se puede obtener el nombre de una reserva sin postulantes");
    }
    public Reserva checkClosure(Reserva reserva) {
        return reserva;
    }
    public void addOnClosure(Reserva reserva) {
        throw new RuntimeException("No se puede agregar un postulante a una reserva cerrada");
    }
}
