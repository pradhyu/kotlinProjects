package com.oauth1;

class OAuthConfig(url:String, consumerKey:String, consumerSecret:String) {
    val url:String
    val consumerKey:String
    val consumerSecret:String
    init{
        if ((url == null || url.isEmpty() ||
                        consumerKey == null || consumerKey.isEmpty() ||
                        consumerSecret == null || consumerSecret.isEmpty()))
        {
            throw IllegalArgumentException("All arguments are required")
        }
        this.url = url
        this.consumerKey = consumerKey
        this.consumerSecret = consumerSecret
    }
}