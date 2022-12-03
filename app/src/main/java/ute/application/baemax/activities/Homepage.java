package ute.application.baemax.activities;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import ute.application.baemax.R;
import ute.application.baemax.dao.Card;
import ute.application.baemax.dao.Category;
import ute.application.baemax.adapters.CategoryAdapter;
import ute.application.baemax.dao.Food;
import ute.application.baemax.dao.ListFood;
import ute.application.baemax.adapters.ListFoodAdapter;
public class Homepage extends AppCompatActivity {
    private  RecyclerView rcvFoodList;
    private ListFoodAdapter listFoodAdapter;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;

    //Testing transfer button
    Button btnOrderHomepage;
    //
    ImageView avatarToProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
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

        //Testing transfer
        setOpenOrderActivity();
        setOpenProfileActivity();
        //
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

    public void setOpenOrderActivity(){
        btnOrderHomepage = (Button) findViewById(R.id.btnORDERHomepage);
        btnOrderHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this,ListViewActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setOpenProfileActivity(){
        avatarToProfile = (ImageView) findViewById(R.id.avatarHomepage);
        avatarToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Homepage.this,Profile.class);
                startActivity(intent);
            }
        });
    }
}