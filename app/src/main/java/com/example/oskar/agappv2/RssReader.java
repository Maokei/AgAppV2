package com.example.oskar.agappv2;

import android.os.AsyncTask;
import android.util.Log;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Oskar on 2017-02-22.
 */

public class RssReader extends AsyncTask<String, Void, ArrayList<Article>> {
    @Override
    protected ArrayList<Article> doInBackground(String... urls) {
        String feed = urls[0];
        URL url = null;

        try{
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();

            url = new URL(feed);
            ArticleContentHandler contentHandler = new ArticleContentHandler();

            xr.setContentHandler(contentHandler);
            xr.parse(new InputSource(url.openStream()));
            ArrayList result = contentHandler.getArticleList();

            return result;

        }
        catch (IOException e){
            Log.e("IO", e.getMessage());
        }
        catch (SAXException e){
            Log.e("SAX", e.getMessage());
        }
        catch (ParserConfigurationException e){
            Log.e("Parser", e.getMessage());
        }
        return null;    }

    @Override
    protected void onPostExecute(ArrayList result){
        if (result != null){
            // (1) Hur får jag in data till Mainactivity när asyncen är färdig?
        }
    }
}
