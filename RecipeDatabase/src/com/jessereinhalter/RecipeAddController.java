package com.jessereinhalter;

import dbUtil.Datasource;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import recipe.Recipe;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecipeAddController implements Initializable {

    Datasource datasource = new Datasource();
    Recipe recipe = new Recipe();
    private Desktop desktop = Desktop.getDesktop();

    @FXML
    Button uploadImage1Btn;
    @FXML
    Button uploadImage2Btn;
    @FXML
    ImageView imageView1;
    @FXML
    ImageView imageView2;

    @FXML
    EventHandler uploadImage1 = new EventHandler<ActionEvent>() {
        public void handle(final ActionEvent e) {
            FileChooser.ExtensionFilter imageFilter =
                    new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(imageFilter);
            chooser.setTitle("Open File");
            File file = chooser.showOpenDialog(new Stage());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                imageView1.setImage(image);
            }
        }
    };

    @FXML
    EventHandler uploadImage2 = new EventHandler<ActionEvent>() {
        public void handle(final ActionEvent e) {
            FileChooser.ExtensionFilter imageFilter =
                    new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(imageFilter);
            chooser.setTitle("Open File");
            File file = chooser.showOpenDialog(new Stage());
            if (file != null) {
                Image image = new Image(file.toURI().toString());
                imageView2.setImage(image);
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        System.out.println("Launch");
        uploadImage1Btn.setOnAction(uploadImage1);
        uploadImage2Btn.setOnAction(uploadImage2);

    }
}



