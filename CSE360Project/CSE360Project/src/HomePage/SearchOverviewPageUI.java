package HomePage;

import application.Core.Navigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.TextAlignment;

import java.util.List;

public class SearchOverviewPageUI {

    public static void display(String query, List<String> groups) {
        // Title Display
        Label titleLabel = new Label("Search Overview");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        titleLabel.setTextAlignment(TextAlignment.CENTER);

        // Set up the search bar
        TextField searchField = new TextField(query);  // Pre-fill with previous search
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(360); // Set width for search field
        searchField.setMinHeight(30); // Minimum height for consistency

        // Create the search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(e -> {
            String newQuery = searchField.getText();
            if (!newQuery.isEmpty()) {
                // Logic to refresh with new search
                Navigation.navigateTo("SearchResultPage");
            }
        });

        // Back button to navigate to the previous page
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            Navigation.navigateTo("UserHomePage");
        });

        // Logout button for user session management
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");

        logoutButton.setOnAction(event -> {
            Navigation.navigateTo("LoginPage");
        });

        // Top bar layout for search and navigation buttons
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT); // Align items to the left
        topBar.getChildren().addAll(backButton, searchField, searchButton, logoutButton);

        // Placeholder Articles with relevant group tags
        VBox articleList = new VBox(10);
        articleList.setAlignment(Pos.TOP_LEFT); // Align to the top left

        // Sample articles with associated group tags
        String[][] articles = {
            {"Article 1", "Eclipse, IntelliJ"},
            {"Article 2", "Fiddle"},
            {"Article 3", "Eclipse, Fiddle"},
            {"Article 4", "IntelliJ"}
        };

        for (String[] article : articles) {
            Hyperlink titleLink = new Hyperlink(article[0]);

            // Display groups as tags with lower opacity
            Text tags = new Text(" (" + article[1] + ")");
            tags.setFill(Color.GRAY);
            tags.setOpacity(0.6);

            // Combine title and tags in a TextFlow
            TextFlow textFlow = new TextFlow(titleLink, tags);
            articleList.getChildren().add(textFlow);

            // Set an action for each hyperlink to navigate to SearchResultPageUI
            titleLink.setOnAction(e -> {
                // Navigate to the SearchResultPageUI
                Navigation.navigateTo("SearchResultPage");
            });
        }

        // Main layout
        BorderPane layout = new BorderPane();
        layout.setTop(topBar); // Set topBar at the top for header layout
        layout.setCenter(articleList);
        layout.setStyle("-fx-background-color: #EEEEEE;"); // Set background color for the page

        Scene scene = new Scene(layout, 600, 400);

        // Register the scene with Navigation
        Navigation.registerScene("SearchOverviewPage", scene);
    }
}
