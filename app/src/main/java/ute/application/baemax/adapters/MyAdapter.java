package ute.application.baemax.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ute.application.baemax.activities.MainActivity;
import ute.application.baemax.activities.Payfood;
import ute.application.baemax.dao.Item;
import ute.application.baemax.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Item> newsArrayList;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

    public MyAdapter(Context context, ArrayList<Item> newsArrayList){
        this.context = context;
        this.newsArrayList = newsArrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_view_1,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = newsArrayList.get(position);

        Glide.with(holder.imageView.getContext()).load(item.getSur()).into(holder.imageView);
        holder.name.setText(item.getName());
        holder.star.setText(item.getStar());
        holder.price.setText(String.valueOf((Double.parseDouble(item.getPrice())+Double.parseDouble(item.getThem()))));
        holder.describe.setText(item.getDescribe());
        holder.trangthai.setText(item.getTrangthai());
        holder.slg.setText("Số lượng: "+item.getSlg());
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Payfood.class);
                intent.putExtra("name",item.getName());
                intent.putExtra("gia",item.getPrice());
                intent.putExtra("them",item.getThem());
                intent.putExtra("tt",item.getTrangthai());
                intent.putExtra("soluong",item.getSlg());
                view.getContext().startActivity(intent);
            }
        });
        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(item.getName()).removeValue();
            }
        });

    }
    public void Update(ArrayList<Item> items){
        this.newsArrayList=items;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView,btnDel;
        TextView name, price,star, describe,trangthai,slg;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_food);
            name = itemView.findViewById(R.id.name);
            star = itemView.findViewById(R.id.star);
            price = itemView.findViewById(R.id.price);
            describe = itemView.findViewById(R.id.describe);
            constraintLayout=itemView.findViewById(R.id.layout_itv);
            trangthai=itemView.findViewById(R.id.trangthai);
            btnDel=itemView.findViewById(R.id.btn_delCart);
            slg=itemView.findViewById(R.id.slg);
        }
    }
}
