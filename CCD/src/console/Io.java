/**
 * 
 */
package console;

import java.util.Scanner;

/**
 * IO Methoden für die Konsolen App
 * 
 * @author Tietz
 *
 */
public class Io {
  /**
   * Scanner Variable zum lesen von Kosolen eingaben
   */
  private static Scanner scanner = new Scanner(System.in);

  /**
   * List die Eingabe der Konsole und gibt sie als Sting zurück
   * 
   * @return
   */
  private static String leseEingabe() {
    String temp = scanner.nextLine();
    // Auf abbruch vom Benutzer prüfen
    if (temp.equals(S.QUIT)) {
      // App beenden durch benutzer
      System.out.println(S.ABBRUCH_BENUTZER);
      System.exit(0);
    }
    return temp;
  }

  /**
   * List die Eingabe der Konsole und gibt sie als Int zurück
   * 
   * @return
   */
  static int leseEingabeInt() {
    // Eingabe der Konsole als String ermitteln
    String temp = leseEingabe();
    // variable mit dem Eingabewert
    int eingabe = S.FEHLER_EINGABE_INT;
    // String als int casten
    try {
      eingabe = Integer.parseInt(temp);
    } catch (NumberFormatException ex) {
      // cast fehlerhaft
      System.out.println(S.FEHLER_EINGABE_INTEGER);
    }
    // eingabe ok, wert zurück geben
    return eingabe;
  }

  /**
   * List die Eingabe der Konsole und gibt sie als Sting zurück
   * 
   * @return
   */
  static String leseEingabeString() {
    // eingabe lesen
    String eingabe = leseEingabe();
    // eingabe ok, wert zurück geben
    return eingabe;
  }

}
