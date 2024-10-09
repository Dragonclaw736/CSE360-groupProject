package application.AccountCreation;

import application.Core.Navigation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class FinishRegistrationUI {

    public static void RegisterWithNavigation() {
        Label securityQuestionLabel = new Label("Security Question:");
        Label securityAnswerLabel = new Label("Answer:");
        Label addressLabel = new Label("Address:");

        TextField securityQuestionField = new TextField();
        securityQuestionField.setPromptText("Enter a security question");

        TextField securityAnswerField = new TextField();
        securityAnswerField.setPromptText("Enter the answer");

        TextField addressField = new TextField();
        addressField.setPromptText("Enter your address");

        Button finishButton = new Button("Finish Registration");
        finishButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        finishButton.setOnAction(event -> {
            String securityQuestion = securityQuestionField.getText();
            String securityAnswer = securityAnswerField.getText();
            String address = addressField.getText();
            Navigation.navigate("HomePage");
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));

        grid.add(securityQuestionLabel, 0, 0);
        grid.add(securityQuestionField, 1, 0);
        grid.add(securityAnswerLabel, 0, 1);
        grid.add(securityAnswerField, 1, 1);
        grid.add(addressLabel, 0, 2);
        grid.add(addressField, 1, 2);
        grid.add(finishButton, 1, 3);

        Scene scene = new Scene(grid, 400, 300);
        Navigation.registerScene("FinishRegistrationPage", scene);
    }
}
