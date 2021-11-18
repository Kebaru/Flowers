package com.example.flowers;

import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private List<Flowers> mFlowers;

    FlowerAdapter(List<Flowers> posts) {
        this.mFlowers = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_flowers, parent,
                false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flowers post = mFlowers.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.postTextView.setText(Html.fromHtml(post.toString(), Html
                    .FROM_HTML_MODE_LEGACY));
        } else {
            holder.postTextView.setText(Html.fromHtml(post.toString()));
        }
    }

    @Override
    public int getItemCount() {
        if (mFlowers == null)
            return 0;
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView postTextView;

        ViewHolder(View itemView) {
            super(itemView);
            postTextView =  itemView.findViewById(R.id.textView_item_post);
        }
    }}
