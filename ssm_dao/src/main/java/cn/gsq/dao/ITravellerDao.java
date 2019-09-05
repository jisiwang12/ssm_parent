package cn.gsq.dao;

import cn.gsq.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from traveller where id in(select TRAVELLERID from ORDER_TRAVELLER where ORDERID=#{id})")
    public List<Traveller> findById(String id);
}
