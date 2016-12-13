/**
 * Created by Söp on 2016.12.06.. Roman number converter
 */
public class NumberConverter {

    public static void main(String[] args) {

    }

    public static String convert(int arabic) {
        StringBuilder result = new StringBuilder();
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};
        Integer[] values = new Integer[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int remaining = arabic;
        for (int i = 0; i < values.length; i++) {
            remaining = appendRomanNumeral(remaining, values[i], symbols[i], result);
        }
        return result.toString();
    }


    private static int appendRomanNumeral(int numeral, int value, String romanSymbol, StringBuilder builder) {
        while (numeral >= value) {
            builder.append(romanSymbol);
            numeral -= value;
        }
        return numeral;
    }
}


//        StringBuilder temp = new StringBuilder();
//
//        String arabicString = Integer.toString(arabic);
//        for (int index = 0; index < arabicString.length(); index++) {
//            if (arabicString.length() < 2) {
//
//            }
//        }
//
//
//       return temp.toString();

//
//        if (arabic >= 1 && arabic < 4) {
//        for (int i = 1; i <= arabic; i++) {
//        temp.append("I");
//        }
//        } else if (arabic >= 4 && arabic < 9) {
//        temp.append("V");
//        if (arabic - 5 < 0) {
//        temp.insert(0, "I");
//        } else {
//        for (int i = 0; i < arabic - 5; i++) {
//        temp.append("I");
//        }
//        }
//        } else {
//        temp.append("X");
//        if (arabic - 10 < 0) {
//        temp.insert(0, "I");
//        }
//        }
//        if (remaining >= 9) {
//                result.append("IX");
//                remaining -= 9;
//                }
//                if (remaining >= 5) {
//                result.append("V");
//                remaining -= 5;
//                }
//                if (remaining <= 4) {
//                result.append("IV");
//                remaining -= 4;
//                }

//        remaining = appendRomanNumeral(remaining, 10, "X", result);
//        remaining = appendRomanNumeral(remaining, 9, "IX", result);
//        remaining = appendRomanNumeral(remaining, 5, "V", result);
//        remaining = appendRomanNumeral(remaining, 4, "IV", result);


//        HashMap<Integer,String> numberToSymbol = new HashMap<Integer,String>(){{
//            put(10, "X");
//            put(9, "IX");
//            put(5, "V");
//            put(4, "IV");
//        }};

//        for (Map.Entry<Integer,String> entry: numberToSymbol.entrySet()) {
//            remaining =appendRomanNumeral(remaining, entry.getKey(), entry.getValue(), result);
//        }

//        for (int i = 0; i < remaining; i++) {
//            result.append("I");
////        }
//        while (remaining >= 1) {
//            result.append("I");
//            remaining -= 1;
//        }