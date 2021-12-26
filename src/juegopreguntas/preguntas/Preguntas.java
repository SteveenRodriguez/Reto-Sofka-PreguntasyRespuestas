package juegopreguntas.preguntas;

import java.util.Random;

public enum Preguntas {

        PREGUNTA_1("¿Conocimientos de un fullstack?", "tecnologia", "backend ", "diseño y backend ", "frontend", "backend y frontend"),
        PREGUNTA_2("¿significado de mvc?", "tecnologia", "martes, viernes, ", "moto,vuelos,carros",
                "view,modelaje,cancion", "Modelo,vista,controlador"),
        PREGUNTA_3("Visual Studio Code es...", "tecnologia", "un api", "un ide",
                "un lenguaje de máquina", "un editor de código"),
        PREGUNTA_4("¿Qué es un IDE?", "tecnologia", "un editor de código", "un juego", "iniciales de una empresa","entorno de desarrollo integrado"),
        PREGUNTA_5("¿Qué es android?", "tecnologia", "sistema operativo de escritorio","núcleo de una máquina", "juego de pc", "sistema operativo móvil"),
        PREGUNTA_6("¿En qué año se dio la independencia Colombiana?", "cultura", "1900", "1010",
                "1991", "1810"),
        PREGUNTA_7("¿Con qué país no limita Colombia?", "cultura", "Venezuela", "Ecuador", "Perú", "México"),
        PREGUNTA_8("¿Quién ganó la guerra de los Mil Días??", "cultura", "centro democrático", "cambio radical",
                "partido liberal", "partido conservador"),
        PREGUNTA_9("¿Cual es el significado de el color azul de la bandera Colombiana?", "por las naciones unidas", "Los sumerios", "por el cielo",
                "por el color de ojos de las ballenas", "por los dos mares que nos rodean"),
        PREGUNTA_10("¿De qué país se independizó Colombia?", "cultura", "Perú", "Estados unidos", "Venezuela",
                "España"),
        PREGUNTA_11("¿Significado de ADN?", "biología", "add, delete, new","Anuncios de google", "comida tipica China", "Ácido desoxirribonucleico"),
        PREGUNTA_12("se alimenta de toda clase de sustancias orgánicas...", "biología",
                "animales", "hervivoros", "carnivoros",
                "omnívoro"),
        PREGUNTA_13("no es un animal cuadrupedo", "biología", "perro", "tigre",
                "elefante", "gallina"),
        PREGUNTA_14("Como se le llama al ser vivo que se sostiene en dos patas?", "biología",
                "homo-sapiens", "mono", "cuadrupedo",
                "bípedo"),
        PREGUNTA_15("¿Qué comen las vacas?", "biología",
                "leche", "queso",
                "plantas", "pasto"),
        PREGUNTA_16("número ordinal trigésimo quinto en cifras", "matematicas", "35000", "3500", "305", "35"),
        PREGUNTA_17("¿Para calcular cuánto es un tercio de 3996, ¿qué tienes que hacer?", "matematicas", "Multiplicar por tres", "Restar tres",
                "sumas tres", "Dividir entre tres"),
        PREGUNTA_18("¿Cuál es el resultado de multiplicar 7x9?", "matematicas", "33", "83",
                "73", "63"),
        PREGUNTA_19("Como se lee este número: 3 DM+ 6UM + 8C", "matematicas", "36", "336", "36000", "36800"),
        PREGUNTA_20("¿Cuánto es un lustro?", "matematicas", "3 años","2 años", "1 año", "5 años"),
        PREGUNTA_21("Grupo de dos vocales distintas y contiguas que se pronuncian en una sola sílaba?", "español",
                "párrafo", "oración", "tílde", "diptongo"),
        PREGUNTA_22("signos de puntuación que se emplean para insertar una información complementaria en medio de una frase?", "español", "la coma","punto y coma","comillas","paréntesis"),
        PREGUNTA_23("que llevan el acento en la antepenúltima sílaba y a todas se les marca la tilde", "español",
                "agudas", "graves", "sobresdrújulas", "esdrújulas"),
        PREGUNTA_24("¿Cúal es el signo ampersand?", "español", "!",":", "%", "&"),
        PREGUNTA_25(" palabra que suena de igual modo que otra, pero que difiere en el significado", "español","graves", "agudas", "esdrújulas", "Homófona");

    public void mostrarPregunta() {
        System.out.println(this.descripcion);
        Random random = new Random();
        int nextInt = random.nextInt(5);
        if (nextInt > 3) {
            System.out.println("1. " + this.incorrecta2);
            System.out.println("2. " + this.incorrecta3);
            System.out.println("3. " + this.incorrecta1);
            System.out.println("4. " + this.correcta);
            this.setPosicionRespuestaCorrecta(4);
        } else if (nextInt >= 2) {
            System.out.println("1. " + this.incorrecta2);
            System.out.println("2. " + this.correcta);
            System.out.println("3. " + this.incorrecta1);
            System.out.println("4. " + this.incorrecta3);
            this.setPosicionRespuestaCorrecta(2);
        } else {
            System.out.println("1. " + this.incorrecta2);
            System.out.println("2. " + this.incorrecta1);
            System.out.println("3. " + this.correcta);
            System.out.println("4. " + this.incorrecta3);
            this.setPosicionRespuestaCorrecta(3);
        }
    }

    Preguntas(String descripcion, String categoria, String opcionFalsa1, String opcionFalsa2, String opcionFalsa3,
            String opcionVerdadera) {
        this.descripcion = descripcion;
        this.categoriaPregunta = categoria;
        this.incorrecta1 = opcionFalsa1;
        this.incorrecta2 = opcionFalsa2;
        this.incorrecta3 = opcionFalsa3;
        this.correcta = opcionVerdadera;
    }

    private int posicionRespuestaCorrecta;
    private String descripcion;
    private String categoriaPregunta;
    private String incorrecta1;
    private String incorrecta2;
    private String incorrecta3;
    private String correcta;

    public int getPosicionRespuestaCorrecta() {
        return posicionRespuestaCorrecta;
    }

    public void setPosicionRespuestaCorrecta(int posicionRespuestaCorrecta) {
        this.posicionRespuestaCorrecta = posicionRespuestaCorrecta;
    }

    public String getIncorrecta1() {
        return incorrecta1;
    }

    public void setIncorrecta1(String incorrecta1) {
        this.incorrecta1 = incorrecta1;
    }

    public String getIncorrecta2() {
        return incorrecta2;
    }

    public void setIncorrecta2(String incorrecta2) {
        this.incorrecta2 = incorrecta2;
    }

    public String getIncorrecta3() {
        return incorrecta3;
    }

    public void setIncorrecta3(String incorrecta3) {
        this.incorrecta3 = incorrecta3;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoriaPregunta() {
        return categoriaPregunta;
    }

    public void setCategoriaPregunta (String categoriaPregunta) {
        this.categoriaPregunta = categoriaPregunta;
    }

}
