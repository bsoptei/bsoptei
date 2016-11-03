public class Workshop28{
    public static void main(String[] args) {
        int z = 13;
        // if z is between 10 and 20 print 'Sweet!'
        // if less than 10 print 'More!',
        // if more than 20 print 'Less!'
        if (z >= 10 && z <= 20) {
            System.out.println("Sweet!");
        } else if (z < 10) {
            System.out.println("More!");
        } else {
            System.out.println("Less!");
        }
    }
}