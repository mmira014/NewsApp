package versionTrevor;
//import java.sql.Date; //might use this later 
import java.util.Collections;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class NewsAppMain extends Application
{ 
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("template.fxml"));
        
        System.out.println("loaded template.fxml");
        Scene scene = new Scene(root);
        stage.setTitle("Positive News App");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
	

}
