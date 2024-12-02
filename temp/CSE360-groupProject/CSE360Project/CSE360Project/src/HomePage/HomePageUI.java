package HomePage;

import application.Core.Navigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HomePageUI {
	public static void RegisterWithNavigation() {
        // Title Label
        Label titleLabel = new Label("Welcome {user type}");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);

        // Search Bar
        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(250);

        // Logout Button
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");
        logoutButton.setOnAction(event -> {
            // TODO: Add actual logout logic here
            Navigation.navigateTo("LoginPage");
        });

        // Top Bar Layout (Search Bar and Logout Button)
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.getChildren().addAll(searchField, logoutButton);

        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topBar);
        mainLayout.setCenter(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        // Scene Setup
        Scene scene = new Scene(mainLayout, 600, 400);
        
        Navigation.registerScene("HomePage", scene);
	}
}