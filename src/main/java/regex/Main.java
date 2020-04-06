package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wpisz imię i nazwisko");
        String informacje = scanner.nextLine();
        String pattern = "^([A-Z][a-z]*)\\s+([A-Z][a-z]*)$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(informacje);
        if (m.find()) {
        System.out.println("Imie : " + m.group(1));
        System.out.println("Nazwisko : " + m.group(2));
        } else {
        System.out.println("Nie udalo sie znalezc poszukiwanych informacji");
        }

    }

}
