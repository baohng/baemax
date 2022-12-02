package ute.application.baemax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class home_admin extends AppCompatActivity {
    LinearLayout backhere;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
    }

    public void onLoginClick3(View View){
        startActivity(new Intent(this,LoginAdmin.class));
        overridePendingTransition(R.anim.slide_in_left,R.anim.stay);

    }
}