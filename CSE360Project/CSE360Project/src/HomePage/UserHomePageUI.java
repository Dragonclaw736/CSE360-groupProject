package HomePage;

import application.Core.Navigation;
import application.Users;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class UserHomePageUI {
    public static void RegisterWithNavigation(Users user) {
        // Title Label
        Label titleLabel = new Label("Welcome User " + user.getUser() + "!");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);

        // Topic Search Title
        Label searchLabel = new Label("Search Topic: ");
        searchLabel.setStyle("-fx-font-size: 24px;");
        searchLabel.setAlignment(Pos.CENTER);

        // Topic Search Bar
        TextField searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(250);

        // Search Button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            String query = searchField.getText();
            if (!query.isEmpty()) {
                SearchResultPageUI.RegisterWithNavigation(query);
                Navigation.navigateTo("SearchResultPage");
            }
        });

        // Logout Button
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");
        logoutButton.setOnAction(event -> {
            Navigation.navigateTo("LoginPage");
        });

        // Top Bar Layout (Search Bar, Search Button, Logout Button)
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_RIGHT);
        topBar.getChildren().addAll(searchLabel, searchField, searchButton, logoutButton);

        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topBar);
        mainLayout.setCenter(titleLabel);
        BorderPane.setAlignment(titleLabel, Pos.CENTER);

        // Scene Setup
        Scene scene = new Scene(mainLayout, 600, 400);
        Navigation.registerScene("UserHome", scene);

        // Register search results page
        SearchResultPageUI.RegisterWithNavigation("Welcome");
    }
}
