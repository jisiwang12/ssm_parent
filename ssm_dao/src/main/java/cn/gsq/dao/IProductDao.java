package cn.gsq.dao;

import cn.gsq.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * 产品dao层接口
 * @author mechrevo
 */

public interface IProductDao {
    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from PRODUCT")
    public List<Product> findAll();

    /**
     * 添加产品
     * @param product
     */
    @Insert("insert into PRODUCT (productnum, productname, cityname, departuretime, productprice, productdesc, productstatus) values " +
            "(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);

    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
