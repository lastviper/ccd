/**
 * 
 */
package controller;

/**
 * Interface f�r R�ckgaben der Views (in den Views ActionListener oder
 * Benutzereingaben etc)
 * 
 * @author Tietz
 *
 */
public interface IControllerEventListener {

  /**
   * Wird ausgef�hrt, wenn der Spieler die Anzahl H�lzer festgelegt hat
   */
  public void actionListenerAnzahlHoelzerGesetzt();

  /**
   * Wird ausgef�hrt, wenn der Spieler H�zer weggenommen hat
   */
  public void actionListenerSpielerNimmtHoelzerGesetzt();

  /**
   * Wird ausgef�hrt, wenn der Spieler gew�hlt hat, wer anfangen soll
   */
  public void actionListenerWerSollAnfangenGesetzt();

}
