package calendario;

import java.time.LocalDate;
import java.time.DayOfWeek;

import java.util.ArrayList;

public class Calendario {

    private ArrayList<Feriado> feriados = new ArrayList<>();

    private ArrayList<String> feriadosSemanal = new ArrayList<>();


    public Calendario agregarFeriado(Feriado feriado){
        feriado.add(this);
        return this;
    }

    public void addNonWeekly(Feriado feriado) {
        feriados.add(feriado);
    }

    public boolean esFeriado(LocalDate fecha) {
        Boolean semanal = feriadosSemanal.contains(fecha.getDayOfWeek().toString().toUpperCase());
        return feriados.stream().anyMatch(feriado -> feriado.getFecha().equals(fecha)) || semanal;
    }


    public void addToWeeklyFeriados(String dia) {
        feriadosSemanal.add(dia);
    }



}
