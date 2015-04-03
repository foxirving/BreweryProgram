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
	public static Profile loadProfile(String profileName) throws Exception {

		Profile profile = new Profile();
		
		//Reads through profile directory to find matching profleeName to pull information from
		String fileNameToGet = null;
		
		//uses method to read in the profile folder
		Profile.readProfileFolder();
		for (int i = 0; i < Profile.readProfileFolder().length;) {
				String username = Profile.readProfileFolder()[i].getName();
			
				if (username.equals(profileName)){
					fileNameToGet = profileName;
					break;
				}
				else {
					throw new Exception("Profile not found");
				}
			}
		String dirName = "profile/";
		String filename = dirName + fileNameToGet;

		try {
			FileInputStream fileIn = new FileInputStream(filename);
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
