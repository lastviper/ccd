/**
 * 
 */
package controller;

import model.SpielModel;
import view.ISpielView;
import view.SPIELER_ODER_COMPUTER;

/**
 * Klasse SpielController. In dieser Klasse wird die Logik zw Anzeige und
 * Verarbeitung bereit gestellt
 * 
 * @author Tietz
 *
 */
public class SpielController implements IControllerEventListener {

  /**
   * Anzeige der Spiels
   */
  private ISpielView spielView = null;

  /**
   * Daten und Berechungen vom Spiel
   */
  private SpielModel spielModel = null;

  /**
   * Spiel initialisieren / starten Standardkonstruktor
   * 
   * @param spielModel
   * @param spielView
   */
  public SpielController(SpielModel spielModel, ISpielView spielView) {
    // View bekannt machen
    this.spielView = spielView;
    // Model bekannt machen
    this.spielModel = spielModel;
    // IControllerEventListener in der view bekannt machen
    this.spielView.setIControllerEventListener(this);
    // View zum Spielstart anzeigen
    this.spielView.zeigeStartbildschirm();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void actionListenerAnzahlHoelzerGesetzt() {
    spielerPruefeStartwert();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void actionListenerSpielerNimmtHoelzerGesetzt() {
    spielerPruefeEingabeMindern();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void actionListenerWerSollAnfangenGesetzt() {
    //
    setStartoptionen();
  }

  /**
   * Erster Spielzug, setzen von Anzahl H�lzern
   */
  private void setAnzahlStartHoelzer() {
    // aus der View ermitteln, wer Anfangen soll, Computer oder Spieler
    if (this.spielModel.getAktuellerSpieler().equals(SPIELER_ODER_COMPUTER.COMPUTER)) {
      // Computer soll anfangen
      this.spielModel.computerBerechneHoelzer();
      spielZugEnde();
    } else {
      // Spieler will anfangen
      this.spielView.zeigeEingabeStarthoelzerSetzen();
    }
  }

  /**
   * 
   */
  private void setStartoptionen() {
    // Model initialisieren und Eingabedaten �bermitteln
    this.spielModel.setStartoptionen(this.spielView.getWerIstAmZug());
    // Starth�lzer ermitteln
    this.setAnzahlStartHoelzer();
  }

  /**
   * 
   */
  private void spielerPruefeEingabeMindern() {
    // Dem Model die Anzahl �bergeben und pr�fen
    if (spielModel.spielerEingabe(spielView.getEingabeAnzahl())) {
      // Eingabe korrekt, H�lzer mindern
      spielZugEnde();
    } else {
      // falsche Eingabe f�r Starth�lzer, erneut abfragen
      spielZugWeiter();
    }
  }

  /**
   * 
   */
  private void spielerPruefeStartwert() {
    // Dem Model die Anzahl �bergeben und pr�fen
    if (spielModel.spielerEingabeStartHoelzer(spielView.getEingabeAnzahl())) {
      spielZugEnde();
    } else {
      // falsche Eingabe f�r Starth�lzer, erneut abfragen
      setAnzahlStartHoelzer();
    }
  }

  /**
   * Wir nach beendigung eines Spielzuges aufgerufen aufgerufen werden
   */
  private void spielZugEnde() {
    //
    spielModel.spielZugBeenden();
    //
    if (spielModel.spielEnde()) {
      // Spiel zu ende, Gewinner bekannt geben
      spielView.zeigeEnde(spielModel.getAktuellerSpieler());
    } else {
      // Spiel weiter
      spielZugWeiter();
    }
  }

  /**
   * Spielzug
   */
  private void spielZugWeiter() {
    // wer ist dran
    if (this.spielModel.getAktuellerSpieler().equals(SPIELER_ODER_COMPUTER.COMPUTER)) {
      // Computer zieht
      spielModel.computerVermindereHoelzer();
      spielZugEnde();
    } else {
      // View auffordern, einen Spielerzug zu erlauben
      this.spielView.zeigeEingabeHoelzerZiehen(this.spielModel.restStreichhoelzer());
    }
  }
}
