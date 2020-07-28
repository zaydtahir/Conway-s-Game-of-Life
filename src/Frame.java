import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    Draw draw;

    public Frame(){
        this.setTitle("Conway's Game of Life");
        this.setSize(750,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        draw = new Draw();
        this.add(draw);
        this.pack();
    }


}
