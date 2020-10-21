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

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Mireia Oliver García - mireia.oliver.11@gmail.com
 */
public class Main {

    public static final Scanner SCN = new Scanner(System.in, "Windows-1252")
            .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static final Calendar CAL = Calendar.getInstance();

    public static void main(String[] args) {
        //Horario de atención
        //inicio
        final int hi = 10;
        final int mi = 30;
        //fin
        final int hf = 12;
        final int mf = 15;
        
        //total
        final int ti = hi * 60 + mi;
        final int tf = hf * 60 + mf;

        System.out.printf("Horario de atención: %n Inicio: %d:%d h %n Fin: "
                + "%d:%d h %n", hi, mi, hf, mf);

        System.out.println("**********");

        //Introducir por teclado
        int ht = 10;
        int mt = 30;

        //Para ht (hora tiempo)
        try {
            System.out.print("¿Cuál es la hora de entrada? ");
            ht = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Entrada incorrecta.");
        } finally {
            SCN.nextLine();
        }

        //para mt (minuto tiempo)
        try {
            System.out.print("¿Cuál es el minuto de entrada? ");
            mt = SCN.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Entrada incorrecta.");
        } finally {
            SCN.nextLine();
        }

        int te = ht * 60 + mt;
        System.out.printf("Hora de usuario: %02d:%02dh%n", ht, mt);
        System.out.printf("%s%n",
                ti <= te && te <= tf
                        ? "Sí. Atencion disponible"
                        : "No. Atencion no disponible");
       

        System.out.println("**********");

        //Random
        //Hora mínima
        final int hr_min = 0;
        final int mr_min = 0;

        //Hora máxima
        final int hr_max = 23;
        final int mr_max = 59;

        int hr = RND.nextInt(hr_max - hr_min + 1) + hr_min;
        int mr = RND.nextInt(mr_max - mr_min + 1) + mr_min;
        System.out.printf("Hora aleatoria: %02d:%02dh%n", hr, mr);
        int hrt = hr * 60 + mr;
        System.out.printf("%s%n",
                ti <= hrt && hrt <= tf
                        ? "Sí. Atencion disponible"
                        : "No. Atencion no disponible");

        System.out.println("**********");

        //Hora sistema
        int hs = CAL.get(Calendar.HOUR);
        int ms = CAL.get(Calendar.MINUTE);
        System.out.printf("Hora del sistema: %02d:%02dh%n", hs, ms);
        int ts = hs * 60 + ms;
        System.out.printf("%s%n",
                ti <= ts && ts <= tf
                        ? "Sí. Atencion disponible"
                        : "No. Atencion no disponible");
    }
}
