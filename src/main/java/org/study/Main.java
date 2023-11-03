package org.study;


// JavaFX
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


// Main application class
public class Main extends Application {

    // Application start
    @Override
    public void start(Stage stage) throws Exception {
	    // 
        Group root = new Group();
        //
        Scene scene = new Scene(root, 800, 600);
        //
        scene.setFill(Color.WHITE);
        //
        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
        //
        stage.setTitle("SuperPasswordManager");
        //
        stage.setScene(scene);
        //
        stage.show();
    }

    // Main func
    public static void main(String[] args) {
        // Launch app
        launch(args);
    }

}