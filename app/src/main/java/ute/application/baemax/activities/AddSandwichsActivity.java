package ute.application.baemax.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import ute.application.baemax.R;

public class AddSandwichsActivity extends AppCompatActivity {

    EditText name, price, describe, star, surl;
    Button btnAdd, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sandwichs);

        name = (EditText) findViewById(R.id.txtNameSandwich);
        price = (EditText) findViewById(R.id.txtPriceSandwich);
        describe= (EditText) findViewById(R.id.txtDescribeSandwich);
        star= (EditText) findViewById(R.id.txtStarSandwich);
        surl = (EditText) findViewById(R.id.txtImageUrlSandwich);

        btnAdd = (Button) findViewById(R.id.btnAddSandwich);
        btnBack = (Button) findViewById(R.id.btnBack_Sandwich);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void insertData() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("price", price.getText().toString());
        map.put("describe", describe.getText().toString());
        map.put("star", star.getText().toString());
        map.put("surl", surl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("sandwichs").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddSandwichsActivity.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddSandwichsActivity.this, "Error while Insertion.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll(){
        name.setText("");
        price.setText("");
        describe.setText("");
        star.setText("");
        surl.setText("");
    }
}