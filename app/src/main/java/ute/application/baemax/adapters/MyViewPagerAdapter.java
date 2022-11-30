package ute.application.baemax.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import ute.application.baemax.fragments.BurgersFragment;
import ute.application.baemax.fragments.DrinksFragment;
import ute.application.baemax.fragments.SandwichFragment;
import ute.application.baemax.fragments.PizzaFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override

    public Fragment createFragment(int position){
        switch (position){
            case 0:
                return new SandwichFragment();
            case 1:
                return new PizzaFragment();
            case 2:
                return new BurgersFragment();
            case 3:
                return new DrinksFragment();
            default:
                return new SandwichFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
