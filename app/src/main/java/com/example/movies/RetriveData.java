package com.example.movies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RetriveData extends AppCompatActivity {

    private Button Back;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    private List<Helper> list;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference myRef = database.getReference("Info");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrive_data);

        Back = findViewById(R.id.back);

        recyclerView=findViewById(R.id.reView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    //Toast.makeText(getApplicationContext(),"Data Present",Toast.LENGTH_LONG).show();
                    for(DataSnapshot dataSnapshot:snapshot.getChildren())
                    {
                        Helper helper = dataSnapshot.getValue(Helper.class);
                        list.add(helper);
                    }
                    //Toast.makeText(getApplicationContext(),list.size()+"",Toast.LENGTH_LONG).show();
                    myAdapter = new MyAdapter(getApplicationContext(),list);
                    recyclerView.setAdapter(myAdapter);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Data Not Present",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}