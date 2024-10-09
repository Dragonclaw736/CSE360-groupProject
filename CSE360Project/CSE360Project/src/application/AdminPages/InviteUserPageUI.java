package application.AdminPages;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

public class InviteUserPageUI {
    public static void RegisterWithNavigation() {
        
        // Create a label for the page title
        Label titleLabel = new Label("Invite User");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create checkboxes for roles
        CheckBox studentRole = new CheckBox("Student");
        CheckBox adminRole = new CheckBox("Admin");
        CheckBox instructorRole = new CheckBox("Instructor");

        // Create a button to generate code
        Button generateCodeButton = new Button("Generate Code");
        generateCodeButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px;");
        TextArea codeArea = new TextArea();
        codeArea.setEditable(false);
        codeArea.setPrefHeight(50);

        generateCodeButton.setOnAction((ActionEvent event) -> {
            String code = UUID.randomUUID().toString();
            String roles = (studentRole.isSelected() ? "Student " : "") +
                           (adminRole.isSelected() ? "Admin " : "") +
                           (instructorRole.isSelected() ? "Instructor " : "");

            String invite = "Code: " + code + "\nRoles: " + roles.trim();
            codeArea.setText(invite);

            // Copy to clipboard
            StringSelection stringSelection = new StringSelection(invite);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        });

        // Back button to go to Admin Home Page
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        backButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("AdminHomePage");
        });

        // Layout adjustments
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(titleLabel, studentRole, adminRole, instructorRole, generateCodeButton, codeArea, backButton);

        Scene scene = new Scene(layout, 400, 400);

        Navigation.registerScene("InviteUserPage", scene);
    }
}
