public class RandomGenerate {

public static int[] randNum() {
    int max = 12;
    int min = 0;
    int range = max - min + 1;

    int rand = (int)(Math.random() * range) + min;
    System.out.println(rand);

 }


}
