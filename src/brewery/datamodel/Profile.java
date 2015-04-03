package brewery.datamodel;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//needs "implements Serializable" when ever you want to serialize data from a class
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//what profile the user is currently signed in as
	private String currentProfile;
	

	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	
	//passes through all data to be serialized
	public Profile(String firstName, String lastName, String username,
			String email, String password) {
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		
	}
	
	//used by the loadProfile method in FileIO
	public Profile(){
		
	}
	
	//gets each instance variable that needs to be serialized
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	

	//remembers what the current profile the user signed in as
	public String getCurrentProfile() {
		return currentProfile;
	}

	public void setCurrentProfile(String profileName) {
		this.currentProfile = profileName;
	}
	
	//reads through the list of ser files in the profile folder, and returns an array
	public static File[] readProfileFolder(){
		
		//reads through the profile folder
		File folder = new File("profile");
		folder.mkdirs();
		File[] listOfFiles = folder.listFiles();
		
		return listOfFiles;	
	}

	
	
}
