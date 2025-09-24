package Biblioteca;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    public static String lerString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = sc.nextLine();
            try {
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    public static double lerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = sc.nextLine();
            try {
                return Double.parseDouble(linha.trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número decimal (ex: 12.5).");
            }
        }
    }
}
