package org.jboss.tools.examples.messenger.message;




import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class remarks {
	

	private long id;
    private String remark;
    private Date created;
    private String author;
    
    public remarks() {
    	
    }
    
    public remarks(long id, String remark, String author) {
    	this.id = id;
    	this.remark = remark;
    	this.author = author;
    	this.created = new Date();
    }

	public long getId() {
		return id;
	} 

	public void setId(long id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
    
	