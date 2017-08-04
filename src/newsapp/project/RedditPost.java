package newsapp.project;
import java.util.regex.*;
import java.util.Comparator;

/**
 *
 * @author Trevor
 */
public class RedditPost
{
        private static int postCount = 0;
        private int postNumber = 0;
	private String author;
	private String title;
	private String url;
	private String datetime;
	private int upvotes;
	private String thumbnail_url;
	private String domain_url;
        private Boolean is_liked;

    /**
     *
     * @return The unique number of a given RedditPost, incremented by postCount
     */
    public int getPostNumber()
        {
            return postNumber;
        }

    /**
     *
     * @return The author of the RedditPost.
     */
    public String getAuthor()
	{
		return this.author;
	}

    /**
     *
     * @return The title of the RedditPost.
     */
    public String getTitle()
	{
		return this.title;
	}

    /**
     *
     * @return The date and time the RedditPost was posted on r/UpliftingNews.
     */
    public String getDatetime()
	{
		return this.datetime;
	}

    /**
     *
     * @return The RedditPost's net upvotes.
     */
    public int getUpvotes()
	{
		return this.upvotes;
	}

    /**
     *
     * @return The URL of the article.
     */
    public String getUrl()
	{
		return this.url;
	}

    /**
     *
     * @return The thumbnail of the article.
     */
    public String getThumbnailUrl()
	{
		return this.thumbnail_url;
	}

    /**
     *
     * @return The domain URL of the article.
     */
    public String getDomainUrl()
	{
		return this.domain_url;
	}
	public String toString()
	{
		return "RedditPost by " + author + " titled " + title + "; posted on " + datetime + " and has " + upvotes + " upvotes";
	}

    /**
     *
     * @return Whether the post is liked or not in the GUI.
     */
    public Boolean getLikeStatus()
        {
            return is_liked;
        }

    /**
     *
     * @return Gets the number of posts retrieved from Reddit.
     */
    public static int getNumberOfPosts()
        {
            return postCount;
        }
	private void retrieveDomain()
	{
		String domainPat = "\\(([^\\)]+)\\)";
		Pattern p = Pattern.compile(domainPat);
		Matcher m = p.matcher(title);
		if (m.find()) {   
			  //System.out.println(m.group(1));
			  this.domain_url = m.group(1);
			  this.title = this.title.replace("(" + domain_url + ")", "");
			  //System.out.println(title);
		}
		
		//regex \(([^\)]+)\); compile and match
	}

    /**
     *
     * @param author Author of the RedditPost
     * @param title Title of the Post
     * @param url URL to the article
     * @param datetime Date and time posted
     * @param upvotes Net upvotes
     * @param thumbnail_url URL of its displayed thumbnail
     */
    public RedditPost(String author, String title, String url, String datetime, int upvotes, String thumbnail_url)
	{
		this.author = author;
		this.title = title;
		this.url = url;
		this.datetime = datetime;
		this.upvotes = upvotes;
		this.thumbnail_url = "http:" + thumbnail_url;
                this.is_liked = false;
                this.retrieveDomain();
                this.postNumber = ++postCount;
	}

    /**
     *
     */
    public void like()
        {
            this.is_liked = true;
        }

    /**
     *
     */
    public void dislike()
        {
            this.is_liked = false;
        }
        
//	public static void main(String[] args) throws Exception {
//		RedditPost test = new RedditPost("a", "Dog revived with oxygen after rescue from burning house gets visit from hero firefighter (usatoday.com)", "c", "d", 5, "e");
//		System.out.println(test.title);
//		test.retrieveDomain();
//	}

}

class CompareRedditPost implements Comparator<RedditPost>
{
	@Override
	public int compare(RedditPost p1, RedditPost p2)
	{
		return p1.getUpvotes() > p2.getUpvotes() ? -1 : (p1.getUpvotes() < p2.getUpvotes() ? 1 : 0);
	}
}