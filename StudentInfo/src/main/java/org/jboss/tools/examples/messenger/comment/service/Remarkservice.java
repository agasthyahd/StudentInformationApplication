package org.jboss.tools.examples.messenger.comment.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.tools.examples.messenger.message.remarks;
import org.jboss.tools.examples.messenger.message.DatabaseClass;
import org.jboss.tools.examples.messenger.message.student;
import org.jboss.tools.examples.messenger.service.Messageservice;


public class Remarkservice {
	private HashMap<Long, student> studentss ;
	public Remarkservice()
	{Messageservice ms=new Messageservice();
	
		studentss =ms.students;
	}
	
	
	
	public ArrayList<remarks> getAllComments(long studentId) {
		System.out.println(studentss.get(1L));
		HashMap<Long, remarks> remarks = studentss.get(studentId).getRemarks();
		return new ArrayList<remarks>(remarks.values());
	}
	
	public remarks getRemark(long studentId, long commentId) {
		HashMap<Long, remarks> remarks = studentss.get(studentId).getRemarks();
		return remarks.get(commentId);
	}
	
	public remarks addRemark(long studentId, remarks remar) {
		Map<Long, remarks> remarkss = studentss.get(studentId).getRemarks();
		remar.setId(remarkss.size() + 1);
		//System.out.println(remarkss.getId());
		remarkss.put(remar.getId(), remar);
		return remar;
	}
	
	public remarks updateRemark(long studentId, remarks remar) {
		System.out.println(studentss.get(1L));
		
		HashMap<Long, remarks> remarkss = studentss.get(studentId).getRemarks();
		if (remar.getId() <= 0) {
			return null;
		}
		remarkss.put(remar.getId(), remar);
		return remar;
	}
	
	public remarks removeComment(long studentId, long remarkId) {
		Map<Long, remarks> remarks = studentss.get(studentId).getRemarks();
		return remarks.remove(studentId);
	}
		
}

