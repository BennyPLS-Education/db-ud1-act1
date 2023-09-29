package act1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

/**
 * <h1>Activitat 1</h1>
 * Realitza les següents accions:
 * Crea una classe anomenada PropietatsSistema.
 * Crea un fitxer anomenat “propietats_del_sistema.json”.
 * Crea un mètode per escriure les següents propietats:
 * El directori on s’ha instal·lat el JRE.
 * Nom del sistema operatiu i versió
 * Separador del sistema de fitxers
 * Nom del compte d’usuari.
 * El separador utilitzar pel sistema operatiu per separar les línies als fitxers de text.
 * Afegeix el control d’errors que consideris.
 * <p>
 * Nota: per introduir el format JSON, haureu de seguir la seva estructura.
 * <p>
 * Exemple de JSON:
 * <p>
 * {
 * <p>
 * "latitude": 40.416875,
 * <p>
 * "longitude": -3.703308,
 * <p>
 * "city": "Madrid"
 * <p>
 * }
 */

public class Main {

    public static void main(String[] args) {

        System.out.println("Activity 1");
        System.out.println("==========");

        SystemProperties.write();

        System.out.println("Fitxer creat correctament.");
    }

    static class SystemProperties {
        static Properties sysProperties = System.getProperties();

        static void write() {
            var file = new File("propietats_del_sistema.json");
            String[] listedProperties = {
                    "java.home",
                    "os.name",
                    "os.version",
                    "file.separator",
                    "user.name",
                    "line.separator"
            };

            try (var writer = new BufferedWriter(new FileWriter(file))) {
                writer.write('{');

                for (int i = 0, listedPropertiesLength = listedProperties.length; i < listedPropertiesLength; i++) {
                    String property = listedProperties[i];

                    var buff = "\n\t\"" + property + "\": \"" + sysProperties.getProperty(property) + "\"";

                    if (i < listedPropertiesLength - 1) {
                        buff += ",";
                    }

                    writer.write(buff);
                }

                writer.write('}');
            } catch (Exception ignored) {
            }

        }
    }
}