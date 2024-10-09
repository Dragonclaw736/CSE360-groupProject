package application.Core;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.sql.SQLException;
import java.util.Scanner;

import HomePage.HomePageUI;
import application.Users;
import javafx.scene.layout.Pane;
import application.LoginPage.*;
import application.AccountCreation.*;

public class Main extends Application {
	
	private static final Users Users = new Users();
	Stage theloginpage;
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage baseStage) {
		Navigation.setPrimaryStage(baseStage);
		
		LoginPageUI.RegisterWithNavigation();
		HomePageUI.RegisterWithNavigation();
		AccountCreationUI.RegisterWithNavigation();
		
        Navigation.navigateTo("LoginPage");
    }
}



/**
	public void createaccountpage() {// the page for creating account page
		Stage createaccount = new Stage();
		createaccount.setTitle("Create a user account");
		TextField text_username = new TextField();
		text_username.setPromptText("Enter username: ");
        TextField text_password = new TextField();
        text_password.setPromptText("Enter password: ");
        Button create = new Button();
        create.setText("Create account");
        create.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	String inputpassword = text_password.getText();
            	Users.setPassword(inputpassword);
            	String inputusername = text_username.getText();
            	Users.setUser(inputusername);
            	createaccount.close();
            	start(theloginpage);
            }
        });
	}
	public void rolepage() {// the role selection page
		Stage roleselection = new Stage();
		roleselection.setTitle("Role Selection");
		Button teacherRole = new Button();
		teacherRole.setText("Teacher Role");
		teacherRole.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	teacherpage();
            	roleselection.close();
            }
        });
        Button studentRole = new Button();
        studentRole.setText("Student Role");
        studentRole.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	studentpage();
            	roleselection.close();
            }
        });
		
	}
	public void finishaccountpage() {// the page for finishing account
		Stage finishaccount = new Stage();
		name _newname = new name();
		String email = "";
		
		finishaccount.setTitle("Finish setting up your account:");
		TextField text_firstname = new TextField();
		text_firstname.setPromptText("Enter First name: ");
		_newname.first = "";
        TextField text_middleinitial = new TextField();
        text_middleinitial.setPromptText("Enter middle initial: ");
        _newname.mI = 'a';
        TextField text_lastname = new TextField();
        text_lastname.setPromptText("Enter last name: ");
        _newname.last = "";
        TextField text_perferedname = new TextField();
        text_perferedname.setPromptText("Enter perfered name: ");
        _newname.prefered = "";
        TextField text_email = new TextField();
        text_email.setPromptText("Enter email: ");
        
        Button finishup = new Button();
        finishup.setText("Finish creating account");
        finishup.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	String role = "";
            	Users.setName(_newname);
            	Users.setEmail(email);
            	if(role == "t") {
                	teacherpage();
                	finishaccount.close();
                }
                else if(role == "s") {
                	studentpage();
                	finishaccount.close();
                }
                else{
                	adminpage();
                	finishaccount.close();
                }
            }
        });
	}
	public void adminpage() {// the admin user page
		Stage Admin = new Stage();
		Admin.setTitle("Admin:");
		Button invite = new Button();
        invite.setText("Invite a new user");
        invite.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	invitepage();
            	Admin.close();
            }
        });
        Button reset = new Button();
        reset.setText("Reset a user's account");
        reset.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	resetpage();
            	Admin.close();
            }
        });
        Button delete = new Button();
        delete.setText("Delete account");
        delete.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	deleteuserpage();
            	Admin.close();
            }
        });
        Button userlist = new Button();
        userlist.setText("List of users accounts");
        userlist.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	resetpage();
            	Admin.close();
            }
        });
        Button addRemoveRole = new Button();
        addRemoveRole.setText("Add or remove a role of a user");
        addRemoveRole.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	addremoverolepage();
            	Admin.close();
            }
        });
        Button logout = new Button();
        logout.setText("Logout");
        logout.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
            	Admin.close();
            }
        });
	}
	public void studentpage() {// the student user page
		Stage Student = new Stage();
		Student.setTitle("Student:");
		Button logout = new Button();
        logout.setText("Logout");
        logout.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                Student.close();
            }
        });
	}
	public void teacherpage() {// the teacher user page
		Stage Teacher = new Stage();
		Teacher.setTitle("Teacher:");
		Button logout = new Button();
        logout.setText("Logout");
        logout.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                Teacher.close();
            }
        });
	}
	public void deleteuserpage() { // for deleting a user
		Stage Delete = new Stage();
		Delete.setTitle("delete user");
		Users.deleteUser();
		Button goback = new Button();
        goback.setText("Go Back");
        goback.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                Delete.close();
                adminpage();
            }
        });
	}
	public void userlistpage() throws SQLException {// for displaying a list of user
		Stage userlist = new Stage();
		userlist.setTitle("userlist");
		Users.userList();
		Button goback = new Button();
        goback.setText("Go Back");
        goback.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                userlist.close();
                adminpage();
            }
        });
		
	}
	public void invitepage() {// for invite a new user
		Stage invite = new Stage();
		invite.setTitle("invite");
		Users.inviteUser();
		Button goback = new Button();
        goback.setText("Go Back");
        goback.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                invite.close();
                adminpage();
            }
        });
	}
	public void resetpage() { // for reseting a user
		Stage reset = new Stage();
		reset.setTitle("Reset user");
		Users.resetUser();
		Button goback = new Button();
        goback.setText("Go Back");
        goback.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                reset.close();
                adminpage();
            }
        });
	}
	public void addremoverolepage() {// for add or removing a role of a user
		Stage addremoverole = new Stage();
		addremoverole.setTitle("Add or remove role to a user");
		Users.addRemoveRole();
		Button goback = new Button();
        goback.setText("Go Back");
        goback.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                addremoverole.close();
                adminpage();
            }
        });
	}
**/	

