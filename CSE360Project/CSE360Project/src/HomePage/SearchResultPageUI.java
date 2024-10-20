package HomePage;

import application.Core.Navigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SearchResultPageUI {
    private static VBox feedbackLayout;
    private static VBox resultLayout;

    public static void RegisterWithNavigation(String query) {
        // Create a label to display the result
        Label resultText = new Label("Result goes here...");
        resultText.setStyle("-fx-background-color: transparent; -fx-padding: 10px; -fx-wrap-text: true;"); // Ensure background is transparent and text wraps
        resultText.setMaxWidth(Double.MAX_VALUE); // Allow label to stretch
        resultText.setAlignment(Pos.TOP_LEFT); // Align text to the top left

        // Create a pane for the result text area
        Pane resultTextBar = new Pane();
        resultTextBar.setStyle("-fx-background-color: #F7F7F7; -fx-border-color: #CCCCCC; -fx-border-width: 1px;"); // Set background and border styles
        resultTextBar.setPrefSize(600, 400); // Define preferred size

        // Create a caret button for dropdown options
        Button caretButton = new Button("⋁");
        caretButton.setStyle("-fx-font-size: 14px; -fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-padding: 2 5; -fx-border-radius: 5; -fx-background-radius: 5;");

        // Set up a context menu for options
        ContextMenu contextMenu = new ContextMenu();
        MenuItem addFeedbackItem = new MenuItem("Add Feedback");
        addFeedbackItem.setStyle("-fx-font-size: 12px;"); // Style for dropdown
        addFeedbackItem.setOnAction(e -> {
            feedbackLayout.setVisible(true);
            feedbackLayout.setManaged(true); // Manage layout space
        });

        MenuItem moreInfoItem = new MenuItem("More Information");
        moreInfoItem.setStyle("-fx-font-size: 12px;");
        moreInfoItem.setOnAction(e -> {
            resultText.setPrefHeight(resultText.getPrefHeight() + 100); // Expand result space
        });

        MenuItem lessInfoItem = new MenuItem("Less Information");
        lessInfoItem.setStyle("-fx-font-size: 12px;");
        lessInfoItem.setOnAction(e -> {
            resultText.setPrefHeight(resultText.getPrefHeight() - 100); // Reduce result space
        });

        contextMenu.getItems().addAll(addFeedbackItem, moreInfoItem, lessInfoItem);

        // Show the context menu on caret button click
        caretButton.setOnMouseClicked(event -> {
            contextMenu.show(caretButton, event.getScreenX(), event.getScreenY());
        });

        // Add resultText and caretButton to the result text bar
        resultTextBar.getChildren().addAll(resultText, caretButton);
        resultTextBar.setPrefWidth(580); // Allow space for caret button

        // Position caret button in the top right corner
        caretButton.setLayoutX(resultTextBar.getPrefWidth() - caretButton.getWidth() - 20); // 5px margin from right
        caretButton.setLayoutY(5);    // 5px margin from top

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
                RegisterWithNavigation(newQuery); // Refresh with new search
                Navigation.navigateTo("SearchResultPage");
            }
        });

        // Back button to navigate to the previous page
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            Navigation.navigateTo("UserHome");
        });

        // Logout button for user session management
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");
        logoutButton.setOnAction(event -> {
            Navigation.navigateTo("LoginPage");
        });

        // Simple star rating system using Unicode characters
        HBox starRating = new HBox(5);
        Label[] stars = new Label[5];
        for (int i = 0; i < 5; i++) {
            stars[i] = new Label("☆"); // Initialize as empty stars
            stars[i].setFont(new Font(30)); // Set font size
            stars[i].setOnMouseClicked(e -> handleStarClick(e, stars)); // Handle star clicks
            starRating.getChildren().add(stars[i]);
        }

        // TextArea for additional comments
        TextArea commentsBox = new TextArea();
        commentsBox.setPromptText("Add any additional comments here...");
        commentsBox.setPrefSize(300, 100);

        // Send button to submit feedback
        Button sendButton = new Button("Send");
        sendButton.setOnAction(e -> {
            feedbackLayout.setVisible(false); // Hide feedback section on send
            feedbackLayout.setManaged(false); // Remove feedback section from layout space
        });

        // Feedback layout for stars, comments, and send button
        feedbackLayout = new VBox(10); // Initialize feedback layout
        feedbackLayout.getChildren().addAll(starRating, commentsBox, sendButton);
        feedbackLayout.setVisible(false);  // Initially hidden
        feedbackLayout.setManaged(false);  // Ensure it doesn't take up space when hidden
        feedbackLayout.setStyle("-fx-padding: 5px;");
        feedbackLayout.setPrefHeight(100); // Fixed height for feedback layout

        // Top bar layout for search and navigation buttons
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER_LEFT); // Align items to the left
        topBar.getChildren().addAll(backButton, searchField, searchButton, logoutButton);

        // Main layout of the scene
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(topBar);
        mainLayout.setStyle("-fx-background-color: #EEEEEE;"); // Set background color for the result page

        // Center layout containing result text and feedback section
        resultLayout = new VBox(10);
        resultLayout.setAlignment(Pos.TOP_LEFT); // Align to the top left

        // Add margin around the resultTextBar
        VBox.setMargin(resultTextBar, new Insets(10)); // Set margin for result text bar
        resultLayout.getChildren().addAll(resultTextBar, feedbackLayout); // Add feedback layout to results

        mainLayout.setCenter(resultLayout);

        // Scene setup with dynamic resizing
        Scene scene = new Scene(mainLayout, 600, 400);
        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            resultTextBar.setPrefWidth(newValue.doubleValue() - 20); // Adjust width based on window size
            searchField.setPrefWidth(newValue.doubleValue() * 0.25); // Adjust search field width
            backButton.setPrefWidth(newValue.doubleValue() * 0.1); // Adjust back button width
            logoutButton.setPrefWidth(newValue.doubleValue() * 0.1); // Adjust logout button width
            searchButton.setPrefWidth(newValue.doubleValue() * 0.1); // Adjust search button width

            // Update caret button position dynamically
            caretButton.setLayoutX(resultTextBar.getPrefWidth() - caretButton.getWidth() - 20); // Position button 5px left from right
        });

        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            // Adjust resultTextBar height based on available space
            double availableHeight = newValue.doubleValue() - topBar.getHeight() - feedbackLayout.getPrefHeight() - 30; // 5px margin on top and bottom, 10px margin for feedback
            resultTextBar.setPrefHeight(Math.max(availableHeight, 0)); // Ensure no negative height
            feedbackLayout.setPrefHeight(100); // Fixed height for feedback layout
        });

        Navigation.registerScene("SearchResultPage", scene); // Register the scene for navigation
    }

    // Handle star click event
    private static void handleStarClick(MouseEvent e, Label[] stars) {
        Label clickedStar = (Label) e.getSource();
        int clickedIndex = -1;

        // Identify the clicked star's index
        for (int i = 0; i < stars.length; i++) {
            if (stars[i] == clickedStar) {
                clickedIndex = i;
                break;
            }
        }

        // Update stars based on the user's selection (filled or empty)
        for (int i = 0; i < stars.length; i++) {
            if (i <= clickedIndex) {
                stars[i].setText("★"); // Fill star
            } else {
                stars[i].setText("☆"); // Empty star
            }
        }
    }
}
