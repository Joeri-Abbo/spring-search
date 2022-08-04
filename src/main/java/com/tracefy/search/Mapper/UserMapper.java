package com.tracefy.search.Mapper;

import com.tracefy.search.Models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setCity(rs.getString("city"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setRoleId(rs.getString("role_id"));
        user.setAddress(rs.getString("address"));
        user.setPostcode(rs.getString("postcode"));
        user.setBusinessId(rs.getString("businesses_id"));
        user.setBusinessName(rs.getString("businesses_name"));
        user.setBusinessAddress(rs.getString("businesses_address"));
        user.setBusinessPostcode(rs.getString("businesses_postcode"));
        user.setBusinessCity(rs.getString("businesses_city"));
        user.setBusinessEmail(rs.getString("businesses_email"));
        user.setBusinessPhone(rs.getString("businesses_phone"));
        user.setBusinessDepth(rs.getInt("businesses_depth"));
        user.setBusinessLevel(user.getBusinessDepth() == 0 ? "root" : "child");
        user.setBusiness();
        user.setEntityId(rs.getString("entity_id"));
        user.setEntityName(rs.getString("entity_name"));
        user.setEntityCount(rs.getInt("entity_count"));
        user.setEntity();
        user.setSubscriptionCount(rs.getInt("subscriptions_count"));
        user.setSubscriptions();
        user.setDeviceImei(rs.getString("device_imei"));
        user.setDevice();
        user.setUrls();
        return user;
    }
}