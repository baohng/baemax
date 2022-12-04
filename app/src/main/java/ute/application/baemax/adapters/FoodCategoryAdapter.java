package ute.application.baemax.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ute.application.baemax.R;
import ute.application.baemax.activities.MainActivity;

public class FoodCategoryAdapter extends FirebaseRecyclerAdapter<model, FoodCategoryAdapter.myviewholder>
{
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

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

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(model.getName()).setValue(model);
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(model.getName()).child("trangthai").setValue("small classic");
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(model.getName()).child("them").setValue("0");
                databaseReference.child("Cart").child(MainActivity.firebaseUser).child(model.getName()).child("soluong").setValue("1");
            }
        });



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
        ConstraintLayout constraintLayout;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1=itemView.findViewById(R.id.image_food);
            nametext=itemView.findViewById(R.id.name);
            pricetext=itemView.findViewById(R.id.price);
            describetext=itemView.findViewById(R.id.describe);
            startext=itemView.findViewById(R.id.star);
            constraintLayout=itemView.findViewById(R.id.layout_itv);
        }
    }

}
