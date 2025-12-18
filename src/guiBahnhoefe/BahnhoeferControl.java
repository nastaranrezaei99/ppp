package guiBahnhoefe;

import business.BahnhoeferModel;
import business.Bahnhof;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BahnhoeferControl implements Observer {

    private BahnhoeferView view;
    private BahnhoeferModel model;

    public BahnhoeferControl(Stage primaryStage) {
        this.model = BahnhoeferModel.getInstance();
        this.view = new BahnhoeferView(this, model, primaryStage);
        this.model.addObserver(this);
    }

    void nehmeBahnhofAuf() {
        try {
            Bahnhof b = new Bahnhof(
                    view.getTxtName().getText(),
                    view.getTxtOrt().getText(),
                    Integer.parseInt(view.getTxtAnzahlGleise().getText()),
                    Integer.parseInt(view.getTxtLetzteRenovierung().getText()),
                    view.getTxtZugarten().getText().split(";")
            );

            model.setBahnhof(b);
            view.zeigeInformationsfensterAn("Der Bahnhof wurde aufgenommen!");
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }

    void zeigeBahnhoefeAn() {
        if (model.getBahnhof() != null) {
            view.getTxtAnzeige().setText(model.getBahnhof().gibBahnhofZurueck(' '));
        } else {
            view.zeigeInformationsfensterAn("Bisher wurde kein Bahnhof aufgenommen!");
        }
    }

    void leseAusDatei(String typ) {
        try {
            model.leseAusDatei(typ);
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn("Fehler: Konnte nicht gelesen werden");
        }
    }

    void schreibeBahnhoefeInCsvDatei() {
        try {
            model.schreibeBahnhoefeInCsvDatei();
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn("Fehler: Konnte nicht geschrieben werden");
        }
    }

    @Override
    public void update() {
        zeigeBahnhoefeAn();
    }
}
