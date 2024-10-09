package application.AdminPages;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AdminHomePage {
    public static void RegisterWithNavigation() {
        
        // Create buttons for different admin functions
        Button inviteUserButton = new Button("Invite User");
        inviteUserButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        inviteUserButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("InviteUserPage");
        });

        Button listUsersButton = new Button("List Users");
        listUsersButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        listUsersButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("ListUsersPage");
        });

        // Back button to go to login page
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        backButton.setOnAction((ActionEvent event) -> {
            Navigation.navigateTo("LoginPage");
        });

        // Layout adjustments
        VBox layout = new VBox(15);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(inviteUserButton, listUsersButton, backButton);

        Scene scene = new Scene(layout, 350, 300);

        Navigation.registerScene("AdminHomePage", scene);
    }
}
