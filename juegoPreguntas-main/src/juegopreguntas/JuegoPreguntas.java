package juegopreguntas;

public class JuegoPreguntas {
    public static void main(String[] args) {
        // Como es un método estático no se instancia
        PersistenciaDatos.mostrarDatos();
        // Instanciamos la clase TestJuego
        TestJuego testJuego = new TestJuego();
        testJuego.bienvenidaJuego();
        PersistenciaDatos.almacenarDatos();
    }
}
