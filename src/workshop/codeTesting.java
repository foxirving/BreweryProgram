package workshop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class codeTesting {

	public static void main(String[] args) {
		
		// creates an array to hold the String names of the ser files
		List<String> stringUsername = new ArrayList<String>();
		List<Enum> currentProfileSource = new ArrayList<Enum>();

		// reads through the profile directory
		File folder = new File("profile");
		folder.mkdirs();
		File[] listOfFiles = folder.listFiles();
		
		//read through each file and gets the name
		//then it adds that name to the String Array list
		for (int i = 0; i < listOfFiles.length; i++) {

			//gets the name of each file at i
			String username = listOfFiles[i].getName();

			//adds that name to the string array
			stringUsername.add(username);

		}//end for
		
		
		for(int i = 0; i < stringUsername.size(); i++) { 
			
		//	String enumUsername = enumType.getEnumConstants(stringUsername.get(i));

			
		}  
		
	}

}
