/******************************************************************************
 *  Compilation:  javac PlayThatTuneDeluxe.java
 *  Execution:    java PlayThatTuneDeluxe < data.txt
 *
 *  % java PlayThatTuneDeluxe 0.5 < elise.txt
 *
 *  Data files
 *  ----------
 *  http://www.cs.princeton.edu/introcs/21function/elise.txt
 *  http://www.cs.princeton.edu/introcs/21function/freebird.txt
 *  http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 *  http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 *  http://www.cs.princeton.edu/introcs/21function/looney.txt
 *  http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 *  http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 *  http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 *  http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 *  http://www.cs.princeton.edu/introcs/21function/firstcut.txt
 *  http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 *  http://www.cs.princeton.edu/introcs/21function/portal.txt
 *
 ******************************************************************************/

public class MusicLibrary {

    // return weighted sum of two arrays
    public static double[] sum(double[] a, double[] b, double awt, double bwt) {

        // precondition: arrays have the same length
        assert a.length == b.length;

        // compute the weighted sum
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i]*awt + b[i]*bwt;
        }
        return c;
    }
//new array with weighted sum
    // create a pure tone of the given frequency for the given duration
    //trim should operate on a sin wave array trim is applied on a wave file not the sheet music
    //save wav version of song
    public static double[] tone(double hz, double duration) {
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a;
    }
    // create a note with harmonics of the given pitch and duration
    // (where 0 = concert A)
    //tone makes the waves//MusicTools.scale
    public static double[] note(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double[] a  = tone(hz, duration);
        double[] hi = tone(2*hz, duration);
        //adds a high octave
        double[] lo = tone(hz/2, duration);
        //adds a low octave
        double[] h  = sum(hi, lo, 0.5, 0.5);
        return sum(a, h, 0.5, 0.5);
    }
//so major chord, minor chord, using the methods, create a 2-4 min composition
public static double[] minorChord(double[] a,double[] b){
  /*double hz = 440.0 * Math.pow(2, pitch / 12.0);
  double[] a  = tone(hz, duration);
  double[] hi = tone(2*hz, duration);
  //adds a high octave
  double[] lo = tone(hz/2, duration);
  */
  double[] c = new double[a.length];
  for (int i = 0; i < a.length; i++) {
      c[i] = a[i]-4+b[i]-7;
  }
  return c;
}
//creating libraries and playing libraries
//harmonic adds 3 together, takes it to original pitch and
//input random numbers, form major chords and minor chords, and change these values in order, repeat them, in order to make a song
public static double[] majorChord(double[] a,double[] b){
  double[] c = new double[a.length];
  for (int i = 0; i < a.length; i++) {
      c[i] = a[i]+4 + b[i]+7;
  }
  return c;

}
//musicTools.scale
public static double[] changeVolume(double amplitude, double[] a){
  double[] c = new double[a.length];
  for (int i = 0; i < a.length; i++) {
      //c[i] = a[i]*tone(2*hz);
  }
  return c;
}
  /*public static double[] trim(){}
    public static double[] delay(){}
      public static double[] fade(){}
        public static double[] clip(){}*/
        // read in notes from standard input and play them on standard audio
        //Std random as well
    public static void main(String[] args) {

        // read in pitch-duration pairs from standard input
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double[] a = note(pitch, duration);
            //double[] b = minorChord(pitch,duration);
            //StdAudio.play(a);
            StdAudio.save("harmonic.wav", a);
            StdAudio.play(a);
          //  StdAudio.play.majorChord(a);
            ///StdAudio.play()
        }
    }
}
