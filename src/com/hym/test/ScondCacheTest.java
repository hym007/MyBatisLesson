package com.hym.test;

import com.hym.mapper.CustomerMapper;
import com.hym.po.Customer;
import com.hym.util.MybatisUtill;
import org.apache.ibatis.session.SqlSession;

public class ScondCacheTest {

    public static void main(String[] args) {
        SqlSession sqlSessionA = MybatisUtill.getSqlSession(false);
        CustomerMapper customerMapper = sqlSessionA.getMapper(CustomerMapper.class);

        Customer customer1 = customerMapper.findById(1);
        System.out.println(customer1);
        MybatisUtill.closeSqlSession(sqlSessionA);

        System.out.println("***********************");

        SqlSession sqlSessionB = MybatisUtill.getSqlSession(false);
        CustomerMapper customerMapper2 = sqlSessionB.getMapper(CustomerMapper.class);

        Customer customer2 = customerMapper2.findById(1);
        System.out.println(customer2);
        MybatisUtill.closeSqlSession(sqlSessionB);
    }
}
