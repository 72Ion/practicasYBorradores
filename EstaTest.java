package estaDeCampo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EstaTest {

    @Test void estacionamientoVacio(){
        assertEquals(0, new Estacionamiento().getPersonasEnEvento());
    }

    @Test void cajaVacia(){
        assertEquals(0, new Estacionamiento().getPlataPorCobrar());
    }

    @Test void personasYDineroPorAsociados(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Coches autoAsociado = new Asociado(4);

        estacionamiento.entraAuto(autoAsociado);

        assertEquals(4, estacionamiento.getPersonasEnEvento());
        assertEquals(100, estacionamiento.getPlataPorCobrar());
    }

    @Test void personasYDineroPorInvitados(){
        Estacionamiento estacionamiento = new Estacionamiento();

        Coches autoInvitado = new Invitado(3);
        estacionamiento.entraAuto(autoInvitado);

        assertEquals(3, estacionamiento.getPersonasEnEvento());
        assertEquals(150, estacionamiento.getPlataPorCobrar());
    }

    // ANTES DE HACER EL BOCA A BOCA QUIERO HACER UNA BUENA REMOCION DE AUTOS.

    @Test void remocion1SoloAutoAsociado(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Coches autoAsociado = new Asociado(4);

        estacionamiento.entraAuto(autoAsociado);
        estacionamiento.remueveAuto(autoAsociado);

        assertEquals(0, estacionamiento.getPersonasEnEvento());
        assertEquals(0, estacionamiento.getPlataPorCobrar());
    }

    @Test void remocion1SoloAutoInvitado(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Coches autoInvitado = new Invitado(3);

        estacionamiento.entraAuto(autoInvitado);
        estacionamiento.remueveAuto(autoInvitado);

        assertEquals(0, estacionamiento.getPersonasEnEvento());
        assertEquals(0, estacionamiento.getPlataPorCobrar());
    }

    @Test void personasYdineroAutosBEB(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Coches autoBeb = new autoBEB(4);

        estacionamiento.entraAuto(autoBeb);

        assertEquals(4, estacionamiento.getPersonasEnEvento());
        assertEquals(4*60+50, estacionamiento.getPlataPorCobrar());
    }

    // Armate un test que remueva autoBEB...
    @Test void remocion1SoloAutoBEB(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Coches autoBeb = new autoBEB(4);

        estacionamiento.entraAuto(autoBeb);
        estacionamiento.remueveAuto(autoBeb);

        assertEquals(0, estacionamiento.getPersonasEnEvento());
        assertEquals(0, estacionamiento.getPlataPorCobrar());
    }


    @Test void variosAutos(){
        Estacionamiento estacionamiento = new Estacionamiento();
        Coches autoAsociado = new Asociado(4);
        Coches autoInvitado = new Invitado(3);
        Coches autoBeb = new autoBEB(4);

        estacionamiento.entraAuto(autoAsociado);
        estacionamiento.entraAuto(autoInvitado);
        estacionamiento.entraAuto(autoBeb);

        assertEquals(11, estacionamiento.getPersonasEnEvento());
        assertEquals(4*60+50+100+150, estacionamiento.getPlataPorCobrar());

        estacionamiento.remueveAuto(autoAsociado);
        estacionamiento.remueveAuto(autoBeb);

        assertEquals(3, estacionamiento.getPersonasEnEvento());
        assertEquals(150, estacionamiento.getPlataPorCobrar());
    }

    


}
