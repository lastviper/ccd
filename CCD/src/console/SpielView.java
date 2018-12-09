/**
 * 
 */
package console;

import controller.IControllerEventListener;
import view.ISpielView;
import view.SPIELER_ODER_COMPUTER;

/**
 * @author bw1tetf0
 *
 */
public class SpielView implements ISpielView {

  /**
   * Variable wer am Zug ist
   */
  private SPIELER_ODER_COMPUTER werIstAmZug = null;
  /**
   * Variable f�r Anzahl H�lzer
   */
  private int eingabeHoelzer = 0;
  /**
   * 
   */
  private IControllerEventListener eventListener = null;

  /**
   * {@inheritDoc}
   */
  @Override
  public int getEingabeAnzahl() {
    return eingabeHoelzer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public SPIELER_ODER_COMPUTER getWerIstAmZug() {
    // R�ckgabe wer Beginnen soll
    return werIstAmZug;
  }

  /**
   * {@inheritDoc} Zeigt die Anzahl der H�lzer auf der Konsole an
   */
  @Override
  public void setAnzahlHoeler(int restStreichhoelzer) {
    System.out.println(S.PC_FAENGT_AN + Integer.toString(restStreichhoelzer));
    eventListener.actionListenerSpielerNimmtHoelzerGesetzt();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setIControllerEventListener(IControllerEventListener controller) {
    this.eventListener = controller;
  }

  /**
   * Methode zum ermitteln wer anfangen soll
   */
  private void werFaengtAn() {
    // abfrage wer anf�ngt
    System.out.println(S.WER_FAENGT_AN);

    // r�ckgabe scan
    String eingabe = Io.leseEingabeString();

    // Eingabe auswerten
    werIstAmZug = eingabe.equals(S.SPIELER) ? SPIELER_ODER_COMPUTER.SPIELER : SPIELER_ODER_COMPUTER.COMPUTER;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void zeigeEingabeHoelzerZiehen(int restStreichhoelzer) {
    // Aktuelle H�lzeranzahl zeigen
    System.out.println(S.SPIELER_INFO_ANZAHL_HOELZER + Integer.toString(restStreichhoelzer));
    // Spieler gibt die Anzahl der H�lzer ein die abgezogen werden
    System.out.println(S.SPIELER_EINGABE_ABZIEHEN);
    // Anzahl der H�lzer abfragen
    eingabeHoelzer = Io.leseEingabeInt();
    // Controller Methode als ActionListener ersatz aufrufen
    eventListener.actionListenerSpielerNimmtHoelzerGesetzt();
  }

  /**
   * {@inheritDoc}
   * 
   */
  @Override
  public void zeigeEingabeStarthoelzerSetzen() {
    // Spieler muss die Anzahl der H�lzer setzen
    System.out.println(S.SPIELER_FAENGT_AN);
    // Eingabe der H�lzer abfragen
    eingabeHoelzer = Io.leseEingabeInt();
    // Controller Methode als ActionListener ersatz aufrufen
    eventListener.actionListenerAnzahlHoelzerGesetzt();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void zeigeEnde(SPIELER_ODER_COMPUTER werHatGewonnen) {
    switch (werHatGewonnen) {
    case SPIELER:
      System.out.println(S.SPIELER_GEWONNEN);
      break;
    case COMPUTER:
      System.out.println(S.COMPUTER_GEWONNEN);
      break;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void zeigeStartbildschirm() {
    // ausgabe initialisieren (haha Konsole) neues spiel
    System.out.println(S.SPIEL_START);

    // Ermitteln wer anfangen soll
    werFaengtAn();

    // Controller Methode als ActionListener ersatz aufrufen
    eventListener.actionListenerWerSollAnfangenGesetzt();
  }

}
