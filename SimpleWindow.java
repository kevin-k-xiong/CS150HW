import javax.swing.*;
import java.awt.FlowLayout;

public class SimpleWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First Window");

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Hello World");
        frame.add(label);

        JButton button = new JButton("Do this work?");
        frame.add(button);

        button.addActionListener(e -> {
            System.out.println("Button Clicked");
        });

        frame.setVisible(true);
    }

}
