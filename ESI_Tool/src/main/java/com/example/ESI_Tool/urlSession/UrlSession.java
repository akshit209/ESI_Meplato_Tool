package com.example.ESI_Tool.urlSession;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.net.URL;
import java.util.Objects;
import java.util.UUID;

@DynamoDBTable(tableName = "ESI_Table")
public class UrlSession {

    private URL url;
    private String id;

        public UrlSession() {
         }

    @DynamoDBHashKey(attributeName = "id")
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName = "url")
    public void setUrl(URL url) {
        this.url = url;
    }
    public URL getUrl() {
        return url;
    }
}
