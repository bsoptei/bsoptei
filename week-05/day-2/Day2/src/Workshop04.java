import java.util.ArrayList;

/**
 * Created by Söp on 2016.11.15..
 */
public class Workshop04 {
    public static void main(String[] args) {
        ArrayList<Person> greenFox = new ArrayList<Person>();

        Student laci = new Student("Laci", 25);
        laci.addGrade(4);
        laci.addGrade(5);
        laci.addGrade(5);
        laci.addGrade(3);
        greenFox.add(laci);

        Student peti = new Student("Peti", 39);
        peti.addGrade(3);
        peti.addGrade(2);
        peti.addGrade(5);
        peti.addGrade(3);
        greenFox.add(peti);

        Student szilvi = new Student("Szilvi", 28);
        szilvi.addGrade(5);
        szilvi.addGrade(5);
        szilvi.addGrade(4);
        szilvi.addGrade(5);
        greenFox.add(szilvi);

        Mentor jakab = new Mentor("Jakab", 33, "medior", "java");
        greenFox.add(jakab);

        for (Person p: greenFox) {
            System.out.println(p);
        }

    }

}
