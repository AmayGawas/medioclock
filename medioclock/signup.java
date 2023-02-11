package com.example.medioclock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText signupemail,signuppassword,signupconfpassword;
     Button signup,switchtologin;
   //  AwesomeValidation awesomeValidation;
     FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //Assigning variables
        signupemail = findViewById(R.id.signupemail);
        signupconfpassword = findViewById(R.id.signupconfpassword);
        signuppassword = findViewById(R.id.signuppassword);
        signup = findViewById(R.id.btnsignup);
        switchtologin =findViewById(R.id.switchtologin);
        fAuth = FirebaseAuth.getInstance();


        switchtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), login.class));
            }
        });

             signup.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                     String Email = signupemail.getText().toString();
                     String password = signuppassword.getText().toString();
                     String cpassword = signupconfpassword.getText().toString();

                     if (Email.isEmpty()){
                         signupemail.setError("Enter Email");
                         return;
                     }

                     if (password.isEmpty()){
                         signuppassword.setError("Enter password");
                         return;
                     }
                     if (cpassword.isEmpty()){
                         signupconfpassword.setError("Enter confirm password");
                         return;
                     }
                     if (!password.equals(cpassword)){
                         signupconfpassword.setError("password does not match");
                         return;
                     }

                     fAuth.createUserWithEmailAndPassword(Email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                         @Override
                         public void onSuccess(AuthResult authResult) {
                             startActivity(new Intent(getApplicationContext(),userprofile.class));
                             finish();

                         }
                     }).addOnFailureListener(new OnFailureListener() {
                         @Override
                         public void onFailure(@NonNull Exception e) {
                             Toast.makeText(signup.this,e.getMessage(),Toast.LENGTH_SHORT).show();

                         }
                     });
                 }
             });



    }
    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
    }

}



//validation style
       // awesomeValidation =new AwesomeValidation(ValidationStyle.BASIC);

        //Validation for Email
     //   awesomeValidation.addValidation(this,R.id.signupemail,
                //RegexTemplate.NOT_EMPTY,R.string.invalid_email);
        //for password
     //   awesomeValidation.addValidation(this,R.id.signuppassword
    //    , ".{6,}",R.string.invalide_password);
        //for confirm password
     //   awesomeValidation.addValidation(this,R.id.signupconfpassword
    //    ,R.id.signuppassword,R.string.invalid_confirm_password);



     //   signup.setOnClickListener(new View.OnClickListener() {
       //     @Override
          //  public void onClick(View v) {


                //checking for successful signup
            //    if (awesomeValidation.validate()){
                    //on success
             //       Toast.makeText(getApplicationContext()
            //        ,"Signup successful!",Toast.LENGTH_SHORT).show();
            //    }
           //     else {
              //      Toast.makeText(getApplicationContext(),
              //      "Singup failed:(",Toast.LENGTH_SHORT).show();
            //    }
           //     String password =signuppassword.getText().toString();
              //  String email =signupemail.getText().toString();
            //    String cpassword = signupconfpassword.getText().toString();


   // fAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
     //   @Override
    //    public void onSuccess(AuthResult authResult) {
            //sending user to the homepage(MainActivity)
        //   startActivity(new Intent(getApplicationContext(), userprofile.class));
            //user will be unable to go signup page after loging in
        //    finish();
     //   }
  //  }).addOnFailureListener(new OnFailureListener() {
  //      @Override
   //     public void onFailure(@NonNull Exception e) {
    //        Toast.makeText(signup.this, e.getMessage(), Toast.LENGTH_SHORT).show();

    //    }
   // });
//}

    //closing brackets here
      //  });
