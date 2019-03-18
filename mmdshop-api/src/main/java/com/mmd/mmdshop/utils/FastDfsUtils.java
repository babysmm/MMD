package com.mmd.mmdshop.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * @author MM
 *
 */
public class FastDfsUtils {

	private static final String CONFFILE = "src/main/resources/fdfs_client.conf";

	StorageServer storageServer = null;
	TrackerServer trackerServer = null;

	StorageClient storage = null;
	TrackerClient tracker = null;

	public FastDfsUtils() throws IOException, MyException {
		this.init();
	}
	
	public static FastDfsUtils initFastDfs() throws IOException, MyException {
		return new FastDfsUtils();
	}

	/**
	 * 初始化操作
	 * 
	 * @throws IOException
	 * @throws MyException
	 */
	public FastDfsUtils init() throws IOException, MyException {
		ClientGlobal.init(CONFFILE);
		tracker = new TrackerClient();
		try {
			tracker = new TrackerClient();
			trackerServer = tracker.getConnection();
			storage = new StorageClient(trackerServer, storageServer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != storageServer)
					storageServer.close();
				if (null != trackerServer)
					trackerServer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return this;
	}

	/**
	 * 上传文件
	 * 
	 * @param fileName
	 *            文件路径
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public String[] updata(String fileName) throws IOException, MyException {
		return storage.upload_file(fileName, "png", null);
	}

	/**
	 * 下载文件输出到对应目录文件
	 * 
	 * @param filePath
	 *            文件在fastDfs的地址
	 * @param groupName
	 *            组名字
	 * @param storePath
	 *            文件索要存的地址
	 * @throws IOException
	 * @throws MyException
	 */
	public FastDfsUtils downloadForPath(String filePath,String storePath) throws IOException, MyException {
		StringBuffer [] filePaths = this.pathSplit(filePath);
		
		
		byte[] bytes = storage.download_file(filePaths[0].toString(), filePaths[1].toString());
		@SuppressWarnings("resource")
		OutputStream out = new FileOutputStream(storePath);
		out.write(bytes);
		
		return this;
	}

	/**
	 * 下载文件输出到字节数组
	 * 
	 * @param filePath
	 *            文件在fastDfs的地址
	 * @param groupName
	 *            组名字
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public byte[] dowmloadForByte(String filePath, String groupName) throws IOException, MyException {
		StringBuffer [] filePaths = this.pathSplit(filePath);
		
		return storage.download_file(filePaths[0].toString(), filePaths[1].toString());
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件在fastDfs的地址
	 * @param groupName
	 *            组名字
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public boolean delete(String filePath) throws IOException, MyException {
		StringBuffer [] filePaths = this.pathSplit(filePath);
		
		int result = storage.delete_file(filePaths[0].toString(), filePaths[1].toString());
		return result == 0 ? true : false;
	}

	/**
	 * 获取文件信息
	 * 
	 * @param filePath
	 *            文件在fastDfs的地址
	 * @param groupName
	 *            组名字
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public FileInfo getFileInfo(String filePath, String groupName) throws IOException, MyException {
		return storage.get_file_info(groupName, filePath);
	}
	
	private StringBuffer[] pathSplit(String path) {
		StringBuffer [] result = new StringBuffer[2];
		
		char [] stringArr = path.toCharArray(); 
    	
    	boolean findx = false;
    	
    	StringBuffer buffers = result[0];
    	StringBuffer buffer = result[1];
    	
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
    	
    	
		return result;
	}
}
