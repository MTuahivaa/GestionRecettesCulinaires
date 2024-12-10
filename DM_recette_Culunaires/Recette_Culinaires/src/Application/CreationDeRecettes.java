package Application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreationDeRecettes {

    public CreationDeRecettes() {
        // Créer la fenêtre principale (JFrame)
        JFrame frame = new JFrame("Gestion des Recettes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        // Créer un JPanel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Panel pour les champs de saisie
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 10, 10));

        // Champs de saisie
        JLabel titreLabel = new JLabel("Titre de la recette:");
        JTextField titreField = new JTextField();

        JLabel descriptionLabel = new JLabel("Description:");
        JTextField descriptionField = new JTextField();

        JLabel ingredientsLabel = new JLabel("Ingrédients (séparés par des virgules):");
        JTextField ingredientsField = new JTextField();

        // Ajouter les composants au panel de saisie
        inputPanel.add(titreLabel);
        inputPanel.add(titreField);
        inputPanel.add(descriptionLabel);
        inputPanel.add(descriptionField);
        inputPanel.add(ingredientsLabel);
        inputPanel.add(ingredientsField);

        // Panel pour les boutons
        JPanel buttonPanel = new JPanel();
        JButton ajouterButton = new JButton("Ajouter Recette");
        JButton afficherButton = new JButton("Afficher Recettes");
        buttonPanel.add(ajouterButton);
        buttonPanel.add(afficherButton);

        // Panel pour afficher les recettes
        JPanel displayPanel = new JPanel();
        JTextArea displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        displayPanel.add(new JScrollPane(displayArea));

        // Ajouter les panels au panel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(displayPanel, BorderLayout.SOUTH);

        // Ajouter le panel principal à la fenêtre
        frame.add(mainPanel);

        // Fonctionnalités des boutons
        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titre = titreField.getText().trim();
                String description = descriptionField.getText().trim();
                String ingredients = ingredientsField.getText().trim();

                if (!titre.isEmpty() && !description.isEmpty() && !ingredients.isEmpty()) {
                    String recette = "Titre: " + titre + "\nDescription: " + description +
                                     "\nIngrédients: " + ingredients + "\n";
                    displayArea.append(recette + "\n----------------\n");

                    // Effacer les champs après ajout
                    titreField.setText("");
                    descriptionField.setText("");
                    ingredientsField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        afficherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayArea.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Aucune recette à afficher.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}
