package dataminer;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class codechefdata {
	private Document doc;
	private String userId;
	
	public void setUserId(String userId) throws IOException
	{
		this.userId = userId;
		
		doc = Jsoup.connect("https://www.codechef.com/users/" + this.userId).timeout(5000).get();
	}
	
	public int getCurrentRating()
	{
		Elements rating = doc.select("div.rating-number");
		return Integer.parseInt(rating.html());
	}
	
	public String getUsername()
	{
		Elements uname = doc.select("h1.h2-style");
		return uname.html();
	}
	
	public String getPartiallySolvedCount()
	{
		Element partialCnt = doc.select("section.problems-solved div h5").get(1);
		return partialCnt.html();
	}
	
	public String getFullySolvedCount()
	{
		Element fullCnt = doc.select("section.problems-solved div h5").get(0);
		return fullCnt.html();
	}
	/*
	public List<String> getProblemCode()
	{
		Elements code = doc.select("section.problems-solved article p span a");
		return code.html();
	}*/
	
}
