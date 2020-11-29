/* 
 * Copyright 2020 Mireia Oliver García - mireia.oliver.11@gmail.com.
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

import java.util.Random;

/**
 *
 * @author Mireia Oliver García - mireia.oliver.11@gmail.com
 */
public class Main {

    public static final Random RND = new Random();

    public static void main(String[] args) {

        final int LLUV_MIN = 0;
        final int LLUV_MAX = 500;

        final int NUM_DIAS = 7;

        double lluviaAcum = 0;
        double lluviaMin = LLUV_MAX;
        double lluviaMax = LLUV_MIN;
        int diaMin = 0;
        int diaMax = 0;

        for (int i = 0; i < 10; i++) {

            double lluvia = RND.nextDouble() * (LLUV_MAX - LLUV_MIN)
                    + LLUV_MIN;
            System.out.printf("Lluvia dia %02d......: %.2f%n", i + 1, lluvia);

            if (lluvia > lluviaMax) {
                lluviaMax = lluvia;
                diaMax = i + 1;
            }

            if (lluvia < lluviaMin) {
                lluviaMin = lluvia;
                diaMin = i + 1;
            }
            // Acumular lluvia
            // Alternativa: lluviaAcum += lluvia;
            lluviaAcum = lluviaAcum + lluvia;
        }

        //Operaciones
        double mediaLluv = lluviaAcum / NUM_DIAS;

        //Salida por pantalla
        System.out.println("---");
        System.out.printf("Lluvia acumulada .: %.2f%n", lluviaAcum);
        System.out.println("---");
        System.out.printf("Día lluvia mínima.: %d%n", diaMin);
        System.out.printf("Cantidad .........: %.2f%n", lluviaMin);
        System.out.println("---");
        System.out.printf("Día lluvia máxima.: %d%n", diaMax);
        System.out.printf("Cantidad .........: %.2f%n", lluviaMax);
        System.out.println("---");
        System.out.printf("Media diaria .....: %.2f%n", mediaLluv);
    }
}
