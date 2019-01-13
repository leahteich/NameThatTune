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
<<<<<<< HEAD


  public static int[] pickAScale() {
    int[][] scales;
    scales  = new int[][] {
      {0,2,3,5,7,8,10,12},
      {1,3,4,6,8,9,11,13},
      {2,4,5,7,9,10,12,14},
      {3,5,6,8,10,11,13,15}
    };
  }
  public static double[] verse(int[] scale) {
      int[] pickScale = scale;
//needrandom
      int note1 = pickScale[0];
      int note2 = pickScale[1];
      int note3 = pickScale[2];
      int note4 = pickScale[3];
//      int note5 = pickScale[4];

//needrandom
      int time1 = 3;
      //int time2 = 3);
      //int time3 = (20,28);
    //  int time4 = (20,28);
    //  int time5 = (20,28);

      double[] a = MusicLibrary.minorChord(note1, 3);
      double[] b = MusicLibrary.minorChord(note2, 3);
      double[] c = MusicLibrary.minorChord(note3, 3);
      double[] d = MusicLibrary.minorChord(note4, 3);
//      double[] e = MusicLibrary.minorChord(note5, time5);

      System.out.println("\nVerse:");
      System.out.println(note1+" "+time1+" Minor");
      System.out.println(note2+" "+time2+" Minor");
      System.out.println(note3+" "+time3+" Minor");
      System.out.println(note4+" "+time4+" Minor");
  //    System.out.println(note5+" "+time5+" Minor");

      double[] concat1 = MusicTools.concatArray(MusicTools.concatArray(a, b), MusicTools.concatArray(c,d));
      double[] array = ArrayTools.concatArray(concat1,conncat1);
      return array;
  }
=======
>>>>>>> 7c115df71964619ba183fbbafaacd3d56eacdff2
