/**
 * Created by Söp on 2016.11.15..
 */
public class Person {
    private String name;
    private int age;

    public Person () {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String toString() {
        return String.format("%s (%d)", name, age);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }
}
