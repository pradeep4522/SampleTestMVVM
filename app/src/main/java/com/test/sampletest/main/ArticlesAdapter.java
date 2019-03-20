package com.test.sampletest.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.sampletest.R;
import com.test.sampletest.model.PopularArticles;
import com.test.sampletest.model.Result;

import java.util.ArrayList;
import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.MyViewHolder> {

    List<Result> data;

    public ArticlesAdapter(List<Result> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_article, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.textDescription.setText(data.get(i).getTitle());
        myViewHolder.textdate.setText(data.get(i).getPublishedDate());
        myViewHolder.textAuthor.setText(data.get(i).getByline());
        myViewHolder.textComp.setText(data.get(i).getSource());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView thumbNail, detailArrow;
        TextView textDescription, textAuthor, textComp, textdate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbNail = itemView.findViewById(R.id.imgvthumbNail);
            detailArrow = itemView.findViewById(R.id.imgvthumbNail);
            textAuthor = itemView.findViewById(R.id.author);
            textComp= itemView.findViewById(R.id.companyName);
            textDescription= itemView.findViewById(R.id.description);
            textdate= itemView.findViewById(R.id.date);

        }
    }
}
