package com.mmd.mmdshop.utils;

import java.io.File;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

/**
 * 七牛云工具类
 * 
 * @ClassName QiNiuYunUtils.java
 * @author MM
 * @version 2.0
 * @date 2019/3/18
 */
public class QiNiuYunUtils {
	
	private static final String NAME = "0imN7QOzB-0mbmr-ITtayh0OC7XGtExG8DI1LTmi";
	private static final String KEY = "52_salQ0QDLouWeu97QMrRDB9PKbYO6est67gNRv";
	
 
	private static final Auth auth = Auth.create(NAME, KEY);
	private static final Configuration cfg = new Configuration(Zone.zone2());
	private static final UploadManager uploadManager = new UploadManager(cfg);
	
	private static final String MAC_NAME = "HmacSHA1";
   	private static final String ENCODING = "UTF-8";
   	
   	private static final String URL = "http://mm.xknow.net/";
 
    /**
     * 获取凭证
     * @param bucketName 空间名称
     * @param key 如果需要覆盖上传则设置此参数
     * @return
     */
    public String getUpToken(String bucketName,String key) {
        return auth.uploadToken(bucketName);
    }
    
    /**
     * 上传方法1
     * @param filePath 文件路径  （也可以是字节数组、或者File对象）
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(String filePath, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filePath, key, getUpToken(bucketName,key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }
    
    /**
     * 上传方法2
     * @param file 文件
     * @param key 上传到七牛上的文件的名称  （同一个空间下，名称【key】是唯一的）
     * @param bucketName 空间名称  （这里是为了获取上传凭证）
     */
    public void upload(File file, String key, String bucketName) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(file, key, getUpToken(bucketName,key));
            // 打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                // 响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException qe) {
                // ignore
            }
        }
    }
    
    /**
     * 前端js获取上传文件凭证
     * @param space
     * @param key
     * @param time
     * 
     */
    public String jsUploadToken(String space,String key,Integer time) {
    	 StringMap stringMap = new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "");
         //System.out.println(auth.uploadToken(space, key, time, stringMap));
    	 return auth.uploadToken(space, key, time, stringMap);
    }
    
    /**
     * 前端js下载凭证
     * @param time
     * @return
     * @throws Exception
     */
    public String jsDownToken(String fileName,String time) throws Exception {
    	byte[] hmac = HmacSHA1Encrypt(URL+fileName+"?e="+time,KEY);
    	String tToken = NAME + ":" + UrlSafeBase64.encodeToString(hmac);
    	
    	return URL+"&token="+tToken;
    }

    
    /**
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名
     * 
     * @param encryptText
     * @param encryptKey
     * @return
     * @throws Exception
     */
    public static byte[] HmacSHA1Encrypt(String encryptText, String encryptKey)
			throws Exception {
		byte[] data = encryptKey.getBytes(ENCODING);
		SecretKey secretKey = new SecretKeySpec(data, MAC_NAME);
		Mac mac = Mac.getInstance(MAC_NAME);
		mac.init(secretKey);
		byte[] text = encryptText.getBytes(ENCODING);
		return mac.doFinal(text);
	}
    
}
