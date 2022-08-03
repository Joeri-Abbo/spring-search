package com.tracefy.search.Dao;

import com.tracefy.search.Models.Business;

import java.util.List;
import javax.sql.DataSource;

public interface BusinessDao {
    /**
     * This is the method to be used to initialize
     * database resources i.e. connection.
     */
    public void setDataSource(DataSource ds);

    /**
     * This is the method to be used to list down
     * all the records from the business table.
     */
    public List<Business> listBusinesses(String name, int amount);
}
