import java.util.ArrayList;

public class Player {
    public Scene scene;
    private ArrayList<Item> inventory;

    public Scene getScene() {
        return this.scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Player(Scene startingScene) {
        this.scene = startingScene;
        this.inventory = new ArrayList<>();
    }

    public void takeItem(Item item){
        inventory.add(item);
    }

    public String getInventoryString(){
        if (inventory.isEmpty()){
            return "A leltár üres";
        }
        // A StringBuilder objektumot olyan szituációban használják,
        // mint például egy loop ahol sok Stringet fűzünk össze (concate-nalunk)
        // Ez azért kell, mert a Java-ban a String immutable, és egyébként mindig úat hozna létre ami költséges művelet
        StringBuilder returnString = new StringBuilder();
        for (Item item: inventory){
            returnString.append(" ").append(item.getName());
        }
        return returnString.toString();
    }
}