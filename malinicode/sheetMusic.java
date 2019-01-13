import java.io.*;
import java.util.Random;

Random rand = new Random();

public class sheetMusic {

	public static void main(String[] args) throws Exception {
//stackoverflow- https://stackoverflow.com/questions/26769345/convert-a-wav-file-to-a-txt-file
    	FileOutputStream f1 = new FileOutputStream("notes"+25+".txt");
    	System.setErr(new PrintStream(f1));

    	int[] scale = pickAScale();
    	double[] chorus = chorus(scale);
  		double[] verse = verse(scale);
      double[] bridge = bridge(scale);

		double[] a = structure(chorus,verse,bridge);
		StdAudio.save("songnumber"+25+".wav", a);
		StdAudio.play(a);

	}


  public static int[] pickAScale() {
    int[][] scales;



  }
  public static double[] verse(int[] scale) {
      int[] pickScale = ArrayTools.shuffle(scale);

      int note1 = pickScale[0];
      int note2 = pickScale[1];
      int note3 = pickScale[2];

			int duration1 = rand.nextInt(4) + 1;
			int duration2 = rand.nextInt(4) + 1;
			int duration3 = rand.nextInt(4) + 1;

      double[] a = MusicLibrary.majorChord(note1, duration1);
      double[] b = MusicLibrary.majorChord(note2, duration2);
      double[] c = MusicLibrary.majorChord(note3, duration3);

      System.out.println("\nChorus:");
      System.out.println(note1+" "+duration1+" Major");
      System.out.println(note2+" "+duration2+" Major");
      System.out.println(note3+" "+duration3+" Major");

      double[] d = ArrayTools.concatenateArray(ArrayTools.concatenateArray(a, b), c);
      double[] array = ArrayTools.concatenateArray(d,d);
      return array;
  }
