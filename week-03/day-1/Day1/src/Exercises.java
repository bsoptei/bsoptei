public class Exercises {
    public static void main(String[] args) {
        byte a = -127;
        byte b = 2;
//        byte c = 278;
        short d = -32768;
//        short e = 65000;
        short f = 567;
        int g = 12;
        Integer h = 13;
        long i = 200;
        long j = 30000000000000L;
        long k = -34500000000L;
        float l = 1.3f;
        float m = 45f;
        Float n = 0f;
        double o = 23.03013103103d;
        Double p = 1d;
        int aa = 3 + 4;
        int bb = 6 * 7;
        int cc = 8 / 4;
        int dd = 8 % 4;
        int ee = 8 % 5;
        int ff = 8;
        ff *= 3;
        ff /= 6;

        Boolean trueCondition = Boolean.TRUE;
        System.out.println(trueCondition);

        boolean trueBool = true;
        boolean falseBool = false;

        boolean isBigger = 3 > 4;
        boolean isTheSame = 5 == 5;

        String actionsProverb = "Actions speak louder than words";
        char firstChar = actionsProverb.charAt(0);
        System.out.println(firstChar);

        String concated = "Hope for the best " + "but";
        concated = concated + " prepare";
        concated += " for ";
        concated.concat("the worst.");
        System.out.println(concated);

        String strWithSpecialCharacters = "I can \"put\" special 'characters in a \\string\\.";
        System.out.println(strWithSpecialCharacters);

        int myLength = "what is my length?".length();
        System.out.println(myLength);

        System.out.println(strWithSpecialCharacters.length());

        String emptyString = "";
        System.out.println("Is \"emptyString\" empty?" + emptyString.isEmpty());
        System.out.println("Is \"actionsProverb\" empty?" + actionsProverb.isEmpty());

        System.out.println(actionsProverb.contains("than"));
        System.out.println(actionsProverb.contains("five"));

        System.out.println(actionsProverb.indexOf("t"));
        System.out.println(actionsProverb.indexOf("t", 3));
        System.out.println(actionsProverb.indexOf("thinking"));

        System.out.println(actionsProverb.lastIndexOf("t"));

        System.out.println(actionsProverb.substring(0,7));
        System.out.println(actionsProverb.substring(14, 20));

        System.out.println(String.format("I have %d cats.", 2));
        System.out.println(String.format("I have %d %s and I love them.", 2, "raptors"));

        System.out.println("a".compareTo("b"));
        System.out.println("b".compareTo("a"));
        System.out.println("a".compareTo("c"));
        System.out.println("a".compareTo("deli"));
        System.out.println("a".compareTo("a"));

        System.out.println("a".compareToIgnoreCase("A"));

        String weakestLinkProverb = "A rope is only as strong as its weakest link.";
        System.out.println(weakestLinkProverb.replace("rope", "chain"));
        System.out.println(weakestLinkProverb.replace("a", "b"));

        System.out.println("How much is the fish?".toUpperCase());
        System.out.println("HOOOORRRAAAAAYYYY".toLowerCase());
        System.out.println("     string with lots of spaces      ".trim());




    }
}