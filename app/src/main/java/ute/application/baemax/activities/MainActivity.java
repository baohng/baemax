package ute.application.baemax.activities;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD:app/src/main/java/ute/application/baemax/activities/MainActivity.java


=======
import android.content.Intent;
>>>>>>> features/na/ui-detail-2:app/src/main/java/ute/application/baemax/MainActivity.java
import android.os.Bundle;

import ute.application.baemax.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(MainActivity.this,menu_detail.class));
    }
}