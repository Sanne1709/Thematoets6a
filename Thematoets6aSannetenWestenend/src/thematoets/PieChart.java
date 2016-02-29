/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thematoets;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Sanne ten Westenend
 */
public class PieChart extends JFrame {

    public PieChart() {
        super("Percentages gevonden artikelen");

        setSize(600, 400);
        setLocation(70, 70);
        show();
    }

    public void paint(Graphics g) {

        g.setColor(Color.yellow);
        g.fillArc(110, 80, 300, 300, 0, 36);
        g.drawString("Aantal %", 420, 80);

        g.setColor(Color.red);
        g.fillArc(110, 80, 300, 300, 36, 120);
        g.drawString("Aantal %", 420, 100);

        g.setColor(Color.blue);
        g.fillArc(110, 80, 300, 300, 120, 240);
        g.drawString("Aantal %", 420, 120);

    }

    public static void main(String args[]) {
        PieChart app = new PieChart();

        app.addWindowListener(
                new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }
        );
    }
}
