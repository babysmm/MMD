package com.mmd.mmdshop.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 
 * @author QJH
 *
 */
@Service
public class ParamValidation{
	/**
	 * 判断参数列表是否null
	 * @param args
	 * @return
	 */
	public boolean isNotNull(Object obj,String ... args) {
		Map<String, Object> classMap = getKeyAndValue(obj);
		for(String name:args){
			if(classMap.get(name) == null) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * 对List参数进行判断
	 * @param <T>
	 * @param obj
	 * @param args
	 * @return
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public <T> boolean isnotNull(List<T> objList,String ... args) {
		for(int i=0;i<objList.size();i++) {
			Map<String, Object> classMap = getKeyAndValue(objList.get(i));
			for(String name:args){
				if(classMap.get(name) == null) {
					System.out.println(classMap.get(name));
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 使用反射实体类转Map
	 */
	public Map<String, Object> getKeyAndValue(Object  obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到类对象
        @SuppressWarnings("rawtypes")
		Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
                //System.out.println(f.getName()+"   "+val);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("单个对象的所有键值==反射==" + map.toString());
        return map;
    }
}
