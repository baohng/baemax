package ute.application.baemax.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ute.application.baemax.R;
import ute.application.baemax.adapters.FoodCategoryAdapter;
import ute.application.baemax.adapters.MyAdapter;
import ute.application.baemax.adapters.model;
import ute.application.baemax.dao.Item;

public class CartActivity extends AppCompatActivity {
    RecyclerView recview;
    MyAdapter myAdapter;
    TextView textView;
    ArrayList<Item> itemList=new ArrayList<>();
    DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();
    Button btnOder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btnOder=findViewById(R.id.btnOder);

        recview = (RecyclerView)findViewById(R.id.lv_card);
        textView=findViewById(R.id.totalBill);
        recview.setLayoutManager(new LinearLayoutManager(CartActivity.this));
        myAdapter = new MyAdapter(CartActivity.this,itemList);
        databaseReference.child("Cart").child(MainActivity.firebaseUser).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Item item;
                double totalbill = 0;
                itemList.clear();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    item = new Item();
                    item.setDescribe(dataSnapshot.child("describe").getValue(String.class));
                    item.setName(dataSnapshot.child("name").getValue(String.class));
                    item.setStar(dataSnapshot.child("star").getValue(String.class));
                    item.setPrice(dataSnapshot.child("price").getValue(String.class));
                    item.setSur(dataSnapshot.child("sur").getValue(String.class));
                    item.setTrangthai(dataSnapshot.child("trangthai").getValue(String.class));
                    item.setThem(dataSnapshot.child("them").getValue(String.class));
                    item.setSlg(dataSnapshot.child("soluong").getValue(String.class));
                    try{
                        totalbill=(Double.parseDouble(item.getPrice())+Double.parseDouble(item.getThem()))*Integer.parseInt(item.getSlg())+totalbill;
                    }catch (Exception e){

                    }
                    itemList.add(item);
                }
                myAdapter.Update(itemList);
                textView.setText(String.valueOf(totalbill));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Cart").child(MainActivity.firebaseUser).removeValue();
                startActivity(new Intent(CartActivity.this,SuccessOderActivity.class));
            }
        });


        recview.setAdapter(myAdapter);
    }
}