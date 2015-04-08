package brewery.datamodel;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextFieldTester {

	
	//runs through the array list the of the input text, and test it 
	public static void textFieldTester(ArrayList<String> OriginalText, ArrayList<String> allTextFields) {

		ArrayList<String> inputText = allTextFields;
		ArrayList<String> originalText = OriginalText;
		
		for (int i = 0; i < inputText.size(); i++) {

			String text = inputText.get(i);

			TestEmptyTextField(text);
			
			for (int j = 0; j < originalText.size(); j++) {
				
				String originalTextOne = originalText.get(i);
				TestOriginalTextField(text, originalTextOne);
				
			}//end for
		}// end for

	}// end constructor

	//test for an empty string
	public static void TestEmptyTextField(String text) {

		if (text.equals(" ") || text.equals("")) {
			System.out.println("please enter stuff in text field");
		}

	}

	// tests to see if the text the user is the same as the text that was originally there
	public static void TestOriginalTextField(String text, String OriginalText) {

		
				if (text.equals(OriginalText)) {
					System.out.println("original text not allowed");
				}
				else{}

	}// end TestTextField
}// end class
