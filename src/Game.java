import java.util.Scanner;

public class Game {

    public Game(){
        Scene enterance = new Scene("A vár bejáratánál állsz. Északra egy nagy faajtó található");
        Scene hall = new Scene("A nagyteremben vagy. Keletre és nyugatra is van egy-egy ajtó");
        Scene armory = new Scene("A fegyvertárban vagy. Látsz egy fényes kard az állványon");

        enterance.setExit(Direction.ESZAK, hall);
        hall.setExit(Direction.DEL, enterance);
        hall.setExit(Direction.NYUGAT, armory);
        armory.setExit(Direction.KELET, hall);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        display("Üdv a várkalandban");

        while (true){

            String input = scanner.nextLine().trim();
            String command = input;

            switch (command){
                case "kilep":
                    display("Köszi a játékot!");
                    scanner.close();
                    return;
            }
        }
    }

    private void display(String message) {
        System.out.println(message);
    }
}