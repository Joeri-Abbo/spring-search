package com.tracefy.search.Mapper;

import com.tracefy.search.Models.Device;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceMapper implements RowMapper<Device> {
    public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
        Device device = new Device();
        device.setId(rs.getString("id"));
        device.setImei(rs.getString("imei"));
        device.setModel(rs.getString("model"));
        device.setIccid(rs.getString("iccid"));
        device.setBusinessId(rs.getString("business_id"));
        device.setBusinessName(rs.getString("business_name"));
        device.setBusiness();
        device.setEntityId(rs.getString("entity_id"));
        device.setEntityName(rs.getString("entity_name"));
        device.setEntity();
        device.setUrls();
        return device;
    }
}