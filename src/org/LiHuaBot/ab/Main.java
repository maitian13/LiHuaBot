package org.LiHuaBot.ab;

/**
 * Created by maitian13 on 2016/1/31.
 */
public class Main {
    public static void main(String args[]){
        System.out.println("hello world!");
        MagicStrings.setRoot_path();
        Bot LiHua=new Bot("LiHua");
        System.out.println(LiHua.name);
    }
}
