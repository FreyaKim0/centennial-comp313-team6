package com.example.centenarioschoolapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import org.bson.Document;
import java.util.Iterator;

public class StudentRegistrationStatus<App> extends AppCompatActivity {
    TextView nav_registration_status_message;

    String mockStatus = "";
    private ImageView imageViewCheckValidName;
    private EditText searchInput;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_registration_status);

        searchInput = findViewById(R.id.nav_registration_search_name_input);
        searchButton = findViewById(R.id.nav_registration_search_button);
        
        imageViewCheckValidName = findViewById(R.id.imageView_check_valid_name);

        if (mockStatus.equals("API return 'Mock Server Error'")) {
            nav_registration_status_message = (TextView) findViewById(R.id.nav_registration_status_message);
            nav_registration_status_message.setText("Server Error...");
        }
        if (mockStatus.equals("API return 'Student name not existing'")) {
            nav_registration_status_message.setText("This Student Not Existing");
        }

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = searchInput.getText().toString();
                String connectionString = "mongodb://zannatulsakina:gAQEnlXLX8ejm3Rm@ac-fjn97pp-shard-00-00.0vezpan.mongodb.net:27017,ac-fjn97pp-shard-00-01.0vezpan.mongodb.net:27017,ac-fjn97pp-shard-00-02.0vezpan.mongodb.net:27017/?ssl=true&replicaSet=atlas-cyqst2-shard-0&authSource=admin&retryWrites=true&w=majority";

                MongoClientSettings settings = MongoClientSettings.builder()
                        .applyConnectionString(new ConnectionString(connectionString))
                        .build();

                // Create a new client and connect to the server
                try (MongoClient mongoClient = MongoClients.create(settings)) {
                    try {
                        // Send a ping to confirm a successful connection
                        MongoDatabase database = mongoClient.getDatabase("admin");
                        database.runCommand(new Document("ping", 1));
                        System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
                    } catch (MongoException e) {
                        nav_registration_status_message = (TextView) findViewById(R.id.nav_registration_status_message);
                        nav_registration_status_message.setText(e.getMessage());
                    }
                }

                if (setApiReturnStatus()) {
                    imageViewCheckValidName.setImageResource(R.drawable.yes);
                } else {
                    imageViewCheckValidName.setImageResource(R.drawable.no);
                }
            }
        });
    }

    public boolean setApiReturnStatus() {
        if(1==1/*Return registration is true*/){
            return true;
        }
        else{
            return false;
        }
    }
}

