package ute.application.baemax.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import ute.application.baemax.R;

public class Home_Admin extends AppCompatActivity {
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
    public void onBurgersClick(View View){
        startActivity(new Intent(this,BurgersActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }

    public void onSandwichsClick(View View){
        startActivity(new Intent(this,SandwichsActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }

    public void onPizzasClick(View View){
        startActivity(new Intent(this,PizzasActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }

    public void onDrinksClick(View View){
        startActivity(new Intent(this,DrinksActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}

