package ute.application.baemax.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import ute.application.baemax.R;

public class FoodCategoryAdapter extends FirebaseRecyclerAdapter<model, FoodCategoryAdapter.myviewholder>
{

    public FoodCategoryAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull final model model) {
        holder.nametext.setText(model.getName());
        holder.pricetext.setText(model.getPrice());
        holder.describetext.setText(model.getDescribe());
        holder.startext.setText(model.getStar());
        Glide.with(holder.img1.getContext()).load(model.getSurl()).into(holder.img1);



    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView nametext,pricetext,describetext, startext;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.image_food);
            nametext=itemView.findViewById(R.id.name);
            pricetext=itemView.findViewById(R.id.price);
            describetext=itemView.findViewById(R.id.describe);
            startext=itemView.findViewById(R.id.star);
        }
    }

}
