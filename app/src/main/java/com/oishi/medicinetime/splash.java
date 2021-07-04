package com.oishi.medicinetime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.google.firebase.auth.FirebaseAuth;


public class splash extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        lottieAnimationView=findViewById(R.id.lottie);
        lottieAnimationView.animate().translationY(2000).setDuration(4000).setStartDelay(2000);


        FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
        //FirebaseAuth firebaseUser =FirebaseAuth.getCurrentUser();

        if(firebaseAuth.getCurrentUser() !=null){
            //final Handler handler=new Handler(Looper.getMainLooper());
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(getApplicationContext(),scroll.class);
                    startActivity(intent);
                    finish();
                }
            },5000);
        }

        else{
            //final Handler handler=new Handler(Looper.getMainLooper());
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(getApplicationContext(),Register.class);
                    startActivity(intent);
                    finish();
                }
            },5000);
        }



    }
}

