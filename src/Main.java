import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame fr = new JFrame("Приближающийся и удаляющийся шар");
        fr.setPreferredSize(new Dimension(300, 300));
        final JPanel pan = new JPanel();
        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm = new Timer(16, new ActionListener() {
            double scale = 0.1;
            boolean growing = true;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D) pan.getRootPane().getGraphics();
                pan.update(gr);


                int centerX = pan.getWidth() / 2;
                int centerY = pan.getHeight() / 2;

                // Изменение масштаба шара
                if (growing) {
                    scale += 0.01;
                    if (scale >= 1.0) growing = false;
                } else {
                    scale -= 0.01;
                    if (scale <= 0.1) growing = true;
                }


                gr.setColor(Color.WHITE);
                gr.fillRect(0, 0, pan.getWidth(), pan.getHeight());


                gr.setColor(Color.BLUE);
                int radius = (int) (50 * scale);
                gr.fillOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
            }
        });

        tm.start();
    }
}