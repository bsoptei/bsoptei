/**
 * Created by Söp on 2016.11.14..
 */
public class BattleApp {
    public static void main(String[] args) {
//        Pirate captainOne = new Pirate("Sick Fuck");
//        System.out.println(captainOne.name);
        Ship shipOne = new Ship("Prince Rupert's Dog", "Slippery Handspike Catherine");
        shipOne.addPirate("Barnacle Barbara");
        shipOne.addPirate("Windlass Ethel");
        shipOne.addPirate("Mighty Eye Ellen");

        Ship shipTwo = new Ship("Lady Vanessa's Serpent", "Tiller Faced James");
        shipTwo.addPirate("Clewline Nathaniel");
        shipTwo.addPirate("Bucket Ralph");
        shipTwo.addPirate("Green Lanyard Henry");

//        System.out.println(shipOne.toString());
//        System.out.println(shipTwo.toString());
//        while (!shipOne.isAllDead() && !shipTwo.isAllDead()) {
//            for (Pirate pirate : shipOne.getCrew()) {
//                if (pirate.status == 2) {
//                    pirate.wakeUp();
//                } else if (pirate.status == 1) {
//                    for (Pirate opponent: shipTwo.getCrew()) {
//                        pirate.brawl(opponent);
//                    }
//                }
//            }
//        }



        System.out.println(shipOne.toString());
        System.out.println(shipTwo.toString());
    }


}

