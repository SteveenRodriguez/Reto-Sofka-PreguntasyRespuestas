package juegopreguntas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// clase para obtener el histórico del juego, manteniendo la persistencia de datos
public class PersistenciaDatos {

    // lista constante que recibe objeto de tipo Jugador
    private static final ArrayList<Jugador> HISTORICO_JUEGO = new ArrayList<>();

    // método para guardar los datos en un archivo .txt
    static void almacenarDatos() {

        FileOutputStream salidaDatos;
        try {
            salidaDatos = new FileOutputStream("src/historico/historico.txt");
            ObjectOutputStream escribiendoDatos = new ObjectOutputStream(salidaDatos);
            escribiendoDatos.writeObject(HISTORICO_JUEGO);
            escribiendoDatos.close();
        } catch (IOException e) {
            System.out.println("Error para guardar los datos en el archivo .txt\n" + e.getMessage());
        }
    }

    static void mostrarDatos() {

        FileInputStream entradaDatos;
        try {
            entradaDatos = new FileInputStream("src/historico/historico.txt");
            ObjectInputStream mostrandoDatos = new ObjectInputStream(entradaDatos);

            // se necesita otra lista para poder leer datos de los jugadores
            ArrayList<Jugador> players = (ArrayList<Jugador>) mostrandoDatos.readObject();
            HISTORICO_JUEGO.addAll(players);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error para mostrar datos de historial\n" + e.getMessage());
        }
    }

    // método para agregar el jugador al HISTORICO_JUEGO
    static void agregarDatoJugador(Jugador jugador) {
        HISTORICO_JUEGO.add(jugador);
    }

    public static void mostrarHistoricoJuego() {
        HISTORICO_JUEGO.forEach((jugador) -> {
            System.out.println("Jugador: " + jugador.getNombreJugador() + " Puntos: " + jugador.getPuntosJugador());
        });
    }
}
