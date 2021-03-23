package com.example.android.fetch;

import android.content.Context;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> implements Filterable {
    private LayoutInflater inflater;
    private Context context;
    ArrayList<Word> words;
    ArrayList<Word> wordsFull;
    private int mColorResourceId;

    public CustomAdapter(Context context, ArrayList<Word> words, int colorResourceId){
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.words = words;
        wordsFull = new ArrayList<>(words);
        mColorResourceId = colorResourceId;
    }


    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItemView = inflater.inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(listItemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, int position) {
        final Word currentWord = words.get(position);
        holder.nameTextView.setText(currentWord.getCategorySelection());
        if(currentWord.hasImage()){
            holder.findImageView.setImageResource(currentWord.getImageResourceId());
            holder.findImageView.setVisibility(View.VISIBLE);
        } else {
            holder.findImageView.setVisibility(View.GONE);
        }

        int color = ContextCompat.getColor(inflater.getContext(), mColorResourceId);
        holder.textContainer.setBackgroundColor(color);


    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    @Override
    public Filter getFilter() {
        return wordFilter;
    }

    private Filter wordFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Word> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(wordsFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Word item : wordsFull) {
                    if(item.getCategorySelection().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            words.clear();
            words.addAll((ArrayList<Word>) results.values);
            notifyDataSetChanged();

        }
    };


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nameTextView;
        private ImageView findImageView;
        private View textContainer;
        private final Context context;

        private MyViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.category_selection_view);
            findImageView = itemView.findViewById(R.id.image);
            textContainer = itemView.findViewById(R.id.text_container);
            context = itemView.getContext();
            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            final Intent intent;
            switch(getAdapterPosition()){
                case 0:
                    intent = new Intent(context, AccountActivity.class);
                    break;
                default:
                    intent = new Intent(context, AccountActivity.class);
                    break;
            }
            context.startActivity(intent);
        }
    }
}
