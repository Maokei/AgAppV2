package com.example.oskar.agappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    //private static final int numberOfItems = 15;
    private String url = "http://www.vafinans.se/rss/nyheter";
    private ArticleAdapter articleAdapter;
    private RecyclerView recyclerView;
    private ArrayList<Article> articleList;
    private RssReader rssReader;
    private ArticleContentHandler contentHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_article);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        refreshList();
        articleAdapter = new ArticleAdapter(articleList);
        recyclerView.setAdapter(articleAdapter);

    }

    private void refreshList(){
        rssReader = new RssReader();
        rssReader.execute(url);
        try {
            updateList(rssReader.get());
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }
    }

    public void updateList(ArrayList arrayList){
        articleList = arrayList;
    }
}
