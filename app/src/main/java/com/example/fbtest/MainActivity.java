package com.example.fbtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText adName, adSName;
    private DatabaseReference myDataBase;
    private String USER_KEY = "USER";
    Button button,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adName = findViewById(R.id.adName);
        adSName = findViewById(R.id.adSName);
        myDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = adName.getText().toString();
                String second_name = adSName.getText().toString();
                User newUser = new User(name,second_name);
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(second_name)){
                    myDataBase.child(name).child("name").setValue(name);
                    myDataBase.child(name).child("second").setValue(second_name);
                }
                else{
                    Toast.makeText(MainActivity.this,"Не все поля заполнены", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Read.class);
                startActivity(intent);
            }
        });
    }





}
