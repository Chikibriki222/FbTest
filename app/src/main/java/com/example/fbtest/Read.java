package com.example.fbtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read extends AppCompatActivity {
    ListView listView;
    String[] dada = {"","","","",""};
    ArrayAdapter adapter;
    private List<String> listData;
    private DatabaseReference myDataBase;
    private String USER_KEY = "USER";
    TextView tv_main;
    List<User> userslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_read);
        listView = findViewById(R.id.listView);
        tv_main = findViewById(R.id.tv_main);
        userslist = new ArrayList<User>();

        myDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);

        myDataBase.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    for (DataSnapshot ds:task.getResult().getChildren()){
                        User added = new User(ds.child("name").getValue().toString(),ds.child("second").getValue().toString());
                        List<String[]> listt =new ArrayList<>();
                        listt.add(added.toArr());
                        userslist.add(added);
                        Toast.makeText(Read.this,added.toString(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(Read.this,ds.getValue().toString(), Toast.LENGTH_SHORT).show();
                        tv_main.setText(userslist.toString());

                    }
                    Log.d("firebase0000000", userslist.toString());
                }
            }
        });


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User("Danil","Sekeresh");
        User user2 = new User("Dasha","Pavlova");
        List<String[]> listt =new ArrayList<>();
        listt.add(user.toArr());
        listt.add(user2.toArr());
        String[][] strings = new String[listt.size()][];
        for (int i = 0; i < listt.size(); i++){

            strings[i] = listt.get(i);

        }
        Log.d("testing", Arrays.deepToString(strings));

        strings[0][0] = "1";
        ;
        dada[1] = "sgsgg";
        adapter = new ArrayAdapter<User>(Read.this, android.R.layout.simple_list_item_1,userslist);
        listView.setAdapter(adapter);





    }


}