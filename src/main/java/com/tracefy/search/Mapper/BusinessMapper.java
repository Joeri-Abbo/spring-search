package com.tracefy.search.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tracefy.search.Models.Business;
import org.springframework.jdbc.core.RowMapper;

public class BusinessMapper implements RowMapper<Business> {
    public Business mapRow(ResultSet rs, int rowNum) throws SQLException {
        Business business = new Business();
        business.setId(rs.getString("id"));
        business.setCity(rs.getString("city"));
        business.setEmail(rs.getString("email"));
        business.setPhone(rs.getString("phone"));
        business.setDepth(rs.getInt("depth"));
        business.setName(rs.getString("name"));
        business.setLevel(business.getDepth() == 0 ? "root" : "child");
        return business;
    }
}