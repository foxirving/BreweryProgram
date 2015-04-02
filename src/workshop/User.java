package workshop;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import brewery.datamodel.Profile;

public class User {
	
	private String username;
	private List<Profile> profileName = new ArrayList<Profile>();
	
	public User(String username){
		
		
		
		
	}
	
	//read in profiles and adds it to the profileName ArrayList
	public void addProfile(Profile profiles){
		
		profileName.add(profiles);
		
	}

}//end class
