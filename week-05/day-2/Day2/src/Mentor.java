/**
 * Created by Söp on 2016.11.15..
 */
public class Mentor extends Person {
    private String seniorityLevel;

    public String getSeniorityLevel() {
        return seniorityLevel;
    }

    public String getSubject() {
        return subject;
    }

    private String subject;

    public Mentor() {
        super();
    }

    public Mentor(String name, int age) {
        super(name, age);
    }

    public Mentor(String name, int age, String seniorityLevel, String subject) {
        super(name, age);
        this.seniorityLevel = seniorityLevel;
        this.subject = subject;
    }

    public String toString() {
        return super.toString() + " Seniority: " + getSeniorityLevel() + " Subject: " + getSubject();
    }

}
