package act3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * <h1>Activitat 3</h1>
 * Realitza les següents accions:
 * <p>
 * Crea una classe anomenada Configmysql.
 * Dins l’anterior classe, escriu un mètode que escrigui
 * la següent configuració de MySQL al fitxer “mysql.conf”.
 * <p>
 * port=3306
 * socket=/tmp/mysql.sock
 * key_buffer_size=16M
 * max_allowed_packet=128M
 * <p>
 * Dins la mateixa classe, escriu un mètode que mostri per
 * pantalla les propietats del fitxer “mysql.conf” creat a
 * l’apartat anterior.
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Activity 3");
        System.out.println("==========");

        Configmysql.writeConfig();

        System.out.println("Fitxer creat correctament.");

        Configmysql.listProperties();

        System.out.println("Fitxer llegit correctament.");
    }

    static class Configmysql {
        private static final Properties mysqlProperties = new Properties();

        static {
            mysqlProperties.put("port", "3306");
            mysqlProperties.put("socket", "/tmp/mysql.sock");
            mysqlProperties.put("key_buffer_size", "16M");
            mysqlProperties.put("max_allowed_packet", "128M");
        }

        private static final String FILE_NAME = "mysql.conf";
        private static final String FILE_PATH = "src/act3/" + FILE_NAME;

        static void writeConfig() {
            try (var writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
                mysqlProperties.store(writer, "MySQL configuration");
            } catch (IOException ignored) {
            }
        }

        static void listProperties() {
            try (var reader = new java.io.FileReader(FILE_PATH)) {
                mysqlProperties.load(reader);
                mysqlProperties.list(System.out);
            } catch (IOException ignored) {
            }
        }
    }
}
