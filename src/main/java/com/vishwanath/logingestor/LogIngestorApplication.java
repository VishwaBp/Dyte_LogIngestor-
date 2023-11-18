package com.vishwanath.logingestor;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static com.mongodb.client.model.Filters.eq;

@SpringBootApplication
@EnableMongoRepositories
public class LogIngestorApplication {

    public static void main(String[] args) {


        SpringApplication.run(LogIngestorApplication.class, args);
        // Replace the placeholder with your MongoDB deployment's connection string
//        String uri = "mongodb+srv://vishwa:<test123>@logingestor.8curvo9.mongodb.net/?retryWrites=true&w=majority";
//        try (MongoClient mongoClient = MongoClients.create(uri)) {
//            MongoDatabase database = mongoClient.getDatabase("LogIngestorDB");
//            MongoCollection<Document> collection = database.getCollection("Logs");
//            Document doc = collection.find(eq("name", "vishwa")).first();
//            if (doc != null) {
//                System.out.println(doc.toJson());
//            } else {
//                System.out.println("No matching documents found.");
//            }
//        }

    }
}
