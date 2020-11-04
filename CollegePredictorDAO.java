package database;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import model.Student;
import java.util.Arrays;

/**
 * DAO - Data Access Object
 */
public class CollegePredictorDAO {

    AmazonDynamoDB client;
    DynamoDB dynamoDB;
    Table table;

    public CollegePredictorDAO(){
        client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(
                                "http://localhost:8000", "us-west-2"))
                .build();

        dynamoDB = new DynamoDB(client);
    }

    public void createTable(String tableName){

        try {
            System.out.println("Attempting to create table; please wait...");
            try{
                client.describeTable(tableName);
                System.out.println("Table already exist, deleting and recreating!");
                client.deleteTable(tableName);
            }catch(ResourceNotFoundException e){
                System.out.println("Table does not exist, creating a new table!");
            }

            table = dynamoDB.createTable(tableName,
                    Arrays.asList(
                            new KeySchemaElement("name", KeyType.HASH)

                            ),

                    Arrays.asList(
                            new AttributeDefinition("name", ScalarAttributeType.S)
                    ),
                    new ProvisionedThroughput(10L, 10L));
            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());
        }
        catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }

    public void create(Student student){

        try {
            System.out.println("Adding a new item...");
            Item item = new Item()
                    .withPrimaryKey(
                            "name", student.name,
                            "rank", student.rank)
                    .withString("email", student.email)
                    .with("phone", student.phone)
                    .withString("exam name",student.exam)
                    .withString("category", student.category);

            PutItemOutcome outcome = table.putItem(item);

            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

        }
        catch (Exception e) {
            System.err.println("Unable to add item: " + student);
            e.printStackTrace();
        }
    }

    public void search(String name){
        GetItemSpec spec = new GetItemSpec()
                .withPrimaryKey("name", name);

        Item item = table.getItem(spec);
        String getName = item.getString("name");
        String email = item.getString("email");
        String phone = item.getString("phone");
        int rank = item.getInt("rank");
        String exam = item.getString("exam name");
        String category = item.getString("category");


     //   Student existingStudent = new Student(getName, phone, email, rank, exam,category);
        System.out.println("The student information with name " + name);
       // System.out.println(existingStudent);

    }
}
