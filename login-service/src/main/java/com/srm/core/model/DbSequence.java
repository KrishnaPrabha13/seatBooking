package com.srm.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "dbSeq")
public class DbSequence {

	@Id
	private String id;

	@Field(name = "Total Record")
	private int seq;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int Seq) {
		this.seq = seq;
	}
}
