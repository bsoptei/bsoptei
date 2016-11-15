public class Parrot {
    boolean isAlive;
    String name;
    Pirate master;

    public Parrot(Pirate master, String name) {
        this.isAlive = true;
        this.name = name;
        this.master = master;
    }
    public String toString() {
        return String.format("This parrot is called %s and belongs to %s.", name, master.name.toString());
    }

    public String getName() {
        return name.toString();
    }

    public String getMaster() {
        return master.getName();
    }
}
