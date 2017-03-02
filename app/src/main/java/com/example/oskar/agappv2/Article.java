package com.example.oskar.agappv2;

/**
 * Created by Oskar on 2017-02-20.
 */

public class Article {

        private String title;
        private String description;
        private String link;
        private String guid;
        private String pubDate;


        //Getters
        public String getPubDate() {
            return pubDate;
        }

        public String getDescription() {
            return description;
        }

        public String getGuid() {
            return guid;
        }

        public String getLink() {
            return link;
        }

        public String getTitle() {
            return title;
        }

        //Setters
        public void setDescription(String description) {
            this.description = description;
        }

        public void setGuid(String guid) {
            this.guid = guid;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

