package com.tracefy.search.JDBC;

import com.tracefy.search.Dao.DeviceDao;
import com.tracefy.search.Mapper.DeviceMapper;
import com.tracefy.search.Models.Business;
import com.tracefy.search.Models.Device;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.object.SqlQuery;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class DeviceJDBCTemplate implements DeviceDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public List<Device> listDevices(String name, int amount) {
        String sql = "select `devices`.`id`, `devices`.`imei`, `devices`.`iccid`, `devices`.`model`, `businesses`.`id` as `business_id`, `businesses`.`name` as `business_name`, `entities`.`id` as `entity_id`, `entities`.`name` as `entity_name` from `devices` left join `businesses` on `businesses`.`id` = `devices`.`business_id` left join `device_entity_user` on `device_entity_user`.`imei` = `devices`.`imei` and `device_entity_user`.`deleted_at` is null left join `entities` on `entities`.`id` = `device_entity_user`.`entity_id` and `device_entity_user`.`deleted_at` is null where (`devices`.`id` like '%" + name + "%' or `devices`.`imei` like '%" + name + "%' or `devices`.`iccid` like '%" + name + "%' or `devices`.`model` like '%" + name + "%') limit" + amount;
        SqlQuery<Device> sqlQuery = new SqlQuery<Device>() {
            @Override
            protected RowMapper<Device> newRowMapper(Object[] parameters, Map<?, ?> context) {
                return new DeviceMapper();
            }
        };
        sqlQuery.setDataSource(dataSource);
        sqlQuery.setSql(sql);
        return sqlQuery.execute();
    }
}