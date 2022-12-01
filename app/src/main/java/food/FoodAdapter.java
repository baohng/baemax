package food;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ute.application.baemax.R;
import food.Food;
public class FoodAdapter  extends RecyclerView.Adapter<FoodAdapter.BookViewHolder> {
    private List<Food> mFoods;
    public void setData(List<Food> list) {
        this.mFoods = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card1,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Food book = mFoods.get(position);
        if (book == null) {
            return;
        }
        holder.imgFood.setImageResource(book.getResourceId());
        holder.txtTitle.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mFoods!=null){
            return mFoods.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFood;
        private TextView txtTitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood= itemView.findViewById(R.id.img_food);
            txtTitle=itemView.findViewById(R.id.txt_food);
        }
    }
}
