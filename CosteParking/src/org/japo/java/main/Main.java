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

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mireia Oliver García - mireia.oliver.alum@iescamp.es
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {

        System.out.println("Párking Morvedre");
        System.out.println("================");

        //Introducir por teclado
        int he = 0;
        int me = 0;

        //Para he (hora entrada)
        try {
            System.out.print("Hora de entrada...: ");
            he = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR: Entrada incorrecta.");
            System.exit(he);
            
        } finally {
            SCN.nextLine();
        }

        //para me (minuto entrada)
        try {
            System.out.print("Hora de salida....: ");
            me = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("ERROR: Entrada incorrecta.");
            System.exit(me);
        } finally {
            SCN.nextLine();
        }

        System.out.println("---");

        System.out.printf("Momento entrada...: %02d:%02dh - Manual%n", he, me);

        //Random
        //Hora mínima
        final int hr_min = he;
        final int mr_min = me;

        //Hora máxima
        final int hr_max = 23;
        final int mr_max = 59;

        int hr = RND.nextInt(hr_max - hr_min + 1) + hr_min;
        int mr = RND.nextInt(mr_max - mr_min + 1) + mr_min;

        System.out.printf("Momento salida....: %02d:%02dh - Aleatorio%n", hr, mr);

        System.out.println("---");

        double tarifa = 0.15;

        System.out.printf("Tarifa............: %.2f €/min%n", tarifa);

        //Cálculos
        //Hora entrada
        int mte = he * 60 + me; //minutos

        //Hora random
        int mtr = hr * 60 + mr; //minutos

        //Tiempo facturado
        int tiempo = mtr - mte;
        int horas = tiempo / 60; //horas
        int minutos = tiempo % 60; //minutos

        System.out.printf("Tiempo Facturado..: %d minutos (%02dh + %02dm) %n",
                tiempo, horas, minutos);

        //Importe
        double importe = tiempo * tarifa;

        System.out.printf("Importe...........: %.2f €%n", importe);

    }
}
