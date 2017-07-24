package versionTrevor;
import java.util.regex.*;

public class RedditPost
{
	private String author;
	private String title;
	private String url;
	private String datetime;
	private int upvotes;
	private String thumbnail_url;
	private String domain_url;
	public String getAuthor()
	{
		return this.author;
	}
	public String getTitle()
	{
		return this.title;
	}
	public String getDatetime()
	{
		return this.datetime;
	}
	public int getUpvotes()
	{
		return this.upvotes;
	}
	public String getThumbnailUrl()
	{
		return this.thumbnail_url;
	}
	public String getDomainUrl()
	{
		return this.domain_url;
	}
	public String toString()
	{
		return "RedditPost by " + author + " titled " + title + "; posted on " + datetime + " and has " + upvotes + " upvotes";
	}
	private void retrieveDomain()
	{
		String domainPat = "\\(([^\\)]+)\\)";
		Pattern p = Pattern.compile(domainPat);
		Matcher m = p.matcher(title);
		if (m.find()) {   
			  System.out.println(m.group(1));
			  this.domain_url = m.group(1);
			  this.title = this.title.replace("(" + domain_url + ")", "");
			  System.out.println(title);
		}
		
		//regex \(([^\)]+)\); compile and match
	}
	public RedditPost(String author, String title, String url, String datetime, int upvotes, String thumbnail_url)
	{
		this.author = author;
		this.title = title;
		this.url = url;
		this.datetime = datetime;
		this.upvotes = upvotes;
		this.thumbnail_url = thumbnail_url;
	}
	public static void main(String[] args) throws Exception {
		RedditPost test = new RedditPost("a", "Dog revived with oxygen after rescue from burning house gets visit from hero firefighter (usatoday.com)", "c", "d", 5, "e");
		System.out.println(test.title);
		test.retrieveDomain();
	}

}
