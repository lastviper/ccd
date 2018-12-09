/**
 * 
 */
package controller;

/**
 * Interface für Rückgaben der Views (in den Views ActionListener oder
 * Benutzereingaben etc)
 * 
 * @author Tietz
 *
 */
public interface IControllerEventListener {

  /**
   * Wird ausgeführt, wenn der Spieler die Anzahl Hölzer festgelegt hat
   */
  public void actionListenerAnzahlHoelzerGesetzt();

  /**
   * Wird ausgeführt, wenn der Spieler Hözer weggenommen hat
   */
  public void actionListenerSpielerNimmtHoelzerGesetzt();

  /**
   * Wird ausgeführt, wenn der Spieler gewählt hat, wer anfangen soll
   */
  public void actionListenerWerSollAnfangenGesetzt();

}
