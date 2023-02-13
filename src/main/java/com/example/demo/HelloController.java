package com.example.demo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button enterButton;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Label dontRightLabel;

    @FXML
    private Label isEmptyLabel;

    @FXML
    void initialize() {

        enterButton.setOnAction(event1 -> {

                if (login.getText().equals("admin") & password.getText().equals("12345")) {
                    enterButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("logic-view.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
                else if (login.getText().isEmpty() | password.getText().isEmpty()) {
                    isEmptyLabel.setTextFill(Color.RED);

                }
                else if (!login.getText().equals("admin") | !password.getText().equals("12345")) {
                    login.clear();
                    password.clear();
                    dontRightLabel.setTextFill(Color.RED);

                }

            });

        }
    }

