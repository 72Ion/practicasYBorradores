package cochera;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class cocheraTest {

    @Test void  cocheraReservaFechaMotivo() {
        Cochera cochera = new Cochera();
        Reserva reserva = new Reserva();

        reserva.setFecha("2021-10-10");
        reserva.setMotivo(1);

        cochera.addReserva(reserva.getFecha(), reserva);

        assertEquals(cochera.getReserva(reserva.getFecha()), reserva);
        assertEquals(cochera.getReserva(reserva.getFecha()).getMotivo(), reserva.getMotivo());
        assertEquals(cochera.getReserva(reserva.getFecha()).getFecha(), reserva.getFecha());
    }

    @Test void consultarSinCerrar() {
        Cochera cochera = new Cochera();
        Reserva reserva = new Reserva();

        reserva.setFecha("2021-10-10");
        reserva.setMotivo(1);
        reserva.setNombre("Juan");

        cochera.addReserva(reserva.getFecha(), reserva);

        assertThrowsLike("No se puede obtener el nombre de una reserva abierta", ()->cochera.getReservaNombre("2021-10-10"));
    }

    @Test void consultarConReservaCerrada() {
        Cochera cochera = new Cochera();
        Reserva reserva = new Reserva();
        reserva.setFecha("2021-10-10");
        reserva.setMotivo(1);
        reserva.setNombre("Juan");


        cochera.addReserva(reserva.getFecha(), reserva).cerrarReserva(reserva.getFecha());
        assertEquals(cochera.getReservaNombre("2021-10-10"), reserva.getNombre());
    }

    @Test void consultarSinPostulantes(){
        Cochera cochera = new Cochera();
        Reserva reserva = new Reserva();
        reserva.setFecha("2021-10-10");
        reserva.setMotivo(1);
        reserva.setNombre("");

        cochera.addReserva(reserva.getFecha(), reserva).cerrarReserva(reserva.getFecha());

        assertThrowsLike("No se puede obtener el nombre de una reserva sin postulantes", ()->cochera.getReservaNombre("2021-10-10"));
    }

    @Test void agregarPostulanteSobreCerrada(){
        Cochera cochera = new Cochera();
        Reserva reserva = new Reserva();
        reserva.setFecha("2021-10-10");
        reserva.setMotivo(1);
        reserva.setNombre("Juan");

        Reserva reserva2 = new Reserva();
        reserva2.setFecha("2021-10-10");
        reserva2.setMotivo(1);
        reserva2.setNombre("Pedro");

        cochera.addReserva(reserva.getFecha(), reserva).cerrarReserva(reserva.getFecha());
        assertThrowsLike("No se puede agregar un postulante a una reserva cerrada", ()->cochera.addReserva(reserva2.getFecha(), reserva2));
    }

    //Code for me a test that adds two reservations to the same date but the "Motivo " of one is higher than the other.

    @Test void addTwoReservationsSameDateDifferentMotivo() {
        Cochera cochera = new Cochera();
        Reserva reserva = new Reserva();
        reserva.setFecha("2021-10-10");
        reserva.setMotivo(1);
        reserva.setNombre("Juan");

        Reserva reserva2 = new Reserva();
        reserva2.setFecha("2021-10-10");
        reserva2.setMotivo(2);
        reserva2.setNombre("Pedro");

        cochera.addReserva(reserva.getFecha(), reserva).addReserva(reserva2.getFecha(), reserva2);

        assertEquals(cochera.getReserva("2021-10-10").privateName(), "Pedro");

        assertEquals(cochera.cerrarReserva("2021-10-10").getReservaNombre("2021-10-10"), "Pedro");
    }

    @Test
    void addMultipleReservationsAndConsultName() {
        Cochera cochera = new Cochera();

        // Create multiple reservations with different priorities
        Reserva reserva1 = new Reserva();
        reserva1.setFecha("2021-10-10");
        reserva1.setMotivo(1);
        reserva1.setNombre("Juan");

        Reserva reserva2 = new Reserva();
        reserva2.setFecha("2021-10-10");
        reserva2.setMotivo(2);
        reserva2.setNombre("Pedro");

        Reserva reserva3 = new Reserva();
        reserva3.setFecha("2021-10-11");
        reserva3.setMotivo(3);
        reserva3.setNombre("Maria");

        Reserva reserva4 = new Reserva();
        reserva4.setFecha("2021-10-11");
        reserva4.setMotivo(4);
        reserva4.setNombre("Carlos");

        // Add reservations to the cochera
        cochera.addReserva(reserva1.getFecha(), reserva1);
        cochera.addReserva(reserva2.getFecha(), reserva2);
        cochera.addReserva(reserva3.getFecha(), reserva3);
        cochera.addReserva(reserva4.getFecha(), reserva4);

        // Close the dates
        cochera.cerrarReserva(reserva1.getFecha());
        cochera.cerrarReserva(reserva3.getFecha());

        // Assert the names of the reservations with the highest priority for each date
        assertEquals(cochera.getReservaNombre(reserva1.getFecha()), reserva2.privateName());
        assertEquals(cochera.getReservaNombre(reserva3.getFecha()), reserva4.privateName());
    }

    // HERMOSOOOOO



    private static void assertThrowsLike(String message, Executable executable) {
        assertEquals(assertThrows(Exception.class, executable).getMessage(), message);
    }

}
