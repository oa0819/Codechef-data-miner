package dataminer;

import java.io.IOException;


public class codechefapp {
	public static void main(String args[]) throws IOException
	{
		codechefdata cdata = new codechefdata();
		
		cdata.setUserId("ayushi_1908");
		
		System.out.println(cdata.getCurrentRating());
		System.out.println(cdata.getUsername());
		System.out.println(cdata.getPartiallySolvedCount());
		System.out.println(cdata.getFullySolvedCount());
	}
}
