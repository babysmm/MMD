package com.mmd.mmdshop.utils;

import java.io.IOException;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;

/**
 * @author MM
 *
 */
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "15633631";
    public static final String API_KEY = "tBlGGsb2vCEpp9yxEexUN8P9";
    public static final String SECRET_KEY = "NDxrWzofrAIRWlMfkngcmezMVYvfedil";
    
    public void a() throws JSONException {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 调用接口
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("per", "4");
        TtsResponse res = client.synthesis("打造最高家居品牌风格,家居改变品质生活我们的产品是公司是成长为使命,致力于成为最具幸福感的企业", "zh", 1, options);
        
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "output.mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }

    }
}

