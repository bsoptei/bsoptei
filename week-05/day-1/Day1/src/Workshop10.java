import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.14..
 */
public class Workshop10 {
    public static void main(String[] args) {
        ArrayList<Pirate> listOfPirates = new ArrayList<Pirate>();
        listOfPirates.add(new Pirate("Long Djohn Silvah"));
        listOfPirates.add(new Pirate("Jax Parrow"));
        listOfPirates.add(new Pirate("Bloody Beard"));

        listOfPirates.get(0).drinkSomeRum();
        listOfPirates.get(1).brawl(listOfPirates.get(2));

        Parrot firstParrot = new Parrot(listOfPirates.get(0),"Angry Bird" );
        System.out.println(firstParrot.master);
        System.out.println(firstParrot.name.toString());
        listOfPirates.get(0).inventory.add(firstParrot);
        System.out.println(firstParrot.getMaster());
        System.out.println(firstParrot.getName());
        System.out.println(listOfPirates.get(0).inventory.get(0).toString());

    }
}
