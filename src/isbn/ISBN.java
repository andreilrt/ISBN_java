package isbn;

import java.util.Scanner;

public class ISBN {

    static Scanner Input = new Scanner(System.in);

    static boolean ValidarNumeros(String ISBN, int Longitud) {
        for (int c = 0; c < Longitud; c++) {
            if (ISBN.charAt(c) < 48 || ISBN.charAt(c) > 57) {
                System.out.println("Codigo ISBN erroneo, Por favor intentelo de nuevo\n");
                return true;
            }
        }
        return false;
    }

    static boolean ValidarTamanos(String ISBN) {
        if (ISBN.length() == 10) {
            if (ValidarNumeros(ISBN, 9)) {
                return true;
            }
            if (ISBN.charAt(9) == 'x' || ISBN.charAt(9) == 'X') {
                return false;
            } else {
                if (ISBN.charAt(9) < 48 || ISBN.charAt(9) > 57) {
                    System.out.println("Codigo ISBN erroneo, Por favor intentelo de nuevo\n");
                    return true;
                }
            }
            return false;
        }
        if (ISBN.length() == 13) {
            if (ValidarNumeros(ISBN, 13)) {
                return true;
            }
            return false;
        } else {
            System.out.println("Codigo ISBN erroneo, Por favor intentelo de nuevo\n");
            return true;
        }
    }

    static void Algoritmo10(String ISBN) {
        int m = 10;
        int suma = 0;
        if (ISBN.charAt(9) == 'X' || ISBN.charAt(9) == 'x') {
            for (int c = 0; c < 9; c++) {
                suma += ((int) (ISBN.charAt(c)) - 48) * m;
                m--;
            }
            suma += 10 * m;
        } else {
            for (int c = 0; c < 10; c++) {
                suma += ((int) (ISBN.charAt(c)) - 48) * m;
                m--;
            }
        }
        if (suma % 11 == 0) {
            System.out.println("Su codigo ISBN es correcto!!! :)");
        } else {
            System.out.println("Su codigo ISBN es incorrecto :(");
        }
    }

    static void Algoritmo13(String ISBN) {
        int SumaFinal = 0;
        int SumaPar = 0;
        int SumaImpar = 0;
        for (int c = 0; c < 13; c++) {
            if (c % 2 == 0) {
                SumaImpar += ((int) ISBN.charAt(c)) - 48;
            } else {
                SumaPar += ((int) ISBN.charAt(c)) - 48;
            }
        }
        SumaFinal = SumaImpar + SumaPar * 3;
        if (SumaFinal % 10 == 0) {
            System.out.println("Su codigo ISBN es correcto!!! :)");
        } else {
            System.out.println("Su codigo ISBN es incorrecto :(");
        }
    }

    static void Proceso() {
        String ISBN = new String();
        boolean Control = true;
        while (Control) {
            System.out.println("Bienvenid@ al programa que valida su codigo ISBN\n");
            System.out.println("Por favor ingrese su codigo sin espacios ni caracteres adicionales");
            System.out.print("Ingrese su codigo ISBN: ");
            ISBN = Input.next();
            Control = ValidarTamanos(ISBN);
        }
        if (ISBN.length() == 10) {
            Algoritmo10(ISBN);
        } else {
            Algoritmo13(ISBN);
        }
    }

    public static void main(String[] args) {
        Proceso();
    }
}
