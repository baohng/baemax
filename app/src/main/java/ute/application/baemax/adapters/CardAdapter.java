package ute.application.baemax.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.List;

import ute.application.baemax.R;
import ute.application.baemax.dao.Card;

public class CardAdapter  extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {
    private List<Card> mCards;
    public void setData(List<Card> list) {
        this.mCards = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card2,parent,false);
        return new CardViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Card card = mCards.get(position);
        if (card == null) {
            return;
        }
        holder.imgCard.setImageResource(card.getResourceId());
        holder.tvTitle.setText(card.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mCards!=null){
            return mCards.size();
        }
        return 0;
    }
    public static class CardViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgCard;
        public BreakIterator tv_Title;
        private TextView tvTitle;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCard= itemView.findViewById(R.id.img_card);
            tvTitle=itemView.findViewById(R.id.tv_title);
        }
    }
}

