package dataminer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class codechefdata {
	private Document doc;
	private String userId;
	
	codechefdata()
	{
		this.userId = null;
	}
	
	codechefdata(String userId) throws Exception
	{
		this.userId = userId;
		this.setUserId(userId);
	}
	
	public void setUserId(String userId) throws Exception
	{
		this.userId = userId;
		
		doc = Jsoup.connect("https://www.codechef.com/users/" + this.userId).timeout(5000).get();
		
		if(doc.baseUri().equals("https://www.codechef.com/"))
			throw new Exception("Wrong userid");
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
	
	public List<String> getProblemCodefull()
	{
		Element code = doc.select("section.problems-solved article").get(0);
		Elements solvedProb = code.select("p").get(0).select("span a");
		
		List<String> res = new ArrayList<>();
		
		for(Element e: solvedProb)
			res.add(e.html());
		
		return res;
	}
	
	public List<String> getProblemCodepartial()
	{
		Element code2 = doc.select("section.problems-solved article").get(1);
		Elements solvedProb2 = code2.select("p").get(0).select("span a");
		
		List<String> res = new ArrayList<>();
		
	
		for(Element e: solvedProb2)
			res.add(e.html());
		return res;
	}
	
}
