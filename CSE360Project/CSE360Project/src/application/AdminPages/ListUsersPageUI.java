package application.AdminPages;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ListUsersPageUI {
    public static void RegisterWithNavigation() {
        // Placeholder user data
        String[] users = {"user1", "user2", "user3"}; // Replace with actual user data
        
        VBox usersList = new VBox(15);
        usersList.setPadding(new Insets(20));
        usersList.setAlignment(Pos.CENTER);

        for (String user : users) {
            HBox userRow = new HBox(10);
            userRow.setAlignment(Pos.CENTER_LEFT);

            Label userNameLabel = new Label(user);

            // Reset Password Button
            Button resetPasswordButton = new Button("Reset Password");
            resetPasswordButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
            resetPasswordButton.setOnAction((ActionEvent event) -> {
                // Handle reset password logic here
            });

            // Delete Account Button
            Button deleteAccountButton = new Button("Delete Account");
            deleteAccountButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
            deleteAccountButton.setOnAction((ActionEvent event) -> {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete this account?");
                alert.showAndWait().ifPresent(response -> {
                    if (response == ButtonType.OK) {
                        // Handle delete account logic here
                    }
                });
            });

            // Change Roles Button
            Button changeRolesButton = new Button("Change Roles");
            changeRolesButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
            changeRolesButton.setOnAction((ActionEvent event) -> {
                // Handle change roles logic here
            });

            userRow.getChildren().addAll(userNameLabel, resetPasswordButton, deleteAccountButton, changeRolesButton);
            usersList.getChildren().add(userRow);
        }

        // Back button to go to Admin Home Page
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        backButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("AdminHomePage");
        });

        usersList.getChildren().add(backButton);

        Scene scene = new Scene(usersList, 500, 400);

        Navigation.registerScene("ListUsersPage", scene);
    }
}
