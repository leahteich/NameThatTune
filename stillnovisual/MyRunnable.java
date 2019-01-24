public class MyRunnable implements Runnable {

    private int var;

    public MyRunnable(int var) {
        this.var = var;
    }

    public void run() {

			int pitch = StdIn.readInt();
			double duration = StdIn.readDouble();
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

      if (pitch<1){
        StdDraw.filledSquare(.05,.5,.1);
      }

      else if(pitch==1||pitch>1&&pitch<2){
        StdDraw.filledSquare(.1,.5,.1);
      }

      else if(pitch==2||pitch>2&&pitch<3){
        StdDraw.filledSquare(.15,.5,.1);
      }

      else if(pitch==3||pitch>3&&pitch<4){
        StdDraw.filledSquare(.2,.5,.1);
      }

      else if(pitch==4||pitch>4&&pitch<5){
        StdDraw.filledSquare(.25,.5,.1);
      }

      else if(pitch==5||pitch>5&&pitch<6){
        StdDraw.filledSquare(.3,.5,.1);
      }

      else if(pitch==6||pitch>6&&pitch<7){
        StdDraw.filledSquare(.35,.5,.1);
      }

      else if(pitch==7||pitch>7&&pitch<8){
        StdDraw.filledSquare(.4,.5,.1);
      }

      else if(pitch==8||pitch>8&&pitch<9){
        StdDraw.filledSquare(.45,.5,.1);
      }

      else if(pitch==9||pitch>9&&pitch<10){
        StdDraw.filledSquare(.5,.5,.1);
      }

      else if(pitch==10||pitch>10&&pitch<11){
        StdDraw.filledSquare(.55,.5,.1);
      }

      else if(pitch==11||pitch>11&&pitch<12){
        StdDraw.filledSquare(.6,.5,.1);
      }

      else if(pitch==12||pitch>12&&pitch<13){
        StdDraw.filledSquare(.65,.5,.1);
      }

      else if(pitch==13||pitch>13&&pitch<14){
        StdDraw.filledSquare(.7,.5,.1);
      }

      else if(pitch==14||pitch>14&&pitch<15){
        StdDraw.filledSquare(.75,.5,.1);
      }

      else if(pitch==15||pitch>15&&pitch<16){
        StdDraw.filledSquare(.8,.5,.1);
      }

      else if(pitch==16||pitch>16&&pitch<17){
        StdDraw.filledSquare(.85,.5,.1);
      }

      else if(pitch==16||pitch>17&&pitch<50){
        StdDraw.filledSquare(.9,.5,.1);
      }




//circles
                       /*if (pitch<1){
                        StdDraw.circle(.02, .02, .025);
                        StdDraw.setPenColor(StdDraw.BOOK_RED);
                        StdDraw.setPenRadius(.02);
                        StdDraw.clear();

                       }


                     else if(pitch==1||pitch>1&&pitch<2){
                       StdDraw.circle(.02, .02, .05);
                       StdDraw.setPenColor(StdDraw.BOOK_RED);
                       StdDraw.setPenRadius(.02);
                       StdDraw.clear();

                     }
                       else if(pitch==2||pitch>2&&pitch<3){
                         StdDraw.circle(.02, .02, .075);
                         StdDraw.setPenColor(StdDraw.BOOK_RED);
                         StdDraw.setPenRadius(.02);
                         StdDraw.clear();

                       }
                         else if(pitch==3||pitch>3&&pitch<4){
                           StdDraw.circle(.02, .02, .1);
                           StdDraw.setPenColor(StdDraw.BOOK_RED);
                           StdDraw.setPenRadius(.02);
                           StdDraw.clear();
                         }
                           else if(pitch==4||pitch>4&&pitch<5){
                             StdDraw.circle(.02, .02, .125);
                             StdDraw.setPenColor(StdDraw.BOOK_RED);
                             StdDraw.setPenRadius(.02);
                             StdDraw.clear();

                           }
                             else if(pitch==5||pitch>5&&pitch<6){
                               StdDraw.circle(.02, .02, .15);
                               StdDraw.setPenColor(StdDraw.BOOK_RED);
                               StdDraw.setPenRadius(.02);
                               StdDraw.clear();

                             }
                               else if(pitch==6||pitch>6&&pitch<7){
                                 StdDraw.circle(.02, .02, .175);
                                 StdDraw.setPenColor(StdDraw.BOOK_RED);
                                 StdDraw.setPenRadius(.02);
                                 StdDraw.clear();

                               }
                                 else if(pitch==7||pitch>7&&pitch<8){
                                   StdDraw.circle(.02, .02, .2);
                                   StdDraw.setPenColor(StdDraw.BOOK_RED);
                                   StdDraw.setPenRadius(.02);
                                   StdDraw.clear();

                                 }
                                   else if(pitch==8||pitch>8&&pitch<9){
                                     StdDraw.circle(.02, .02, .225);
                                     StdDraw.setPenColor(StdDraw.BOOK_RED);
                                     StdDraw.setPenRadius(.02);
                                     StdDraw.clear();

                                   }
                                     else if(pitch==9||pitch>9&&pitch<10){
                                       StdDraw.circle(.02, .02, .25);
                                       StdDraw.setPenColor(StdDraw.BOOK_RED);
                                       StdDraw.setPenRadius(.02);
                                       StdDraw.clear();

                                     }
                                       else if(pitch==10||pitch>10&&pitch<11){
                                         StdDraw.circle(.02, .02, .275);
                                         StdDraw.setPenColor(StdDraw.BOOK_RED);
                                         StdDraw.setPenRadius(.02);
                                         StdDraw.clear();

                                       }
                                         else if(pitch==11||pitch>11&&pitch<12){
                                           StdDraw.circle(.02, .02, .3);
                                           StdDraw.setPenColor(StdDraw.BOOK_RED);
                                           StdDraw.setPenRadius(.02);
                                           StdDraw.clear();

                                         }
                                           else if(pitch==12||pitch>12&&pitch<13){
                                             StdDraw.circle(.02, .02, .325);
                                             StdDraw.setPenColor(StdDraw.BOOK_RED);
                                             StdDraw.setPenRadius(.02);
                                             StdDraw.clear();

                                           }
                                             else if(pitch==13||pitch>13&&pitch<14){
                                               StdDraw.circle(.02, .02, .35);
                                               StdDraw.setPenColor(StdDraw.BOOK_RED);
                                               StdDraw.setPenRadius(.02);
                                               StdDraw.clear();

                                             }
                                               else if(pitch==14||pitch>14&&pitch<15){
                                                 StdDraw.circle(.02, .02, .375);
                                                 StdDraw.setPenColor(StdDraw.BOOK_RED);
                                                 StdDraw.setPenRadius(.02);
                                                 StdDraw.clear();

                                               }
                                                 else if(pitch==15||pitch>15&&pitch<16){
                                                   StdDraw.circle(.02, .02, .4);
                                                   StdDraw.setPenColor(StdDraw.BOOK_RED);
                                                   StdDraw.setPenRadius(.02);
                                                   StdDraw.clear();

                                                 }
                                                   else if(pitch==16||pitch>16&&pitch<17){
                                                     StdDraw.circle(.02, .02, .425);
                                                     StdDraw.setPenColor(StdDraw.BOOK_RED);
                                                     StdDraw.setPenRadius(.02);
                                                     StdDraw.clear();

                                                   }

                                                       else if(pitch==16||pitch>17&&pitch<50){
                                                         StdDraw.circle(.02, .02, .45);
                                                         StdDraw.setPenColor(StdDraw.BOOK_RED);
                                                         StdDraw.setPenRadius(.02);
                                                         StdDraw.clear();

                                                       }*/

      //black piano keys
        /*StdDraw.filledSquare(.15,.9,.1);
        StdDraw.filledSquare(.25,.9,.1);
        StdDraw.filledSquare(.35,.9,.1);
        StdDraw.filledSquare(.45,.9,.1);
        StdDraw.filledSquare(.55,.9,.1);
        StdDraw.filledSquare(.65,.9,.1);
        StdDraw.filledSquare(.75,.9,.1);
        StdDraw.filledSquare(.85,.9,.1);
        StdDraw.filledSquare(.95,.9,.1);
        StdDraw.filledSquare(1.05,.9,.1);*/

}
}
