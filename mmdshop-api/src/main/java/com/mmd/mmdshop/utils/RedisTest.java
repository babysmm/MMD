package com.mmd.mmdshop.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.mmd.mmdshop.result.commodity.CommodityRough;

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
    	
    	String [] topImgUrls = new String[3];
    	topImgUrls[0] = "http://mm.xknow.net/20181224104849409.jpg";
    	topImgUrls[1] = "http://mm.xknow.net/20181224133800485.jpg";
    	topImgUrls[2] = "http://mm.xknow.net/20181225110153158.jpg";
    	jedis.set("topImgUrls", SerializeUtil.serializeToString(topImgUrls));
    	
    	String [] topHostMessage = new String[3];
    	topHostMessage[0] = "冰淇淋今日开张";
    	topHostMessage[1] = "冰淇淋免费试吃";
    	jedis.set("topHostMessage", SerializeUtil.serializeToString(topHostMessage));
    	
    	String [] hostSearch = new String[3];
    	hostSearch[0] = "热搜1";
    	hostSearch[1] = "热搜2";
    	hostSearch[2] = "热搜3";
    	jedis.set("hostSearch", SerializeUtil.serializeToString(hostSearch));
    	
    	String [] discounts = new String[8];
    	discounts[0] = "https://mm.xknow.net/001.jpg";
    	discounts[1] = "https://mm.xknow.net/002.jpg";
    	discounts[2] = "https://mm.xknow.net/003.jpg";
    	discounts[3] = "https://mm.xknow.net/004.jpg";
    	discounts[4] = "https://mm.xknow.net/005.jpg";
    	discounts[5] = "https://mm.xknow.net/006.jpg";
    	discounts[6] = "https://mm.xknow.net/007.jpg";
    	discounts[7] = "https://mm.xknow.net/008.jpg";
    	jedis.set("discounts", SerializeUtil.serializeToString(discounts));
    	
    	//设置商品
    	//Commodity
    	CommodityRough[] commodityLeft = new CommodityRough[2];
    	CommodityRough[] commodityright = new CommodityRough[2];
    	
    	
    	commodityLeft[0] = new CommodityRough(1L, "http://mm.xknow.net/269450775921561600.png", "喵喵奶茶1", new BigDecimal(10), new BigDecimal(20));
    	commodityLeft[1] = new CommodityRough(1L, "http://mm.xknow.net/269450775921561601.png", "喵喵奶茶1", new BigDecimal(10), new BigDecimal(20));
    	
    	commodityright[1] = new CommodityRough(1L, "http://mm.xknow.net/269450775921561600.png", "喵喵奶茶1", new BigDecimal(10), new BigDecimal(20));
    	commodityright[0] = new CommodityRough(2L, "http://mm.xknow.net/269450775921561601.png", "喵喵奶茶1", new BigDecimal(20), new BigDecimal(30));
    	
    	
    	jedis.set("commodityLeft", SerializeUtil.serializeToString(commodityLeft));
    	jedis.set("commodityright", SerializeUtil.serializeToString(commodityright));
    	
    	jedis.close();
    }
}