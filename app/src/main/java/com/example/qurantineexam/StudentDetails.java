package com.example.qurantineexam;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    StudAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        recyclerView=findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference(DashboardAct.keyn);
        FirebaseRecyclerOptions<Smodel> options=new FirebaseRecyclerOptions.Builder<Smodel>()
                .setQuery(FirebaseDatabase.getInstance().getReference(DashboardAct.keyn).child("Candidates"),Smodel.class)
                .build();
        adapter=new StudAdapter(options);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.startListening();
        databaseReference=firebaseDatabase.getReference(DashboardAct.Keyr);
     //   FirebaseRecyclerOptions<Smodel> options=new FirebaseRecyclerOptions.Builder<Smodel>()
     //           .setQuery(FirebaseDatabase.getInstance().getReference(DashboardAct.Keyr).child())
    }
}