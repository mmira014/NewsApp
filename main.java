package test;
import org.jsoup.Jsoup;
 
public class Main
{	
	public static void main(String[] args) throws Exception
	{
		String url = "https://www.reddit.com/r/upliftingnews/";
		String html = Jsoup.connect(url).get().toString();
		System.out.println(html);
		
		String [] arrOfLinks = new String[25];
		String [] arrOfImages = new String[25];
		
		Links(html, arrOfLinks, "data-url="); // finds the links 
		Links(html, arrOfImages, "img src="); //finds the thumbnails
	}
	
	// get link following the target string and save it in array
	static void Links(String str, String [] arr, String target)
	{
		boolean skipFirst = false; //skip first link
		boolean imageFlag = false; //skip second link
		int i = 0; // stores the next open spot in the array of links
		
		System.out.println("");
		for(int temp = 0; temp < (str.length() - target.length()); ++temp) //starts at first char, loops until end of html
		{
			if(!Character.toString(str.charAt(temp)).equals(Character.toString(target.charAt(0)))) // if current char does not match first char of target
			{
				continue; //skip iteration
			}
			
			String tempSub = str.substring(temp, temp + target.length()); //use tempSub to search for target string
			if(tempSub.equals(target))
			{
				if(skipFirst == false) // skip first link (not an actual link)
				{
					skipFirst = true;
					continue;
				}
				if(imageFlag == false && target.equals("img src=")) // skip 2nd image link (first and second image links are not thumbnails)
				{
					imageFlag = true;
					continue;
				}
				//get actual link from within quotation marks
				//example link : data-url="https://www.independent.co.uk/news/world/asia/india-plant ... .html"
				temp = temp + target.length() + 1; // update temp to be the index after the first quotation mark
				String url = "";
				while(str.charAt(temp) != '\"') // keep concatenating until full url
				{
					url = url + Character.toString(str.charAt(temp));
					++temp;
				}
				System.out.println(url);
				arr[i] = url;
				++i;
			}
		}
	}
}
