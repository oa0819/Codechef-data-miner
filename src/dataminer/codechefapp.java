package dataminer;

import java.util.List;


public class codechefapp {
	public static void main(String args[]) throws Exception
	{
		codechefdata cdata = new codechefdata();
		
		cdata.setUserId("ayushi_1908");
		
		System.out.println(cdata.getCurrentRating());
		System.out.println(cdata.getUsername());
//		System.out.println(cdata.getPartiallySolvedCount());
		
		System.out.println("List of solved problems: ");
		System.out.println(cdata.getFullySolvedCount());
		
		List<String> solvedprob = cdata.getProblemCodefull();
		
		for(String e: solvedprob)
			System.out.println(e);
		System.out.println();
		
		System.out.println("List of solved problems: ");
		System.out.println(cdata.getPartiallySolvedCount());
		
		List<String> solvedprob2 = cdata.getProblemCodepartial();
		
		for(String e: solvedprob2)
			System.out.println(e);
		System.out.println();
	}
}
