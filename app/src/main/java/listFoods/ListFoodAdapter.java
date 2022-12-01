package listFoods;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import category.Category;
import listFoods.ListFood;
import java.util.List;
import food.FoodAdapter;
import ute.application.baemax.R;

public class ListFoodAdapter extends RecyclerView.Adapter<listFoods.ListFoodAdapter.CategoryViewHolder> {
    private Context mContext;
    private List<ListFood> mListCategory;
    private Object LinearLayoutManager;

    public ListFoodAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void  setData(List<ListFood> list){
        this.mListCategory= list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public listFoods.ListFoodAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list,parent,false);
        return new listFoods.ListFoodAdapter.CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listFoods.ListFoodAdapter.CategoryViewHolder holder, int position) {
        ListFood category= mListCategory.get(position);
        if (category==null){
            return;
        }
        holder.tvNameCategory.setText(category.getNameCategory());
        androidx.recyclerview.widget.LinearLayoutManager linearLayoutManager= new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL,false);
        holder.rcvBook.setLayoutManager(linearLayoutManager);

        FoodAdapter foodAdapter= new FoodAdapter();
        foodAdapter.setData(category.getBooks());
        holder.rcvBook.setAdapter(foodAdapter);
    }

    @Override
    public int getItemCount() {
        if(mListCategory!=null ){
            return mListCategory.size();

        }
        return 0;
    }
    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNameCategory;
        private RecyclerView rcvBook;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory= itemView.findViewById(R.id.tv_name_foodList);
            rcvBook= itemView.findViewById(R.id.rcv_foodList);
        }
    }
}