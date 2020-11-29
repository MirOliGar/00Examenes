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
        final int PISO_MIN = 0;
        final int PISO_MAX = 10;
        final int PERS_TOT = 4;

        //Variables
        int i = 0;

        do {
            try {
                //Entrada teclado
                System.out.printf("Persona %d: Elija un piso......: ", i + 1);
                int piso = SCN.nextInt();

                // Comprobar Limites
                if (piso >= PISO_MIN && piso <= PISO_MAX) {
                    System.out.printf("Persona %d ha seleccionado piso %d.%n",
                            i + 1, piso);

                    // Actualizar
                    i++;
                
                } else {
                    System.out.println("ERROR: Planta inexistente");
                }
            } catch (Exception e) {
                System.out.println("ERROR. Entrada Incorrecta");
            } finally {
                SCN.nextLine();
            }
        } while (i < PERS_TOT);

    }
}
