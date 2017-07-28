/**
 * Sample Skeleton for 'template.fxml' Controller Class
 */

package versionTrevor;

import java.net.URL;
import java.util.Collections;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.lang.Math;
import javafx.event.EventHandler;

public class NewsAppController {
    private int currentPostIndex = 0;
    NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Pane masterWindowPane;

    @FXML
    private AnchorPane displayAnchorPane;

    @FXML
    private TextArea newsTitle;

    @FXML
    private ImageView currentPostThumbnail;

    @FXML
    private ImageView previousPostThumbnail;

    @FXML
    private ImageView futurePostThumbnail;

    @FXML
    private TextField metadataAndTime;

    @FXML
    private TextField disclaimerText;

    @FXML
    private MenuButton dropdownMenu;

    @FXML
    private MenuItem postedToday;

    @FXML
    private MenuItem likedPosts;

    @FXML
    private TextField currentDateTime;

    @FXML
    private Hyperlink browserLink;

    @FXML
    private Button previousArticleButton;

    @FXML
    private Button nextArticleButton;

    @FXML
    private CheckBox likedCheckBox; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        System.out.println("initialize()");
        assert masterWindowPane != null : "fx:id=\"masterWindowPane\" was not injected: check your FXML file 'template.fxml'.";
        assert displayAnchorPane != null : "fx:id=\"displayAnchorPane\" was not injected: check your FXML file 'template.fxml'.";
        assert newsTitle != null : "fx:id=\"newsTitle\" was not injected: check your FXML file 'template.fxml'.";
        assert currentPostThumbnail != null : "fx:id=\"currentPostThumbnail\" was not injected: check your FXML file 'template.fxml'.";
        assert previousPostThumbnail != null : "fx:id=\"previousPostThumbnail\" was not injected: check your FXML file 'template.fxml'.";
        assert futurePostThumbnail != null : "fx:id=\"futurePostThumbnail\" was not injected: check your FXML file 'template.fxml'.";
        assert metadataAndTime != null : "fx:id=\"metadataAndTime\" was not injected: check your FXML file 'template.fxml'.";
        assert disclaimerText != null : "fx:id=\"disclaimerText\" was not injected: check your FXML file 'template.fxml'.";
        assert dropdownMenu != null : "fx:id=\"dropdownMenu\" was not injected: check your FXML file 'template.fxml'.";
        assert postedToday != null : "fx:id=\"postedToday\" was not injected: check your FXML file 'template.fxml'.";
        assert likedPosts != null : "fx:id=\"likedPosts\" was not injected: check your FXML file 'template.fxml'.";
        assert currentDateTime != null : "fx:id=\"currentDateTime\" was not injected: check your FXML file 'template.fxml'.";
        assert browserLink != null : "fx:id=\"browserLink\" was not injected: check your FXML file 'template.fxml'.";
        assert previousArticleButton != null : "fx:id=\"previousArticleButton\" was not injected: check your FXML file 'template.fxml'.";
        assert nextArticleButton != null : "fx:id=\"nextArticleButton\" was not injected: check your FXML file 'template.fxml'.";
        assert likedCheckBox != null : "fx:id=\"likedCheckBox\" was not injected: check your FXML file 'template.fxml'.";
        System.out.println("variables loaded");
        //NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
        //System.out.println(n.posts.toString());
    	n.loadPosts();
    	Collections.sort(n.getAllPosts(), new CompareRedditPost());
        previousArticleButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("previousArticleButton pressed.");
            }
        });
        nextArticleButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("nextArticleButton pressed.");
            }
        });
        likedCheckBox.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("likedCheckButton pressed.");
            }
        });
        
        refreshPosts();
        

    }
    @FXML
    void refreshPosts()
    {
        System.out.println("Calling refreshposts()");
        RedditPost currentPost = n.posts.get(currentPostIndex);
        this.newsTitle.setText(currentPost.getTitle());
        System.out.println(currentPost.getThumbnailUrl());
        this.currentPostThumbnail.setImage(new Image(currentPost.getThumbnailUrl()));
        this.metadataAndTime.setText(currentPost.getUpvotes() + " upvotes; posted " + currentPost.getDatetime());
        int previousIndex = currentPostIndex - 1;
        int futureIndex = currentPostIndex + 1;
        if (previousIndex == -1)
        {
            this.previousPostThumbnail.setImage(new Image("http://i.imgur.com/S6uyoKG.jpg"));
        }
        else
        {
            System.out.println("\npreviousPostIndex: " + (currentPostIndex-1));
            RedditPost previousPost = n.posts.get(currentPostIndex-1);
            this.previousPostThumbnail.setImage(new Image(previousPost.getThumbnailUrl()));
        }
        if (futureIndex == n.getNumberOfPosts())
        {
            
            this.futurePostThumbnail.setImage(new Image("http://i.imgur.com/S6uyoKG.jpg"));
        }
        else
        {
            System.out.println("\nfuturePostIndex: " + (currentPostIndex+1));
            RedditPost futurePost = n.posts.get(currentPostIndex+1);
            this.futurePostThumbnail.setImage(new Image(futurePost.getThumbnailUrl()));
        }
        System.out.println("end of refreshPosts()\n------------");
    }
    
    
    
    
    public NewsAppController()
    {
        System.out.println("NewsAppController()");
    }
}
//need to lock text AND center it