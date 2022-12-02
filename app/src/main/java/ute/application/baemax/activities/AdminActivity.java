package ute.application.baemax.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ute.application.baemax.R;

public class AdminActivity extends AppCompatActivity {

    Button button_burgers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        button_burgers =findViewById(R.id.button_burgers);

        button_burgers.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View view) {
            Intent i = new Intent(AdminActivity.this, BurgersActivity.class);
            startActivity(i);
         }
        });

    }
    }