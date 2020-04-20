package com.example.ESI_Tool.FileStore;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.example.ESI_Tool.urlSession.UrlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileStore {
    private final AmazonDynamoDB dbClient;

    @Autowired
    public FileStore(AmazonDynamoDB dbClient) {
        this.dbClient = dbClient;
    }


    public void save(UrlSession url){
        DynamoDBMapper mapper = new DynamoDBMapper(dbClient);
        DynamoDB dynamoDB = new DynamoDB(dbClient);
        mapper.save(url);
    }
}
