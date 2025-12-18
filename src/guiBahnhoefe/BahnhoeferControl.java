package guiBahnhoefe;

import business.BahnhoeferModel;
import business.Bahnhof;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BahnhoeferControl implements Observer {

    private BahnhoeferView view;
    private BahnhoeferModel model;

    public BahnhoeferControl(Stage primaryStage) {
        this.model = BahnhoeferModel.getInstance();
        this.view = new BahnhoeferView(this, model, primaryStage);
        this.model.addObserver(this);       
        this.initListener();
    }

    private void nehmeBahnhofAuf() {
        try {
            model.setBahnhof(new Bahnhof(
                    view.txtName.getText(),
                    view.txtOrt.getText(),
                    Integer.parseInt(view.txtAnzahlGleise.getText()),
                    Integer.parseInt(view.txtLetzteRenovierung.getText()),
                    view.txtZugarten.getText().split(";")));
            view.zeigeInformationsfensterAn("Der Bahnhof wurde aufgenommen!");
        } catch (Exception exc) {
            view.zeigeFehlermeldungsfensterAn(exc.getMessage());
        }
    }

    void zeigeBahnhoefeAn() {
        if (model.getBahnhof() != null) {
            view.txtAnzeige.setText(model.getBahnhof().gibBahnhofZurueck(' '));
        } else {
            view.zeigeInformationsfensterAn("Bisher wurde keine Bahnhof aufgenommen!");
        }
    }

    private void initListener() {
        view.btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                nehmeBahnhofAuf();
            }
        });
        view.btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                zeigeBahnhoefeAn();  
            }
        });
        view.mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    model.leseAusDatei("csv");
                } catch (Exception e1) {
                    view.zeigeFehlermeldungsfensterAn("Fehler: Konnte nicht gelesen werden");
                }
            }
        });
        view.mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    model.leseAusDatei("txt");
                } catch (Exception e2) {
                    view.zeigeFehlermeldungsfensterAn("Fehler: Konnte nicht gelesen werden");
                }
            }
        });
        view.mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try {
                    model.schreibeBahnhoefeInCsvDatei();
                } catch (Exception e3) {
                    view.zeigeFehlermeldungsfensterAn("Fehler: Konnte nicht geschrieben werden");
                }
            }
        });
    }

    @Override
    public void update() {
  
        zeigeBahnhoefeAn();
    }
}
