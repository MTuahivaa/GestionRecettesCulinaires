package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {

    private ApplicationRecetteCulinaire appData;

    public MainApp() {
        appData = new ApplicationRecetteCulinaire();
        creerDonneesTest(); // Ajout de données de test

        // Configuration de la fenêtre
        setTitle("Écran de Connexion");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Composants de connexion
        JLabel lblUsername = new JLabel("Nom d'utilisateur :");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Mot de passe :");
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Se connecter");
        JLabel lblMessage = new JLabel("", SwingConstants.CENTER);
        lblMessage.setForeground(Color.RED);

        // Action du bouton
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if (validerConnexion(username, password)) {
                    lblMessage.setText("Connexion réussie !");
                    afficherEcranPrincipal();
                } else {
                    lblMessage.setText("Échec de la connexion. Veuillez réessayer.");
                }
            }
        });

        // Ajout des composants au panneau
        mainPanel.add(lblUsername);
        mainPanel.add(txtUsername);
        mainPanel.add(lblPassword);
        mainPanel.add(txtPassword);
        mainPanel.add(btnLogin);

        // Conteneur principal
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(lblMessage, BorderLayout.SOUTH);

        // Rendre visible
        setVisible(true);
    }

    private boolean validerConnexion(String username, String password) {
        return appData.getListeUtilisateurs().stream()
                .anyMatch(user -> (user.getNom() + " " + user.getPrenom()).equals(username) && user.getPassword().equals(password));
    }

    private void afficherEcranPrincipal() {
        // Fermeture de la fenêtre actuelle
        dispose();

        // Nouvelle fenêtre pour l'écran principal
        JFrame mainFrame = new JFrame("Application Recette Culinaire");
        mainFrame.setSize(500, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        JLabel lblWelcome = new JLabel("Bienvenue dans l'application !", SwingConstants.CENTER);
        JButton btnQuit = new JButton("Quitter");

        btnQuit.addActionListener(e -> System.exit(0));

        panel.add(lblWelcome, BorderLayout.CENTER);
        panel.add(btnQuit, BorderLayout.SOUTH);

        mainFrame.add(panel);
        mainFrame.setVisible(true);
    }

    private void creerDonneesTest() {
        appData.creerUtilisateur(1, "Doe", "John", "password123");
        appData.creerUtilisateur(2, "Smith", "Alice", "securepassword");
        appData.creerUtilisateur(3, "Brown", "Bob", "12345");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainApp::new);
    }
}
