package org.LiHuaBot.ab;

import java.io.*;
import java.util.HashMap;

/**
 * Created by maitian13 on 2016/2/1.
 *
 */
public class Properties extends HashMap {
    /**
     * @param path 机器人属性文件
     *             获取机器人的属性
     */
    public void getProperties(String path){
        try {
            //FileInputStream input=new FileInputStream(new File(path));
            BufferedReader bf=new BufferedReader(new FileReader(path));
            String line="";
            while((line=bf.readLine())!=null){
                String[] items=line.split(":");
                put(items[0],items[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
