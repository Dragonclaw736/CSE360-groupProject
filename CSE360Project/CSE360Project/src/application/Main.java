package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.sql.SQLException;
import java.util.Scanner;

public class Main extends Application {
	
	private static final Users Users = new Users();
	
	public static void main(String[] args) {
		launch(args);
	}
	public void start(Stage loginpage) {// main login page
		loginpage.setTitle("login");
		TextField text_username = new TextField();
		text_username.setPromptText("Enter username: ");
        TextField text_password = new TextField();
        text_password.setPromptText("Enter password: ");
		 Button login = new Button();
	        login.setText("Login");
	        login.setOnAction(new EventHandler<>() {
	            public void handle(ActionEvent event) {
	                
	            }
	        });
	}
	public void createaccountpage() {// the page for creating account page
		Stage createaccount = new Stage();
		createaccount.setTitle("Crerate a user account");
		TextField text_username = new TextField();
		text_username.setPromptText("Enter username: ");
		setUser(String newUser);
        TextField text_password = new TextField();
        text_password.setPromptText("Enter password: ");
        setPassword(String newPassword);
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
        TextField text_middleinitial = new TextField();
        name.first = "";
        text_middleinitial.setPromptText("Enter middle initial: ");
        TextField text_lastname = new TextField();
        text_lastname.setPromptText("Enter last name: ");
        TextField text_perferedname = new TextField();
        text_perferedname.setPromptText("Enter perfered name: ");
        TextField text_email = new TextField();
        text_email.setPromptText("Enter email: ");
        setEmail( email);
        Button finishup = new Button();
        finishup.setText("Finish creating account");
        finishup.setOnAction(new EventHandler<>() {
            public void handle(ActionEvent event) {
                if() {
                	
                }
                else if() {
                	
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
	public void userlistpage() {// for displaying a list of user
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
}
