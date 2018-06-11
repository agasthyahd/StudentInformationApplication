package org.jboss.tools.examples.messenger.message;
import java.util.*;
public class DatabaseClass {

	
	
	private static HashMap<Long,student>students=new HashMap<>();
	
	private static HashMap<Long,Profile>profiles=new HashMap<>();
	
	public static HashMap<Long,student>getMessages()
	{
		return students;
		
		
	}
	public static HashMap<Long,Profile>getProfiles()
	{
		
		return profiles;
		
		
	}
	
	
	
	
	
	
	
	
	
}
