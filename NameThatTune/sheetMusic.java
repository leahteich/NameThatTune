/*
Malini Kundamal and Leah Teichholtz NameThatTune, Unit 3
Advanced CS I - Mr. Gohde - 1/23/2019

OUR STRATEGY FOR GENERATING MUSIC and ANIMATION:
* Pick a random minor scale for the VERSE. We shuffle scale and randomly pick 4 notes from the minor scale
* We then choose how many notes to play, which is random (20-40 notes). The time is random as well. (.3-.8 secs)
* The CHORUS is generated from a random major scale. It is 5-10 notes, each for a random time (1-2 secs)
* The BRIDGE is on a major scale but played as harmonics. It has the SAME time (2-4 secs) per note,
each note is random from major scale, however. This is same scale as chorus.
* We generate a txt file that denotes pitch, duration, and type (1 = major, 2 = minor, 3 = harmonic)
* This txt file is played in PlayThatTuneDeluxe.java, where animation is generated.
* The animation is designed to look like a piano. When a note is within a certain pitch on piano,
it lights up notes around it. The animation stays for the duration of the ntoe.

*/

import java.io.*;
import java.lang.System;

public class sheetMusic {

	public static void main(String[] args) throws Exception {
//stackoverflow- https://stackoverflow.com/questions/26769345/convert-a-wav-file-to-a-txt-file

			int songNum = StdRandom.uniform(0,10000);

			PrintStream out = new PrintStream(new FileOutputStream("song.txt"));

			System.setOut(out);

    	int[] scale1 = chooseMinor();
      int[] scale2 = chooseMajor();

			generateText(scale1, scale2);

    	double[] chorus = chorus(scale2);
  		double[] verse = verse(scale1);
			double[] bridge = bridge(scale1);

		  double[] a = MusicLibrary.fadeIn(playFullSong(chorus, verse, bridge),5);

//https://stackoverflow.com/questions/1994255/how-to-write-console-output-to-a-txt-file
		   StdAudio.save("song"+songNum+".wav", a);

		  // StdAudio.play(a);
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
		return MusicLibrary.shuffle(scales[StdRandom.uniform(0,12)]);
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

    return MusicLibrary.shuffle(scales[StdRandom.uniform(0,12)]);
		//even though it says musiclibrary is library for shuffle, it's really the method from stdrandom...

  }

  public static double[] verse(int[] scale1) {
      int[] pickScale = scale1;

			int noteNumber = StdRandom.uniform(20,40);
			int[] notes = new int[noteNumber];
			double[] times = new double[noteNumber];

			double[] concatOrig = {};

			for (int i = 0; i < noteNumber; i++) {
				notes[i] = pickScale[StdRandom.uniform(0,4)];
				times[i] = StdRandom.uniform(.3,.8);

				String currentNote = Integer.toString(notes[i]);
				String currentTime = Double.toString(times[i]);

				System.out.println(currentNote + " " + currentTime + " 2");

				double[] noteToPlay = MusicLibrary.minorChord(notes[i], times[i]);

				concatOrig = MusicTools.concatArray(concatOrig, noteToPlay);
			}

			concatOrig = MusicTools.concatArray(concatOrig, concatOrig);
      return concatOrig;
  }

  public static double[] chorus(int[] scale2) {
      int[] pickScale = scale2;

			int noteNumber = StdRandom.uniform(5,10);
			int[] notes = new int[noteNumber];
			double[] times = new double[noteNumber];

			double[] concatOrig = {};

			for (int i = 0; i < noteNumber; i++) {
				notes[i] = pickScale[StdRandom.uniform(0,4)];
				times[i] = StdRandom.uniform(1,2);

				String currentNote = Integer.toString(notes[i]);
				String currentTime = Double.toString(times[i]);

				System.out.println(currentNote + " " + currentTime + " 1");

				double[] noteToPlay = MusicLibrary.majorChord(notes[i], times[i]);

				concatOrig = MusicTools.concatArray(concatOrig, noteToPlay);
			}

			concatOrig = MusicTools.concatArray(concatOrig, concatOrig);
      return concatOrig;

  }

  public static double[] bridge(int[] scale2) {
      int[] pickScale = scale2;
			int[] notes = new int[4];

      int time1 = StdRandom.uniform(2,4);

			double[] concatOrig = {};

			for (int i = 0; i<4; i++) {
				notes[i] = pickScale[StdRandom.uniform(1,8)];

				String currentNote = Integer.toString(notes[i]);
				String currentTime = Double.toString(time1);

				System.out.println(currentNote + " " + currentTime + " 3");

				double[] noteToPlay = MusicLibrary.harmonic(notes[i], time1);

				concatOrig = MusicTools.concatArray(concatOrig, noteToPlay);
			}

			concatOrig = MusicTools.concatArray(concatOrig, concatOrig);
      return concatOrig;
    }

		public static double[] rest(double length) {
	    double[] restArray = new double[(int)(length*StdAudio.SAMPLE_RATE)];
			for (int i=0; i < restArray.length; i++) {
				restArray[i] = 0;
			}
			System.out.println(1 + " " + length + " 4");
			return restArray;
	   }

	public static void generateText(int[] scale1, int[] scale2) {
		verse(scale1);
		rest(StdRandom.uniform(1,2));
		chorus(scale2);
		rest(StdRandom.uniform(1,2));
		verse(scale1);
		rest(StdRandom.uniform(1,2));
		chorus(scale2);
		rest(StdRandom.uniform(1,2));
		verse(scale1);
		rest(StdRandom.uniform(1,2));
		bridge(scale2);
		chorus(scale2);
		chorus(scale2);
	}

   public static double[] playFullSong(double[] chorus, double[] verse, double[] bridge) {
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
