interface Playable {
    void play();
    void pause();
    void stop();
}

class MusicPlayer implements Playable {
    public void play() {
        System.out.println("Music is playing");
    }

    public void pause() {
        System.out.println("Music is paused");
    }

    public void stop() {
        System.out.println("Music is stopped");
    }
}

public class TestPlayer {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.play();
        player.pause();
        player.stop();
    }
}