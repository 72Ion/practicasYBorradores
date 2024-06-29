package calendario;
import java.time.LocalDate;
import java.time.DayOfWeek;

public abstract class Feriado {
    private LocalDate fecha;
    private String tipo;


    public abstract LocalDate getFecha();

    public abstract String getTipo();

    public abstract Calendario add(Calendario calendario);
}

class FeriadoPuntual extends Feriado {
    private LocalDate fecha;
    private String tipo;

    public FeriadoPuntual(LocalDate fecha) {
        this.fecha = fecha;
        this.tipo = "Puntual";
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public Calendario add(Calendario calendario) {
        calendario.addNonWeekly(this);
        return calendario;
    }

}

class FeriadoSemanal extends Feriado {
    private DayOfWeek dia;
    private String tipo;

    public FeriadoSemanal(DayOfWeek dia) {
        this.dia = dia;
        this.tipo = "Semanal";
    }

    public LocalDate getFecha() {
        return LocalDate.now().with(DayOfWeek.MONDAY);
    }

    public String getTipo() {
        return tipo;
    }

    public Calendario add(Calendario calendario) {
        calendario.addToWeeklyFeriados(dia.toString());
        return calendario;
    }

}

class FeriadoDePeriodo extends Feriado {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    private LocalDate dateIterator;
    private String tipo;

    public FeriadoDePeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = "Periodo";
    }

    public LocalDate getFecha() {
//        return LocalDate.now().with(DayOfWeek.MONDAY);
        return fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public Calendario add(Calendario calendario) {
        for (LocalDate dateIterator = fechaInicio; dateIterator.isBefore(fechaFin); dateIterator = dateIterator.plusDays(1)) {
            FeriadoPuntual feriado = new FeriadoPuntual(dateIterator);
            calendario.addNonWeekly(feriado);
        }
        return calendario;
    }

}
