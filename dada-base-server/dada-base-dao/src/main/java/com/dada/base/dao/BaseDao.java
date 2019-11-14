package com.dada.base.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * DAO公共基类
 * @author lijinghua on 2019/9/9
 */
@Repository
public interface BaseDao<ID, T extends Serializable> {

    /**
     * 保存实体
     *
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 删除实体
     *
     * @param entity
     * @return
     */

    int delete(T entity);
    /**
     * 通过entity更新实体
     *
     * @param entity
     * @return
     */
    int update(T entity);

    /**
     * 通过唯一值id查找一条实体
     *
     * @param id
     * @return
     */
    T selectID(ID id);

    /**
     * 条件查询返回唯一实体
     *
     * @param entity
     * @return
     */
    T selectEntity(T entity);

    /**
     * 通过条件查询返回list实体
     *
     * @param entity
     * @return
     */
    List<T> selectBy(T entity);

    /**
     * 通过条件查询总条数
     *
     * @param entity
     * @return
     */
    long selectByCount(T entity);
}