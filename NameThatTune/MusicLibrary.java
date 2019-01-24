public class MusicLibrary {
  /**
  *<h1> Shuffle the contents of an array</h1>
  * This method is from the StdRandom library, and it randomly shuffles  the contents of a given array
  *
  *@author    Robert Sedgewick
  *@author    Kevin Wayne
  *@param     a, an array of integer values to be shuffled
  *@return    a, the shuffled array
  **/
  public static int[] shuffle(int[] a) {
      if (a == null) throw new IllegalArgumentException("argument array is null");
      int n = a.length;
      for (int i = 0; i < n; i++) {
          int r = i + StdRandom.uniform(n-i);     // between i and n-1
          int temp = a[i];
          a[i] = a[r];
          a[r] = temp;
      }
      return a;
  }
  /**
  *<h1> Change the volume of music</h1>
  * This scales an array of values representing music
  *
  *@author    Malini Kundamal
  *@author    Leah Teichholtz
  *@param     array, an array of double values
  *@param     volume, a double to scale volume by
  *@return    the new array with higher or lower volume
  **/
public static double[] changeVolume(double[] array, double volume) {
       return MusicTools.scaleArray(array, volume);
     }
/**
*<h1> Create a harmonic chord</h1>
* This adds the lower octave and the higher octave of a root note
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     pitch, an int representing the hZ
*@param     duration, a double, the time to hold a note
*@return    the new harmonic chord
**/
public static double[] harmonic(int pitch, double duration) {
  double hz = 440.0 * Math.pow(2, pitch / 12.0);
  double[] a  = pitch(hz, duration);
  double[] hi = pitch(2*hz, duration);
  double[] lo = pitch(hz/2, duration);
  double[] h  = MusicTools.weightedAddArray(hi, lo, 0.5, 0.5);

  return MusicTools.weightedAddArray(a, h, 0.5, 0.5);
}

/**
*<h1> Delay an array!</h1>
* This delays a section of music to create an echo effect.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     a, the original array to be delayed
*@param     volume, the new volume of the echoed array
*@param     seconds, the time by which to delay the original array
*@return    the new array which includes the echo
**/
public static double[] delay(double[] a, double volume, double seconds){
  int time = (int) (StdAudio.SAMPLE_RATE*seconds);
  double[] delayed = new double[a.length+time];

  for(int i = 0; i < time; i++) {
    delayed[i] = 0;
  }

  for(int i = time; i < a.length+time; i++) {
    delayed[i] = a[i-time];
  }

  return MusicTools.weightedAddArray(a, MusicTools.scaleArray(delayed, volume), .5, .5);
}


/**
*<h1> Fade in some music!</h1>
* This fades in an array, so the volume becomes increasingly louder.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     array, the original array of doubles without the fade filter
*@param     seconds, the integer time over which to fade in
*@return    faded, the array of double values with the fade in effect
**/
public static double[] fadeIn(double[] array, int seconds){
  int time = StdAudio.SAMPLE_RATE*seconds;
  double [] faded = new double [array.length];
  for (int i = 0;i<time;i++) {
    faded[i] = ((array[i])*((float)i)/time);
  }
  for (int i = time; i < array.length; i++) {
    faded[i] = array[i];
  }
  return faded;
}

/**
*<h1> Fade out some music!</h1>
* This fades out an array, so the volume becomes increasingly quieter.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     array, the original array of doubles without the fade filter
*@param     seconds, the integer time over which to fade out
*@return    faded, the array of double values with the fade out effect
**/
public static double[] fadeOut(double[] array, int seconds){
  int time = StdAudio.SAMPLE_RATE*seconds;
  double [] faded = new double [array.length];

  for (int i = array.length-1; i > (array.length-1-time); i--) {
    faded[i] = (array[i]*(((float)array.length-i-1)/time));
  }
  for (int i = array.length-time-1; i > -1; i--) {
    faded[i] = array[i];
  }
  return faded;
}

/**
*<h1> Play a minor chord!</h1>
* This creates a minor chord given a root note.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     pitch, the int value to be the root note of the chord
*@param     duration, the time to play the minor chord
*@return    the minor chord
**/
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

/**
*<h1> Play a major chord!</h1>
* This creates a major chord given a root note.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     pitch, the int value to be the root note of the chord
*@param     duration, the time to play the major chord
*@return    the major chord
**/
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

/**
*<h1> Play a pitch!</h1>
* This creates a pitch given the hz and duration.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     hz, the double to be played
*@param     duration, the time to play the pitch for
*@return    a, the pitch
**/
public static double[] pitch(double hz, double duration) {
    int n = (int) (StdAudio.SAMPLE_RATE * duration);
    double[] a = new double[n+1];
    for (int i = 0; i <= n; i++) {
        a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
    }
    return a;
} //pitch

/**
*<h1> Sum notes!</h1>
* This performs weighted addition of notes.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     a, an array of double values to be summed
*@param     b, an array of double values to be summed
*@param     awt, the double to scale a by
*@param     bwt, the double to scale b by
*@return    the newly summed notes
**/
public static double[] sum(double[] a, double[] b, double awt, double bwt) {
  return MusicTools.weightedAddArray(a, b, awt, bwt);
} //sum


/**
*<h1> Clip a song!</h1>
* This clips a portion of audio so it can't go higher or lower than a certain point.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     array, the original array of double values to be clipped
*@param     max, a double, the maximum value
*@param     min, a double, the minimum value
*@return    the clipped array
**/
public static double[] clip(double[] array, double max, double min) {
  for (int i = 0; i < array.length; i++) {
  if (array[i] >= max) {
    array[i] = max;
  }
  if (array[i] <= min) {
    array[i] = min;
  }
}
  return array;
}

/**
*<h1> Trim zeroes!</h1>
* This trims an array of leading and trailing zeroes.
*
*@author    Malini Kundamal
*@author    Leah Teichholtz
*@param     array, the original array of double values to be trimmed
*@return    trimmed, the array of double values without leading or trailing zeroes
**/
public static double[] trim(double[] array) {
  int length = array.length;
  int start = 0;
  for (int i = 0; i < length; i++) {
    if (array[i] == 0)
      start = i; //if it is 0, record place of 0 and keep going
    else
      length = i; //if its not 0, stop by making length and i the same
  }
  int end = 0;
  length = 0;
  for (int y = array.length-1; y > length; y--) {
    if (array[y]==0)
      end = y;
    else
      length = y;
  }

  double[] trimmed = MusicTools.copyArray(array,start,end); //then copy inbtwn these indices
  return trimmed;

  }

}
