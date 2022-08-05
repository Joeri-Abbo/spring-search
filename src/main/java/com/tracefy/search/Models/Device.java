package com.tracefy.search.Models;

import com.tracefy.search.Helpers.Url;

import java.util.HashMap;

public class Device {
    private String name;
    private String id;
    private int depth;
    private String phone;
    private String email;
    private String city;
    private String level;
    private Object urls;
    private String imei;
    private String model;
    private String iccid;
    private String business_id;
    private String business_name;
    private Object business;
    private String entity_id;
    private String entity_name;
    private Object entity;

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

    public void setUrls() {
        HashMap<String, String> urls = new HashMap<String, String>();

        urls.put("show", getShowUrl(id));
        urls.put("destroy", getDestroyUrl(id));

        this.urls = urls;
    }

    public static String getShowUrl(String imei) {
        return Url.getBackofficeUrl() + "devices/" + imei;
    }

    public static String getDestroyUrl(String id) {
        return Url.getBackofficeUrl() + "devices/" + id + "/destroy";
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getImei() {
        return imei;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public String getIccid() {
        return iccid;
    }

    public void setBusinessId(String business_id) {
        this.business_id = business_id;
    }

    public String getBusinessId() {
        return business_id;
    }

    public void setBusinessName(String business_name) {
        this.business_name = business_name;
    }

    public String getBusinessName() {
        return business_name;
    }

    public void setBusiness() {
        HashMap<String, String> business = new HashMap<String, String>();

        business.put("show", Business.getShowUrl(imei));
        business.put("name", getBusinessName());

        this.business = business;
    }

    public Object getBusiness() {
        return business;
    }

    public void setEntityId(String entity_id) {
        this.entity_id = entity_id;
    }

    public String getEntityId() {
        return entity_id;
    }

    public void setEntityName(String entity_name) {
        this.entity_name = entity_name;
    }

    public String getEntityName() {
        return entity_name;
    }

    public void setEntity() {
        HashMap<String, String> entity = new HashMap<String, String>();

        entity.put("show", Business.getShowUrl(id));
        entity.put("name", getBusinessName());

        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }
}