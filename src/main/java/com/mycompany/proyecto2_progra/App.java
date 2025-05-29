package com.mycompany.proyecto2_progra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carga el FXML principal
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/fxml/MainView.fxml")
        );
        Scene scene = new Scene(loader.load());
        // (Opcional) Aplica tu hoja de estilos
        scene.getStylesheets().add(
            getClass().getResource("/app.css").toExternalForm()
        );
        primaryStage.setTitle("Museo Management App");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}