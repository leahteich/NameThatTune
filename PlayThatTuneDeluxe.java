public class PlayThatTuneDeluxe {
    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            int pitch = StdIn.readInt();
            double duration = StdIn.readDouble();
            double[] a = MusicLibrary.majorChord(pitch, duration);
            StdAudio.play(a);
            StdAudio.save("major.wav", a);
        }
    }
}
