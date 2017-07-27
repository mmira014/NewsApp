/**
 * Sample Skeleton for 'template.fxml' Controller Class
 */

package versionTrevor;

import java.net.URL;
import java.util.Collections;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class NewsAppController {
    int currentPostIndex = 0;
    NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="scrollPaneForPost"
    private ScrollPane scrollPaneForPost; // Value injected by FXMLLoader

    @FXML // fx:id="displayAnchorPane"
    private AnchorPane displayAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="newsTitle"
    private TextArea newsTitle; // Value injected by FXMLLoader

    @FXML // fx:id="previousPostThumbnail"
    private ImageView previousPostThumbnail; // Value injected by FXMLLoader

    @FXML // fx:id="currentPostThumbnail"
    private ImageView currentPostThumbnail; // Value injected by FXMLLoader

    @FXML // fx:id="futurePostThumbnail"
    private ImageView futurePostThumbnail; // Value injected by FXMLLoader

    @FXML // fx:id="metadataAndTime"
    private TextField metadataAndTime; // Value injected by FXMLLoader

    @FXML // fx:id="disclaimerText"
    private TextField disclaimerText; // Value injected by FXMLLoader

    @FXML // fx:id="dropdownMenu"
    private MenuButton dropdownMenu; // Value injected by FXMLLoader

    @FXML // fx:id="postedToday"
    private MenuItem postedToday; // Value injected by FXMLLoader

    @FXML // fx:id="likedPosts"
    private MenuItem likedPosts; // Value injected by FXMLLoader

    @FXML // fx:id="currentDateTime"
    private TextField currentDateTime; // Value injected by FXMLLoader

    @FXML // fx:id="browserLink"
    private Hyperlink browserLink; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        System.out.println("initialize()");
        assert scrollPaneForPost != null : "fx:id=\"scrollPaneForPost\" was not injected: check your FXML file 'template.fxml'.";
        System.out.println("yee");
        assert displayAnchorPane != null : "fx:id=\"displayAnchorPane\" was not injected: check your FXML file 'template.fxml'.";
        assert newsTitle != null : "fx:id=\"newsTitle\" was not injected: check your FXML file 'template.fxml'.";
        assert previousPostThumbnail != null : "fx:id=\"previousPostThumbnail\" was not injected: check your FXML file 'template.fxml'.";
        assert currentPostThumbnail != null : "fx:id=\"currentPostThumbnail\" was not injected: check your FXML file 'template.fxml'.";
        assert futurePostThumbnail != null : "fx:id=\"futurePostThumbnail\" was not injected: check your FXML file 'template.fxml'.";
        assert metadataAndTime != null : "fx:id=\"metadataAndTime\" was not injected: check your FXML file 'template.fxml'.";
        assert disclaimerText != null : "fx:id=\"disclaimerText\" was not injected: check your FXML file 'template.fxml'.";
        assert dropdownMenu != null : "fx:id=\"dropdownMenu\" was not injected: check your FXML file 'template.fxml'.";
        assert postedToday != null : "fx:id=\"postedToday\" was not injected: check your FXML file 'template.fxml'.";
        assert likedPosts != null : "fx:id=\"likedPosts\" was not injected: check your FXML file 'template.fxml'.";
        assert currentDateTime != null : "fx:id=\"currentDateTime\" was not injected: check your FXML file 'template.fxml'.";
        assert browserLink != null : "fx:id=\"browserLink\" was not injected: check your FXML file 'template.fxml'.";
        System.out.println("variables loaded");
        //NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
        //System.out.println(n.posts.toString());
    	n.loadPosts();
    	Collections.sort(n.getAllPosts(), new CompareRedditPost());
        refreshPosts();

    }
    @FXML
    void refreshPosts()
    {
        RedditPost currentPost = n.posts.get(currentPostIndex);
        this.newsTitle.setText(currentPost.getTitle());
        this.currentPostThumbnail = new ImageView(new Image(currentPost.getThumbnailUrl()));
        this.metadataAndTime.setText(currentPost.getUpvotes() + " upvotes; posted " + currentPost.getDatetime());
    }
    public NewsAppController()
    {
        System.out.println("NewsAppController()");
    }
}
//need to lock text AND center it