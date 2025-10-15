import java.util.Scanner;

public class Game {
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