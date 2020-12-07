package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText mId, mName, mActor;
    Button save,retrive;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Info");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mId = findViewById(R.id.movieId);
        mName = findViewById(R.id.movieName);
        mActor = findViewById(R.id.movieActor);
        save = findViewById(R.id.saveData);
        retrive = findViewById(R.id.retData);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
            }
        });

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RetriveData.class));
            }
        });
    }

    private void insertData(View v)
    {
        String id=mId.getText().toString();
        String name=mName.getText().toString();
        String actor=mActor.getText().toString();

        Helper helper = new Helper(id,actor,name);

        myRef.child(id).setValue(helper);

        Toast.makeText(this,"Insert Sucessfull",Toast.LENGTH_LONG).show();

        mId.setText("");
        mName.setText("");
        mActor.setText("");
    }
}