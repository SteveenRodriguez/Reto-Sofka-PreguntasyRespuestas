package juegopreguntas;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import juegopreguntas.preguntas.Preguntas;

public class TestJuego {

    private final ArrayList<Preguntas> preguntasSeleccionadas;
    private final Jugador jugador;
    private int puntosJugador;

    public TestJuego() {
        this.preguntasSeleccionadas = new ArrayList<>();
        this.jugador = new Jugador();
        this.puntosJugador = 0;
    }

    void bienvenidaJuego() {
        Scanner sc = new Scanner(System.in);
        System.out.println("BIENVENIDO A QUIEN QUIERE SER INTELIGENTE \n\n");
        System.out.println("1. Comenzar a jugar");
        System.out.println("2. Mostrar historial de jugadores anteriores");
        System.out.println("3.  Salir del juego");
        System.out.println("Digite número de la opción que desees realizar:");
        String opcTexto = sc.nextLine();
        int opcion = 0;
        opcion = Integer.parseInt(opcTexto);
        boolean ciclo;
        do {
            try {
                if (opcion < 1 || opcion > 3) {
                    System.out.println("No puedes ingresar una opción menor a 1 o mayor a 3");
                    ciclo = true;
                } else {
                    ciclo = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número");
                ciclo = true;
            }
        } while (ciclo);

        switch (opcion) {
            case 1:
                comenzarJuego();
                break;
            case 2:
                verHistorial();
                break;
            default:
                System.exit(0);
        }
    }

    public void comenzarJuego() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite su nombre:\n");
        this.jugador.setNombreJugador(sc.nextLine());
        ronda("ronda 1");
        ronda("ronda 2");
        ronda("ronda 3");
        ronda("ronda 4");
        ronda("ronda 5");
        this.jugador.setPuntosJugador(this.puntosJugador);
        System.out.println("Congratulations " + this.jugador.getNombreJugador()
                + "\n Puntaje Total = " + this.puntosJugador);
        updateHistoricoJuego(this.jugador);
        bienvenidaJuego();
    }

    private void ronda(String ronda) {
        System.out.println(ronda);
        System.out.println("Si deseas retirarte digite \"salir\"");
        // buscar preguntas nuevas
        escogerPregunta("arte", ronda);
        escogerPregunta("deporte", ronda);
        escogerPregunta("geografia", ronda);
        escogerPregunta("entretenimiento", ronda);
        escogerPregunta("ciencia", ronda);
    }

    private void escogerPregunta(String categoria, String nivel) {
        Scanner scanner = new Scanner(System.in);
        Preguntas pregunta;
        boolean sinMostrar;
        int opcion = 0;
        do {
            pregunta = getPregunta(categoria);
            sinMostrar = listarPregunta(pregunta);
        } while (sinMostrar);

        boolean ciclo;
        do {
            try {
                String opcTexto = scanner.nextLine();
                if (opcTexto.equalsIgnoreCase("salir")) {
                    System.out.println("Gracias por Jugar " + this.jugador.getNombreJugador());
                    this.jugador.setPuntosJugador(this.puntosJugador);
                    updateHistoricoJuego(this.jugador);
                    System.exit(0);
                }
                opcion = Integer.parseInt(opcTexto);
                if (opcion < 1 || opcion > 4) {
                    System.out.println("debe ingresar un valor de los que estan en las respuestas");
                    ciclo = true;
                } else {
                    ciclo = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("debe ingresar un numero");
                ciclo = true;
            }
        } while (ciclo);

        comprobarRespuesta(opcion, pregunta, nivel);
    }

    private Preguntas getPregunta(String categoriaPregunta) {
        boolean preguntaEncontrada = true;
        Preguntas[] valores = Preguntas.values();
        Random random = new Random();
        Preguntas valorPregunta;
        do {
            int iteracion = random.nextInt(valores.length);
            valorPregunta = valores[iteracion];
            if (valorPregunta.getCategoriaPregunta().equals(categoriaPregunta)) {
                preguntaEncontrada = false;
            }
        } while (preguntaEncontrada);

        return valorPregunta;
    }

    private boolean listarPregunta(Preguntas pregunta) {
        boolean contienePregunta = this.preguntasSeleccionadas.contains(pregunta);
        if (!contienePregunta) {
            this.preguntasSeleccionadas.add(pregunta);
            pregunta.mostrarPregunta();
            System.out.println("\nDigite respuesta");
        }
        return contienePregunta;
    }

    private void comprobarRespuesta(int respuestaJugador, Preguntas pregunta, String ronda) {
        if (pregunta.getPosicionRespuestaCorrecta() == respuestaJugador) {
            switch (ronda) {
                case "ronda 1":
                    this.puntosJugador += 50;
                    break;
                case "ronda 2":
                    this.puntosJugador += 100;
                    break;
                case "ronda 3":
                    this.puntosJugador += 150;
                    break;
                case "ronda 4":
                    this.puntosJugador += 250;
                    break;
                case "ronda 5":
                    this.puntosJugador += 300;
                    break;
            }
            System.out.println("Opción elegida correcta!");
            System.out.println("Total puntos: " + this.puntosJugador);
        } else {
            System.out.println(
                    "Opción elegida incorrecta! :/ la correcta era " + pregunta.getPosicionRespuestaCorrecta());
            System.out.println("GAME OVER!!!");
            this.jugador.setPuntosJugador(this.puntosJugador);
            updateHistoricoJuego(this.jugador);
            bienvenidaJuego();
        }
    }

    private void updateHistoricoJuego(Jugador jugador) {
        PersistenciaDatos.agregarDatoJugador(jugador);
        PersistenciaDatos.almacenarDatos();
    }

    void verHistorial() {
        Scanner scanner = new Scanner(System.in);
        PersistenciaDatos.mostrarHistoricoJuego();
        System.out.println("Presione cualquier tecla, para volver al inicio.");
        scanner.nextLine();
        bienvenidaJuego();
    }
}
