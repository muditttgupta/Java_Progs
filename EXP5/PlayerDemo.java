class Player {
    String name;
    int age;
    String position;

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public void displayDetails() {
        System.out.println("Player: " + name + ", Age: " + age + ", Position: " + position);
    }

    public void play() {
        System.out.println(name + " is playing.");
    }

    public void train() {
        System.out.println(name + " is training.");
    }
}

class Cricket_Player extends Player {
    public Cricket_Player(String name, int age, String position) {
        super(name, age, position);
    }

    public void play() {
        System.out.println(name + " is batting/bowling in a cricket match.");
    }

    public void train() {
        System.out.println(name + " is practicing in the nets.");
    }
}

class Football_Player extends Player {

    public Football_Player(String name, int age, String position) {
        super(name, age, position);
    }

    public void play() {
        System.out.println(name + " is playing football on the field.");
    }

    public void train() {
        System.out.println(name + " is doing football drills.");
    }
}

class Hockey_Player extends Player {
    public Hockey_Player(String name, int age, String position) {
        super(name, age, position);
    }

    public void play() {
        System.out.println(name + " is playing hockey on the rink.");
    }

    public void train() {
        System.out.println(name + " is practicing passing.");
    }
}

public class PlayerDemo {
    public static void main(String args[]) {
        Player cricketPlayer = new Cricket_Player("Virat Kohli", 35, "Batsman");
        Player footballPlayer = new Football_Player("Leo Messi", 35, "Forward");
        Player hockeyPlayer = new Hockey_Player("Manpreet Singh", 32, "Midfielder");

        cricketPlayer.displayDetails();
        cricketPlayer.play();
        cricketPlayer.train();
        
        System.out.println();

        footballPlayer.displayDetails();
        footballPlayer.play();
        footballPlayer.train();

        System.out.println();

        hockeyPlayer.displayDetails();
        hockeyPlayer.play();
        hockeyPlayer.train();
    }
}



