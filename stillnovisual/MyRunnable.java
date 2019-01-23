public class MyRunnable implements Runnable {

    private int var;

    public MyRunnable(int var) {
        this.var = var;
    }

    public void run() {

			int pitch = StdIn.readInt();
			double duration = StdIn.readDouble();

			StdDraw.circle(pitch, 50+duration, 50);
			StdDraw.setPenColor(StdDraw.BOOK_RED);
			StdDraw.setPenRadius(.02);
    }
}
