package cn.gsq.service;

import cn.gsq.domain.Product;

import java.util.List;

/**
 * 产品service层接口
 * @author mechrevo
 */
public interface IProductService {


    /**
     * 查询所有
     * @return
     */
    List<Product> findAll();

    /**
     * 添加产品
     * @param product
     */
    void save(Product product);
}
