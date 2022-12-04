package ute.application.baemax.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;

import ute.application.baemax.R;
import ute.application.baemax.adapters.ListViewActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        //            đăng xuất khi on click vào button log out trên layout profile

         button = (Button) findViewById(R.id.buttonDangXuat);









        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.profileV);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), Homepage.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profileV:
                        return  true;

                    case R.id.listV:
                        startActivity(new Intent(getApplicationContext(), ListViewActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), CartActivity.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }








        });

//// logout profile / app

    logout= (Button) findViewById(R.id.buttonDangXuat);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Profile.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
            builder.setTitle("bạn có muốn thoát khỏi app");
            builder.setMessage("Hãy lựa chọn bên dưới để xác nhận");

            builder.setIcon(android.R.drawable.ic_btn_speak_now);
            builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    //code logout on back layout app
//                    onBackPressed();


                    /// logout success in home phone
                    finishAffinity();


                }
            });
            builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.show();
        }
    });


    //onclick button

    }
    public void onProfileClicktoAdmin(View View){
        startActivity(new Intent(this,LoginAdmin.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }



}