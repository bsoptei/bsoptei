package Workshop03;

/**
 * Created by Söp on 2016.11.16..
 */
import com.greenfox.bx.CreditCard;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {


        ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
        int ct = 10;

        for (int i = 0; i<ct; i++) {
            cards.add(new CreditCard(0,"ABC" + i, random16()));
        }

        for (CreditCard iCard: cards) {
            System.out.println(iCard.toString());
            System.out.println(iCard.ValidCard(iCard.getCodeAccount(), iCard.getSumCVV()));
        }

    }

    static String random16() {
        String out ="";
        for(int i = 0; i<16; i++) {
            out += Integer.toString( (int) ( Math.random() * 9));
        }

        return out;
    }
}
