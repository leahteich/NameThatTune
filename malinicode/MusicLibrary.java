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
    public static double[] pitch(double hz, double duration) {
        int n = (int) (StdAudio.SAMPLE_RATE * duration);
        double[] a = new double[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
        }
        return a;
    } //pitch

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
    public static double[] majorChord(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double firstm = 440.0 * Math.pow(2, (pitch + 4) / 12.0);
        double secondm = 440.0 * Math.pow(2, (pitch + 7) / 12.0);
        //sets the 3 in major chord
        double[] a  = pitch(hz, duration);
        double[] mid = pitch(firstm, duration);
        double[] hi = pitch(secondm, duration);
        double[] h  = MusicTools.weightedAddArray(mid, hi, 0.5, 0.5);
        return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
    } //majorChord
    //so major chord, minor chord, using the methods, create a 2-4 min composition

    public static double[] minorChord(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double firstm = 440.0 * Math.pow(2, (pitch + 3) / 12.0);
        double secondm = 440.0 * Math.pow(2, (pitch + 7) / 12.0);
//sets the 3 in the minor chord
        double[] a  = pitch(hz, duration);
        double[] mid = pitch(firstm, duration);
        double[] hi = pitch(secondm, duration);
//using MusicTools, and weightedAddArray, creating minor chord
        double[] h  = MusicTools.weightedAddArray(mid, hi, 0.5, 0.5);
        return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
    } //minorChord
//creating libraries and playing libraries
//harmonic adds 3 together, takes it to original pitch and
//input random numbers, form major chords and minor chords, and change these values in order, repeat them, in order to make a song
public static double[] fadeIn(double[] array, int in) {
    int fadeInDuration = (int) (StdAudio.SAMPLE_RATE * in);
    double[] fadeInArray = new double[array.length+1];
      for (int i =0; i<fadeInDuration; i++) {
        fadeInArray[i]= array[i]*i/fadeInDuration;
      }
      return fadeInArray;
}//fade in

public static double[] fadeOut(double[] array, int out) {
    int fadeOutDuration = (int) (StdAudio.SAMPLE_RATE * out);
    double[] fadeOutArray = new double[array.length+1];
    for (int i =0; i<fadeOutDuration; i++) {
      fadeOutArray[fadeOutArray.length-i-1]= (array[fadeOutArray.length-i-1]*i)/fadeOutDuration;
//percentage
    }
    return fadeOutArray;
} //fade out

public static double[] changeVolume(double[] array, double volume) {
    return MusicTools.scaleArray(array, volume);
}


/*public static double[] clip(double[] array, int out) {
public static double[] fadeinnote(int pitch, double duration, double fadeloc) {
    double hz = 440.0 * Math.pow(2, pitch / 12.0);
    double[] a  = fadeintone(hz, duration, fadeloc);
    //MusicTools.printArray(a);
    return (a);
  }
  public static double[] fadeintone(double hz, double duration, double fadeloc) {
    int n = (int) (StdAudio.SAMPLE_RATE * duration);
    int f = (int) (StdAudio.SAMPLE_RATE * fadeloc);
    double[] a = new double[n+1];
    for (int i = 0; i <= f; i++) {
      double q = ((Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE))/(f))*i;
      //  a[i] = (.1*q)*Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
      a[i] = q;

    }
    for (int i = f; i <= n; i++) {
      a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
    }
    return a;
  }

  public static double[] fadeoutnote(int pitch, double duration, double fadeloc) {
    double hz = 440.0 * Math.pow(2, pitch / 12.0);
    double[] a  = fadeouttone(hz, duration, fadeloc);
    //MusicTools.printArray(a);
    return (a);
  }
  public static double[] fadeouttone(double hz, double duration, double fadeloc) {
    int n = (int) (StdAudio.SAMPLE_RATE * duration);
    int f = (int) (StdAudio.SAMPLE_RATE * fadeloc);
    double[] a = new double[n+1];
    for (int i = 0; i <= f; i++) {
      a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
    }
    for (int i = f; i <= n; i++) {
      double q = ((Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE))/(n-f))*((n-f)-(i-f));
      a[i] = q;
    }
    return a;
  }

}*/
    public static void main(String[] args) {

        // read in pitch-duration pairs from standard input
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double[] a = note(pitch, duration);
            //double[] b = minorChord(pitch,duration);
            //StdAudio.play(a);
            //StdAudio.save("harmonic.wav", (fadeIn(minorChord(pitch,duration),2)));
            //StdAudio.play(a);
            //StdAudio.play(minorChord(pitch,duration));
             StdAudio.play(fadeIn(minorChord(pitch,duration),1));

           //  StdAudio.play.majorChord(a);
            ///StdAudio.play()
        }
    }
}
