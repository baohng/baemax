package ute.application.baemax;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import card.Card;
import category.Category;
import category.CategoryAdapter;
import food.Food;
import listFoods.ListFood;
import listFoods.ListFoodAdapter;
public class home_activity extends AppCompatActivity {
    private  RecyclerView rcvFoodList;
    private ListFoodAdapter listFoodAdapter;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rcvFoodList = findViewById(R.id.rcv_list);
        listFoodAdapter = new ListFoodAdapter(this);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvFoodList.setLayoutManager(linearLayoutManager1);
        listFoodAdapter.setData(getListFood());
        rcvFoodList.setAdapter(listFoodAdapter);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }
    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Card> listBook=new ArrayList<>();
        listBook.add(new Card(R.drawable.hambager,"hambager"));
        listBook.add(new Card(R.drawable.pizza,"Pizza"));
        listBook.add(new Card(R.drawable.hotdog,"Hotdog"));
        listBook.add(new Card(R.drawable.pizza,"Pizza"));
        listBook.add(new Card(R.drawable.hotdog,"Hotdog"));
        listBook.add(new Card(R.drawable.hambager,"hambager"));

        listCategory.add(new Category("Categories",listBook));
        return listCategory ;
    }
    private List<ListFood> getListFood(){
        List<ListFood> listListFood = new ArrayList<>();
        List<Food> listFood=new ArrayList<>();
        listFood.add(new Food(R.drawable.foot_main_1,"Burgers hot"));
        listFood.add(new Food(R.drawable.foot_main_2,"Burgers hot"));
        listFood.add(new Food(R.drawable.foot_main_3,"Burgers hot"));
        listListFood.add(new ListFood("Food for you", listFood));
        return listListFood ;
    }
}