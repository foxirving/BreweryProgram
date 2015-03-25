package brewery.datamodel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileIO {

	// reads in the variable from the profile class
	public static void saveProfile(Profile profile) {

		try {
			// creates a new file to stores the serialized data in
			String username = profile.getUsername();
			String dirName = "profile/";
			String filename = dirName + username;
			FileWriter fw = new FileWriter(filename, true);
			fw.close();

			// serializes the data in the file made above
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(profile);
			outStream.close();
			fileOut.close();

		} catch (IOException i) {
			i.printStackTrace();
		}

	}// end saveProfile

	// loads any serialized data that exists in the profile folder
	public static Profile loadProfile() {

		Profile profile = new Profile();

		// this code hasn't been updated, so it might not find the correct place
		// to find these serialized files
		try {
			FileInputStream fileIn = new FileInputStream("profile/userOne.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			profile = (Profile) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i)

		{
			i.printStackTrace();

		} catch (ClassNotFoundException c) {
			System.out.println("Profile not found");
			c.printStackTrace();

		}

		return profile;

	}// end loadProfile

}// end class
