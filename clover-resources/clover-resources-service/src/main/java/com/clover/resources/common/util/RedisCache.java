package com.clover.resources.common.util;

import com.clover.common.cache.Cache;
import com.clover.common.domain.BusinessException;
import com.clover.common.domain.CommonErrorCode;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedisCache
 * @Description: RedisCache具体逻辑层
 * @Author: Clover
 * @Date: 2021.04.13
 * Version: 1.0
 */
public class RedisCache implements Cache {

	private StringRedisTemplate redisTemplate;

	public RedisCache(StringRedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	//========================common================
	/**
	 * 指定缓存失效时间
	 * @param key 键
	 * @param time 时间（秒）
	 * @return
	 */
	public  Boolean expire(String key,long time){
		try {
			if(time>0){
				redisTemplate.expire(key,time, TimeUnit.SECONDS);
			}
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}

	}

	/**
	 * 根据key 获取过期时间
	 * @param key 键 不能位Null
	 * @return  时间（秒）  返回0代表位永久有效
	 */
	public long getExpire(String key){
		return  redisTemplate.getExpire(key,TimeUnit.SECONDS);
	}

	/**
	 * 判断key 是否存在
	 * @param key 键
	 * @return ture存在 false不存在
	 */
	public  Boolean hasKey(String key){
		try {
			return  redisTemplate.hasKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}

	/**
	 * 删除缓存
	 * @param key  可以传一个值  或者多个
	 */
	@SuppressWarnings("unchecked")
	public  void  del (String... key){
		if (key!=null && key.length>0){
			if (key.length==1){
				redisTemplate.delete(key[0]);
			}else{
				redisTemplate.delete(CollectionUtils.arrayToList(key));
			}
		}
	}
	//==================String===========================

	/**
	 * 普通缓存获取
	 * @param key 键
	 * @return 值
	 */
	public String get(String key){
		return  key==null?null:redisTemplate.opsForValue().get(key);
	}


	/**
	 * 普通缓存放入
	 * @param key 键
	 * @param value 值
	 * @return true成功 false 失败
	 */
	public  Boolean set(String key,String value){
		try {
			redisTemplate.opsForValue().set(key,value);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}

	/**
	 * 递增
	 * @param key 键
	 * @param delta 要增加几（大于0）
	 * @return
	 */
	public  long incr(String key,long delta){
		throwMethod(delta);
		return  redisTemplate.opsForValue().increment(key,delta);
	}
	/**
	 * 递减
	 * @param key 键
	 * @param delta 要增少几（大于0）
	 * @return
	 */
	public  long decr(String key,long delta){
		throwMethod(delta);
		return  redisTemplate.opsForValue().increment(key,-delta);
	}

	//========================map=====================
	/**
	 * hashget
	 * @param key 键  不能为空
	 * @param item 键  不能为空
	 * @return
	 */
	public Object hget(String key,String item){
		return  redisTemplate.opsForHash().get(key,item);
	}
	/**
	 * 获取hashkey对应的所有键值
	 * @param key 键
	 * @return 对应的多个键值
	 */
	public Object hmget(String key){
		return  redisTemplate.opsForHash().entries(key);
	}

	/**
	 * hashset
	 * @param key 键
	 * @param map 值
	 * @return true成功 false 失败
	 */
	public  Boolean hmset(String key, Map<String,Object> map){
		try {
			redisTemplate.opsForHash().putAll(key,map);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}
	/**
	 * hashset 并设置是加班呢
	 * @param key 键
	 * @param map 值
	 * @Param time 时间（秒）
	 * @return true成功 false 失败
	 */
	public  Boolean hmset(String key, Map<String,String> map, long time){
		try {
			redisTemplate.opsForHash().putAll(key,map);
			if (time>0){
				expire(key, time);
			}
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}
	/**
	 *向一张hash表中放入数据，如果不存在讲创建
	 * @param key 键
	 * @param item 值
	 * @param value 值
	 * @param  time 时间
	 * @return true成功 false 失败
	 */
	public  Boolean hmset(String key, String item,Object value,long time){
		try {
			redisTemplate.opsForHash().put(key,item,value);
			if (time>0){
				expire(key, time);
			}
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}
	/**
	 * 删除hash表中的值
	 * @param key 键  不能为空
	 * @param item 键 可以多个 不能为空
	 * @return
	 */
	public Object hdel(String key,Object... item){
		return  redisTemplate.opsForHash().delete(key,item);
	}
	/**
	 * 判断hash表中是否有该项的值
	 * @param key 键  不能为空
	 * @param item 键 可以多个 不能为空
	 * @return
	 */
	public Object hHasKey(String key,String item){
		return  redisTemplate.opsForHash().hasKey(key,item);
	}

	/**
	 * hash递增  如果不存在就会创建一个 并把新增加后的值返回
	 * @param key  键
	 * @param item 项
	 * @param by   要增加几（大于0）
	 * @return
	 */
	public double hincr(String key,String item,double by){
		return  redisTemplate.opsForHash().increment(key,item,by);
	}
	/**
	 * hash递减
	 * @param key  键
	 * @param item 项
	 * @param by   要减少几（小于0）
	 * @return
	 */
	public double hdecr(String key,String item,double by){
		return  redisTemplate.opsForHash().increment(key,item,-by);
	}
	//===============================set=================================

	/**
	 * 根据key 获取set中的所有值
	 * @param key 键
	 * @return
	 */
	public Set<String> sGet(String key){
		try {
			return  redisTemplate.opsForSet().members(key);
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}
	}
	/**
	 * 根据value从一个set中查询，是否存在
	 * @param key 键  不能为空
	 * @param value 键  不能为空
	 * @return
	 */
	public Boolean sHasKye(String key,Object value){
		return  redisTemplate.opsForSet().isMember(key,value);
	}


	/**
	 * 将数据放入set缓存
	 * @param key 键
	 * @param values 值   可以多个
	 * @return 成功个数
	 */
	public  long sSet(String key,String... values){
		try {
			return redisTemplate.opsForSet().add(key, values);
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
		}
	}
	/**
	 * 将数据放入set缓存
	 * @param key 键
	 * @param  time 时间（秒）
	 * @param values 值   可以多个
	 * @return 成功个数
	 */
	public  long sSetAndTime(String key,long time,String... values){
		try {
			Long count=redisTemplate.opsForSet().add(key,values);
			if (time>0)
				expire(key, time);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
		}
	}
	/**
	 *向获取set缓存的长度
	 * @param key 键
	 * @return
	 */
	public  long sGetSetSize(String key){
		try {

			return redisTemplate.opsForSet().size(key);
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
		}
	}

	/**
	 * 移除值位value
	 * @param key 键  不能为空
	 * @param value 键 可以多个 不能为空
	 * @return
	 */
	public long sdel(String key,Object... value){
		try {
			Long count=redisTemplate.opsForSet().remove(key,value);
			return  count;
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
		}
	}
	//====================list===================

	/**
	 * 获取list缓存的长度
	 * @param key 键
	 * @return
	 */
	public  long lGetListSize(String key){
		try {
			return  redisTemplate.opsForList().size(key);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	/**
	 * 根据k索引 获取list中的所有值
	 * @param key 键
	 * @param  index 索引
	 * @return
	 */
	public Object lGetListIntex(String key,long index){
		try {
			return  redisTemplate.opsForList().index(key,index);
		} catch (Exception e) {
			e.printStackTrace();
			return  null;
		}

	}


	/**
	 * 将list放入缓存
	 * @param key 键
	 * @param values 值   可以多个
	 * @return 成功个数
	 */
	public  Boolean lSet(String key,String values){
		try {
			redisTemplate.opsForList().rightPush(key,values);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}

	@Override
	public Boolean lSet(String key, Object values, long time) {
		return null;
	}

	@Override
	public Boolean lUpdateIndex(String key, long index, Object values) {
		return null;
	}

	/**
	 * 将list放入缓存
	 * @param key 键
	 * @param  time 时间（秒）
	 * @param values 值   可以多个
	 * @return 成功个数
	 */
	public  Boolean lSet(String key,String values,long time){
		try {
			redisTemplate.opsForList().rightPush(key,values);
			if (time>0)
				expire(key, time);
			return  true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}
	/**
	 * 根据索引修改list中的某条数据
	 * @param key 键
	 * @param  index 索引
	 * @param values 值
	 * @return 成功个数
	 */
	public  Boolean lUpdateIndex(String key,long index,String values){
		try {
			redisTemplate.opsForList().set(key,index,values);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return  false;
		}
	}
	/**
	 * 移除N个值位value
	 * @param key 键  不能为空
	 * @param value 键 可以多个 不能为空
	 * @param  count 移除多少个
	 * @return
	 */
	public long lRemove(String key,Object value,long count){
		try {
			Long remove=redisTemplate.opsForList().remove(key,count,value);
			return  remove;
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
		}
	}
	private void throwMethod(long delta) {
		if (delta <0){
			throw  new BusinessException(CommonErrorCode.E_500001);
		}
	}

}
