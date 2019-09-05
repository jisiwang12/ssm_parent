package cn.gsq.service.impl;

import cn.gsq.dao.IOrdersDao;
import cn.gsq.domain.Orders;
import cn.gsq.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrdersService {
    @Autowired
    IOrdersDao ordersDao;

    @Override
    public List<Orders> findAllByPage(int page, int pageSize) throws Exception {
        PageHelper.startPage(page, pageSize);
        return ordersDao.findAllByPage();

    }

    @Override
    public Orders findById(String id) {
        Orders byId = ordersDao.findById(id);
        return byId;

    }
}
