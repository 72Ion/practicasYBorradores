package calendario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.*;


public class CalendarioTest {

    @Test void feriadosVacio(){
        Calendario calendario = new Calendario();
        assertEquals(false, calendario.esFeriado(LocalDate.of(2021, 1, 1)));
    }

    @Test void feriadoPuntualValido(){
        Calendario calendario = new Calendario();
        Feriado feriado = new FeriadoPuntual(LocalDate.of(2021, 1, 1));
        calendario.agregarFeriado(feriado);
        assertEquals(true, calendario.esFeriado(LocalDate.of(2021, 1, 1)));
    }

    @Test void feriadoSemanalValido(){
        Calendario calendario = new Calendario();
        Feriado feriado = new FeriadoSemanal(DayOfWeek.MONDAY);
        calendario.agregarFeriado(feriado);
        assertEquals(true, calendario.esFeriado(LocalDate.of(2024, 6, 3)));
        assertEquals("Semanal", feriado.getTipo());
    }


    @Test void feriadoDePeriodoValido(){
        Calendario calendario = new Calendario();
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 1, 31);
        Feriado feriado = new FeriadoDePeriodo(startDate, endDate);
        calendario.agregarFeriado(feriado);

        // Check a date within the period
        assertTrue(calendario.esFeriado(LocalDate.of(2022, 1, 15)));

        // Check another date within the period
        assertTrue(calendario.esFeriado(LocalDate.of(2022, 1, 20)));

        // Check a date before the period
        assertFalse(calendario.esFeriado(LocalDate.of(2021, 12, 31)));

        // Check a date after the period
        assertFalse(calendario.esFeriado(LocalDate.of(2022, 2, 1)));
    }

}
