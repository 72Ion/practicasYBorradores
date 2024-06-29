package cochera;

import java.util.HashMap;


public class Cochera {
    //Create a variable that is a hashmap with the key being the date and the value being the Reserva which is a class I already created.
    //code

    private HashMap<String, Reserva> reservas;

    public Cochera() {
        this.reservas = new HashMap<>();
    }

    public Cochera addReserva(String fecha, Reserva reserva) {
        if (!this.reservas.containsKey(fecha)) {
            this.reservas.put(fecha, reserva);
            return this;
        }
        this.getReserva(fecha).addOnClosure().readyCompare(reserva);
        return this;
    }

    public Reserva getReserva(String fecha) {
        return this.reservas.get(fecha);
    }

    public String getReservaNombre(String fecha) {
        return this.reservas.get(fecha).getNombre();
    }

    public Cochera cerrarReserva(String fecha) {
        this.reservas.get(fecha).cerrar();
        return this;
    }

}
