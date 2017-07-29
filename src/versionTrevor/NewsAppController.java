/**
 * Sample Skeleton for 'fixedtemplate.fxml' Controller Class
 */

package versionTrevor;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class NewsAppController {
    private int currentPostIndex = 0;
    public static int numLiked = 0;
    
    NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="masterWindowPane"
    private GridPane masterWindowPane; // Value injected by FXMLLoader

    @FXML // fx:id="currentPostThumbnail"
    private ImageView currentPostThumbnail; // Value injected by FXMLLoader

    @FXML // fx:id="previousPostThumbnail"
    private ImageView previousPostThumbnail; // Value injected by FXMLLoader

    @FXML // fx:id="futurePostThumbnail"
    private ImageView futurePostThumbnail; // Value injected by FXMLLoader

    @FXML // fx:id="previousArticleButton"
    private Button previousArticleButton; // Value injected by FXMLLoader

    @FXML // fx:id="nextArticleButton"
    private Button nextArticleButton; // Value injected by FXMLLoader

    @FXML // fx:id="browserLink"
    private Hyperlink browserLink; // Value injected by FXMLLoader

    @FXML // fx:id="likedCheckBox"
    private CheckBox likedCheckBox; // Value injected by FXMLLoader

    @FXML // fx:id="redditLink"
    private Hyperlink redditLink; // Value injected by FXMLLoader

    @FXML // fx:id="previousPostTitle"
    private Label previousPostTitle; // Value injected by FXMLLoader

    @FXML // fx:id="newsTitle"
    private Label newsTitle; // Value injected by FXMLLoader

    @FXML // fx:id="futurePostTitle"
    private Label futurePostTitle; // Value injected by FXMLLoader

    @FXML // fx:id="dropdownMenu"
    private MenuButton dropdownMenu; // Value injected by FXMLLoader

    @FXML // fx:id="postedToday"
    private MenuItem postedToday; // Value injected by FXMLLoader

    @FXML // fx:id="likedPosts"
    private MenuItem likedPosts; // Value injected by FXMLLoader

    @FXML // fx:id="aboutThisApp"
    private MenuItem aboutThisApp; // Value injected by FXMLLoader

    @FXML // fx:id="randomQuote"
    private Label randomQuote; // Value injected by FXMLLoader

    @FXML // fx:id="happyYeezy"
    private ImageView happyYeezy; // Value injected by FXMLLoader

    @FXML // fx:id="metadataAndTime"
    private Label metadataAndTime; // Value injected by FXMLLoader

    @FXML // fx:id="newsSelection"
    private Label newsSelection; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert masterWindowPane != null : "fx:id=\"masterWindowPane\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert currentPostThumbnail != null : "fx:id=\"currentPostThumbnail\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert previousPostThumbnail != null : "fx:id=\"previousPostThumbnail\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert futurePostThumbnail != null : "fx:id=\"futurePostThumbnail\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert previousArticleButton != null : "fx:id=\"previousArticleButton\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert nextArticleButton != null : "fx:id=\"nextArticleButton\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert browserLink != null : "fx:id=\"browserLink\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert likedCheckBox != null : "fx:id=\"likedCheckBox\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert redditLink != null : "fx:id=\"redditLink\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert previousPostTitle != null : "fx:id=\"previousPostTitle\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert newsTitle != null : "fx:id=\"newsTitle\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert futurePostTitle != null : "fx:id=\"futurePostTitle\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert dropdownMenu != null : "fx:id=\"dropdownMenu\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert postedToday != null : "fx:id=\"postedToday\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert likedPosts != null : "fx:id=\"likedPosts\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert aboutThisApp != null : "fx:id=\"aboutThisApp\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert randomQuote != null : "fx:id=\"randomQuote\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert happyYeezy != null : "fx:id=\"happyYeezy\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert metadataAndTime != null : "fx:id=\"metadataAndTime\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
        assert newsSelection != null : "fx:id=\"newsSelection\" was not injected: check your FXML file 'fixedtemplate.fxml'.";
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
                System.out.println("Check button check status: " + likedCheckBox.isSelected());
            }
        });
        browserLink.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("browserLink pressed; open URL in browser");
            }
        });
        likedPosts.setOnAction(e -> 
                {
                    System.out.println("clicked on liked posts archive");
                    LikedPosts.display("Liked Posts Archive");
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