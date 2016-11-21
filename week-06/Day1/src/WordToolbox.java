import java.util.HashMap;

/**
 * Created by Söp on 2016.11.21. Testing Competition
 */
public class WordToolbox implements IWordToolbox {
    private String stringHeld;
    private HashMap<Character, Integer> countOfChars;

    public WordToolbox(String stringHeld) {
        this.stringHeld = stringHeld;
    }

    @Override
    public void WaitingItOut() {
        System.out.println("hi.");
    }

    public void helper() {
        countOfChars = new HashMap<>();
        for (int index = 0; index < stringHeld.length(); index++) {
            countOfChars.put(stringHeld.toLowerCase().charAt(index), countHowMany(stringHeld.charAt(index)));
        }

    }

    public int countHowMany(char charToFind) {
        int howMany = 0;
        if (stringHeld.contains(String.valueOf(charToFind))) {
            for (int i = 0; i < stringHeld.length(); i++) {
                if (stringHeld.substring(i, i + 1).equalsIgnoreCase(String.valueOf(charToFind))) {
                    howMany++;
                }
            }
        }
        return howMany;
    }

    @Override
    public void setS(String s) {
        this.stringHeld = s;
    }

    @Override
    public String getS() {
        return stringHeld;
    }

    @Override
    public boolean isAnAnagram(String stringToCheck) throws Exception {
        helper();
        stringToCheck = stringToCheck.toLowerCase();
        boolean outputBoolean = true;
        if (stringToCheck.length() != getS().length()) {
            outputBoolean = false;
        } else {
            int index = 0;
            while (index < stringToCheck.length() && index < getS().length()) {
                if (countHowMany(stringToCheck.charAt(index)) != getCountOfChars().get(getS().charAt(index))) {
                    outputBoolean = false;
                }
                index++;
            }
        }
        return outputBoolean;
    }

    public HashMap<Character, Integer> getCountOfChars() {
        return countOfChars;
    }

}
