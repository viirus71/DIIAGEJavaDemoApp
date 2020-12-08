package diiage.potherat.demo.demoapp3.ui.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.DiffUtil;

import org.jetbrains.annotations.NotNull;

import diiage.potherat.demo.demoapp3.R;
import diiage.potherat.demo.demoapp3.model.Quote;

public class QuoteAdapter extends PagingDataAdapter<Quote,QuoteViewHolder> {

    private static DiffUtil.ItemCallback<Quote> DIFF_CALLBACK = new DiffUtil.ItemCallback<Quote> (){

        @Override
        public boolean areItemsTheSame(@NonNull Quote oldItem, @NonNull Quote newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Quote oldItem, @NonNull Quote newItem) {
            return oldItem.equals(newItem);
        }
    };

    public QuoteAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_quote,parent,false);
        return new QuoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        Quote item = getItem(position);
        if (item != null) {
            holder.getQuote().setText(item.getQuote());
            holder.getSource().setText(item.getSource());
        }
    }
}
