package com.example.medioclock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.medioclock.Adapter.EventAdapter;
import com.example.medioclock.Database.DatabaseClass;
import com.example.medioclock.Database.EntityClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;

import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity  {

    TextView firstname;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    Button alarm,viewprofile,gotosearch;
    EventAdapter eventAdapter;
    RecyclerView recyclerview1;

    DatabaseClass databaseClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewprofile=findViewById(R.id.viewprofile);
        gotosearch=findViewById(R.id.gotosearch);

        alarm=findViewById(R.id.alarm);
        recyclerview1 = findViewById(R.id.recyclerview1);

        databaseClass = DatabaseClass.getDatabase(getApplicationContext());

        firstname = findViewById(R.id.firstname);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();




        userID=fAuth.getCurrentUser().getUid();
        viewprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), viewprofile.class));
            }
        });

        gotosearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), search.class));
            }
        });


        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), alarm.class));
            }
        });


   DocumentReference documentReference=fStore.collection("user").document(userID);
   documentReference.get()
           .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
               @Override
               public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                   if (task.getResult().exists()){

                       String fname = task.getResult().getString("firstname");

                       firstname.setText(fname);
                   }

               }
           });


 //       DocumentReference documentReference =fStore.collection("user").document(userID);
   //     userID=fAuth.getCurrentUser().getUid();

     //    documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {

       //     @Override

         //   public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

  //              firstname.setText(DocumentSnapshot.getString("fName"));
//
    //        }
      //  });


    }
    @Override
    protected void onResume() {
        super.onResume();
        setAdapter();

    }

    private void setAdapter() {
        List<EntityClass> classList = databaseClass.EventDao().getAllData();
        eventAdapter = new EventAdapter(getApplicationContext(), classList);
        recyclerview1.setAdapter(eventAdapter);
    }









}
