public class RandomGenerate {

public static int[] randNum() {
    int max = 12;
    int min = 0;
    int range = max - min + 1;

    for (int i = 0; i < 10; i++) {
       int rand = (int)(Math.random() * range) + min;
       System.out.println(rand);
   }
 }


}
