package ute.application.baemax;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Item> newsArrayList;

    public  MyAdapter(Context context, ArrayList<Item> newsArrayList){
        this.context = context;
        this.newsArrayList = newsArrayList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = newsArrayList.get(position);

        holder.imageView.setImageResource(item.image);
        holder.name.setText(item.name);
        holder.star.setText(item.star);
        holder.price.setText(item.price);
        holder.describe.setText(item.describe);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name, price,star, describe;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_food);
            name = itemView.findViewById(R.id.name);
            star = itemView.findViewById(R.id.star);
            price = itemView.findViewById(R.id.price);
            describe = itemView.findViewById(R.id.describe);
        }
    }
}
