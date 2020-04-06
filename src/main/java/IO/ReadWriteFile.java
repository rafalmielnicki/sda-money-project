package IO;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadWriteFile {

    public static void main(String[] args) {

        //Odczyt pliku linia po linii
        Path path = Paths.get("src/main/resources/sample.txt");
        try {
            Files.lines(path).forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Lista plików w katalogu
        Path path1 = Paths.get(".");
        try {
            System.out.println("Pliki w folderze: ");
            Files.list(path1).forEach(f -> System.out.println(f.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Program wczytujący tekst od użytkownika i szukający tego tekstu w plikach
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź tekst, który chcesz wyszukiwać w plikach");
        String pattern = scanner.nextLine();

        //Odczyt tekstu
        Path path2 = Paths.get("src/main/resources/sample.txt");
        try {
            String informacje = new String(Files.readAllBytes(path));
            //System.out.println(informacje);
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(informacje);
            if (m.find()) {
                System.out.println("Udalo sie znalezc poszukiwane informacje");
            } else {
                System.out.println("Nie udalo sie znalezc poszukiwanych informacji");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Pathern quote jeżeli chcemy wyszukiwać elementy z gwiazdkami to trzeba skorzystać z tego

    }

}
