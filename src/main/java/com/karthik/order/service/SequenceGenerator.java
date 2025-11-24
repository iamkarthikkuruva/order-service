package com.karthik.order.service;

import com.karthik.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

   /* public int generateNextOrderId() {
        Sequence counter = mongoOperations.findAndModify(
                query(where("_id").is("sequence")),
                new Update().inc("sequence", 1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        return counter.getSequence();
    }*/

    public int generateNextOrderId() {
        Query query = query(Criteria.where("_id").is("sequence"));
        Update update = new Update().inc("sequence", 1);

        Sequence counter = mongoOperations.findAndModify(
                query,
                update,
                options().returnNew(true).upsert(true),
                Sequence.class
        );
        if (counter == null) {
            throw new IllegalStateException("Failed to generate next order ID: sequence document is null");
        }
        return counter.getSequence();
    }

}
