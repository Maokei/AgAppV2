package com.example.oskar.agappv2;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oskar on 2017-02-22.
 */

public class ArticleContentHandler extends DefaultHandler{
    private Article currentArticle = new Article();
    private ArrayList articleList = new ArrayList<>();
    private int articlesAdded = 0;
    private int articlesLimit = 15;
    StringBuffer chars = new StringBuffer();

    public ArrayList<Article> getArticleList(){return articleList;}


    public void startElement(String uri, String localName, String qName, Attributes atts) {
        chars = new StringBuffer();
    }

    public void endElement (String uri, String localName, String qName) throws SAXException{
        if(localName.equalsIgnoreCase("title")){
            currentArticle.setTitle(chars.toString());
        }
        else if(localName.equalsIgnoreCase("description")){
            currentArticle.setDescription(chars.toString());
        }
        else if(localName.equalsIgnoreCase("pubdate")){
            currentArticle.setPubDate(chars.toString());
        }
        else if(localName.equalsIgnoreCase("guid")){
            currentArticle.setGuid(chars.toString());
        }
        else if(localName.equalsIgnoreCase("entry")){}

        if(localName.equalsIgnoreCase("entry")){
            articleList.add(currentArticle);
            currentArticle = new Article();
            articlesAdded++;
            if(articlesAdded>=articlesLimit){
                throw new SAXException();
            }

        }
    }

    public void characters(char ch[], int start, int length) {
        chars.append(new String(ch, start, length));
    }
}
