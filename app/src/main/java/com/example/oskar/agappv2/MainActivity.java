package com.example.oskar.agappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

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
        articleAdapter = new ArticleAdapter(articleList); // (3) Kommer artikellistan in rätt här?
        recyclerView.setAdapter(articleAdapter);

    }

    private void refreshList(){
        rssReader = new RssReader();
        rssReader.execute(url);

    }

    public void updateList(ArrayList arrayList){
        articleList = arrayList;
        // (2) Kan data komma in här och fylla arraylisten med artiklar?
    }
}
