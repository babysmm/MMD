package com.mmd.mmdshop.controller;

import java.io.FileOutputStream;

import java.io.IOException;
import java.io.OutputStream;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
 
public class TestFastDfs {
    
	//fdfs_client 核心配置文件
    public String conf_filename = "src/main/resources/fdfs_client.conf"; 
 
    @Test
    public void testUpload() {	//上传文件
    	TrackerServer trackerServer =null;
    	StorageServer storageServer = null;
    	
        try { 
            ClientGlobal.init(conf_filename);
            TrackerClient tracker = new TrackerClient(); 
            trackerServer = tracker.getConnection(); 
            //StorageClient1 client = new StorageClient1(trackerServer, storageServer); 
            
            //要上传的文件路径
            String local_filename = "/Users/shenwei/Desktop/1.png";
//            这个参数可以指定，也可以不指定，如果指定了，可以根据 testGetFileMate()方法来获取到这里面的值
//            NameValuePair nvp [] = new NameValuePair[]{ 
//                    new NameValuePair("age", "18"), 
//                    new NameValuePair("sex", "male") 
//            }; 
            
            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
//          String fileIds[] = storageClient.upload_file(local_filename, "png", nvp);
            String fileIds[] = storageClient.upload_file(local_filename, "png", null);
            
            System.out.println(fileIds.length); 
            System.out.println("组名：" + fileIds[0]); 
            System.out.println("路径: " + fileIds[1]);
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally{
			try {
				if(null!=storageServer) storageServer.close();
				if(null!=trackerServer) trackerServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
 
    @Test 
    public void testDownload() {	//下载文件
    	TrackerServer trackerServer =null;
    	StorageServer storageServer = null;
    	
        try {
        	String groupName = "group1";
        	//String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
        	String filePath = "M00/00/00/wKgBdVx42LaAD3X3AAAAN64jzU494.java";
        	
        	
        	String data = "group1/M00/00/00/wKgBdVx42LaAD3X3AAAAN64jzU494.java";
        	
        	char [] stringArr = data.toCharArray(); 
        	
        	boolean findx = false;
        	
        	StringBuffer buffers = new StringBuffer();
        	StringBuffer buffer = new StringBuffer();
        	
        	for(int i=0;i<stringArr.length;i++) {
        		if(findx == true) {
        			buffer.append(stringArr[i]);
        		}else {
        			if(stringArr[i] == '/') {
            			findx = true;
            		}else {
            			buffers.append(stringArr[i]);
            		}
				}
        	}
        	
        	System.out.println(buffers);
        	
        	System.out.println(buffer);
        	
        	
            ClientGlobal.init(conf_filename);
 
            TrackerClient tracker = new TrackerClient(); 
            trackerServer = tracker.getConnection(); 
 
            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
            //byte[] bytes = storageClient.download_file(groupName, filePath); 
            
            String storePath = "G:\\素材库\\图片\\1.java";
            //OutputStream out = new FileOutputStream(storePath);
            //out.write(bytes);
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally{
			try {
				if(null!=storageServer) storageServer.close();
				if(null!=trackerServer) trackerServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
    
    @Test 
    public void testGetFileInfo(){ //获取文件信息
    	TrackerServer trackerServer =null;
    	StorageServer storageServer = null;
    
        try { 
        	
        	
        	
        	
        	
        	
        	String groupName = "group1";
        	String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
            ClientGlobal.init(conf_filename);
 
            TrackerClient tracker = new TrackerClient(); 
            trackerServer = tracker.getConnection(); 
 
            StorageClient storageClient = new StorageClient(trackerServer, storageServer); 
            FileInfo file = storageClient.get_file_info(groupName, filePath); 
            System.out.println("ip--->"+file.getSourceIpAddr()); 
            System.out.println("文件大小--->"+file.getFileSize()); 
            System.out.println("文件上传时间--->"+file.getCreateTimestamp()); 
            System.out.println(file.getCrc32()); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally{
			try {
				if(null!=storageServer) storageServer.close();
				if(null!=trackerServer) trackerServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
    } 
    
    @Test 
    public void testGetFileMate(){ //获取文件的原数据类型
    	TrackerServer trackerServer =null;
    	StorageServer storageServer = null;
    	
    	try { 
    		String groupName = "group1";
        	String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
    		ClientGlobal.init(conf_filename);
 
            TrackerClient tracker = new TrackerClient(); 
            trackerServer = tracker.getConnection(); 
 
            StorageClient storageClient = new StorageClient(trackerServer, 
                    storageServer); 
            
            //这个值是上传的时候指定的NameValuePair
            NameValuePair nvps [] = storageClient.get_metadata(groupName, filePath); 
            if(null!=nvps && nvps.length>0){
            	for(NameValuePair nvp : nvps){ 
            		System.out.println(nvp.getName() + ":" + nvp.getValue()); 
            	} 
            }
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally{
			try {
				if(null!=storageServer) storageServer.close();
				if(null!=trackerServer) trackerServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
    } 
    
    @Test 
    public void testDelete(){ //删除文件
    	TrackerServer trackerServer =null;
    	StorageServer storageServer = null;
    	
    	try { 
    		String groupName = "group1";
        	String filePath = "M00/00/00/ZGIW_lpujW-ADvpRAAblmT4ACuo125.png";
    		ClientGlobal.init(conf_filename);
 
            TrackerClient tracker = new TrackerClient(); 
            trackerServer = tracker.getConnection(); 
 
            StorageClient storageClient = new StorageClient(trackerServer, 
                    storageServer); 
            int i = storageClient.delete_file(groupName, filePath); 
            System.out.println( i==0 ? "删除成功" : "删除失败:"+i); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally{
			try {
				if(null!=storageServer) storageServer.close();
				if(null!=trackerServer) trackerServer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       }
    }
}
