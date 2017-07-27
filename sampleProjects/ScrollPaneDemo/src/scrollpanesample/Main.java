package scrollpanesample;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Main extends Application {
 
    final ScrollPane sp = new ScrollPane();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();
    final Label fileName = new Label();
    final String [] imageNames = new String [] {"/fw1.jpg", "/fw2.jpg",
        "/fw3.jpg", "/fw4.jpg", "/fw5.jpg"};
 
    @Override
    public void start(Stage stage) {
        VBox box = new VBox();
        Scene scene = new Scene(box, 180, 180);
        stage.setScene(scene);
        stage.setTitle("Scroll Pane");
        box.getChildren().addAll(sp, fileName);
        VBox.setVgrow(sp, Priority.ALWAYS);
 
        fileName.setLayoutX(30);
        fileName.setLayoutY(160);
 
        for (int i = 0; i < 5; i++) {
            images[i] = new Image(getClass().getResourceAsStream(imageNames[i]));
            pics[i] = new ImageView(images[i]);
            pics[i].setFitWidth(100);
            pics[i].setPreserveRatio(true);
            vb.getChildren().add(pics[i]);
        }
        sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        sp.setVmax(440);
        sp.setHmax(300);
        sp.setPrefSize(115, 150);
        sp.setContent(vb);
        sp.vvalueProperty().addListener((ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) -> {
                fileName.setText(imageNames[(new_val.intValue() - 1)/100]);
        });
        
        sp.hvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    System.out.println(new_val.intValue());
            }
        }); 
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
} 
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.ScrollPane;
//import javafx.scene.control.ScrollPane.ScrollBarPolicy;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.stage.Stage;
////ww  w.  j ava  2 s. c  o  m
//public class Main extends Application {
//	
//    @Override
//    public void start(Stage stage) {
//        Group root = new Group();
//        Scene scene = new Scene(root, 500, 200);
//        stage.setScene(scene);
//
//        Image img = new Image("http://b.thumbs.redditmedia.com/aCMSDrp_lbHLbkUoXnRhtQ_84q3wzo9kOV5cWtpY6aQ.jpg");
//        ScrollPane sp = new ScrollPane();
//        sp.setContent(new ImageView(img));
//
//        sp.setHbarPolicy(ScrollBarPolicy.ALWAYS);
//        sp.setVbarPolicy(ScrollBarPolicy.ALWAYS);
//
//        root.getChildren().add(sp);
//        stage.show();
//    }
//    public static void main(String[] args) {
//    	System.out.println("Working dir:  " + System.getProperty("user.dir"));
//        launch(args);
//    }
//}