package client;

import controller.ClientFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Clase principal que lanza la aplicación del cliente de chat.
 * Configura y muestra las interfaces gráficas de inicio de sesión y la sala de chat.
 */
public class ClientLauncher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/ClientForm.fxml"));
        ClientFormController controller = new ClientFormController();
        fxmlLoader.setController(controller);
        primaryStage.setScene(new Scene(fxmlLoader.load()));

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
