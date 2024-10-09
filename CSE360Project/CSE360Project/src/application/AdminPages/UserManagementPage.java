package application.AdminPages;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class UserManagementPage {
    public static void RegisterWithNavigation() {
        
        // Create buttons for user management actions
        Button inviteUserButton = new Button("Invite User");
        inviteUserButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        inviteUserButton.setOnAction((ActionEvent event) -> {
            // Invite user action
        });

        Button resetUserButton = new Button("Reset User");
        resetUserButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        resetUserButton.setOnAction((ActionEvent event) -> {
            // Reset user action
        });

        Button deleteUserButton = new Button("Delete User");
        deleteUserButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        deleteUserButton.setOnAction((ActionEvent event) -> {
            // Delete user action
        });

        Button listUsersButton = new Button("List Users");
        listUsersButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        listUsersButton.setOnAction((ActionEvent event) -> {
            // List users action
        });

        Button addRemoveRoleButton = new Button("Add/Remove Role");
        addRemoveRoleButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        addRemoveRoleButton.setOnAction((ActionEvent event) -> {
            // Add/Remove role action
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
        layout.getChildren().addAll(inviteUserButton, resetUserButton, deleteUserButton, listUsersButton, addRemoveRoleButton, backButton);

        Scene scene = new Scene(layout, 350, 400);

        Navigation.registerScene("UserManagementPage", scene);
    }
}
