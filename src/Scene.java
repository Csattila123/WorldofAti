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

    public void setExit(Direction direction, Scene neighbor){
        // itt adunk hozzá kijáratott a helyszínhez, irány és szomszédhelyszín formájában
        // a HashMap put() metódus az hasonló az arraylist add() metódusához, új elemet adunk hozzá
        // csak ez a key (direction) és value (neighbor) párokat vár mindig. A Direction egy ENUM
        exits.put(direction, neighbor);
    }

    public void addItem(Item item){
        items.add(item);
    }

    // az adott irányban milyen szomszédos helyszín van
    public Scene getExit(Direction direction){
        return exits.get(direction);
    }

}
