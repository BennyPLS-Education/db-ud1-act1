package act2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h1>Activitat 2</h1>
 * Realitza les següents accions:
 * Crea una classe anomenada FetImportant.
 * Demana a l’usuari que introdueixi un dels següents valors (2001, 2008, 2016) per teclat.
 * Segons el valor introduït, mostra el contingut del fitxer corresponent (1886.txt, 1928.txt, 1969.txt).
 * Afegeix el control d’errors que consideris.
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("Activity 2");
        System.out.println("==========");

        var input = FetImportant.getInput();

        var file = new File(input.getFileName());

        try (var reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException ignored) {
            System.out.println("Error al llegir el fitxer.");
        }

        System.out.println("Fitxer llegit correctament.");
    }

    static class FetImportant {
        static ImportantDates getInput() {
            var input = new Scanner(System.in);

            while (true) {
                try {
                    System.out.println("Introdueix un dels següents valors (2001, 2008, 2016): ");
                    var year = input.nextInt();

                    return switch (year) {
                        case 2001 -> ImportantDates.YEAR_2001;
                        case 2008 -> ImportantDates.YEAR_2008;
                        case 2016 -> ImportantDates.YEAR_2016;
                        default -> throw new IllegalArgumentException();
                    };

                } catch (IllegalArgumentException ignored) {
                    System.out.println("Valor incorrecte.");
                } catch (InputMismatchException ignored) {
                    input.next();
                    System.out.println("Introdueix un valor numèric.");
                }
            }
        }
    }

    enum ImportantDates {
        YEAR_2001("2001.txt"),
        YEAR_2008("2008.txt"),
        YEAR_2016("2016.txt");

        private final String fileName;
        private static final String prefix = "src/act2/";
        ImportantDates(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return prefix + fileName;
        }
    }
}
