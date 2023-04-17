package com.example.centenarioschoolapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import com.mongodb.client.MongoClient;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class StudentRegistrationStatus<App> extends AppCompatActivity {
    TextView nav_registration_status_message;
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

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = searchInput.getText().toString();

                // Connect to MongoDB Atlas
                String mongoURI = "mongodb://zannatulsakina:gAQEnlXLX8ejm3Rm@team6centenario.0vezpan.mongodb.net/Team6Centenario";
                ConnectionString connectionString = new ConnectionString(mongoURI);
                MongoClientSettings settings = MongoClientSettings.builder()
                        .applyConnectionString(connectionString)
                        .build();
                MongoClient mongoClient = MongoClients.create(settings);
                MongoDatabase db = mongoClient.getDatabase(connectionString.getDatabase());

                // Access to Registration database
                MongoDatabase database = mongoClient.getDatabase("Registration");

                // Acceses to Student collection
                MongoCollection<Document> collection = database.getCollection("Student");

                // Check registration status by searching the student name
                Document student = collection.find(new Document("name", inputName)).first();

                // If student name not found, return not found message
                if (student == null) {
                    nav_registration_status_message = (TextView) findViewById(R.id.nav_registration_status_message);
                    nav_registration_status_message.setText("Student name not found");
                }

                // If student name found, return registration status true or false
                if (student.getBoolean("registration_status")==true) {
                    imageViewCheckValidName.setImageResource(R.drawable.yes);
                } else {
                    imageViewCheckValidName.setImageResource(R.drawable.no);
                }
            }
        });
    }
}

