package Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreationUtilisateur extends JFrame {

	public CreationUtilisateur(ApplicationRecetteCulinaire appData) {
		setTitle("Creation d'un nouvel Utilisateur");
		setSize(400, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel createUserPanel = new JPanel();
	    createUserPanel.setLayout(new GridLayout(5, 2, 10, 10));
	    createUserPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

	    // Champs pour saisir les informations utilisateur
	    JLabel lblFirstName = new JLabel("Prénom :");
	    JTextField txtFirstName = new JTextField();
	    JLabel lblLastName = new JLabel("Nom :");
	    JTextField txtLastName = new JTextField();
	    JLabel lblPassword = new JLabel("Mot de passe :");
	    JPasswordField txtPassword = new JPasswordField();
	    JButton btnSave = new JButton("Enregistrer");
	    JLabel lblMessage = new JLabel("", SwingConstants.CENTER);
	    lblMessage.setForeground(Color.RED);

	    // Action associée au bouton "Enregistrer"
	    btnSave.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            String firstName = txtFirstName.getText();
	            String lastName = txtLastName.getText();
	            String password = new String(txtPassword.getPassword());

	            if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty()) {
	                lblMessage.setText("Veuillez remplir tous les champs.");
	            } else {
	                int newId = appData.getListeUtilisateurs().size() + 1; // Générer un ID simple
	                appData.creerUtilisateur(newId, lastName, firstName, password);
	                lblMessage.setText("Utilisateur créé avec succès !");
	                lblMessage.setForeground(Color.GREEN);
	            }
	        }
	    });

	    // Ajout des composants au panneau
	    createUserPanel.add(lblFirstName);
	    createUserPanel.add(txtFirstName);
	    createUserPanel.add(lblLastName);
	    createUserPanel.add(txtLastName);
	    createUserPanel.add(lblPassword);
	    createUserPanel.add(txtPassword);
	    createUserPanel.add(new JLabel("")); // Espacement
	    createUserPanel.add(btnSave);
	    
	    getContentPane().add(createUserPanel, BorderLayout.CENTER);
	    getContentPane().add(lblMessage, BorderLayout.SOUTH);
	    
	    setVisible(true);
	    
	}

}
