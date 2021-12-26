package juegopreguntas;

import java.io.Serializable;

public class Jugador implements Serializable {

    private String nombreJugador;
    private int puntosJugador;

    public Jugador() {

    }

    public Jugador(String nombreJugador, int puntosJugador) {
        this.nombreJugador = nombreJugador;
        this.puntosJugador = puntosJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getPuntosJugador() {
        return puntosJugador;
    }

    public void setPuntosJugador(int puntosJugador) {
        this.puntosJugador = puntosJugador;
    }

    @Override
    public String toString() {
        return "Jugador{" + "Nombre = " + nombreJugador + ", puntos = " + puntosJugador + '}';
    }

}
