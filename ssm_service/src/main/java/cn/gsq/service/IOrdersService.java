package cn.gsq.service;

import cn.gsq.domain.Orders;

import java.util.List;

public interface IOrdersService {
    /**
     * 查询并分页
     * @param page
     * @param pageSize
     * @return
     */
    List<Orders> findAllByPage(int page, int pageSize) throws Exception;

    Orders findById(String id);
}
