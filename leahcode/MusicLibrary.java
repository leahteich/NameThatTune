
//harmonic – adds both a high and a low octave to a root note
//minorChord- forms a minor chord around a root note
//majorChord- forms a major chord around a root note
//pitch- translates one note from your sheet music into a “sine wave”
//sum- adds two sine waves
//trim - removes leading and trailing 0’s from your array
//delay- repeats a tone based on an echo volume and time interval
//changeVolume- scales the amplitude of the tone according to a decimal (i.e .80 or 1.20)
//fade- scales the amplitude of the first/last n seconds from 0 to usual value (or vice versa) depending on parameter: “In”, “Out”. Feel free to use either a linear or logarithmic fade pattern.
//clip- establishes a max/min for the amplitude of a sound wave. Values that exceed the boundaries of the range are replaced with the max/min


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
}
public static double[] majorChord(int pitch, double duration) {
    double hz = 440.0 * Math.pow(2, pitch / 12.0);
    double m = 440.0 * Math.pow(2, (pitch + 4) / 12.0);
    double p = 440.0 * Math.pow(2, (pitch + 7) / 12.0);
    double[] a  = pitch(hz, duration);
    double[] mid = pitch(m, duration);
    double[] hi = pitch(p, duration);
    double[] h  = MusicTools.weightedAddArray(mid, hi, 0.5, 0.5);
    return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
}

public static double[] pitch(double hz, double duration) {
    int n = (int) (StdAudio.SAMPLE_RATE * duration);
    double[] a = new double[n+1];
    for (int i = 0; i <= n; i++) {
        a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
    }
    return a;
}

public static double[] sum(double[] a, double[] b, double awt, double bwt) {
  return MusicTools.weightedAddArray(a, b, awt, bwt);
}

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

}
//public static double[] delay(double volume, double duration) {}
//public static double[] changeVolume(double[] array, double scalar) {}
//public static double[] fade(double in, double out) {}
//public static double[] clip(double bound) {}


public static double makeHZ(int pitch){
  double hz = 440.0 * Math.pow(2, pitch / 12.0);
  return hz;
}

}
