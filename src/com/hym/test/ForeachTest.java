package com.hym.test;

import com.hym.mapper.CustomerMapper;
import com.hym.po.Customer;
import com.hym.util.MybatisUtill;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ForeachTest {
    public static void main(String[] args) {
    }

    /**
     * 批量增
     */
    @Test
    public void insertCustomer(){
        SqlSession sqlSession = MybatisUtill.getSqlSession(true);
        CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);

        List<Customer> list = new ArrayList<>();
        list.add(new Customer(17,"诸葛亮","军师","18657923648"));
        list.add(new Customer(18,"周瑜","程序猿","3679845672"));
        list.add(new Customer(19,"小乔","家庭主妇","18569743569"));
        int row = customerMapper.insertCustomer(list);
        if (row>0){
            System.out.println("成功插入了"+row+"条数据");
        }else{
            System.out.println("插入失败");
        }
        MybatisUtill.closeSqlSession(sqlSession);
    }


    /**
     * 批量修改
     */
    @Test
    public void updateCustomer(){
        SqlSession sqlSession = MybatisUtill.getSqlSession(true);
        CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);

        List<Customer> list = new ArrayList<>();
        list.add(new Customer(17,"程序猿"));
        list.add(new Customer(18,"教师"));
        list.add(new Customer(19,"医生"));
        int row = customerMapper.updateCustomer(list);

        if (row>0){
            System.out.println("成功修改了"+row+"条数据");
        }else {
            System.out.println("修改失败");
        }

        MybatisUtill.closeSqlSession(sqlSession);
    }


    /**
     * 批量删除
     */
    @Test
    public void delCustomer(){
        SqlSession sqlSession = MybatisUtill.getSqlSession(true);
        CustomerMapper customerMapper= sqlSession.getMapper(CustomerMapper.class);

        String[] array = new String[]{"17","18","19"};
        int row = customerMapper.delCustomer(array);

        if (row>0){
            System.out.println("成功删除了"+row+"条数据");
        }else {
            System.out.println("删除失败");
        }
        MybatisUtill.closeSqlSession(sqlSession);
    }
}
