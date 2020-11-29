/* 
 * Copyright 2020 Mireia Oliver García - mireia.oliver.alum@iescamp.es.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author Mireia Oliver García - mireia.oliver.alum@iescamp.es
 */
public class Main {

    public static final Random RND = new Random();
    public static final Calendar CAL = Calendar.getInstance();

    public static void main(String[] args) {

        //Constantes
        final int AFO_MIN = 0;
        final int AFO_MAX = 1234;

        final int NUM_DIAS = 7;

        //Variables
        int aforoAcum = 0;
        int aforoMin = AFO_MAX;
        int aforoMax = AFO_MIN;

        //Días de la semana
        String dia = "";
        String diaMax = "";
        String diaMin = "";

        //Cabecera
        System.out.println("CINES DEL CENTRO COMERCIAL XeKeBó - CONTROL DE AFORO");
        System.out.println("====================================================");

        for (int i = 0; i < NUM_DIAS; i++) {

            int aforo = RND.nextInt((AFO_MAX - AFO_MIN) + AFO_MIN);
            
            //Bucle días
            if (i == 0) {
                dia = "Lunes";
            }
            if (i == 1) {
                dia = "Martes";
            }
            if (i == 2) {
                dia = "Miércoles";
            }
            if (i == 3) {
                dia = "Jueves";
            }
            if (i == 4) {
                dia = "Viernes";
            }
            if (i == 5) {
                dia = "Sábado";
            }
            if (i == 6) {
                dia = "Domingo";
            }
            
            System.out.printf("%-9s - Aforo......: %4d personas%n", dia, aforo);

            //Bucle aforo
            if (aforo > aforoMax) {
                aforoMax = aforo;
                diaMax = dia;
            }

            if (aforo < aforoMin) {
                aforoMin = aforo;
                diaMin = dia;
            }
            // Acumular aforo
            aforoAcum = aforoAcum + aforo;
        }
        //Operaciones

        int mediaAforo = aforoAcum / NUM_DIAS;
        double porMedia = (double) (mediaAforo * NUM_DIAS) / 100;
        double porMax = (double) (aforoMax * NUM_DIAS) / 100;
        double porMin = (double) (aforoMin * NUM_DIAS) / 100;

//Salida por pantalla
        System.out.println("---");
        System.out.printf("Aforo semanal ........: %d personas%n", aforoAcum);
        System.out.printf("Aforo medio diario ...: %d personas (%.2f%%)%n",
                mediaAforo, porMedia);
        System.out.println("---");
        System.out.printf("Día de máximo aforo ..: %d personas (%.2f%%) - %s%n",
                aforoMax, porMax, diaMax);
        System.out.printf("Día de mínimo aforo ..: %d personas (%.2f%%) - %s%n",
                aforoMin, porMin, diaMin);

    }
}
