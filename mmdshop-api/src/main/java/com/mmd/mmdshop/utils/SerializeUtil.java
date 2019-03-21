package com.mmd.mmdshop.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil{
	//序列化
    public static String serializeToString(Object obj) throws Exception{
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();  
        ObjectOutputStream objOut = new ObjectOutputStream(byteOut);  
        objOut.writeObject(obj);  
        String str = byteOut.toString("ISO-8859-1");//此处只能是ISO-8859-1,但是不会影响中文使用
        return str;
    }
    //反序列化
    public static Object deserializeToObject(String str) throws Exception{
         ByteArrayInputStream byteIn = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));  
         ObjectInputStream objIn = new ObjectInputStream(byteIn);  
         Object obj =objIn.readObject();  
         return obj;  
    }
    
    /*
     *
    public static void main(String[] args) throws Exception{
        Student student=new Student();
        student.setId("1");
        student.setName("王老三");
        String serialStr=serializeToString(student);
        System.out.println(serialStr);
        Student deserialStudent=(Student) deserializeToObject(serialStr);
        System.out.println(deserialStudent.getName());//输出王老三
    }
     */
}


 
 

