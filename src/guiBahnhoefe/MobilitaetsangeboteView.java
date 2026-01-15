package guiBahnhoefe;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import business.BahnhoeferModel;
import business.CModel;
import business.Carsharing;
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
    private CModel cModel;
    private Pane pane = new Pane();

    private Label lblAnzeigeBahnhoefe = new Label("Anzeige Bahnhoefe");
    private TextArea txtAnzeigeBahnhoefe = new TextArea();
    private Button btnAnzeigeBahnhoefe = new Button("Anzeige");

    private Label lblAnzeigeBahnhoefeCar = new Label("Anzeige Carsharing");
    private TextArea txtAnzeigeBahnhoefeCar = new TextArea();
    private Button btnAnzeigeBahnhoefeCar = new Button("Anzeige");

    private MenuBar mnbrMenuLeiste = new MenuBar();
    private Menu mnDatei = new Menu("Datei");
    private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport = new MenuItem("txt-Import");

    public MobilitaetsangeboteView(
            MobilitaetsangeboteControl mobilitaetsangeboteControl,
            Stage primaryStage,
            BahnhoeferModel bahnhoefeModel,
            CModel cModel) {

        this.cModel = cModel;
        this.mobilitaetsangeboteControl = mobilitaetsangeboteControl;
        this.bahnhoefeModel = bahnhoefeModel;
        this.stage = primaryStage;

        Scene scene = new Scene(this.pane, 560, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Anzeige von Mobilitaetsangeboten");
        primaryStage.show();

        initMenue();
        initKomponentenBahnhoefer();
        initKomponentenOnline();
        initListenerOnline();
    }

    private void initMenue() {
        mnbrMenuLeiste.setLayoutX(0);
        mnbrMenuLeiste.setLayoutY(0);
        mnbrMenuLeiste.setPrefWidth(560);

        mnDatei.getItems().add(mnItmCsvImport);
        mnDatei.getItems().add(mnItmTxtImport);
        mnDatei.getItems().add(new SeparatorMenuItem());
        mnbrMenuLeiste.getMenus().add(mnDatei);

        pane.getChildren().add(mnbrMenuLeiste);

        mnItmCsvImport.setOnAction(e ->
                mobilitaetsangeboteControl.leseCarsharingAusCsvDatei()
        );

        mnItmTxtImport.setOnAction(e ->
                mobilitaetsangeboteControl.leseAusDatei("txt")
        );
    }

    private void initKomponentenBahnhoefer() {
        Font font = new Font("Arial", 18);

        lblAnzeigeBahnhoefe.setLayoutX(40);
        lblAnzeigeBahnhoefe.setLayoutY(50);
        lblAnzeigeBahnhoefe.setFont(font);
        lblAnzeigeBahnhoefe.setStyle("-fx-font-weight: bold;");

        txtAnzeigeBahnhoefe.setEditable(false);
        txtAnzeigeBahnhoefe.setLayoutX(40);
        txtAnzeigeBahnhoefe.setLayoutY(90);
        txtAnzeigeBahnhoefe.setPrefWidth(220);
        txtAnzeigeBahnhoefe.setPrefHeight(185);

        btnAnzeigeBahnhoefe.setLayoutX(40);
        btnAnzeigeBahnhoefe.setLayoutY(290);

        pane.getChildren().addAll(
                lblAnzeigeBahnhoefe,
                txtAnzeigeBahnhoefe,
                btnAnzeigeBahnhoefe
        );
    }

    private void initKomponentenOnline() {
        Font font = new Font("Arial", 18);

        lblAnzeigeBahnhoefeCar.setLayoutX(310);
        lblAnzeigeBahnhoefeCar.setLayoutY(50);
        lblAnzeigeBahnhoefeCar.setFont(font);
        lblAnzeigeBahnhoefeCar.setStyle("-fx-font-weight: bold;");

        txtAnzeigeBahnhoefeCar.setEditable(false);
        txtAnzeigeBahnhoefeCar.setLayoutX(310);
        txtAnzeigeBahnhoefeCar.setLayoutY(90);
        txtAnzeigeBahnhoefeCar.setPrefWidth(220);
        txtAnzeigeBahnhoefeCar.setPrefHeight(185);

        btnAnzeigeBahnhoefeCar.setLayoutX(310);
        btnAnzeigeBahnhoefeCar.setLayoutY(290);

        pane.getChildren().addAll(
                lblAnzeigeBahnhoefeCar,
                txtAnzeigeBahnhoefeCar,
                btnAnzeigeBahnhoefeCar
        );
    }

    
    
    private void initListenerOnline() {
        btnAnzeigeBahnhoefeCar.setOnAction(e -> zeigeCarsharingAn());
    }
    
    
    

    private void zeigeCarsharingAn() {
        mobilitaetsangeboteControl.leseCarsharingAusCsvDatei();

        if (cModel.getCModel() != null && !cModel.getCModel().isEmpty()) {
            StringBuffer text = new StringBuffer();
            for (Carsharing sh : cModel.getCModel()) {
                text.append(sh.gibCarsharingZurueck(' ')).append("\n");
            }
            txtAnzeigeBahnhoefeCar.setText(text.toString());
        } else {
            zeigeInformationsfensterAn(
                    "Es gibt keine Carsharing in der csv-Datei!"
            );
        }
    }

    void setAnzeigeTextOnline(String text) {
        txtAnzeigeBahnhoefeCar.setText(text);
    }

    void setAnzeigeText(String text) {
        txtAnzeigeBahnhoefe.setText(text);
    }

    void zeigeFehlermeldungsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(
                AlertType.ERROR,
                "Fehler",
                meldung
        ).zeigeMeldungsfensterAn();
    }

    void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(
                AlertType.INFORMATION,
                "Information",
                meldung
        ).zeigeMeldungsfensterAn();
    }
}
