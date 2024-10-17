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

/*
 * Okay this is some skeleton code for the admin panel
 * The instructor panel will just be a dumbed down
 * copy paste of this, once we actually have articles,
 * we can add functionality to the buttons
 * */

public class AdminPanel {

	public static void RegisterWithNavigation() {
		
		// Title Label
		Label titleLabel = new Label("Admin Panel");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        titleLabel.setAlignment(Pos.CENTER);
		
		// Create
        Button createButton = new Button("Create Article");
        createButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");
		
		// Update
        Button updateButton = new Button("Edit Article");
        updateButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");

		
		// Delete
        Button deleteButton = new Button("Delete Article");
        deleteButton.setStyle("-fx-background-color: #E74C3C; -fx-text-fill: white;");

        
        // Top Bar
        HBox topBar = new HBox(10);
        topBar.setPadding(new Insets(10));
        topBar.setAlignment(Pos.CENTER);
        topBar.getChildren().addAll(titleLabel);   
        
        // Body
        HBox body = new HBox(100);
        topBar.setAlignment(Pos.TOP_CENTER);
        topBar.getChildren().addAll(createButton, updateButton, deleteButton);
        
        BorderPane panelLayout = new BorderPane();
        panelLayout.setTop(topBar);
        panelLayout.setBottom(body);
        
        Scene scene = new Scene(panelLayout, 500, 500);
        Navigation.registerScene("AdminPanel", scene);
	}
	
}
