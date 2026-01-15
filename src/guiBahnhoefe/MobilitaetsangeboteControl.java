package guiBahnhoefe;

import java.io.IOException;
import business.BahnhoeferModel;
import business.CModel;
import business.Carsharing;
import javafx.stage.Stage;
import ownUtil.Observable;
import ownUtil.Observer;

public class MobilitaetsangeboteControl implements Observer {

    private MobilitaetsangeboteView view;
    private BahnhoeferModel model;
    private CModel cModel;

    public MobilitaetsangeboteControl(Stage primaryStage) {
        this.model = BahnhoeferModel.getInstance();
        this.cModel = CModel.getInstance();

        this.view = new MobilitaetsangeboteView(
                this,
                primaryStage,
                model,
                cModel
        );

        model.addObserver(this);
        cModel.addObserver(this);
    }

    public void leseCarsharingAusCsvDatei() {
        try {
            cModel.leseCarsharingAusCsvDatei();
        } catch (IOException e) {
            view.zeigeInformationsfensterAn(
                    "IOException beim Lesen von Carsharing"
            );
        } catch (Exception e) {
            view.zeigeInformationsfensterAn(
                    "Unbekannter Fehler beim Lesen von Carsharing"
            );
        }
    }

    public void leseAusDatei(String typ) {
        
    }

    @Override
    public void update(Observable obs) {
        if (model.getBahnhof() != null) {
            view.setAnzeigeText(
                    model.getBahnhof().gibBahnhofZurueck(' ')
            );
        } else {
            view.zeigeInformationsfensterAn(
                    "Bisher wurde kein Bahnhof aufgenommen!"
            );
        }
    }
}
