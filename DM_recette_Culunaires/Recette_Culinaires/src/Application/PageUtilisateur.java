package Application;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PageUtilisateur {

	public PageUtilisateur(ApplicationRecetteCulinaire Appdata, String User) {

        JFrame mainFrame = new JFrame("Application Recette Culinaire");
        mainFrame.setSize(500, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblWelcome = new JLabel("Bienvenue " + User, SwingConstants.CENTER);
        JButton btnQuit = new JButton("Quitter");

        btnQuit.addActionListener(e -> System.exit(0));

        panel.add(lblWelcome, BorderLayout.NORTH);
        panel.add(btnQuit, BorderLayout.SOUTH);

        mainFrame.add(panel);
        mainFrame.setVisible(true);
	}

}
