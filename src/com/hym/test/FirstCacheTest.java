package com.hym.test;

import com.hym.mapper.CustomerMapper;
import com.hym.po.Customer;
import com.hym.util.MybatisUtill;
import org.apache.ibatis.session.SqlSession;

public class FirstCacheTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtill.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);

        Customer customer = customerMapper.findById(1);
        System.out.println(customer);
//        sqlSession.commit();

        System.out.println("***************************");

        Customer customer2 = customerMapper.findById(1);
        System.out.println(customer2);
    }
}
