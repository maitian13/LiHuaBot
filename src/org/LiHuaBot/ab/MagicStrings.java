package org.LiHuaBot.ab;

/**
 * Created by maitian13 on 2016/1/31.
 * 用于保存一些全局字符串
 */
public class MagicStrings {
    public static String root_path="c:/ab";
    public static void setRoot_path(String path){
        root_path=path;
    }
    public static void setRoot_path(){
        root_path=System.getProperty("user.dir");
    }
}
