package newsapp.project;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class LikedPosts {
    private ArrayList<RedditPost> likedPostArray;
    
    public void setArray(ArrayList<RedditPost> copyPostArray)
    {
        likedPostArray = copyPostArray;
    }
    public Boolean removePost(int postNumber)
    {
        for (RedditPost p : likedPostArray)
        {
            if (p.getPostNumber() == postNumber)
            {
                return likedPostArray.remove(p);
            }
        }
        return false;
    }
    public static void display(String title)
    {
        Stage window = new Stage();
        window.setTitle(title);
        
        if(NewsAppController.numLiked == 0)
        {
            System.out.println("Liked is 0");
            Label empty = new Label();
            empty.setText("You haven't liked anything yet.");
            
            VBox layout = new VBox(20);
            layout.setMinSize(400, 300);
            layout.getChildren().addAll(empty);
            layout.setAlignment(Pos.CENTER);
            
            Scene scene = new Scene(layout);
            window.setScene(scene);
        }
        else
        {
            //show liked posts
            //show posts in vertical rows 
            //displaying titles and clickable to go to url
            Label label = new Label();
            Label label2 = new Label("another");
            label.setText("TEST TITLE");
            VBox layout = new VBox(20);
            ScrollPane sP = new ScrollPane();
            //sP.setSize(600,800);
            sP.setContent(layout);
            sP.setPannable(true);
            for(int i = 0; i < NewsAppController.numLiked; ++i)
            {
                Hyperlink label_i = new Hyperlink();
                label_i.setText(NewsAppResponse.likedPostArray.get(i).getTitle());
                try
                {
                    URI url = new URI(NewsAppResponse.likedPostArray.get(i).getUrl());
                    label_i.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            try {
                                Desktop.getDesktop().browse(url);
                            } catch (IOException ex) {
                                Logger.getLogger(LikedPosts.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }
                catch(URISyntaxException e1)
                {
                    e1.printStackTrace();
                }
                
                layout.getChildren().addAll(label_i);
            }
            //layout.setMinSize(350, 150);
            //layout.getChildren().addAll(label, sP);
            Scene scene = new Scene(sP, 600, 400);
            window.setScene(scene);
        }
        window.show();
    }
}