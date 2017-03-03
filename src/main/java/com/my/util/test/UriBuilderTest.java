package com.my.util.test;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

public class UriBuilderTest {
    public static void main(String[] args) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("http")
                .setHost("test")
                .setPort(80)
                .setPath("/test/uri")
                .addParameter("a", "");

        try {
            HttpGet httpget = new HttpGet(builder.build());
            System.out.println(httpget.getURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
