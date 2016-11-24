package Workshop05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Söp on 2016.11.16..
 */
public class App {
    public static void main(String[] args) {
        List<Model> tvModels= new ArrayList<Model>();

        tvModels.add(new Model("Samsung S19E200BW", "19", 5));
        tvModels.add(new Model("LG 19MB35D", "18", 2));
        tvModels.add(new Model("NEC MultiSync EA193Mi", "18", 8));
        tvModels.add(new Model("Asus VE198S", "17", 6));

        tvModels.sort(modelNameComparator);
        System.out.println(tvModels.toString());

        tvModels.sort(modelSizeComparator);
        System.out.println(tvModels.toString());
    }

    public static Comparator<Model> modelNameComparator = new Comparator<Model>() {
        public int compare (Model model1, Model model2) {
            String left = model1.getName().toUpperCase();
            String right = model2.getName().toUpperCase();
            return left.compareTo(right);
        }
    };

    public static Comparator<Model> modelSizeComparator = new Comparator<Model>() {
        public int compare (Model model1, Model model2) {
            String left = model1.getSize();
            String right = model2.getSize();
            return left.compareTo(right);
        }
    };
}
