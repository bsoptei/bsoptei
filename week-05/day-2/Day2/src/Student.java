import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Söp on 2016.11.15..
 */
public class Student extends Person {
    private ArrayList<Integer> grades = new ArrayList<Integer>();
    private static ArrayList<Integer> oneToFive = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

    public Student() {
        super();
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void addGrade(int grade) {
        if (oneToFive.contains(grade)) {
            grades.add(grade);
        }
    }

    public float getAverage() {
        float sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String toString() {
        return super.toString() + "Average: " + getAverage();
    }

}
