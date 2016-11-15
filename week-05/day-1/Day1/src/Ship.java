import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.14..
 */
public class Ship {
    private ArrayList<Pirate> crew = new ArrayList<>();
    private Pirate captain;
    String name;

    public Ship(String shipName, String captainName) {
        this.name = shipName;
        this.captain = new Pirate(captainName);
    }

    public Pirate getPirate(int pirateNum) {
        return crew.get(pirateNum);
    }

    public int getCrewSize() {
        return crew.size();
    }

    public void removeMember(int pirateNum) {
        this.crew.remove(pirateNum);
    }

    public Pirate getCaptain() {
        return captain;
    }

    public ArrayList<Pirate> getCrew() {
        return crew;
    }

    public void addPirate(String pirateName) {
        this.crew.add(new Pirate(pirateName));
    }

    public boolean isAllDead() {
        boolean allDead = true;
        for (Pirate pirate: crew) {
            if (pirate.getStatus() != 0) {
                allDead = false;
            }
        }
        return allDead;
    }

    public String toString() {
        if (crew.isEmpty()) {
         return String.format("Ship name: %s, ship captain: %s.", name, captain.name);
        } else {
            return String.format("Ship name: %s, ship captain: %s , crew: %s ", name, captain.toString(), crew.toString());
        }
    }
}
