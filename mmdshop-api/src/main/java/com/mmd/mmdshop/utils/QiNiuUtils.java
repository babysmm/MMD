package com.mmd.mmdshop.utils;

import java.io.File;

import org.junit.Test;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
 
/**
 * 七牛 java sdk 简单上传，覆盖上传，文件上传
 * @author yunlingfly 
 */
public class QiNiuUtils {
 
    Auth auth = Auth.create("UTGwEARIYS8loLRm63rrKdt9-ifdaNLJ2vEGdOHH", "Vm7EcRiyhH5ka5lCrKTf6MRY8P3IA3dm4tSH0QM0");
    Configuration cfg = new Configuration(Zone.zone2());
    UploadManager uploadManager = new UploadManager(cfg);
 
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
     * 上传方法3 覆盖上传
     * @param path
     *            上传文件路径
     * @param bucketName
     *            空间名
     * @param key
     *            文件名
     */
    public void overrideUpload(String path, String key, String bucketName) {
        try {
            String token = getUpToken(bucketName, key);//获取 token
            Response response = uploadManager.put(path, key, token);//执行上传，通过token来识别 该上传是“覆盖上传”
            System.out.println(response.toString());
        } catch (QiniuException e) {
            System.out.println(e.response.statusCode);
            e.printStackTrace();
        }
    }
    
    
    public void getToken() {
    	
    }
    
    
    
    /**
     * 主函数：程序入口，测试功能
     * @param args
     */
    @Test 
    public void test() {
    	/*
        // 上传文件的路径，因为在Mac下，所以路径和windows下不同
        String filePath = "G:\\安装包\\wKgBdVx42LaAD3X3AAAAN64jzU494.java";
        // 要上传的空间
        String bucketName = "mmd_shop";
        // 上传到七牛后保存的文件名
        String key = "wKgBdVx42LaAD3X3AAAAN64jzU494.txt";
        // 这里的filepath可以直接替换成File如下注释所示
        // File file=new File(filePath);
        // new SimpleUpload().upload(file, key, bucketName);
        new QiNiuUtils().upload(filePath, key, bucketName);
        */
    	
    	//生成token
        //System.out.println(auth.uploadToken("mmd_shop"));
        
        //System.out.println(auth.uploadToken("mmd_shop"));
        
        //System.out.println(auth.uploadToken("mmd_shop"));
        
        StringMap stringMap = new StringMap().put("endUser", "uid").putNotEmpty("returnBody", "");
        
        System.out.println(auth.uploadToken("mmd_shop", "111", 3600, stringMap));
        
        //System.out.println(auth.uploadToken("mmd_shop", "123455", 3600, stringMap));
        
        
        //String a = auth.uploadToken("mmd_shop", "abcd", 3600, stringMap);
        
        //String b = auth.uploadToken("mmd_shop", "dcba", 3600, stringMap);
        
        //System.out.println(a.equals(b));
        
        //System.out.println(auth.uploadToken("mmd_shop", "1234567", 3600, stringMap));
        
        //System.out.println(auth.uploadToken("mmd_shop", "12345678", 3600, stringMap));
        
    }
}
