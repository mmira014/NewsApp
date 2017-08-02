package versionTrevor;
//import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class NewsAppResponse
{
	private Document doc;
	private String toURL;
	ArrayList<RedditPost> posts;
	ArrayList<RedditPost> likedPostArray;
    ArrayList<String> quotes;
    public void addLikedPost(RedditPost p)
	{
		likedPostArray.add(p);
	}
        
    public Boolean removeLikedPost(RedditPost p)
    {
        return likedPostArray.remove(p);
    }
	
	public NewsAppResponse(String url)
	{
            likedPostArray = new ArrayList();
            quotes = new ArrayList();
            quotes.add("\"The reason we struggle with insecurity is because we compare "
                    + "our behind-the-scenes with everyone else’s highlight reel.\" -Steve Furtick");
            quotes.add("\"You can be the ripest, juiciest peach in the world, and there's still going to be somebody who hates peaches.\"" +
                    "-Dita Von Teese");
            quotes.add("\"Be the person your dog thinks you are.\" - J.W. Stephens");
            quotes.add("\"If you're going through hell, keep going.\" -Winston Churchill");
            quotes.add("\"Live your life so that when your feet hit the floor in the morning, the Devil goes 'Oh shit, he's up.' \"" +
                    "-Dwayne 'The Rock' Johnson");
            quotes.add("\"Please: Do everything you possibly can in one lifetime.\" -Kanye West");
		this.toURL = url;
		try
		{
			this.doc = Jsoup.connect(toURL).get();
			//this.htmlResponse = Jsoup.connect(toURL).get().toString();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public String getURL()
	{
		return toURL;
	}
	public String getHTMLResponseString()
	{
	return this.doc.toString();
	}
	
	public Document getHTMLResponse()
	{
		return this.doc;
		
	}

	public void loadPosts()
	{
            
		posts = new ArrayList<RedditPost>();
		NewsAppResponse htmlResult = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
		Document d = htmlResult.getHTMLResponse();
		Elements webpage = d.getElementsByClass("thing");
		if (webpage.hasText())
		{
			for (Element e : webpage)
			{
	    		String t1 = e.select("div.entry div.top-matter p.tagline time").attr("title");
	    		String t2 = e.select("div.entry div.top-matter p.tagline time").text();
	    		String postDate = t1 + " (" + t2 + ")";
	    		int upvotes = 0;
	    		if (e.select("div.midcol.unvoted div.score.unvoted").attr("title").isEmpty())
	    		{
	    			upvotes = 0;
	    		}
	    		else
	    		{
	    			upvotes = Integer.parseInt(e.select("div.midcol.unvoted div.score.unvoted").attr("title"));
	    		}
	    		Elements img = e.select("a.thumbnail.invisible-when-pinned.may-blank.outbound img");
	    		String thumbnailUrl = img.attr("src").toString();
	    		//System.out.println(thumbnailUrl);
                        RedditPost p = new RedditPost(e.attr("data-author"),e.select("div.entry div.top-matter p.title").text(), 
					e.attr("data-url"), postDate, upvotes, thumbnailUrl);
                        if (p.getTitle().startsWith("Upliftingnews in review"))
                        {
                            continue;
                        }
                        else
                        {
                            posts.add(p);
                        }
//posts.add(new RedditPost(e.attr("data-author"),e.select("div.entry div.top-matter p.title").text(), e.attr("data-url"), postDate, upvotes, thumbnailUrl));
			}
		}
	}
	
	public ArrayList<RedditPost> getAllPosts()
	{
		return posts;
	}
	
	public int getNumberOfPosts()
	{
		return posts.size();
	}
	
	
    public static void main(String[] args) throws Exception {
    	NewsAppResponse n = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
    	n.loadPosts();
    	//Collections.sort(n.getAllPosts(), new CompareRedditPost());
    	for (RedditPost p : n.posts)
    	{
    		//System.out.println(p.getTitle()+ " has " +  p.getUpvotes() + " upvotes");
            System.out.println(p.getTitle() +  " + posted " + p.getDatetime());
            System.out.println("RedditPost #" + p.getPostNumber() + " + posted " + p.getDatetime());
    	}
        System.out.println(n.getNumberOfPosts());
    	
//    	//URL url = new URL("https://www.reddit.com/r/UpliftingNews/.json");
//    	NewsAppResponse htmlResult = new NewsAppResponse("https://www.reddit.com/r/UpliftingNews/");
//    	//System.out.println(htmlResult.getHTMLResponseString());
//    	//System.out.println(htmlResult.getHTMLResponse());//.body().text());
//    	Document d = htmlResult.getHTMLResponse();
//    	//Elements huh = d.select("a[href]"); this will get EVERY link
//    	Elements test = d.getElementsByClass("thing");
//    	System.out.println(test.hasText());
//    	for (Element e : test)
//    	{
//    		System.out.println("\n-------------");
//    		System.out.println(e); //figure out how to retrieve parts for RedditPost
////    		private String author;
////    		private String title;
////    		private String url;
////    		private String datetime;
////    		private int upvotes;
////    		private String thumbnail_url;
//    		System.out.println("\n" + e.attr("data-author")); //author
//    		System.out.println(e.attr("data-url"));
//    		System.out.println(e.select("div.entry div.top-matter p.title").text());
//    		
//    		//Elements e2 = e.select(">div");
//    		String t1 = e.select("div.entry div.top-matter p.tagline time").attr("title");
//    		String t2 = e.select("div.entry div.top-matter p.tagline time").text();
//    	
//    		System.out.println(t1 + " (" + t2 + ")");
//    		//System.out.println(e.select("div.midcol.unvoted div.score.unvoted").attr("title"));
//    		int upvotes = 0;
//    		if (e.select("div.midcol.unvoted div.score.unvoted").attr("title").isEmpty())
//    		{
//    			upvotes = 0;
//    		}
//    		else
//    		{
//    			upvotes = Integer.parseInt(e.select("div.midcol.unvoted div.score.unvoted").attr("title"));
//    		}
//    		System.out.println(upvotes);
//    		
//
//
////    		for (Element e3 : e2)
////    		{
////    			System.out.println("\n~~~~~~~~~");
////    			System.out.println(e3.toString());
////    			System.out.println("~~~~~~~~~\n");
////    		}
//    		Elements img = e.select("a.thumbnail.invisible-when-pinned.may-blank.outbound img");
//    		String thumbnailUrl = img.attr("src").toString();
//    		System.out.println(thumbnailUrl);
//    		
//    		
//    		
//    		
//    		System.out.println("--------------\n");
//    	}
    	
    	
    	
    	
    	
    	
    	
    }

}



