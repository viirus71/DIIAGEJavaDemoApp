package diiage.potherat.demo.demoapp3.ui.gallery;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import diiage.potherat.demo.demoapp3.R;

public class QuoteViewHolder extends RecyclerView.ViewHolder {
    TextView quote;
    TextView source;

    public QuoteViewHolder(@NonNull View itemView) {
        super(itemView);
        quote = itemView.findViewById(R.id.txtQuote);
        source = itemView.findViewById(R.id.txtSource);
    }

    public TextView getQuote() {
        return quote;
    }

    public TextView getSource() {
        return source;
    }
}
