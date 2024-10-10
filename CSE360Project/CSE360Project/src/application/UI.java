package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.control.Button;

/**
 * The UI class provides utility methods to set up user interface components such as Labels, TextFields, and Buttons.
 * It configures the layout, font, alignment, and size of these components for a consistent appearance in the application.
 */
public class UI {
	
	/**
	 * Configures the appearance and layout of a Label.
	 */
	private void setupLabelUI(Label l, String ff, double f, double w, Pos p, double x, double y) {
		// Set the font family and size for the label
		l.setFont(Font.font(ff, f));
		
		// Set the minimum width of the label
		l.setMinWidth(w);
		
		// Set the alignment for the label's content
		l.setAlignment(p);
		
		// Set the position of the label in the layout
		l.setLayoutX(x);
		l.setLayoutY(y);
	}
	
	/**
	 * Configures the appearance and layout of a TextField.
	 */
	private void setupTextUI(TextField t, String ff, double f, double w, Pos p, double x, double y, boolean e) {
		// Set the font family and size for the TextField
		t.setFont(Font.font(ff, f));
		
		// Set the minimum and maximum width for the TextField
		t.setMinWidth(w);
		t.setMaxWidth(w);
		
		// Set the alignment of the text within the TextField
		t.setAlignment(p);
		
		// Set the position of the TextField in the layout
		t.setLayoutX(x);
		t.setLayoutY(y);
		
		// Set whether the TextField is editable
		t.setEditable(e);
	}
	
	/**
	 * Configures the appearance and layout of a Button.
	 */
	private void setupbuttonUI(Button b, String ff, double f, double w, Pos p, double x, double y, boolean e) {
		// Set the font family and size for the button text
		b.setFont(Font.font(ff, f));
		
		// Set the minimum and maximum width for the Button
		b.setMinWidth(w);
		b.setMaxWidth(w);
		
		// Set the alignment of the button's content
		b.setAlignment(p);
		
		// Set the position of the Button in the layout
		b.setLayoutX(x);
		b.setLayoutY(y);
	}
}
