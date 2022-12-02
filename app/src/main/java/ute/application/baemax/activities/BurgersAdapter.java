package ute.application.baemax.activities;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import ute.application.baemax.R;

public class BurgersAdapter extends FirebaseRecyclerAdapter<MainModel,BurgersAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public BurgersAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    Context context;

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull MainModel model) {

        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.describe.setText(model.getDescribe());
        holder.star.setText(model.getStar());
        Glide.with(holder.img.getContext())
               .load(model.getSurl())
             .into(holder.img);

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1500)
                        .create();


                View view1 = dialogPlus.getHolderView();

                EditText name = view1.findViewById(R.id.txtName);
                EditText price= view1.findViewById(R.id.txtPrice);
                EditText describe = view1.findViewById(R.id.txtDescribe);
                EditText star = view1.findViewById(R.id.txtStar);
                EditText surl = view1.findViewById(R.id.txtImageUrl);

                Button btnUpdate = view1.findViewById(R.id.btnUpdate);

                name.setText(model.getName());
                price.setText(model.getPrice());
                describe.setText(model.getDescribe());
                star.setText(model.getStar());
                surl.setText(model.getSurl());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("name",name.getText().toString());
                        map.put("price",price.getText().toString());
                        map.put("describe",describe.getText().toString());
                        map.put("star",star.getText().toString());
                        map.put("surl",surl.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("burgers")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.name.getContext(),"Data Update Successfully",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure( Exception e) {
                                        Toast.makeText(holder.name.getContext(),"Error While Updating",Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });



            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.name.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted data can't be Undo.");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("burgers")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.name.getContext(),"Canclled",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class  myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView img;
        TextView name, price, describe, star;
        Button btnEdit, btnDelete;

        public myViewHolder(@NonNull View itemView){
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img_food);
            name = (TextView) itemView.findViewById(R.id.nametext);
            price = (TextView) itemView.findViewById(R.id.pricetext);
            describe = (TextView) itemView.findViewById(R.id.describetext);
            star = (TextView) itemView.findViewById(R.id.startext);

            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
        }
    }
}
