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

public class AddPizzasActivity extends AppCompatActivity {

    EditText name, price, describe, star, surl;
    Button btnAdd, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizzas);

        name = (EditText) findViewById(R.id.txtNamePizza);
        price = (EditText) findViewById(R.id.txtPricePizza);
        describe= (EditText) findViewById(R.id.txtDescribePizza);
        star= (EditText) findViewById(R.id.txtStarPizza);
        surl = (EditText) findViewById(R.id.txtImageUrlPizza);

        btnAdd = (Button) findViewById(R.id.btnAddPizza);
        btnBack = (Button) findViewById(R.id.btnBackPizza);

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

        FirebaseDatabase.getInstance().getReference().child("pizzas").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddPizzasActivity.this, "Data Inserted Successfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddPizzasActivity.this, "Error while Insertion.", Toast.LENGTH_SHORT).show();
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