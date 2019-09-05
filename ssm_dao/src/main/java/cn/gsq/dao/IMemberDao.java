package cn.gsq.dao;

import cn.gsq.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * 会员的Dao层接口
 * @author mechrevo
 */
public interface IMemberDao {
    /**
     * 通过id查找
     * @param id
     * @return
     */
    @Select("select * from MEMBER where ID=#{id}")
    public Member findById(String id);
}
