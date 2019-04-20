package com.hym.mapper;

import com.hym.po.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    //通过ID查询
    Customer findById(int i);
    //查询所有
    List<Customer> findAll();

    //使用if元素合二为一查询
    List<Customer> findAllByLikeName(@Param("keyword") String keyword);

    List<Customer> findAllByLikeName2(@Param("keyword") String keyword,@Param("jobs") String jobs,@Param("id") int id);

    //批量查操作
    List<Customer> findCustomerByIds(List<Customer> list);

    //批量增操作
    int insertCustomer(List<Customer> list);

    //批量修改
    int updateCustomer(List<Customer> list);

    //批量删除
    int delCustomer(String[] arry);

}
