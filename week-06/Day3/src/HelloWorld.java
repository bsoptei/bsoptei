import javax.swing.*;
import java.awt.*;

/**
 * Created by Söp on 2016.11.23. Hello World!
 */
public class HelloWorld extends JFrame {
    private static String[] hellos = {"Mirëdita", "Ahalan", "Parev", "Zdravei", "Nei Ho", "Dobrý den", "Ahoj", "Goddag", "Goede dag, Hallo", "Hello", "Saluton", "Hei", "Bonjour",
            "Guten Tag", "Gia'sou", "Aloha", "Shalom", "Namaste", "Namaste", "Jó napot", "Halló", "Helló", "Góðan daginn", "Halo", "Aksunai", "Qanuipit", "Dia dhuit",
            "Salve", "Ciao", "Kon-nichiwa", "An-nyong Ha-se-yo", "Salvëte", "Ni hao", "Dzien' dobry", "Olá", "Bunã ziua", "Zdravstvuyte", "Hola", "Jambo", "Hujambo", "Hej",
            "Sa-wat-dee", "Merhaba", "Selam", "Vitayu", "Xin chào", "Hylo", "Sut Mae", "Sholem Aleychem", "Sawubona"};

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HelloWorld::new);
    }

    private HelloWorld(){
        this.setTitle("Hello World!");
        this.setSize(400,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int xPos = (dim.width / 2) - (this.getWidth() / 2);
        int yPos = (dim.height / 2) - (this.getHeight() / 2);
        this.setLocation(xPos, yPos);
        JPanel panel1 = new JPanel();
        this.add(panel1);
        JLabel label1 = new JLabel();
        label1.setText("Hello world!");
        panel1.add(label1);
        for (String hello: hellos) {
            panel1.add(new JLabel(hello));
        }
        this.setVisible(true);
    }
}
