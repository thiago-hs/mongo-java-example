import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;

import com.mongodb.ServerAddress;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;
import java.util.Arrays;
import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		MongoClient mongoClient = MongoClients.create();
		
		MongoDatabase database = mongoClient.getDatabase("myDbTest");
		
		MongoCollection<Document> collection = database.getCollection("myCollection");
		
		Document doc = new Document("name","MongoDB")
				.append("type", "document");
		
		//collection.insertOne(doc);
		
		
		MongoCursor<Document> cursor = collection.find().iterator();
		
		try {
			
			
			while(cursor.hasNext()) {
				
				System.out.println(cursor.next().toJson());
				
			}
			
		}finally {
			
			cursor.close();
			
		}
	}

}
