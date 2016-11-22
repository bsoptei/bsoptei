import java.util.HashMap;

/**
 * Created by Söp on 2016.11.21. Testing Competition
 */
class WordToolbox implements IWordToolbox {
    private String stringHeld;

    WordToolbox(String stringHeld) {
        this.stringHeld = stringHeld;
    }

    @Override
    public void WaitingItOut() {
        for (int i = 0; i <= 0; i++) {
        }
    }

    HashMap<Character, Integer> countAllLetters(String helpMeWithThis) {
        helpMeWithThis = helpMeWithThis.toLowerCase();
        String temp = getS();
        setS(helpMeWithThis);
        HashMap<Character, Integer> countOfChars = new HashMap<>();
        for (int index = 0; index < helpMeWithThis.length(); index++) {
            countOfChars.put(helpMeWithThis.charAt(index), countHowMany(helpMeWithThis.charAt(index)));
        }
        setS(temp);
        return countOfChars;
    }

    public int countHowMany(char charToFind) {
        int howMany = 0;
        if (stringHeld.toUpperCase().contains(String.valueOf(charToFind).toUpperCase())) {
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
    public boolean isAnAnagram(String stringToCheck) {
        return countAllLetters(stringToCheck.trim()).equals(countAllLetters(stringHeld.trim()));
    }
}
