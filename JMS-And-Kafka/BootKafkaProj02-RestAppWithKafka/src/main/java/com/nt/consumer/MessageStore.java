package com.nt.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStore {
	private List<String> list=new ArrayList();
	
	public void  addMessage(String message) {
		list.add(message);
	}
	
	public List<String>  getAllMessages(){
		return list;
	}

}
