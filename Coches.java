package estaDeCampo;

public abstract class Coches {
    public int numeroPasajeros;

    public abstract Estacionamiento modificacionEntrada(Estacionamiento estacionamiento);

    public abstract Estacionamiento modificacionSalida(Estacionamiento estacionamiento);
}
class Asociado extends Coches {
    private int numeroPasajeros;
    private int pagoGeneral = 100;

    public Asociado(int i) {
        this.numeroPasajeros = i;
    }

    public Estacionamiento modificacionEntrada(Estacionamiento estacionamiento) {
        estacionamiento.setPersonasEnEvento(estacionamiento.getPersonasEnEvento() + numeroPasajeros);
        estacionamiento.setPlataPorCobrar(estacionamiento.getPlataPorCobrar() + pagoGeneral);
        return estacionamiento;
    }

    public Estacionamiento modificacionSalida(Estacionamiento estacionamiento) {
        estacionamiento.setPersonasEnEvento(estacionamiento.getPersonasEnEvento() - numeroPasajeros);
        estacionamiento.setPlataPorCobrar(estacionamiento.getPlataPorCobrar() - pagoGeneral);
        return estacionamiento;
    }

}

class Invitado extends Coches {
    private int numeroPasajeros;
    private int pagoGeneral = 150;


    public Invitado(int pasajeros) {
        this.numeroPasajeros = pasajeros;
    }

    public Estacionamiento modificacionEntrada(Estacionamiento estacionamiento) {
        estacionamiento.setPersonasEnEvento(estacionamiento.getPersonasEnEvento() + numeroPasajeros);
        estacionamiento.setPlataPorCobrar(estacionamiento.getPlataPorCobrar() + pagoGeneral);
        return estacionamiento;
    }

    public Estacionamiento modificacionSalida(Estacionamiento estacionamiento) {
        estacionamiento.setPersonasEnEvento(estacionamiento.getPersonasEnEvento() - numeroPasajeros);
        estacionamiento.setPlataPorCobrar(estacionamiento.getPlataPorCobrar() - pagoGeneral);
        return estacionamiento;
    }
}

class autoBEB extends Coches {
    private int numeroPasajeros;
    private int pagoGeneral = 50;

    public autoBEB(int pasajeros) {
        this.numeroPasajeros = pasajeros;
    }

    public Estacionamiento modificacionEntrada(Estacionamiento estacionamiento) {
        estacionamiento.setPersonasEnEvento(estacionamiento.getPersonasEnEvento() + numeroPasajeros);
        estacionamiento.setPlataPorCobrar(estacionamiento.getPlataPorCobrar() + pagoGeneral + 60*numeroPasajeros);
        return estacionamiento;
    }

    public Estacionamiento modificacionSalida(Estacionamiento estacionamiento) {
        estacionamiento.setPersonasEnEvento(estacionamiento.getPersonasEnEvento() - numeroPasajeros);
        estacionamiento.setPlataPorCobrar(estacionamiento.getPlataPorCobrar() - pagoGeneral - 60*numeroPasajeros);
        return estacionamiento;
    }
}
