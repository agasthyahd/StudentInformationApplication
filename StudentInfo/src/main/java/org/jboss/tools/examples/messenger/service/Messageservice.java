package org.jboss.tools.examples.messenger.service;
import org.jboss.tools.examples.messenger.message.student;
import org.jboss.tools.examples.messenger.message.DatabaseClass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.jboss.tools.examples.messenger.message.student;
public class Messageservice {

	
	
	
	public  HashMap<Long,student>students = DatabaseClass.getMessages();
	
	public Messageservice()
	{
		//messages.put(1L,new Message(1,"Hello world","koushik"));
	//	messages.put(2L,new Message(2,"Hello world","agasthyahd"));
	//	messages.put(3L,new Message(3,"Hello world!!","agasthyahd"));
	//	messages.put(4L,new Message(4,"Hello world!!!!","agasthyahd"));
	}
	
	public List<student> getAllMessageForYear(int y)
	
	
	{
		List<student> studentsyear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		
		for(student mess:students.values())
		{
			cal.setTime(mess.getCreated());
			if(cal.get(Calendar.YEAR)==y)
			{
				studentsyear.add(mess);
				
				
			}}
			return studentsyear;
		}
	
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	public  ArrayList<student> getAllMessages()
	{
		
		return new ArrayList<student>(students.values());
	}
	
	public student getMessage(long id)
	{
		return students.get(id);
		
	}
	
	public student addMessage(student student)
	
	
	{
		student.setId(students.size()+1);
		
		students.put(student.getId(),student);
		
		
		
		
		return student;
		
		
		
		
	}
	public student updateMessage(student student)
	{
		
		if(student.getId()<0)
			return null;
		students.put(student.getId(),student);
		
		return student;
	}
	
	public student removeMessage(long id)
	{
		return students.remove(id);
		
		
	}

	public List<student> getAllMessagePaginated(int start, int size) {
		
		ArrayList<student> student=new ArrayList<>(students.values());
		
		if(start+size>student.size())
			return new ArrayList<student>();
		return student.subList(start,start+size);
	}
}
