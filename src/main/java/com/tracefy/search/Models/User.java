package com.tracefy.search.Models;

import com.tracefy.search.Helpers.Url;

import java.util.HashMap;

public class User {
    private String name;
    private static String id;
    private String phone;
    private String email;
    private String city;
    private Object urls;
    private String roleId;
    private String role;
    private String address;
    private String postcode;
    private String businesses_id;
    private String businesses_name;
    private String businesses_address;
    private String businesses_postcode;
    private String businesses_city;
    private String businesses_email;
    private String businesses_phone;
    private Integer businesses_depth;
    private String businesses_level;
    private Object business;
    private String entityId;
    private String entityName;
    private Integer entityCount;
    private Object entity;
    private Integer subscriptions_count;
    private Object subscriptions;
    private String device_imei;
    private Object device;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
        setRole();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRole() {
        if (roleId.equals("a67b62f7-353c-497c-a90f-b234568e8949")) {
            this.role = "Super Admin";
        } else if (roleId.equals("96f03ca9-fd96-4750-a812-b4840f88367d")) {
            this.role = "Analyzer";
        } else if (roleId.equals("7748d502-e758-4c51-b26c-6b284b559558")) {
            this.role = "Dealer";
        } else if (roleId.equals("d4b3c6db-5cec-4d97-9dbb-d2c95963f35a")) {
            this.role = "Manager";
        } else if (roleId.equals("38cb5d4c-f307-461a-8831-64a31e880fd0")) {
            this.role = "Reporter";
        } else if (roleId.equals("c3fa5e40-0a7c-483e-b279-e68903db2bbe")) {
            this.role = "Technician";
        } else if (roleId.equals("53621528-91aa-42a6-afb4-b764f68c05c9")) {
            this.role = "User";
        } else {
            this.role = "No role";
        }
    }

    public String getRole() {
        return role;
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

    public Object getUrls() {
        return urls;
    }

    public void setUrls() {
        HashMap<String, String> urls = new HashMap<String, String>();

        urls.put("show", getShowUrl(id));
        urls.put("destroy", getDestroyUrl(id));
        urls.put("forceDestroy", getDestroyUrl(id));

        this.urls = urls;
    }

    public static String getShowUrl(String id) {
        return Url.getBackofficeUrl() + "businesses/" + id;
    }

    public static String getDestroyUrl(String id) {
        return Url.getBackofficeUrl() + "businesses/" + id + "/destroy";
    }

    public static String getForceDestroyUrl(String id) {
        return Url.getBackofficeUrl() + "businesses/" + id + "/force-destroy";
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setBusinessId(String businesses_id) {
        this.businesses_id = businesses_id;
    }

    public String getBusinessId() {
        return businesses_id;
    }

    public void setBusinessName(String businesses_name) {
        this.businesses_name = businesses_name;
    }

    public String getBusinessName() {
        return businesses_name;
    }

    public void setBusinessAddress(String businesses_address) {
        this.businesses_address = businesses_address;
    }

    public String getBusinessAddress() {
        return businesses_address;
    }

    public void setBusinessPostcode(String businesses_postcode) {
        this.businesses_postcode = businesses_postcode;
    }

    public String getBusinessPostcode() {
        return businesses_postcode;
    }

    public void setBusinessCity(String businesses_city) {
        this.businesses_city = businesses_city;
    }

    public String getBusinessCity() {
        return businesses_city;
    }

    public void setBusinessEmail(String businesses_email) {
        this.businesses_email = businesses_email;
    }

    public String getBusinessEmail() {
        return businesses_email;
    }

    public void setBusinessPhone(String businesses_phone) {
        this.businesses_phone = businesses_phone;
    }

    public String getBusinessPhone() {
        return businesses_phone;
    }

    public void setBusinessDepth(Integer businesses_depth) {
        this.businesses_depth = businesses_depth;
    }

    public Integer getBusinessDepth() {
        return businesses_depth;
    }

    public void setBusinessLevel(String businesses_level) {
        this.businesses_level = businesses_level;
    }

    public String getBusinessLevel() {
        return businesses_level;
    }

    public void setBusiness() {
        HashMap<String, String> business = new HashMap<String, String>();

        business.put("show", Business.getShowUrl(id));
        business.put("name", getBusinessName());
        business.put("level", getBusinessLevel());
        business.put("address", getBusinessAddress());
        business.put("postcode", getBusinessPostcode());
        business.put("city", getBusinessCity());
        business.put("email", getBusinessEmail());
        business.put("phone", getBusinessPhone());

        this.business = business;
    }

    public Object getBusiness() {
        return business;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityCount(Integer entityCount) {
        this.entityCount = entityCount;
    }

    public Integer getEntityCount() {
        return entityCount;
    }

    public void setEntity() {
        HashMap<String, String> entity = new HashMap<String, String>();

        entity.put("show", Url.getBackofficeUrl() + "entities/" + entityId);
        entity.put("id", getEntityId());
        entity.put("name", getEntityName());
        entity.put("lastSeen", "Implement me");
        entity.put("odo", "Implement me");
        entity.put("count", getEntityCount().toString());

        this.entity = entity;
    }

    public Object getEntity() {
        return entity;
    }

    public void setSubscriptionCount(Integer subscriptions_count) {
        this.subscriptions_count = subscriptions_count;
    }

    public Integer getSubscriptionCount() {
        return subscriptions_count;
    }

    public void setSubscriptions() {
        HashMap<String, String> subscriptions = new HashMap<String, String>();
        subscriptions.put("count", getSubscriptionCount().toString());

        this.subscriptions = subscriptions;
    }

    public Object getSubscriptions() {
        return subscriptions;
    }

    public void setDeviceImei(String device_imei) {
        this.device_imei = device_imei;
    }
    public String getDeviceImei() {
        return device_imei;
    }
    public void setDevice() {
        HashMap<String, String> device = new HashMap<String, String>();
        device.put("imei", getDeviceImei());
        device.put("show", Device.getShowUrl(getDeviceImei()));

        this.device = device;
    }

    public Object getDevice() {
        return device;
    }
}