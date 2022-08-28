package com.srm.core.service;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import com.srm.core.model.DbSequence;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

@Service
public class SeqService {

	@Autowired
	private MongoOperations mongoOperations;
	
	public int getSqeNumber(String sequenceName) {
		Query query = new Query(Criteria.where("id").is(sequenceName));
		
		Update update = new Update().inc("seq", 1);
		
		DbSequence counter =  mongoOperations.findAndModify(
				query, update, options().returnNew(true).upsert(true),
				DbSequence.class);
		System.out.println(counter);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
		
	}
}
