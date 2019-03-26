package com.mmd.mmdshop.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {

    private RedisUtil redisUtil = new RedisUtil();

    // 字符串操作
    @Test
    public void testStr() {
        Jedis jedis = redisUtil.getJedis();
        jedis.set("id", "15"); // 只能是字符串
        String id = jedis.get("id");
        System.out.println(id);
        jedis.close();
    }

    // 操作 map
    @Test
    public void testMap() {
        Jedis jedis = redisUtil.getJedis();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        jedis.hmset("user", map);
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);
        jedis.hdel("user", "age");
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + jedis.hmget("user", key));
        }
        jedis.close();
    }
    // 操作 list
    @Test
    public void testList() {
        Jedis jedis = redisUtil.getJedis();
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
        jedis.close();
    }

    // 操作 set
    @Test
    public void testSet() {
        Jedis jedis = redisUtil.getJedis();
        jedis.sadd("user1", "liuling");
        jedis.sadd("user1", "xinxin");
        jedis.sadd("user1", "ling");
        jedis.sadd("user1", "zhangxinxin");
        jedis.sadd("user1", "who");
        jedis.srem("user1", "who"); // 移除noname
        System.out.println(jedis.smembers("user1"));// 获取所有加入的value
        System.out.println(jedis.sismember("user1", "who"));// 判断 who
        System.out.println(jedis.srandmember("user1")); // 是否是user集合的元素
        System.out.println(jedis.scard("user1"));// 返回集合的元素个数
        jedis.close();
    }

    // jedis 排序
    @Test
    public void testOrder() {
        Jedis jedis = redisUtil.getJedis();
        jedis.del("a");
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));  
        System.out.println(jedis.sort("a"));          
        System.out.println(jedis.lrange("a", 0, -1));
        jedis.close();
    }
    
    @Test
    public void test1() {
    	Jedis jedis = redisUtil.getJedis();
        String name = "name";
        String value = "qq";
        jedis.set(name, value);
        System.out.println("追加前：" + jedis.get(name)); // 追加前：qq

        // 在原有值得基础上添加,如若之前没有该key，则导入该key
        jedis.append(name, "ww");
        System.out.println("追加后：" + jedis.get(name)); // 追加后：qqww

        jedis.append("id", "ee");
        System.out.println("没此key：" + jedis.get(name));
        System.out.println("get此key：" + jedis.get("id"));

    }
    
    @Test
    public void init() throws Exception {
    	Jedis jedis = redisUtil.getJedis();
    	//加入上部滑动图片
    	
    	String [] data = new String[3];
    	
    	data[0] = "http://mm.xknow.net/1.jpg";
    	data[0] = "http://mm.xknow.net/2.jpg";
    	data[0] = "http://mm.xknow.net/3.jpg";
    	
    	
    	jedis.set("topImgUrl", SerializeUtil.serializeToString(data));
    	
    	String topImgUrl = jedis.get("topImgUrl");
    	 
        System.out.println(SerializeUtil.deserializeToObject(topImgUrl));
    	
    	
    	jedis.close();
    }
}