package baseballscores;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;


public class Main {
	private String filename = "NBAtest.html";
	private StringBuffer rawData;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	
	Main() {
		rawData = new StringBuffer();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line;
			while((line = in.readLine()) != null)
				rawData.append(line +"\n");
			in.close();
		} catch (IOException ioe) {
			System.out.println("Problem reading "+ filename);
			System.exit(0);
		}
	} // constructor
	
	
	public void run() {
		//Pattern selectRow = Pattern.compile("name=\"G[0-2]+");
		Pattern selectRow = Pattern.compile("name=\"G[0-2]+");
		List<MatchResult> matches = findGames(selectRow, rawData.toString());
		System.out.println("result is "+ matches);
		for(MatchResult mr : matches) 
			System.out.printf("Found %s\n", mr.group());
	}
	
	
	public List<MatchResult> findGames(Pattern pattern, CharSequence text) {
		List<MatchResult> results = new ArrayList<MatchResult>();
		Matcher m = pattern.matcher(text);
		while(m.find()) 
			results.add(m.toMatchResult());
		return results;
	}
	

} // class Main
