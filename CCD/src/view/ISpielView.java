package view;

import controller.IControllerEventListener;

/**
 * Interface für unterschiedliche Spiele Views
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
   * Anzahl der Hölzer an die View übergeben
   * 
   * @param restStreichhoelzer
   */
  public void setAnzahlHoeler(int restStreichhoelzer);

  public void setIControllerEventListener(IControllerEventListener controller);

  /**
   * View die Info der restliche Hölzer übergeben und Spieler zur Eingabe der
   * Anzahl der wegzunehmenden Hölzer auffordern
   * 
   * @param restStreichhoelzer
   */
  public void zeigeEingabeHoelzerZiehen(int restStreichhoelzer);

  /**
   * View auffordern, den Spieler die StartHölzer einzugeben
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
