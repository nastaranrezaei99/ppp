package guiBahnhoefe;

import business.BahnhoeferModel;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class BahnhoeferView {

    private BahnhoeferControl coltrol;
    private BahnhoeferModel model;
    private Stage stage;

    Pane pane = new Pane();
    Label lblEingabe = new Label("Eingabe");
    Label lblAnzeige = new Label("Anzeige");
    Label lblName = new Label("Name:");
    Label lblOrt = new Label("Ort:");
    Label lblAnzahlGleise = new Label("AnzahlGleise:");
    Label lblLetzteRenovierung = new Label("Letzte Renovierung:");
    Label lblZugarten = new Label("Zugarten:");
    TextField txtName = new TextField();
    TextField txtOrt = new TextField();
    TextField txtAnzahlGleise = new TextField();
    TextField txtLetzteRenovierung = new TextField();
    TextField txtZugarten = new TextField();
    TextArea txtAnzeige = new TextArea();
    Button btnEingabe = new Button("Eingabe");
    Button btnAnzeige = new Button("Anzeige");
    MenuBar mnbrMenuLeiste = new MenuBar();
    Menu mnDatei = new Menu("Datei");
    MenuItem mnItmCsvImport = new MenuItem("csv-Import");
    MenuItem mnItmTxtImport = new MenuItem("txt-Import");
    MenuItem mnItmCsvExport = new MenuItem("csv-Export");

    public BahnhoeferView(BahnhoeferControl control, BahnhoeferModel model, Stage primaryStage) {
        this.coltrol = control;
        this.model = model;

        Scene scene = new Scene(this.pane, 700, 340);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Verwaltung von Bahnhoefen");
        primaryStage.show();

        this.stage = primaryStage;
        this.initKomponenten();
    }

    private void initKomponenten() {

        lblEingabe.setLayoutX(20);
        lblEingabe.setLayoutY(40);
        Font font = new Font("Arial", 24);
        lblEingabe.setFont(font);
        lblEingabe.setStyle("-fx-font-weight: bold;");
        lblAnzeige.setLayoutX(400);
        lblAnzeige.setLayoutY(40);
        lblAnzeige.setFont(font);
        lblAnzeige.setStyle("-fx-font-weight: bold;");
        lblName.setLayoutX(20);
        lblName.setLayoutY(90);
        lblOrt.setLayoutX(20);
        lblOrt.setLayoutY(130);
        lblAnzahlGleise.setLayoutX(20);
        lblAnzahlGleise.setLayoutY(170);
        lblLetzteRenovierung.setLayoutX(20);
        lblLetzteRenovierung.setLayoutY(210);
        lblZugarten.setLayoutX(20);
        lblZugarten.setLayoutY(250);
        pane.getChildren().addAll(lblEingabe, lblAnzeige, lblName, lblOrt,
                lblAnzahlGleise, lblLetzteRenovierung, lblZugarten);

        txtName.setLayoutX(170);
        txtName.setLayoutY(90);
        txtName.setPrefWidth(200);
        txtOrt.setLayoutX(170);
        txtOrt.setLayoutY(130);
        txtOrt.setPrefWidth(200);
        txtAnzahlGleise.setLayoutX(170);
        txtAnzahlGleise.setLayoutY(170);
        txtAnzahlGleise.setPrefWidth(200);
        txtLetzteRenovierung.setLayoutX(170);
        txtLetzteRenovierung.setLayoutY(210);
        txtLetzteRenovierung.setPrefWidth(200);
        txtZugarten.setLayoutX(170);
        txtZugarten.setLayoutY(250);
        txtZugarten.setPrefWidth(200);
        pane.getChildren().addAll(txtName, txtOrt, txtAnzahlGleise,
                txtLetzteRenovierung, txtZugarten);

        txtAnzeige.setEditable(false);
        txtAnzeige.setLayoutX(400);
        txtAnzeige.setLayoutY(90);
        txtAnzeige.setPrefWidth(270);
        txtAnzeige.setPrefHeight(185);
        pane.getChildren().add(txtAnzeige);

        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige);

        mnbrMenuLeiste.getMenus().add(mnDatei);
        mnDatei.getItems().add(mnItmCsvImport);
        mnDatei.getItems().add(mnItmTxtImport);
        mnDatei.getItems().add(new SeparatorMenuItem());
        mnDatei.getItems().add(mnItmCsvExport);
        pane.getChildren().add(mnbrMenuLeiste);
    }

    void zeigeInformationsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.INFORMATION,
                "Information", meldung).zeigeMeldungsfensterAn();
    }

    void zeigeFehlermeldungsfensterAn(String meldung) {
        new MeldungsfensterAnzeiger(AlertType.ERROR,
                "Fehler", meldung).zeigeMeldungsfensterAn();
    }
}
