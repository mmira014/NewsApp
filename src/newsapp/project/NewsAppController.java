/**
 * Sample Skeleton for 'fixedtemplate.fxml' Controller Class
 */

package newsapp.project;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewsAppController {
    private int currentPostIndex = 0;
    public static int numLiked = 0;
    private Boolean debug = false;
    
    NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews");
    
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
        n.loadPosts();
        assert n.getNumberOfPosts() > 0 : "That can't be right. Are you connected to the internet?";
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
        if (debug)
            System.out.println("variables loaded");
        //NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
        //System.out.println(n.posts.toString());
    	//n.loadPosts();
        
        masterWindowPane.setPadding(new Insets(10));
        
        Random Dice = new Random();
        int randIndex = Dice.nextInt(n.quotes.size());
        randomQuote.setText(n.quotes.get(randIndex));
    	Collections.sort(n.getAllPosts(), new CompareRedditPost());
        LocalDate localDate = LocalDate.now();
        newsSelection.setText("Today is " + DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
        previousArticleButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                likedCheckBox.setSelected(false); //reset check box
                if (debug)
                    System.out.println("previousArticleButton pressed.");
                if (currentPostIndex-1 < 0)
                {
                    if (debug)
                        System.out.println("Possible index error at previousArticleButton()");
                    currentPostIndex = n.getNumberOfPosts()-1;
                }
                else
                {
                    --currentPostIndex;
                }
                if (debug)
                    System.out.println("currentPostIndex is " + currentPostIndex);
                refreshPosts();
                if(n.posts.get(currentPostIndex).getLikeStatus())
                {
                    likedCheckBox.setSelected(true); 
                }
                else
                {
                    likedCheckBox.setSelected(false);
                }
            }
        });
        nextArticleButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                likedCheckBox.setSelected(false); //reset check box
                if (debug)
                    System.out.println("nextArticleButton pressed.");
                if (currentPostIndex+1 >= n.getNumberOfPosts())
                {
                    if (debug)
                        System.out.println("Possible index error at nextArticleButton()");
                    currentPostIndex = 0;
                }
                else
                {
                    ++currentPostIndex;
                }
                if (debug)
                    System.out.println("currentPostIndex is " + currentPostIndex);
                refreshPosts();
                if(n.posts.get(currentPostIndex).getLikeStatus())
                {
                    likedCheckBox.setSelected(true); 
                }
                else
                {
                    likedCheckBox.setSelected(false);
                }
            }
        });
        likedCheckBox.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //user pressed and resulted in like, so add current post to liked posts array
                //FIXME: NEED TO REMEMBER CHECKED/UNCHECKED STATUS
                if(likedCheckBox.isSelected()) {
                    n.posts.get(currentPostIndex).like();
                    ++numLiked;
                    if (debug)
                {
                    System.out.println("likedCheckButton pressed.");
                    System.out.println("Check button check status: " + likedCheckBox.isSelected());
                    System.out.println(n.posts.get(currentPostIndex));
                }
                    
                    
                    
                    n.addLikedPost(n.posts.get(currentPostIndex));
                    if (debug)
                        System.out.println("Number of liked posts is " + n.likedPostArray.size());
                }
                else
                {
                    if (debug)
                        System.out.println("Check button check status: " + likedCheckBox.isSelected());
                    //user pressed and resulted in dislike, so remove current post from liked posts array
                    n.posts.get(currentPostIndex).dislike();
                    --numLiked;
                    
                    n.removeLikedPost(n.posts.get(currentPostIndex));
                    if (debug)
                        System.out.println("Number of liked posts is " + n.likedPostArray.size());
                }
            }
        });
        browserLink.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (debug)
                    System.out.println("browserLink pressed; open URL in browser");
                try
                {
                    Desktop.getDesktop().browse(new URI(n.posts.get(currentPostIndex).getUrl()));
                }
                catch(IOException e1)
                {
                    e1.printStackTrace();
                }
                catch(URISyntaxException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        redditLink.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if (debug)
                    System.out.println("redditLink pressed; open URL in browser");
                try
                {
                    Desktop.getDesktop().browse(new URI("https://www.reddit.com/r/UpliftingNews/"));
                }
                catch(IOException e1)
                {
                    e1.printStackTrace();
                }
                catch(URISyntaxException e1)
                {
                    e1.printStackTrace();
                }
            }
        });
        likedPosts.setOnAction(e -> 
                {
                    if (debug)
                {
                    System.out.println("clicked on liked posts archive");
                    //LikedPosts.display("Liked Posts Archive");
                }
                    LikedPosts.display("Liked Posts Archive");

        });
        aboutThisApp.setOnAction(e -> displayAbout("About"));
        
        refreshPosts();
        

    }
    @FXML
    void refreshPosts()
    {
        if (debug)
            System.out.println("Calling refreshposts()");
        RedditPost currentPost = n.posts.get(currentPostIndex);
        this.newsTitle.setText(currentPost.getTitle());
        if (debug)
            System.out.println("->" + currentPost.getThumbnailUrl() + "<-");
        if (currentPost.getThumbnailUrl() == "http:")
        {
            if (debug)
                System.out.println("yeah boi");
            this.currentPostThumbnail.setImage(new Image("http://i.imgur.com/S6uyoKG.jpg"));
        }
        else
        {
            this.currentPostThumbnail.setImage(new Image(currentPost.getThumbnailUrl()));
        }
        //this.currentPostThumbnail.setImage(new Image(currentPost.getThumbnailUrl()));
        this.metadataAndTime.setText(currentPost.getUpvotes() + " upvotes; posted " + currentPost.getDatetime());
        int previousIndex = currentPostIndex - 1;
        int futureIndex = currentPostIndex + 1;
        if (previousIndex == -1)
        {
            previousIndex = n.getNumberOfPosts()-1;
        }
        if (debug)
            System.out.println("\npreviousPostIndex: " + (previousIndex));
        RedditPost previousPost = n.posts.get(previousIndex);
        this.previousPostThumbnail.setImage(new Image(previousPost.getThumbnailUrl()));
        this.previousPostTitle.setText(previousPost.getTitle());

        if (futureIndex == n.getNumberOfPosts())
        {
            
            futureIndex = 0;
        }
        if (debug)
            System.out.println("\nfuturePostIndex: " + (futureIndex));
        RedditPost futurePost = n.posts.get(futureIndex);
        this.futurePostThumbnail.setImage(new Image(futurePost.getThumbnailUrl()));
        this.futurePostTitle.setText(futurePost.getTitle());
//        if (previousIndex == -1)
//        {
//            this.previousPostThumbnail.setImage(new Image("http://i.imgur.com/S6uyoKG.jpg"));
//        }
//        else
//        {
//            System.out.println("\npreviousPostIndex: " + (currentPostIndex-1));
//            RedditPost previousPost = n.posts.get(currentPostIndex-1);
//            this.previousPostThumbnail.setImage(new Image(previousPost.getThumbnailUrl()));
//        }
//        if (futureIndex == n.getNumberOfPosts())
//        {
//            
//            this.futurePostThumbnail.setImage(new Image("http://i.imgur.com/S6uyoKG.jpg"));
//        }
//        else
//        {
//            System.out.println("\nfuturePostIndex: " + (currentPostIndex+1));
//            RedditPost futurePost = n.posts.get(currentPostIndex+1);
//            this.futurePostThumbnail.setImage(new Image(futurePost.getThumbnailUrl()));
//        }
        if (debug)
            System.out.println("end of refreshPosts()\n------------");
    }
    
    
    public void displayAbout(String title)
    {
        Stage window = new Stage();
        window.setTitle(title);
        
        Label appInfo_1 = new Label();
        Label appInfo_2 = new Label();
        Label appInfo_3 = new Label("News feed provided by www.reddit.com/upliftingnews/");
        
        appInfo_1.setText("Created by Marcos Miranda and Trevor Dinh");
        appInfo_2.setText("2017 All rights reserved");
        
        VBox layout = new VBox(20);
        layout.setMinSize(350, 150);
        layout.getChildren().addAll(appInfo_1, appInfo_3, appInfo_2);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}