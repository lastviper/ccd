/**
 * 
 */
package main;

import console.S;
import controller.SpielController;
import model.SpielModel;

/**
 * Klasse Main
 * 
 * @author tietz
 * @version 1.0.0 Hier werden
 *
 */
public class Main {

  /**
   * Variable zum Speichern der Übergabeparameter für die Anwendung
   */
  private static String[] args = null;

  /**
   * Hauptprogrammeinstieg, hier wird der wietere Programmverlauf angegeben.
   * 
   * @param args Optionale Startparameter für die Anwendung
   */
  public static void main(String[] args) {

    try {
      // Übergabeparameter setzen
      Main.args = args;
      // Param auf einen Wert prüfen
      if (Main.args.length >= 1 && Main.args[0].equals(S.HELP)) {
        // hilfe aufrufen
      } else if (Main.args.length == 1 && Main.args[0].equals(S.SWING)) {
        // Spiel als JSwing aufrufen
        new SpielController(new SpielModel(), new swing.SpielView());
      } else {
        // Spiel als Konsole aufrufen
        new SpielController(new SpielModel(), new console.SpielView());
      }
    } catch (Exception ex) {
      // Bei Fehlern einen Hinweistext ausgeben
      System.out.println(ex.getMessage());
      System.out.println(S.FEHLER_PROGRAMMSTART);
    }
  }
}
