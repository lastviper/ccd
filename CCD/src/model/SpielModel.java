/**
 * 
 */
package model;

import view.SPIELER_ODER_COMPUTER;

/**
 * @author bw1tetf0
 *
 */
public class SpielModel {

  private final int MIN_ZUFALL = 1;
  private final int MAX_ZUFALL = 10;

  private final int MIN_WEGNEHMEN = 1;
  private final int MAX_WEGNEHMEN = 3;

  private int restStreichhoelzer = 0;

  private SPIELER_ODER_COMPUTER aktuellerSpieler = null;

  private boolean spielEnde = true;

  /**
   * StreichHölzer berechnen die vom Computer vorgegebenw erden sollen, dies muss
   * n-Faches von min + max wegnehmbaren Hölzern sein. Basis ist eine Ganzzahl
   * zwischen 1 und 10 (default)
   */
  public void computerBerechneHoelzer() {
    restStreichhoelzer = (int) ((Math.random()) * MAX_ZUFALL + MIN_ZUFALL) * (MIN_WEGNEHMEN + MAX_WEGNEHMEN);
  }

  /**
   * 
   */
  public void computerVermindereHoelzer() {
    // restHölzer muss vielfaches von MIN_WEGNEHMEN + MAX_WEGNEHMEN sein
    while (restStreichhoelzer % (MIN_WEGNEHMEN + MAX_WEGNEHMEN) != 0) {
      restStreichhoelzer -= MIN_WEGNEHMEN;
    }
  }

  public SPIELER_ODER_COMPUTER getAktuellerSpieler() {
    return aktuellerSpieler;
  }

  /**
   * minimale Anzahl für Eingabe N vom Spieler
   * 
   * @return
   */
  public int minAnzahl() {
    return 2 * MIN_WEGNEHMEN + MAX_WEGNEHMEN;
  }

  public int restStreichhoelzer() {
    return restStreichhoelzer;
  }

  public void setStartoptionen(SPIELER_ODER_COMPUTER aktuellerSpieler) {
    // Spiel zurück setzen
    this.restStreichhoelzer = 0;
    this.spielEnde = false;
    // wer soll den ersten Zug machen
    this.aktuellerSpieler = aktuellerSpieler;
  }

  public boolean spielEnde() {
    return spielEnde;
  }

  /**
   * 
   * @param vermindernUm
   * @return
   */
  public boolean spielerEingabe(int vermindernUm) {
    if (MIN_WEGNEHMEN <= vermindernUm && vermindernUm <= MAX_WEGNEHMEN) {
      // Eingabe korrekt
      restStreichhoelzer -= vermindernUm;
      return true;
    } else {
      // Eingabe Fehlerhaft
      return false;
    }
  }

  /**
   * 
   * @param spielerSetztN
   * @return
   */
  public boolean spielerEingabeStartHoelzer(int spielerSetztN) {
    //
    restStreichhoelzer = spielerSetztN;
    return (spielerSetztN >= minAnzahl());
  }

  /**
   * Zug beendet, überprüfen ob das Spiel beendet ist Wenn nicht aktuellen Spieler
   * wechseln
   */
  public void spielZugBeenden() {
    // Sind noch Hölzer im Spiel
    if (restStreichhoelzer <= 0) {
      // keine Hölzer mehr im Spiel
      spielEnde = true;
      return;
    } else {
      // prüfen wer am Zug war
      if (aktuellerSpieler.equals(SPIELER_ODER_COMPUTER.SPIELER)) {
        // aktuellen Spieler auf PC setzen
        aktuellerSpieler = SPIELER_ODER_COMPUTER.COMPUTER;
      } else {
        // aktuellen Spieler auf Spieler setzen
        aktuellerSpieler = SPIELER_ODER_COMPUTER.SPIELER;
      }
    }
  }
}
