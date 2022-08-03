package com.tracefy.search.Models;

import com.tracefy.search.Helpers.Url;

import java.util.HashMap;

public class Business {
    private String name;
    private String id;
    private int depth;
    private String phone;
    private String email;
    private String city;
    private String level;
    private Object urls;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public Object getUrls() {
        return urls;
    }

    public void setUrls(String id) {
        HashMap<String, String> urls = new HashMap<String, String>();

        urls.put("show", getShowUrl());
        urls.put("destroy", getDestroyUrl());

        this.urls = new String[]{id};
    }

    public String getShowUrl() {
        return Url.getBackofficeUrl() + "/businesses/" + id;
    }

    public String getDestroyUrl() {
        return Url.getBackofficeUrl() + "/businesses/" + id + "/destroy";
    }
}