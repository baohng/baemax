package ute.application.baemax.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ute.application.baemax.R;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    public void onLoginClick(View View){
        startActivity(new Intent(this,Register.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
    public void onLoginClickADMIN(View View){
        startActivity(new Intent(this, LoginAdmin.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}