package view;

import controller.IControllerEventListener;

/**
 * Interface f�r unterschiedliche Spiele Views
 * 
 * @author Tietz
 *
 */
public interface ISpielView {

  /**
   * Benutzereingabe abfragen
   * 
   * @return
   */
  public int getEingabeAnzahl();

  /**
   * Ermitteln
   * 
   * @return
   */
  public SPIELER_ODER_COMPUTER getWerIstAmZug();

  /**
   * Anzahl der H�lzer an die View �bergeben
   * 
   * @param restStreichhoelzer
   */
  public void setAnzahlHoeler(int restStreichhoelzer);

  public void setIControllerEventListener(IControllerEventListener controller);

  /**
   * View die Info der restliche H�lzer �bergeben und Spieler zur Eingabe der
   * Anzahl der wegzunehmenden H�lzer auffordern
   * 
   * @param restStreichhoelzer
   */
  public void zeigeEingabeHoelzerZiehen(int restStreichhoelzer);

  /**
   * View auffordern, den Spieler die Starth�lzer einzugeben
   */
  public void zeigeEingabeStarthoelzerSetzen();

  /**
   * View Gewinnerbildschirm anzeigen
   * 
   * @param werHatGewonnen
   */
  public void zeigeEnde(SPIELER_ODER_COMPUTER werHatGewonnen);

  /**
   * Spiel Anzeige aufrufen, GUIs, Konsole ...
   */
  public void zeigeStartbildschirm();

}
