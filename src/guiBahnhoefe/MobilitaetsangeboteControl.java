package guiBahnhoefe;

import business.BahnhoeferModel;
import business.Bahnhof;
import javafx.stage.Stage;
import ownUtil.Observer;

public class MobilitaetsangeboteControl implements Observer {

    private MobilitaetsangeboteView view;
    private BahnhoeferModel model;

    public MobilitaetsangeboteControl(Stage primaryStage) {
        this.model = BahnhoeferModel.getInstance();
        this.view = new MobilitaetsangeboteView(this, primaryStage, model);
        this.model.addObserver(this);
    }

    void zeigeBahnhoefeAn() {
        String text = "";

        if (model.getBahnhof() != null && model.getBahnhof().size() > 0) {
            for (int i = 0; i < model.getBahnhof().size(); i++) {
                Bahnhof b = (Bahnhof) model.getBahnhof().get(i);
                text = text + b.gibBahnhofZurueck(' ') + "\n";
            }
            view.setAnzeigeText(text);
        } else {
            view.zeigeInformationsfensterAn("Bisher wurde kein Bahnhof aufgenommen!");
        }
    }

    @Override
    public void update() {
        zeigeBahnhoefeAn();
    }
}


