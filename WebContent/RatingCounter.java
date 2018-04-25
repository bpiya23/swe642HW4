import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;

/**
 * this class reads movie-ratings.data file amd counts the number of times 
 * for each movie rating
 * 
 * @author saurav bhattacharyya
 *
 */
public class RatingCounter {

	private String fileName="movie-ratings.data";
	
	
	/**
	 * one arg constructor
	 * 
	 * @param fileName
	 */
	public RatingCounter(String fileName) {
		this.fileName=fileName;
	}
	
	/**
	 * count the rating and output to console
	 * 
	 */
	public void countRating() {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(fileName);
			Reader reader = new InputStreamReader(in);
			br = new BufferedReader(reader);

			String sCurrentLine;

			// read every line
			
			HashMap<String, Integer> countMap = new HashMap<String, Integer>();
			
			while ((sCurrentLine = br.readLine()) != null) {
				if(null!= sCurrentLine || !"".equals(sCurrentLine)) {
					String[] splitter=sCurrentLine.split("\t");
					if(null!= splitter) {
						if(countMap.containsKey(splitter[2])) {
							countMap.put(splitter[2], countMap.get(splitter[2]) + 1);
						}
						else {
							countMap.put(splitter[2], 1);
						}
						
					}
					
				}
				
			}
			for (Iterator iterator = countMap.keySet().iterator(); iterator.hasNext();) {
				String rating = (String) iterator.next();
				System.out.println("Ratings " + rating + " occurs " 
				+ countMap.get(rating) + " times");
				
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		
	}
	
	public static void main(String[] args) {
		 String fileName="movie-ratings.data";
		 RatingCounter counter = new RatingCounter(fileName);
		 counter.countRating();
	}
}
