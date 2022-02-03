/*
 * Copyright (c) 2019.
 *
 *  /*
 *  Nour El Houda Tine.
 *  tinenourelhouda@gmail.com
 *  *  All Rights Reserved.
 *  *
 *  * NOTICE:  All information contained herein is, and remains
 *  * the property of Nour El Houda Tine,
 *  * The intellectual and technical concepts contained
 *  * herein are proprietary to Nour El Houda Tine
 *  * and its suppliers and may be covered by U.S. and Foreign Patents,
 *  * patents in process, and are protected by trade secret or copyright law.
 *  * Dissemination of this information or reproduction of this material
 *  * is strictly forbidden unless prior written permission is obtained
 *
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Suroban extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //View __ the settings
        FXMLLoader start_loader = new FXMLLoader((getClass().getClassLoader().getResource("View/start.fxml")));
        Parent start = start_loader.load();
        primaryStage.getIcons().add(new Image("icons/abacus.ico"));
        primaryStage.setTitle("Suroban");
        primaryStage.setScene(new Scene(start));
        primaryStage.show();

        primaryStage.setOnCloseRequest( event -> {
            Platform.exit();
            System.exit(0);
        });

    }
}
