package workshop;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import brewery.datamodel.Profile;

public class TextFieldTester {
	
	private static Boolean isCorrectInput;
	private static Boolean instance;

	public Boolean getIsCorrectInput() {
		return isCorrectInput;
	}

	public void setIsCorrectInput(Boolean isCorrectInput) {
		this.isCorrectInput = isCorrectInput;
	}
	
	//creates the instance value of the boolean
	public static Boolean getInstance() {
		if (instance == null) {
			instance = new Boolean(isCorrectInput);
		}
		return instance;
	}

	public TextFieldTester(ArrayList<String> allTextFields) {

		for (int i = 0; i < allTextFields.size(); i++) {

			String text = allTextFields.get(i);
			
			TestEmptyTextField(text);
			
			
			//This is where we run the testing methods
			
		}//end for

	}//end constructor
	
	public static void TestEmptyTextField(String text){
		
		if (text.equals(" ") || text.equals("")) {
			System.out.println("please enter stuff in text field");
		}

		
	}
	
	
	// tests the text inside the text fields for the correct input
	public static void TestTextField(JPanel CenterTextBox) {
			
			int i = 0;

			// gets the text fields from the CenterTextBox JPanel
			for (Component c : CenterTextBox.getComponents()) {

				
				if (c instanceof JTextField) {

					String inputText = ((JTextField) c).getText();

					if (inputText.equals(" ") || inputText.equals("")) {
						System.out.println("please enter stuff in text field");
					}

					// There is def a better way to write this, but I couldn't
					// figure it out
					if (inputText.equals("First Name")) {
						System.out.println("original text not allowed");
					}
					if (inputText.equals("Last Name")) {
						System.out.println("original text not allowed");
					}
					if (inputText.equals("Username")) {
						System.out.println("original text not allowed");
					}
					if (inputText.equals("E-mail")) {
						System.out.println("original text not allowed");
					}
					if (inputText.equals("Re-enter E-mail")) {
						System.out.println("original text not allowed");
					}
					else{
						i = i + 1;
					}
					

				}// end if
				else {
				}
				
			}// end for
			
			
		}// end TestTextField
}//end class
