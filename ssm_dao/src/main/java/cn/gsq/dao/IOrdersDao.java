package cn.gsq.dao;

import cn.gsq.domain.Member;
import cn.gsq.domain.Orders;
import cn.gsq.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results( {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType =Product.class, one = @One(select =
                    "cn.gsq.dao.IProductDao.findById"))})
    List<Orders> findAllByPage() throws Exception;

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    @Select("select * from ORDERS where ID=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType =Product.class, one = @One(select =
                    "cn.gsq.dao.IProductDao.findById")),
            @Result(column = "memberId" ,property = "member",javaType = Member.class,
                    one = @One(select = "cn.gsq.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers" ,javaType = List.class,
                    many = @Many(select = "cn.gsq.dao.ITravellerDao.findById"))
    })
    Orders findById(String id);
}


