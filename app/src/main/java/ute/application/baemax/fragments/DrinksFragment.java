package ute.application.baemax.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import ute.application.baemax.R;
import ute.application.baemax.adapters.FoodCategoryAdapter;
import ute.application.baemax.adapters.model;


public class DrinksFragment extends Fragment {
    RecyclerView recview;
    FoodCategoryAdapter listBurgerAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        recview = (RecyclerView)view.findViewById(R.id.recyclerview_drinks);
        recview.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("drinks"), model.class)
                        .build();

        listBurgerAdapter = new FoodCategoryAdapter(options);
        recview.setAdapter(listBurgerAdapter);

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
        listBurgerAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        listBurgerAdapter.stopListening();
    }
}