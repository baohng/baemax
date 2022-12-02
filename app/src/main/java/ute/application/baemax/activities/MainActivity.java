package ute.application.baemax.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ute.application.baemax.R;


public class MainActivity extends AppCompatActivity {
    //Testing transfer activity
    Button startBtn;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(MainActivity.this,menu_detail.class));

        setStartActivity();
    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,Register.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }

    public void setStartActivity(){
        startBtn = (Button) findViewById(R.id.btnStartActivity);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Homepage.class);
                startActivity(intent);
            }
        });
    }
}