package com.clover.common.cache;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @InterfaceName: Cache
 * @Description: 处理redis
 * @Author: Clover
 * @Date: 2021.03.18
 * Version: 1.0
 */
public interface Cache {

    //========================common================

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间（秒）
     * @return
     */
    Boolean expire(String key, long time);

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能位Null
     * @return 时间（秒）  返回0代表位永久有效
     */
    long getExpire(String key);

    /**
     * 判断key 是否存在
     *
     * @param key 键
     * @return ture存在 false不存在
     */
    Boolean hasKey(String key);

    /**
     * 删除缓存
     *
     * @param key 可以传一个值  或者多个
     */

    void del(String... key);
    //==================String===========================

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return true成功 false 失败
     */
    Boolean set(String key, String value);

    /**
     * 递增
     *
     * @param key   键
     * @param delta 要增加几（大于0）
     * @return
     */
    long incr(String key, long delta);

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要增少几（大于0）
     * @return
     */
    long decr(String key, long delta);
    //========================map=====================

    /**
     * hashget
     *
     * @param key  键  不能为空
     * @param item 键  不能为空
     * @return
     */
    Object hget(String key, String item);

    /**
     * 获取hashkey对应的所有键值
     *
     * @param key 键
     * @return 对应的多个键值
     */
    Object hmget(String key);

    /**
     * hashset
     *
     * @param key 键
     * @param map 值
     * @return true成功 false 失败
     */
    Boolean hmset(String key, Map<String, Object> map);

    /**
     * hashset 并设置是加班呢
     *
     * @param key 键
     * @param map 值
     * @return true成功 false 失败
     * @Param time 时间（秒）
     */
    Boolean hmset(String key, Map<String, String> map, long time);


    /**
     * 向一张hash表中放入数据，如果不存在讲创建
     *
     * @param key   键
     * @param item  值
     * @param value 值
     * @param time  时间
     * @return true成功 false 失败
     */
    Boolean hmset(String key, String item, Object value, long time);

    /**
     * 删除hash表中的值
     *
     * @param key  键  不能为空
     * @param item 键 可以多个 不能为空
     * @return
     */
    Object hdel(String key, Object... item);

    /**
     * 判断hash表中是否有该项的值
     *
     * @param key  键  不能为空
     * @param item 键 可以多个 不能为空
     * @return
     */
    Object hHasKey(String key, String item);

    /**
     * hash递增  如果不存在就会创建一个 并把新增加后的值返回
     *
     * @param key  键
     * @param item 项
     * @param by   要增加几（大于0）
     * @return
     */
    double hincr(String key, String item, double by);

    /**
     * hash递减
     *
     * @param key  键
     * @param item 项
     * @param by   要减少几（小于0）
     * @return
     */
    double hdecr(String key, String item, double by);
    //===============================set=================================

    /**
     * 根据key 获取set中的所有值
     *
     * @param key 键
     * @return
     */
    Set<String> sGet(String key);

    /**
     * 根据value从一个set中查询，是否存在
     *
     * @param key   键  不能为空
     * @param value 键  不能为空
     * @return
     */
    Boolean sHasKye(String key, Object value);


    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param values 值   可以多个
     * @return 成功个数
     */
    long sSet(String key, String... values);

    /**
     * 将数据放入set缓存
     *
     * @param key    键
     * @param time   时间（秒）
     * @param values 值   可以多个
     * @return 成功个数
     */
    long sSetAndTime(String key, long time, String... values);

    /**
     * 向获取set缓存的长度
     *
     * @param key 键
     * @return
     */
    long sGetSetSize(String key);

    /**
     * 移除值位value
     *
     * @param key   键  不能为空
     * @param value 键 可以多个 不能为空
     * @return
     */
    long sdel(String key, Object... value);
    //====================list===================

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    long lGetListSize(String key);

    /**
     * 根据k索引 获取list中的所有值
     *
     * @param key   键
     * @param index 索引
     * @return
     */
    Object lGetListIntex(String key, long index);


    /**
     * 将list放入缓存
     *
     * @param key    键
     * @param values 值   可以多个
     * @return 成功个数
     */
    Boolean lSet(String key, String values);

    /**
     * 将list放入缓存
     *
     * @param key    键
     * @param time   时间（秒）
     * @param values 值   可以多个
     * @return 成功个数
     */
    Boolean lSet(String key, Object values, long time);



    /**
     * 根据索引修改list中的某条数据
     *
     * @param key    键
     * @param index  索引
     * @param values 值
     * @return 成功个数
     */
    Boolean lUpdateIndex(String key, long index, Object values);

    /**
     * 移除N个值位value
     *
     * @param key   键  不能为空
     * @param value 键 可以多个 不能为空
     * @param count 移除多少个
     * @return
     */
    long lRemove(String key, Object value, long count);

}
