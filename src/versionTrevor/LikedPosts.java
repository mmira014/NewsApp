package versionTrevor;

import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class LikedPosts {
    private static ArrayList<RedditPost> likedPostArray = new ArrayList<RedditPost>(30);
    public static void addLikedPost(RedditPost p)
    {
        System.out.print("Adding liked post");
        likedPostArray.add(p);
    }
    public static void removeLikedPost(RedditPost p)
    {
        System.out.print("Removing liked post");
        likedPostArray.remove(p);
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
            label.setText("FIXME: ADD POSTS");
            VBox layout = new VBox(20);
            layout.setMinSize(350, 150);
            layout.getChildren().addAll(label);
            Scene scene = new Scene(layout);
            window.setScene(scene);
        }
        window.show();
    }
    
}