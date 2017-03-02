package com.example.oskar.agappv2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oskar on 2017-02-20.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>{

    private ArrayList<Article> articleList;

    public ArticleAdapter(ArrayList<Article> articles){
        articleList = articles;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.activity_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean toParent = false;

        View view = inflater.inflate(layoutId, parent, toParent);
        ArticleViewHolder viewHolder = new ArticleViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        holder.bind(article);


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder{

        TextView titleView;
        TextView descriptionView;
        TextView pubdateView;
        Article article;

        private  String Article_key = "ARTICLEKEY";

        public ArticleViewHolder(View view){
            super(view);
            titleView = (TextView) view.findViewById(R.id.tv_articleTitle);
            descriptionView = (TextView) view.findViewById(R.id.tv_articleDescription);
            pubdateView = (TextView) view.findViewById(R.id.tv_articleDate);
        }

        public void bind(Article theArticle){
            article = theArticle;
            titleView.setText(article.getTitle());
            descriptionView.setText(article.getDescription());
            pubdateView.setText(article.getPubDate());

        }



    }
}
