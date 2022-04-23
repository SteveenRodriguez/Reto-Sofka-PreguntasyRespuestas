package com.softka.juegopreguntas.preguntas;

import java.util.Random;
import java.util.logging.Logger;

public class MostrarPregunta {

    private Preguntas preguntas;
    private Logger logger;

    public MostrarPregunta(Preguntas preguntas){
        this.preguntas = preguntas;
        this.logger = Logger.getLogger("");
    }

    public void mostrarPregunta() {
        System.out.println(preguntas.descripcion());
        Random random = new Random();
        Integer nextInt = random.nextInt(5);
        posicionRespuestaCorrecta(nextInt);
    }

    public void posicionRespuestaCorrecta(Integer numero){
        if (numero > 3) {
            logger.info("1. " + preguntas.incorrecta2());
            logger.info("2. " + preguntas.incorrecta3());
            logger.info("3. " + preguntas.incorrecta1());
            logger.info("4. " + preguntas.correcta());
           preguntas.setPosicionRespuestaCorrecta(4);
        }
        if (numero >= 2) {
            logger.info("1. " + preguntas.incorrecta2());
            logger.info("2. " + preguntas.correcta());
            logger.info("3. " + preguntas.incorrecta1());
            logger.info("4. " + preguntas.incorrecta3());
           preguntas.setPosicionRespuestaCorrecta(2);
        }
        if( numero == 1 ) {
            logger.info("1. " + preguntas.incorrecta2());
            logger.info("2. " + preguntas.incorrecta1());
            logger.info("3. " + preguntas.correcta());
            logger.info("4. " + preguntas.incorrecta3());
           preguntas.setPosicionRespuestaCorrecta(3);
        }
    }



}
