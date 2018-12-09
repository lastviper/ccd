/**
 * 
 */
package swing;

import controller.IControllerEventListener;
import view.ISpielView;
import view.SPIELER_ODER_COMPUTER;

/**
 * @author bw1tetf0
 *
 */
public class SpielView implements ISpielView {

  /**
   * Standardkonstruktor für die Spiele View
   */
  public SpielView() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public int getEingabeAnzahl() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public SPIELER_ODER_COMPUTER getWerIstAmZug() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setAnzahlHoeler(int restStreichhoelzer) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setIControllerEventListener(IControllerEventListener controller) {
    // TODO Auto-generated method stub

  }

  @Override
  public void zeigeEingabeHoelzerZiehen(int restStreichhoelzer) {
    // TODO Auto-generated method stub

  }

  @Override
  public void zeigeEingabeStarthoelzerSetzen() {
    // TODO Auto-generated method stub

  }

  @Override
  public void zeigeEnde(SPIELER_ODER_COMPUTER werHatGewonnen) {
    // TODO Auto-generated method stub

  }

  @Override
  public void zeigeStartbildschirm() {
    // TODO Auto-generated method stub

  }

}
