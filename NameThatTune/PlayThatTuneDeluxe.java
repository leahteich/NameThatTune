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

public class PlayThatTuneDeluxe {

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

    // create a pure tone of the given frequency for the given duration
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
    public static double[] note(int pitch, double duration) {
        double hz = 440.0 * Math.pow(2, pitch / 12.0);
        double[] a  = tone(hz, duration);
        double[] hi = tone(2*hz, duration);
        double[] lo = tone(hz/2, duration);
        double[] h  = sum(hi, lo, 0.5, 0.5);
        return sum(h, lo, 0.5, 0.5);
    }


    // read in notes from standard input and play them on standard audio
    public static void main(String[] args) {

        // read in pitch-duration pairs from standard input
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            int type = StdIn.readInt();

            if (type == 1) {
              double[] a = MusicLibrary.majorChord(pitch, duration);
                    StdDraw.square(.05,.5,.1);
                    StdDraw.square(.1,.5,.1);
                    StdDraw.square(.15,.5,.1);
                    StdDraw.square(.2,.5,.1);
                    StdDraw.square(.25,.5,.1);
                    StdDraw.square(.3,.5,.1);
                    StdDraw.square(.35,.5,.1);
                    StdDraw.square(.4,.5,.1);
                    StdDraw.square(.45,.5,.1);
                    StdDraw.square(.5,.5,.1);
                    StdDraw.square(.55,.5,.1);
                    StdDraw.square(.6,.5,.1);
                    StdDraw.square(.65,.5,.1);
                    StdDraw.square(.7,.5,.1);
                    StdDraw.square(.75,.5,.1);
                    StdDraw.square(.8,.5,.1);
                    StdDraw.square(.85,.5,.1);
                    StdDraw.square(.9,.5,.1);


               if (pitch<1||pitch==1||pitch>1&&pitch<3){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);
                 StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                 StdDraw.filledSquare(.05,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
               }

               else if(pitch==3||pitch>3&&pitch<5){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();

                 StdDraw.setPenColor(StdDraw.BOOK_RED);
                 StdDraw.filledSquare(.1,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();

                 //StdDraw.filledCircle(.5,.5,.3);
               }

               else if(pitch==5||pitch>5&&pitch<7){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                 StdDraw.filledSquare(.15,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);
               }

               else if(pitch==7||pitch>7&&pitch<9){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.filledSquare(.2,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==9||pitch>9&&pitch<11){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.YELLOW);
                 StdDraw.filledSquare(.25,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==11||pitch>11&&pitch<13){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.ORANGE);
                 StdDraw.filledSquare(.3,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==13||pitch>13&&pitch<15){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.WHITE);
                 StdDraw.filledSquare(.35,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==15||pitch>15&&pitch<17){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.GREEN);
                 StdDraw.filledSquare(.4,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                // StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==17||pitch>17&&pitch<19){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.PINK);
                 StdDraw.filledSquare(.45,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==19||pitch>19&&pitch<21){
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 StdDraw.setPenColor(StdDraw.GRAY);
                 StdDraw.filledSquare(.5,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }

               else if(pitch==21||pitch>21&&pitch<23){
                 StdDraw.setPenColor(StdDraw.MAGENTA);
                 StdDraw.filledSquare(.55,.5,.1);
                 StdDraw.setPenColor(StdDraw.BLACK);
                 StdDraw.setPenRadius();
                 //StdDraw.filledCircle(.5,.5,.3);

               }
               StdAudio.play(a);

            }
            if (type == 2) {
              double[] a = MusicLibrary.minorChord(pitch, duration);

              StdDraw.square(.05,.5,.1);
              StdDraw.square(.1,.5,.1);
              StdDraw.square(.15,.5,.1);
              StdDraw.square(.2,.5,.1);
              StdDraw.square(.25,.5,.1);
              StdDraw.square(.3,.5,.1);
              StdDraw.square(.35,.5,.1);
              StdDraw.square(.4,.5,.1);
              StdDraw.square(.45,.5,.1);
              StdDraw.square(.5,.5,.1);
              StdDraw.square(.55,.5,.1);
              StdDraw.square(.6,.5,.1);
              StdDraw.square(.65,.5,.1);
              StdDraw.square(.7,.5,.1);
              StdDraw.square(.75,.5,.1);
              StdDraw.square(.8,.5,.1);
              StdDraw.square(.85,.5,.1);
              StdDraw.square(.9,.5,.1);

         if (pitch<1||pitch==1||pitch>1&&pitch<3){

           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           //StdDraw.filledCircle(.5,.5,.3);
           StdDraw.setPenColor(StdDraw.BOOK_BLUE);
           StdDraw.filledSquare(.05,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();

         }

         else if(pitch==3||pitch>3&&pitch<5){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();

           StdDraw.setPenColor(StdDraw.BOOK_RED);
           StdDraw.filledSquare(.1,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();

           //StdDraw.filledCircle(.5,.5,.3);
         }

         else if(pitch==5||pitch>5&&pitch<7){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
           StdDraw.filledSquare(.15,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           //StdDraw.filledCircle(.5,.5,.3);
         }

         else if(pitch==7||pitch>7&&pitch<9){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.filledSquare(.2,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           //StdDraw.filledCircle(.5,.5,.3);

         }

         else if(pitch==9||pitch>9&&pitch<11){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.YELLOW);
           StdDraw.filledSquare(.25,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           //StdDraw.filledCircle(.5,.5,.3);

         }

         else if(pitch==11||pitch>11&&pitch<13){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.ORANGE);
           StdDraw.filledSquare(.3,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           //StdDraw.filledCircle(.5,.5,.3);

         }

         else if(pitch==13||pitch>13&&pitch<15){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.WHITE);
           StdDraw.filledSquare(.35,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           //StdDraw.filledCircle(.5,.5,.3);

         }

         else if(pitch==15||pitch>15&&pitch<17){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.GREEN);
           StdDraw.filledSquare(.4,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
          // StdDraw.filledCircle(.5,.5,.3);

         }

         else if(pitch==17||pitch>17&&pitch<19){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.PINK);
           StdDraw.filledSquare(.45,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
         }
         else if(pitch==19||pitch>19&&pitch<21){
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
           StdDraw.setPenColor(StdDraw.GRAY);
           StdDraw.filledSquare(.5,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
         }
         else if(pitch==21||pitch>21&&pitch<23){
           StdDraw.setPenColor(StdDraw.MAGENTA);
           StdDraw.filledSquare(.55,.5,.1);
           StdDraw.setPenColor(StdDraw.BLACK);
           StdDraw.setPenRadius();
         }
         StdAudio.play(a);


  }
            if (type == 3) {
              double[] a = MusicLibrary.harmonic(pitch, duration);
                  StdDraw.square(.05,.5,.1);
                  StdDraw.square(.1,.5,.1);
                  StdDraw.square(.15,.5,.1);
                  StdDraw.square(.2,.5,.1);
                  StdDraw.square(.25,.5,.1);
                  StdDraw.square(.3,.5,.1);
                  StdDraw.square(.35,.5,.1);
                  StdDraw.square(.4,.5,.1);
                  StdDraw.square(.45,.5,.1);
                  StdDraw.square(.5,.5,.1);
                  StdDraw.square(.55,.5,.1);
                  StdDraw.square(.6,.5,.1);
                  StdDraw.square(.65,.5,.1);
                  StdDraw.square(.7,.5,.1);
                  StdDraw.square(.75,.5,.1);
                  StdDraw.square(.8,.5,.1);
                  StdDraw.square(.85,.5,.1);
                  StdDraw.square(.9,.5,.1);
             if (pitch<1||pitch==1||pitch>1&&pitch<3){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.BOOK_BLUE);
               StdDraw.filledSquare(.05,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==3||pitch>3&&pitch<5){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.BOOK_RED);
               StdDraw.filledSquare(.1,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==5||pitch>5&&pitch<7){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
               StdDraw.filledSquare(.15,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==7||pitch>7&&pitch<9){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.filledSquare(.2,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();

             }

             else if(pitch==9||pitch>9&&pitch<11){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.YELLOW);
               StdDraw.filledSquare(.25,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();

             }

             else if(pitch==11||pitch>11&&pitch<13){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.ORANGE);
               StdDraw.filledSquare(.3,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==13||pitch>13&&pitch<15){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.WHITE);
               StdDraw.filledSquare(.35,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==15||pitch>15&&pitch<17){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.GREEN);
               StdDraw.filledSquare(.4,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==17||pitch>17&&pitch<19){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.PINK);
               StdDraw.filledSquare(.45,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==19||pitch>19&&pitch<21){
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
               StdDraw.setPenColor(StdDraw.GRAY);
               StdDraw.filledSquare(.5,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }

             else if(pitch==21||pitch>21&&pitch<23){
               StdDraw.setPenColor(StdDraw.MAGENTA);
               StdDraw.filledSquare(.55,.5,.1);
               StdDraw.setPenColor(StdDraw.BLACK);
               StdDraw.setPenRadius();
             }
             StdAudio.play(a);
            }
            //StdAudio.save("harmonic.wav", a);
        }
    }
}
