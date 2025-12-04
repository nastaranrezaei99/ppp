package guiBahnhoefe;

import business.BahnhoeferModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import ownUtil.Observer;

public class MobilitaetsangeboteControl implements Observer {

    private MobilitaetsangeboteView view;
    private BahnhoeferModel model;

    public MobilitaetsangeboteControl(Stage primaryStage) {
        this.model = BahnhoeferModel.getInstance();
        this.view = new MobilitaetsangeboteView(this, primaryStage, model);
        this.model.addObserver(this);      
        initListener();
    }

    private void initListener() {
        view.getBtnAnzeigeBahnhoefe().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                update();              
            }
        });
    }

    @Override
    public void update() {
        if (model.getBahnhof() != null) {
            view.setAnzeigeText(
                    model.getBahnhof().gibBahnhofZurueck(' ')
            );
        } else {
            view.zeigeInformationsfensterAn("Bisher wurde kein Bahnhof aufgenommen!");
        }
    }
}
