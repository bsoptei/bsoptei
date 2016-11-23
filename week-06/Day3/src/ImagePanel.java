import javax.swing.*;
import java.awt.*;

class ImagePanel extends JPanel {
    private Image image;

    ImagePanel(){
        image=this.getToolkit().createImage("C:\\Users\\Söp\\Greenfox\\bsoptei\\week-06\\Day3\\src\\David-Hasselhoff-face.jpg");
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(image,0,0,getWidth(),getHeight(),this);
    }
}