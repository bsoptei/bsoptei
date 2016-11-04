public class DeadAnts{
    static int totalNumberOfDeaths = 0;
    static String[] ant = {"a", "n", "t"};
    static String firstGroup = ".";
    static String secondGroup = firstGroup;
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.printf("Round %d\n", i);
            if (i < 10) {
                firstGroup = marchOfTheFireAnts(firstGroup, "..") + firstGroup;
            } else {
                secondGroup = marchOfTheFireAnts(secondGroup, "...") + secondGroup;
                firstGroup = "." + firstGroup;
            }
            System.out.println("1st group of ants: " + firstGroup);
            System.out.println("2nd group of ants: " + secondGroup);
            System.out.println("Number of deaths in this round is " + countDeadAnts(firstGroup, secondGroup));
        }
        System.out.println("The total number of deaths is " + totalNumberOfDeaths);
    }
    static String marchOfTheFireAnts(String inputAnts, String spaceBetween) {
        String marchingAnts = (Math.random() < 0.5 && inputAnts.startsWith(".")) ? ("ant") : spaceBetween;
        return marchingAnts;
    }
    static int countDeadAnts(String first, String second) {
        if (!second.isEmpty()) {
            int numberOfDeadAnts = 0;
            int index = 0;
            while (index < second.length() - 1 && index < first.length() - 1) {
                if (second.charAt(index) == 't' && first.charAt(index) != '.') {
                    numberOfDeadAnts++;
                    replaceAntWithDots(index);
                    index += 3;
                } else {
                    index ++;
                }
            }
            totalNumberOfDeaths += numberOfDeadAnts;
            return numberOfDeadAnts;
        } else {
            return 0;
        }
    }
    static void replaceAntWithDots(int where) {
        for (String letter: ant) {
            firstGroup = firstGroup.replaceFirst(letter, ".");
        }
    }
}