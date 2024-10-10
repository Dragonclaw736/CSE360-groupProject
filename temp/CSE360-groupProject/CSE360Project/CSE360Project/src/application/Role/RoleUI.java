package application.Role;

import application.Core.Navigation;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class RoleUI {
	public static void RegisterWithNavigation() {
	// Create a label for the page title
		Label titleLabel = new Label("Please select your role:");
		titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
		
		//add if statements for database logic here
		Button AdminButton = new Button("Admin role");
        AdminButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        AdminButton.setPadding(new Insets(10, 20, 10, 20));
        AdminButton.setOnAction((ActionEvent event) -> {
        	Navigation.navigateTo("AdminHomePage");
        });
        
        Button teacherButton = new Button("Teacher role");
        teacherButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        teacherButton.setPadding(new Insets(10, 20, 10, 20));
        teacherButton.setOnAction((ActionEvent event) -> {
        	Navigation.navigateTo("TeacherHomePage");
        });
        
        Button studentButton = new Button("Teacher role");
        studentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px;");
        studentButton.setPadding(new Insets(10, 20, 10, 20));
        studentButton.setOnAction((ActionEvent event) -> {
        	Navigation.navigateTo("TeacherHomePage");
        });
        VBox layout = new VBox(15);  // Increased spacing between elements
        layout.setPadding(new Insets(20));  // Add padding around the layout
        layout.setAlignment(Pos.CENTER);  // Center the elements
        layout.getChildren().addAll(titleLabel, AdminButton, teacherButton, studentButton);
    	
        Scene scene = new Scene(layout, 350, 250);
    	
    	Navigation.registerScene("RolePage", scene);
	}
}