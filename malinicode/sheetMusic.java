import java.io.*;

public class sheetMusic {

	public static void main(String[] args) throws Exception {
//stackoverflow- https://stackoverflow.com/questions/26769345/convert-a-wav-file-to-a-txt-file
    	FileOutputStream f1 = new FileOutputStream("notes"+25+".txt");
    	System.setErr(new PrintStream(f1));

    	int[] scale = chooseScale();
    	double[] chorus = chorus(scale);
  		double[] verse = verse(scale);
      double[] bridge = bridge(scale);

		double[] a = structure(chorus,verse,bridge);
		StdAudio.save("songnumber"+25+".wav", a);
		StdAudio.play(a);

	}
