package com.mmd.mmdshop.utils;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author QJH
 *
 */
public class BaiduSpeechSynthesis {
    
    @Autowired
    private AipSpeech client;
    
    public void synthesisToMp3(String context,String path) throws JSONException {
    	HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        
        TtsResponse res = client.synthesis(context, "zh", 1, options);
        
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }
    }
    
    public byte[] synthesisToByteArray(String context) throws JSONException {
    	
    	HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        
        TtsResponse res = client.synthesis(context, "zh", 1, options);
		return res.getData();
    }
    
    public static byte[] byteMerger(byte[] byte_1, byte[] byte_2,int byteread){
		byte[] byte_3 = new byte[byte_1.length+byteread];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byteread);
		return byte_3;
	}

    
    
    @SuppressWarnings("restriction")
	public String synthesisToBase64(String context) throws JSONException{	
		return new BASE64Encoder().encode(this.synthesisToByteArray(context));
    }	
}
