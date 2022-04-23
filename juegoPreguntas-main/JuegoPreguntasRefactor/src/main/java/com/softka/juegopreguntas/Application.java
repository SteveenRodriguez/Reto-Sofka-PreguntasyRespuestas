package com.softka.juegopreguntas;

import com.softka.juegopreguntas.controller.TestJuego;
import com.softka.juegopreguntas.model.PersistenciaDatos;

public class Application {
    public static void main(String[] args) {
        PersistenciaDatos.mostrarDatos();
        TestJuego testJuego = new TestJuego();
        testJuego.bienvenidaJuego();
        PersistenciaDatos.almacenarDatos();
    }
}
