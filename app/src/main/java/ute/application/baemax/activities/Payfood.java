package ute.application.baemax.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ute.application.baemax.R;

public class Payfood extends AppCompatActivity {


    RadioButton r1,r2,r3,r11,r22,r33;
    TextView t1,t2,t3;
    TextView tong;
    String tongg,tonggg;
    Button btn;
    String giaa,giaa1,giaa2;
    CardView btn_remove,btn_add;
    ImageView btnCancel;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payfood);

        btnCancel=findViewById(R.id.iconCancel);
        tong=findViewById(R.id.textViewTotalMoneyPay);
        r1= findViewById(R.id.rdosmall);
        r2= findViewById(R.id.rdomedium);
        r3= findViewById(R.id.rdolarge);
        t1=findViewById(R.id.sizesmall);
        btn_remove=findViewById(R.id.btn_truSL);
        btn_add=findViewById(R.id.btn_addSL);
        r11=findViewById(R.id.cb11);
        r22=findViewById(R.id.cb22);
        r33=findViewById(R.id.cb33);
        btn=findViewById(R.id.buttonOrder);
        t2=findViewById(R.id.tvslg);
        String tt= getIntent().getStringExtra("tt").split(" ")[0];
        String tt1= getIntent().getStringExtra("tt").split(" ")[1];
        tongg=tt;
        tonggg=tt1;
        System.out.println(tt+" trangthai "+tt1);
        if (tt.equals("small")){
            giaa="0";
            r1.setChecked(true);
        }else if (tt.equals("medium")){
            giaa="5.99";
            r2.setChecked(true);
        }else {
            r3.setChecked(true);
            giaa="8.99";
        }

        if (tt1.equals("classic")){
            giaa1="0";
            r11.setChecked(true);
        }else if (tt1.equals("thin")){
            giaa1="5.99";
            r22.setChecked(true);
        }else {
            giaa1="8.99";
            r33.setChecked(true);
        }



        String name = getIntent().getStringExtra("name");
        String gia=getIntent().getStringExtra("gia");
        String them=String.valueOf(Double.parseDouble(giaa)+Double.parseDouble(giaa1));
        String slg=getIntent().getStringExtra("soluong");
        t2.setText(slg);
        t1.setText(gia+"$");
        tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");

        r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaa="0";
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
                tongg="small";
                r2.setChecked(false);
                r3.setChecked(false);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaa= "5.99";
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
                tongg="medium";
                r1.setChecked(false);
                r3.setChecked(false);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaa= "8.99";
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
                tongg="large";
                r2.setChecked(false);
                r1.setChecked(false);
            }
        });
        r11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaa1="0";
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
                tonggg="classic";
                r22.setChecked(false);
                r33.setChecked(false);
            }
        });
        r22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaa1= "5.99";
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
                tonggg="thin";
                r11.setChecked(false);
                r33.setChecked(false);
            }
        });
        r33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giaa1= "8.99";
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
                tonggg="chee";
                r22.setChecked(false);
                r11.setChecked(false);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(name).child("trangthai").setValue(tongg+" "+tonggg);
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(name).child("them").setValue(String.valueOf(Double.parseDouble(giaa)+Double.parseDouble(giaa1)));
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(name).child("soluong").setValue(t2.getText().toString());
                Intent intent = new Intent(Payfood.this,CartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(String.valueOf(Integer.parseInt(t2.getText().toString())-1));
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t2.setText(String.valueOf(Integer.parseInt(t2.getText().toString())+1));
                tong.setText(String.valueOf((Double.parseDouble(gia)+Double.parseDouble(giaa)+Double.parseDouble(giaa1))*Integer.parseInt(t2.getText().toString()))+"$");
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Payfood.this,CartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}
