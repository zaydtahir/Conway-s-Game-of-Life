import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {

    public Draw(){
        this.setPreferredSize(new Dimension(1000,1000));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        Main.drawCells(g2D);

    }
}
