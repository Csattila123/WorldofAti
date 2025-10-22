import java.util.Scanner;

public class Game {
    Player player;
    private Display display;

    public Game(){
        display = new ConsoleDisplay();
        Scene enterance = new Scene("A vár bejáratánál állsz. Északra egy nagy faajtó található");
        Scene hall = new Scene("A nagyteremben vagy. Keletre és nyugatra is van egy-egy ajtó");
        Scene armory = new Scene("A fegyvertárban vagy. Látsz egy fényes kard az állványon");

        enterance.setExit(Direction.ESZAK, hall);
        hall.setExit(Direction.DEL, enterance);
        hall.setExit(Direction.NYUGAT, armory);
        armory.setExit(Direction.KELET, hall);

        player = new Player(enterance);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();

    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        display.display("Üdv a várkalandban");

        while (true){
            display.display("----------------------------");
            display.display(player.getCurrentScene().getDescription());
            display.display(">");

            // a scanner nextLine() egy teljes sort olvas be
            String[] words = getCommand(scanner);

            String command = words[0];

            // ha van második szó majd kinyerjük egy ternary operatorral -> ternary operator az ugyanaz mint egy if-then, csak tömör
            String subject = words.length > 1 ? words[1] : "";

            switch (command){
                case "menj":
                    Direction direction = Direction.fromString(subject);
                    movePlayer(direction);
                    break; // ha nincs break tovább menne a következő ágra

                case "kilep":
                    display.display("Köszi a játékot!");
                    scanner.close();
                    return;

                default:
                    display.display("Nem értem a parancsot!");
                    break;
            }
        }
    }

    private static String[] getCommand(Scanner scanner) {
        String input = scanner.nextLine().toLowerCase().trim();
        String[] words = input.split(" ");
        return words;
    }

    private void movePlayer(Direction direction){
        Scene nextScene = player.getCurrentScene().getExit(direction);
        if (nextScene == null){
            display.display("Nem mehetsz arra");
        } else {
            player.setCurrentScene(nextScene);
        }
    }

    /*
    private void display(String message) {
        System.out.println(message);
    }
    */
}