    public class Workshop37 {
        public static void main(String[] args) {
            // Write a program which has this output
            //# # # # # # #
            //  # # # # # # #
            // # # # # # # #
            //  # # # # # # #
            // # # # # # # #
            //  # # # # # # #
            // # # # # # # #
            // The # character should be replacable, hence store it in a variable
            char c = '#';
            for (int i = 1; i <=7; i++) {
                String output = "";

                    if (i % 2 == 1) {
                        for (int j = 1; j <= 13; j++) {
                            if (j % 2 == 1) {
                                output = output.concat(Character.toString(c));
                            } else {
                                output = output.concat(" ");
                            }
                        }
                    }
                    else {
                        for (int j = 1; j <= 15; j++) {
                            if (j % 2 == 1 && j >= 3) {
                                output = output.concat(Character.toString(c));
                            } else {
                                output = output.concat(" ");
                            }
                        }
                    }
                System.out.println(output);
            }
        }
    }