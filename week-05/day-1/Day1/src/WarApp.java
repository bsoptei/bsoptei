/**
 * Created by Söp on 2016.11.14..
 */
public class WarApp {

    public static void main(String[] args) {
        Armada queensFleet = new Armada("Queen's fleet");
        Armada anotherFleet = new Armada("Some totally random fleet");

        System.out.println(queensFleet.toString());
        System.out.println(anotherFleet.toString());

        queensFleet.createShipsAndCrew(1, 2);
        anotherFleet.createShipsAndCrew(1, 2);

        int i = 0;
        int j = 0;

        while (i < queensFleet.getShip(0).getCrewSize() && j < anotherFleet.getShip(0).getCrewSize()) {
            if (queensFleet.getCrewMember(0, i).getStatus() == 2) {
                queensFleet.getCrewMember(0, i).wakeUp();
            } else if (anotherFleet.getCrewMember(0, j).getStatus() == 2) {
                anotherFleet.getCrewMember(0, j).wakeUp();
            }

            queensFleet.getCrewMember(0, i).brawl(anotherFleet.getCrewMember(0, j));
            if (queensFleet.getCrewMember(0, i).getStatus() == 0) {
                queensFleet.getShip(0).removeMember(i);
                i++;
            } else if (anotherFleet.getCrewMember(0, j).getStatus() == 0) {
                anotherFleet.getShip(0).removeMember(j);
                j++;
            }
        }

        System.out.println(queensFleet.toString());
        System.out.println(anotherFleet.toString());
    }


}
