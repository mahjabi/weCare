package com.oishi.medicinetime;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register<string> extends AppCompatActivity {

    EditText mFullname,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mFullname=findViewById(R.id.PersonName);
        mEmail=findViewById(R.id.EmailAddress);
        mPassword=findViewById(R.id.Password);
        mPhone=findViewById(R.id.Phone);
        mRegisterBtn=findViewById(R.id.button2);
        mLoginBtn=findViewById(R.id.textviewcrt);

        fAuth=FirebaseAuth.getInstance();
        progressBar= findViewById(R.id.progressBar);
        if(fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email =  mEmail.getText().toString().trim();
                String pass =  mPassword.getText().toString().trim();
                if (TextUtils.isEmpty((CharSequence) email)) {
                    mEmail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty((CharSequence) pass)) {
                    mPassword.setError("password is required");
                    return;
                }
                if (((CharSequence) pass).length() < 6) {
                    mPassword.setError("password must be >=6 characters");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);

                fAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), scroll.class));
                        } else {
                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });


    }
}

