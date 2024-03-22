package server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Clase que inicia la aplicación del servidor de chat.
         * Configura y muestra las interfaces gráficas del servidor y la ventana de inicio de sesión.
         */
public class ServerLauncher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Configura la interfaz gráfica del formulario del servidor
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ServerForm.fxml"))));
        primaryStage.setTitle("Server");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
        // Configura y muestra la ventana de inicio de sesión
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(primaryStage.getScene().getWindow());
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        stage.setTitle("EChat");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();

    }
}
