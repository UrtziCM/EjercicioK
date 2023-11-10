package application;

import java.io.IOException;

import controller.RelojController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RelojApplication extends Application {

	public void start(Stage stage) throws IOException {
    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/reloj.fxml"));
		Parent root = loader.load();
    	Scene scene = new Scene( root );
        stage.setTitle("Reloj");
        stage.setOnCloseRequest(e -> {
        	((RelojController)loader.getController()).timer.cancel();
        	Platform.exit();
        });
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
		launch(args);
	}
}
