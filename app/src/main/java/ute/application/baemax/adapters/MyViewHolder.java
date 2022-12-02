package ute.application.baemax.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ute.application.baemax.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, priceView, starView, describeView ;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_food);
        nameView = itemView.findViewById(R.id.name);
        starView = itemView.findViewById(R.id.star);
        priceView = itemView.findViewById(R.id.price);
        describeView = itemView.findViewById(R.id.describe);

    }
}
