package test.oauh.cz.javafxaplikace;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    TextField login;
    @FXML
    TextField password;
    @FXML
    protected void login() throws IOException {
        if("a".equals(login.getText()) && "a".equals(password.getText())){
           HelloApplication h = new HelloApplication();
            h.start(stage);
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        Login.stage = stage;
        stage.setScene(scene);
        stage.show();
    }
}
