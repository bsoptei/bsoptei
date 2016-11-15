import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.14..
 */
public class Armada {
    private ArrayList<Ship> shipList = new ArrayList<>();
    private String armadaName;

    public Armada(String armadaName) {
        this.armadaName = armadaName;
    }

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    public Ship getShip(int i) {
        return shipList.get(i);
    }

    public Pirate getCrewMember(int shipNum, int pirateNum) {
        return this.getShip(shipNum).getPirate(pirateNum);
    }

    public void addShip(String shipName, String captainName) {
        this.shipList.add(new Ship(shipName, captainName));
    }

    public void createShipsAndCrew(int numShips, int numPeople) {
        for (int i = 1; i <= numShips; i++) {
            this.addShip("Ship " + Integer.toString(i), "Captain " + Integer.toString(i));
            for (int j = 1; j <= numPeople; j++) {
                this.getShip(i - 1).addPirate("Pirate " + i + "/" + j);
            }
        }
    }

    public String toString() {
        if (shipList.isEmpty()) {
            return String.format("Armada: %s.", armadaName);
        } else {
            return String.format("Armada: %s, %s", armadaName, shipList.toString());
        }
    }
}
