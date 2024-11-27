package com.dhernandez.nicestart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;





public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        LottieAnimationView loti=findViewById(R.id.loti);
        loti.setVisibility(View.INVISIBLE);

        ImageView mGirl = findViewById(R.id.girl);
        Glide.with(this)
                // .load(R.drawable.girl)
                .load("https://attic.sh/dh8y986csspynffxk94ermb3598q")
                .transition(DrawableTransitionOptions.withCrossFade(1500))
                //.centerCrop()
                //.circleCrop()

                //.placeholder(new ColorDrawable(this.getResources().getColor(R.color.Teal3)))
                .into(mGirl);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void openSignup(View v) {
        Intent intent = new Intent(Login.this, Signup.class);
        startActivity(intent);

    }
    public void openMain(View v){
        ImageView capa=findViewById(R.id.capa);
        capa.getBackground().setAlpha(128);
        LottieAnimationView loti=findViewById(R.id.loti);
        loti.setVisibility(View.VISIBLE);
        loti.playAnimation();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run() {
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        }, 5000);
    }
}