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
  public static double[] harmonic(int pitch, double duration) {
    double hz = 440.0 * Math.pow(2, pitch / 12.0);
    double[] a  = pitch(hz, duration);
    double[] hi = pitch(2*hz, duration);
    double[] lo = pitch(hz/2, duration);
    double[] h  = MusicTools.weightedAddArray(hi, lo, 0.5, 0.5);

    return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
  }

  public static double[] minorChord(int pitch, double duration) {
      double hz = 440.0 * Math.pow(2, pitch / 12.0);
      double m = 440.0 * Math.pow(2, (pitch + 3) / 12.0);
      double p = 440.0 * Math.pow(2, (pitch + 7) / 12.0);
      double[] a  = pitch(hz, duration);
      double[] mid = pitch(m, duration);
      double[] hi = pitch(p, duration);
      double[] h  = MusicTools.weightedAddArray(mid, hi, 0.5, 0.5);
      return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
  } //minorChord

  public static double[] majorChord(int pitch, double duration) {
      double hz = 440.0 * Math.pow(2, pitch / 12.0);
      double m = 440.0 * Math.pow(2, (pitch + 4) / 12.0);
      double p = 440.0 * Math.pow(2, (pitch + 7) / 12.0);
      double[] a  = pitch(hz, duration);
      double[] mid = pitch(m, duration);
      double[] hi = pitch(p, duration);
      double[] h  = MusicTools.weightedAddArray(mid, hi, 0.5, 0.5);
      return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
  } //majorChord

  public static double[] fadeIn(double[] note, double secondsToFade) {
          double n = (double) StdAudio.SAMPLE_RATE;
          int length = (int) Math.ceil(n * secondsToFade);
          double[] finalA = new double[length];
          for (int i = 0; i < length; i += 1) {
              finalA[i] = note[i] * ((double) i / (n * secondsToFade));
          }
          return finalA;
      }//fade in
  public static double[] pitch(double hz, double duration) {
      int n = (int) (StdAudio.SAMPLE_RATE * duration);
      double[] a = new double[n+1];
      for (int i = 0; i <= n; i++) {
          a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
      }
      return a;
  } //pitch

  public static double[] sum(double[] a, double[] b, double awt, double bwt) {
    return MusicTools.weightedAddArray(a, b, awt, bwt);
  } //sum

  public static double[] trim(double[] array) {
    int leadzeroes = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i]==0) {
        leadzeroes++;
      }
    }

    double[] newArray = new double[array.length-leadzeroes];
    for (int i = 0; i < newArray.length; i++) {
      newArray[i] = array[leadzeroes];
    }


  public static double makeHZ(int pitch){
    double hz = 440.0 * Math.pow(2, pitch / 12.0);
    return hz;
  }

}
