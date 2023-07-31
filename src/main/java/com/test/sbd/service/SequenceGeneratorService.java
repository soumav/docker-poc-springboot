package com.test.sbd.service;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.test.sbd.model.CustomSequences;


@Service
public class SequenceGeneratorService {
    @Autowired private MongoOperations mongo;

    public Long getNextSequence(String seqName)
    {
        CustomSequences counter = mongo.findAndModify(
            query(where("_id").is(seqName)),
            new Update().inc("seq",1L),
            options().returnNew(true).upsert(true),
            CustomSequences.class);
        
        return counter.getSeq();
    }
}