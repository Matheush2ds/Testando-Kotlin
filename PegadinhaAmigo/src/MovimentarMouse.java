import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovimentarMouse extends JFrame {
    private JLabel yesLabel;
    private JLabel noLabel;
    private JLabel messageLabel;
    private Point point;
    private boolean flag = true;

    public MovimentarMouse() {
        setTitle("Aplicativo Teste");

        messageLabel = new JLabel("Você Ama a Tatiane?");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 40));
        yesLabel = new JLabel("Sim");
        yesLabel.setFont(new Font("Arial", Font.BOLD, 25));
        noLabel = new JLabel("Não");
        noLabel.setFont(new Font("Arial", Font.BOLD, 25));
        point = noLabel.getLocation();

        yesLabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Amo você <3");
            }
        });

        noLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (flag) {
                    point = noLabel.getLocation();
                    noLabel.setLocation(point.x + 100, point.y);
                }
            }

            public void mouseExited(MouseEvent e) {
                if (flag) {
                    noLabel.setLocation(point);
                }
            }

            public void mousePressed(MouseEvent e) {
                flag = false;
            }

            public void mouseReleased(MouseEvent e) {
                flag = true;
            }
        });

        JPanel container = new JPanel();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        container.add(messageLabel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        container.add(yesLabel, gbc);
        gbc.gridx = 1;
        container.add(noLabel, gbc);

        add(container);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MovimentarMouse();
    }
}
