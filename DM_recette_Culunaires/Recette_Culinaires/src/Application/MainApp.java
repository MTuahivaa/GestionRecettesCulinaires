package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {

    private ApplicationRecetteCulinaire appData;

    public MainApp() {
        appData = new ApplicationRecetteCulinaire();
        creerDonneesTest();

        setTitle("Écran de Connexion");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblUsername = new JLabel("Nom d'utilisateur :");
        JTextField txtUsername = new JTextField();
        JLabel lblPassword = new JLabel("Mot de passe :");
        JPasswordField txtPassword = new JPasswordField();
        JButton btnLogin = new JButton("Se connecter");
        JLabel lblMessage = new JLabel("", SwingConstants.CENTER);
        lblMessage.setForeground(Color.RED);
        JButton btnCreateUser = new JButton("Créer un utilisateur");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());
                if (validerConnexion(username, password)) {
                    lblMessage.setText("Connexion réussie !");
                    afficherEcranPrincipal(username);
                } else {
                    lblMessage.setText("Échec de la connexion. Veuillez réessayer.");
                }
            }
        });
        
        btnCreateUser.addActionListener(new ActionListener() {
        	 @Override
             public void actionPerformed(ActionEvent e) {
                 afficherEcranDeCreationUtilisateur();
             }
        });
        mainPanel.add(lblUsername);
        mainPanel.add(txtUsername);
        mainPanel.add(lblPassword);
        mainPanel.add(txtPassword);
        mainPanel.add(btnLogin);
        mainPanel.add(btnCreateUser);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(lblMessage, BorderLayout.SOUTH);

        setVisible(true);
    }

    private boolean validerConnexion(String username, String password) {
        return appData.getListeUtilisateurs().stream()
                .anyMatch(user -> (user.getNom() + " " + user.getPrenom()).equals(username) && user.getPassword().equals(password));
    }

    private void afficherEcranPrincipal(String User) {
        dispose();

        new PageUtilisateur(appData, User);
    }
    
    private void afficherEcranDeCreationUtilisateur() {
    	
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
