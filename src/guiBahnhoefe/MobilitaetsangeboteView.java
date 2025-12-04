package guiBahnhoefe;

import business.BahnhoeferModel;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class MobilitaetsangeboteView {

    private MobilitaetsangeboteControl mobilitaetsangeboteControl;
    private Stage stage;
    private BahnhoeferModel bahnhoefeModel;

    private Pane pane = new Pane();
    private Label lblAnzeigeBahnhoefe = new Label("Anzeige Bahnhoefe");
    private TextArea txtAnzeigeBahnhoefe = new TextArea();
    private Button btnAnzeigeBahnhoefe = new Button("Anzeige");

    public MobilitaetsangeboteView(
            MobilitaetsangeboteControl mobilitaetsangeboteControl,
            Stage primaryStage,
            BahnhoeferModel bahnhoefeModel) {

        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Anzeige von Mobilitaetsangeboten");
        primaryStage.show();

        this.mobilitaetsangeboteControl = mobilitaetsangeboteControl;
        this.bahnhoefeModel = bahnhoefeModel;
        this.stage = primaryStage;

        initKomponenten();
    }

    private void initKomponenten() {
        Font font = new Font("Arial", 20);
        lblAnzeigeBahnhoefe.setLayoutX(310);
        lblAnzeigeBahnhoefe.setLayoutY(40);
        lblAnzeigeBahnhoefe.setFont(font);
        lblAnzeigeBahnhoefe.setStyle("-fx-font-weight: bold;");
        pane.getChildren().add(lblAnzeigeBahnhoefe);

        txtAnzeigeBahnhoefe.setEditable(false);
        txtAnzeigeBahnhoefe.setLayoutX(310);
        txtAnzeigeBahnhoefe.setLayoutY(90);
        txtAnzeigeBahnhoefe.setPrefWidth(220);
        txtAnzeigeBahnhoefe.setPrefHeight(185);
        pane.getChildren().add(txtAnzeigeBahnhoefe);

        btnAnzeigeBahnhoefe.setLayoutX(310);
        btnAnzeigeBahnhoefe.setLayoutY(290);
        pane.getChildren().add(btnAnzeigeBahnhoefe);
    }

    
    Button getBtnAnzeigeBahnhoefe() {
        return btnAnzeigeBahnhoefe;
    }

    void setAnzeigeText(String text) {
        txtAnzeigeBahnhoefe.setText(text);
    }

    void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(
                AlertType.INFORMATION,
                "Information",
                meldung
        ).zeigeMeldungsfensterAn();
    }
}
