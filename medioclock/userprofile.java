package com.example.medioclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class userprofile extends AppCompatActivity //implements RadioGroup.OnCheckedChangeListener
{
    EditText firstnameinput, lastnameinput, ageinput, chroniconditioninput;
    RadioGroup genderbox;
    RadioButton Bmale, Bfemale;
    Button submitprofilebtn;
    String gender;
    String male;
    String female;

    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    //using awesome validation


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        //assinging variables
        genderbox = (RadioGroup) findViewById(R.id.genderbox);
        firstnameinput =(EditText) findViewById(R.id.firstnameinput);
        ageinput = (EditText) findViewById(R.id.ageinput);
        chroniconditioninput = (EditText) findViewById(R.id.chroniconditioninput);
        lastnameinput = (EditText) findViewById(R.id.lastnameinput);
        submitprofilebtn = (Button) findViewById(R.id.submitprofilebtn);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        Bmale = (RadioButton) findViewById(R.id.radiomale);
        Bfemale = (RadioButton) findViewById(R.id.radiofemale);




       submitprofilebtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String firstname= firstnameinput.getText().toString();
               String lastname= lastnameinput.getText().toString();
               String age=ageinput.getText().toString();
               String croniccondition = chroniconditioninput.getText().toString();

               if (firstname.isEmpty()){
                   firstnameinput.setError("Enter First name");
                   return;
               }
               if (lastname.isEmpty()){
                   lastnameinput.setError("Enter Last name");
                   return;
               }
               if (age.isEmpty()){
                   ageinput.setError("Enter valid age");
                   return;
               }

               userID=fAuth.getCurrentUser().getUid();
               DocumentReference documentReference=fStore.collection("user").document(userID);
               Map<String,Object>user=new HashMap<>();
               user.put("firstname",firstname);
               user.put("lastname",lastname);
               user.put("age",age);
               user.put("chronicondition",croniccondition);
               documentReference.set(user);
               startActivity(new Intent(getApplicationContext(), MainActivity.class));
               finish();

           }
       });

    }


}






