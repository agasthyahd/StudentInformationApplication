package org.jboss.tools.examples.messenger.message;
import java.util.Date;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class student {

	private long id;private String name,rollno;private Date created;
	private   HashMap<Long,remarks> remarkshm;
	
	public student()
	{
		
		
		
	}
	
	public student(long id,String name,String rollno) 
	
	{				
		this.id=id;
		this.name=name;
		this.rollno=rollno;
		this.created=new Date();	
		remarkshm=new HashMap<>(); 
		//comments.put(1L, new Comment(1,"hello","agasthya"));
		
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	@XmlTransient
	public HashMap<Long, remarks> getRemarks() {
		return remarkshm;
	}

	public void setRemarks(HashMap<Long, remarks> remarks) {
		this.remarkshm = remarks;
	}
    
    

	
	
}
