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

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Mireia Oliver García - mireia.oliver.11@gmail.com
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {
        //Constantes
        final int PESO_MIN = 0;
        final int PESO_MAX = 250;
        final int NUM_DIAS = 7;

        //Variables
        double pesoAcum = 0;
        int i = 0;

        do {
            try {
                //Entrada teclado
                System.out.printf("Peso dia %d......: ", i + 1);
                double peso = SCN.nextDouble();

                // Comprobar Limites
                if (peso >= PESO_MIN && peso <= PESO_MAX) {
                    // Acumular peso
                    pesoAcum = pesoAcum + peso;
                    // Alternativa: pesoAcum += peso;
                    
                    // Actualizar
                    i++;
                } else {
                    System.out.println("ERROR: Rango Incorrecto");
                }
            } catch (Exception e) {
                System.out.println("ERROR. Entrada Incorrecta");
            } finally {
                SCN.nextLine();
            }
        } while (i < NUM_DIAS);

        //Operaciones
        //Media: suma de todos dividido del total
        double pesoMedio = pesoAcum / NUM_DIAS;

        //salida final
        System.out.printf("Media semanal ..: %.2f%n", pesoMedio);

    }
}
