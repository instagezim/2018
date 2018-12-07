package view;

import javafx.scene.text.*;
import javafx.scene.control.*;
import java.lang.*;
import javafx.scene.layout.*;
import javafx.scene.layout.AnchorPane;

public abstract class NewPlayerViewBase extends AnchorPane {

    protected final Region region;
    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final TextField matrikelnummerField;
    protected final PasswordField passwordField;
    protected final PasswordField passwordField0;
    protected final HBox hBox;
    protected final Button button;
    protected final Button button0;

    public NewPlayerViewBase() {

        region = new Region();
        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        matrikelnummerField = new TextField();
        passwordField = new PasswordField();
        passwordField0 = new PasswordField();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();

        AnchorPane.setTopAnchor(region, 0.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(406.0);

        AnchorPane.setLeftAnchor(region, 0.0);
        AnchorPane.setTopAnchor(region, 0.0);
        region.setMaxHeight(USE_PREF_SIZE);
        region.setMaxWidth(USE_PREF_SIZE);
        region.setMinHeight(USE_PREF_SIZE);
        region.setMinWidth(USE_PREF_SIZE);
        region.setPrefHeight(56.0);
        region.setPrefWidth(406.0);
        region.getStyleClass().add("regione");
        region.getStylesheets().add("/view/style.css");

        AnchorPane.setLeftAnchor(label, 20.0);
        AnchorPane.setTopAnchor(label, 20.0);
        label.setLayoutX(49.0);
        label.setLayoutY(20.0);
        label.setMaxHeight(USE_PREF_SIZE);
        label.setMaxWidth(USE_PREF_SIZE);
        label.setMinHeight(USE_PREF_SIZE);
        label.setMinWidth(USE_PREF_SIZE);
        label.setPrefHeight(30.0);
        label.setPrefWidth(300.0);
        label.getStyleClass().add("labelWindowTitle");
        label.getStylesheets().add("/view/style.css");
        label.setText("Neuer Spieler");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 20.0));

        AnchorPane.setBottomAnchor(gridPane, 164.0);
        AnchorPane.setLeftAnchor(gridPane, 25.0);
        gridPane.setLayoutX(25.0);
        gridPane.setLayoutY(107.0);
        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(129.0);
        gridPane.setPrefWidth(300.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(200.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label0.setText("Benutzername");

        GridPane.setRowIndex(label1, 1);
        label1.setText("Passwort");

        GridPane.setRowIndex(label2, 2);
        label2.setText("Passwort");

        GridPane.setColumnIndex(matrikelnummerField, 1);
        matrikelnummerField.setPrefHeight(27.0);
        matrikelnummerField.setPrefWidth(155.0);

        GridPane.setColumnIndex(passwordField, 1);
        GridPane.setRowIndex(passwordField, 1);

        GridPane.setColumnIndex(passwordField0, 1);
        GridPane.setRowIndex(passwordField0, 2);

        AnchorPane.setBottomAnchor(hBox, 20.0);
        AnchorPane.setRightAnchor(hBox, 20.0);
        hBox.setLayoutX(244.0);
        hBox.setLayoutY(355.0);
        hBox.setMaxHeight(USE_PREF_SIZE);
        hBox.setMaxWidth(USE_PREF_SIZE);
        hBox.setMinHeight(USE_PREF_SIZE);
        hBox.setMinWidth(USE_PREF_SIZE);
        hBox.setPrefHeight(25.0);
        hBox.setPrefWidth(191.0);
        hBox.setSpacing(20.0);

        button.setMnemonicParsing(false);
        button.setOnAction(this::handleAbbrechen);
        button.setStyle("-fx-background-color: #7EC0EE;");
        button.getStyleClass().add("style.css");
        button.setText("Abbrechen");
        button.setTextFill(javafx.scene.paint.Color.WHITE);

        button0.setMnemonicParsing(false);
        button0.setOnAction(this::handleBestaetitung);
        button0.setStyle("-fx-background-color: #7EC0EE;");
        button0.setText("Bestätigen");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);

        getChildren().add(region);
        getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(matrikelnummerField);
        gridPane.getChildren().add(passwordField);
        gridPane.getChildren().add(passwordField0);
        getChildren().add(gridPane);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        getChildren().add(hBox);

    }

    protected abstract void handleAbbrechen(javafx.event.ActionEvent actionEvent);

    protected abstract void handleBestaetitung(javafx.event.ActionEvent actionEvent);

}
