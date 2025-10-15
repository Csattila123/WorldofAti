import java.util.ArrayList;
import java.util.HashMap;

public class Scene {
    private String description;
    private ArrayList<Item> items;
    private HashMap<Direction, Scene> exits;

    public Scene(String description) {
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
    }
    public void setExit(Direction direction, Scene neigbhor){
        // itt adunk hozzá kijáratot a helyszínhez, irány és zomszédhelyszin formájában.
        // A HashMap put metódusa az hasonló az arrayList add()
        // csak ez key (direction) és value(szomszéd) párokat vár mindig
        exits.put(direction, neigbhor);

    }
    public void setItems(Item item){
        items.add(item);
    }
    public Scene getExit(Direction direction){
        return exits.get(direction);
    }

    public String getDescription() {
        return this.description;
    }
}