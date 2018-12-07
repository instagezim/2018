package view;

import javafx.scene.image.*;
import java.net.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import java.lang.*;
import javafx.scene.layout.*;
import javafx.scene.layout.AnchorPane;

public abstract class LoginViewBase extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label label;
    protected final TextField usernameField;
    protected final Label label0;
    protected final PasswordField passwordField;
    protected final HBox hBox;
    protected final Button button;
    protected final Button button0;
    protected final ImageView imageView;
    protected final HBox hBox0;
    protected final Hyperlink hyperlink;
    protected final Hyperlink hyperlink0;

    public LoginViewBase() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        label = new Label();
        usernameField = new TextField();
        label0 = new Label();
        passwordField = new PasswordField();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();
        imageView = new ImageView();
        hBox0 = new HBox();
        hyperlink = new Hyperlink();
        hyperlink0 = new Hyperlink();

        setMaxHeight(Double.MAX_VALUE);
        setMaxWidth(Double.MAX_VALUE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(535.0);
        setPrefWidth(454.0);
        getStylesheets().add("/view/../../../classlist/src/view/style.css");

        AnchorPane.setLeftAnchor(gridPane, 116.0);
        gridPane.setAlignment(javafx.geometry.Pos.CENTER);
        gridPane.setLayoutX(116.0);
        gridPane.setLayoutY(302.0);
        gridPane.setMaxHeight(USE_PREF_SIZE);
        gridPane.setMaxWidth(USE_PREF_SIZE);
        gridPane.setMinHeight(USE_PREF_SIZE);
        gridPane.setMinWidth(USE_PREF_SIZE);
        gridPane.setPrefHeight(169.0);
        gridPane.setPrefWidth(196.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label.getStyleClass().add("labelLogin");
        label.getStylesheets().add("/view/style.css");
        label.setText("Benutzername:");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#7ec0ee"));

        GridPane.setRowIndex(usernameField, 1);
        usernameField.getStyleClass().add("usernameField");
        usernameField.getStylesheets().add("/view/../../../MajestyGame/src/view/style.css");

        GridPane.setRowIndex(label0, 2);
        label0.getStyleClass().add("labelLogin");
        label0.getStylesheets().add("/view/style.css");
        label0.setText("Passwort:");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#7ec0ee"));

        GridPane.setRowIndex(passwordField, 3);
        passwordField.setStyle(": ;");
        passwordField.getStyleClass().add("passwordField");
        passwordField.getStylesheets().add("/view/../../../MajestyGame/src/view/style.css");

        GridPane.setRowIndex(hBox, 5);
        hBox.setMaxHeight(USE_PREF_SIZE);
        hBox.setMaxWidth(USE_PREF_SIZE);
        hBox.setMinHeight(USE_PREF_SIZE);
        hBox.setMinWidth(USE_PREF_SIZE);
        hBox.setPrefHeight(30.0);
        hBox.setPrefWidth(197.0);
        hBox.setSpacing(25.0);

        button.setMnemonicParsing(false);
        button.setOnAction(this::exitButton);
        button.setStyle(": ;");
        button.getStylesheets().add("/view/../../../MajestyGame/src/view/style.css");
        button.setText("Schliessen");
        button.setTextFill(javafx.scene.paint.Color.WHITE);

        button0.setMnemonicParsing(false);
        button0.setOnAction(this::loginButton);
        button0.setPrefHeight(27.0);
        button0.setPrefWidth(86.0);
        button0.getStylesheets().add("/view/../../../MajestyGame/src/view/style.css");
        button0.setText("Anmelden");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);
        hBox.setOpaqueInsets(new Insets(0.0));

        imageView.setFitHeight(266.0);
        imageView.setFitWidth(469.0);
        imageView.setLayoutY(-1.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../../../../../Desktop/FHNW/4_Sem/IT_Projekt/Mockup_LOGin/Majesty-cover.jpg").toExternalForm()));

        hBox0.setLayoutX(312.0);
        hBox0.setLayoutY(494.0);
        hBox0.setPrefHeight(27.0);
        hBox0.setPrefWidth(128.0);

        hyperlink.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        hyperlink.setOnAction(this::registrierenButton);
        hyperlink.setText("Registrieren");
        hyperlink.setUnderline(true);

        hyperlink0.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        hyperlink0.setOnAction(this::hilfeButton);
        hyperlink0.setText("Hilfe");
        hyperlink0.setUnderline(true);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getChildren().add(label);
        gridPane.getChildren().add(usernameField);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(passwordField);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        gridPane.getChildren().add(hBox);
        getChildren().add(gridPane);
        getChildren().add(imageView);
        hBox0.getChildren().add(hyperlink);
        hBox0.getChildren().add(hyperlink0);
        getChildren().add(hBox0);

    }

    protected abstract void exitButton(javafx.event.ActionEvent actionEvent);

    protected abstract void loginButton(javafx.event.ActionEvent actionEvent);

    protected abstract void registrierenButton(javafx.event.ActionEvent actionEvent);

    protected abstract void hilfeButton(javafx.event.ActionEvent actionEvent);

}
