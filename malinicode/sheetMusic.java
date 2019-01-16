import java.io.*;

public class sheetMusic {

	public static void main(String[] args) throws Exception {
//stackoverflow- https://stackoverflow.com/questions/26769345/convert-a-wav-file-to-a-txt-file
    	FileOutputStream f1 = new FileOutputStream("notes"+25+".txt");
    	System.setErr(new PrintStream(f1));

    	int[] scale1 = chooseMinor();
      int[] scale2 = chooseMajor();
    	double[] chorus = chorus(scale2);
  		double[] verse = verse(scale1);
			double[] bridge = bridge(scale2);

		  double[] a = musicPlan(chorus,verse,bridge);
		  StdAudio.save("songnumber"+25+".wav", a);
		  StdAudio.play(a);
	}

  public static int[] chooseMinor() {
    int[][] scales;

    scales  = new int[][] {
    {0,2,3,5,7,8,10,12},
    {1,3,4,6,8,9,11,13},
    {2,4,5,7,9,10,12,14},
    {3,5,6,8,10,11,13,15},
    {4,6,7,9,11,12,14,16},
    {5,7,8,10,12,13,15,17},
    {6,8,9,11,13,14,16,18},
    {7,9,10,12,14,15,17,19},
    {8,10,11,13,15,16,18,20},
    {9,11,12,14,16,17,19,21},
    {10,12,13,15,17,18,20,22},
    {11,13,14,16,18,19,21,23}
    };

		return scales[2];
  }

  public static int[] chooseMajor() {
    int[][] scales;

    scales = new int[][] {
      {3,5,7,8,10,12,14,15},
      {5,7,9,10,12,14,16,17},
      {7,9,11,12,14,16,18,19},
      {8,11,13,14,16,18,20,21},
      {10,12,14,15,17,19,21,22},
      {0,2,4,5,7,9,11,12},
      {2,4,6,7,9,11,13,14},
      {4,6,8,9,11,13,15,16},
      {6,8,10,11,13,15,17,18},
      {9,11,13,14,16,18,20,21},
      {11,13,15,16,18,20,22,23},
      {1,3,5,6,8,10,12,13}
    };

    return scales[3];
  }

  public static double[] verse(int[] scale1) {
      int[] pickScale = scale1;
			int note1 = pickScale[StdRandom.uniform(1,8)];
      int note2 = pickScale[StdRandom.uniform(1,8)];
      int note3 = pickScale[StdRandom.uniform(1,8)];
      int note4 = pickScale[StdRandom.uniform(1,8)];

      int time1 = StdRandom.uniform(1,3);
			int time2 = StdRandom.uniform(1,3);
			int time3 = StdRandom.uniform(1,3);
			int time4 = StdRandom.uniform(1,3);

      double[] a = MusicLibrary.minorChord(note1, time1);
      double[] b = MusicLibrary.minorChord(note2, time2);
      double[] c = MusicLibrary.minorChord(note3, time3);
      double[] d = MusicLibrary.minorChord(note4, time4);

      System.out.println("\nVerse:");
      System.out.println(note1+" "+" Minor");

      double[] concat1 = MusicTools.concatArray(MusicTools.concatArray(a, b), MusicTools.concatArray(c,d));
      double[] array = MusicTools.concatArray(concat1,concat1);
      return array;
  }

  public static double[] chorus(int[] scale2) {
      int[] pickScale = scale2;

      int note1 = pickScale[0];
      int note2 = pickScale[3];
      int note3 = pickScale[6];
      int note4 = pickScale[1];

      double[] a = MusicLibrary.majorChord(note1, 3);
      double[] b = MusicLibrary.majorChord(note2, 3);
      double[] c = MusicLibrary.majorChord(note3, 3);
      double[] d = MusicLibrary.majorChord(note4, 3);

      double[] concat2 = MusicTools.concatArray(MusicTools.concatArray(a, b), MusicTools.concatArray(c,d));
      double[] array = MusicTools.concatArray(concat2,concat2);
      return array;
  }

  public static double[] bridge(int[] scale2) {
      int[] pickScale = scale2;

      int note1 = pickScale[1];
      int note2 = pickScale[4];
      int note3 = pickScale[3];
      int note4 = pickScale[2];

      double[] a = MusicLibrary.majorChord(note1, 3);
      double[] b = MusicLibrary.majorChord(note2, 3);
      double[] c = MusicLibrary.majorChord(note3, 3);
      double[] d = MusicLibrary.majorChord(note4, 3);

      double[] concat3 = MusicTools.concatArray(MusicTools.concatArray(a, b), MusicTools.concatArray(c,d));
      double[] array = MusicTools.concatArray(concat3,concat3);
      return array;
    }

    public static double[] musicPlan(double[] chorus, double[] verse, double[] bridge) {
      double[] array = new double[8];
      array = MusicTools.concatArray(array,verse);
      array = MusicTools.concatArray(array,chorus);
      array = MusicTools.concatArray(array,verse);
      array = MusicTools.concatArray(array,chorus);
      array = MusicTools.concatArray(array,verse);
      array = MusicTools.concatArray(array,bridge);
      array = MusicTools.concatArray(array,chorus);
      array = MusicTools.concatArray(array,chorus);

      return array;
    }

  }
