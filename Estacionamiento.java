package estaDeCampo;

import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {

    private List<Coches> cochesList = new ArrayList<>();

    private int cantidadDePersonas = 0;
    private int porCobrar = 0;

    public int getPersonasEnEvento() {
        return cantidadDePersonas;
    }

    public int getPlataPorCobrar() {
        return porCobrar;
    }

    public void setPersonasEnEvento(int personas) {
        this.cantidadDePersonas = personas;
    }

    public void setPlataPorCobrar(int dinero) {
        this.porCobrar = dinero;
    }



    public Estacionamiento entraAuto(Coches auto) {
        cochesList.add(auto);
        return auto.modificacionEntrada(this);
    }

    public Estacionamiento remueveAuto(Coches auto) { // Esto en realidad estaria bueno complementarlo con un estado pero fue...
        cochesList.remove(auto);
        return auto.modificacionSalida(this);

    }


}
