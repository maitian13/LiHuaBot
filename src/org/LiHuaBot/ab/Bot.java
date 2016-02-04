package org.LiHuaBot.ab;

import org.LiHuaBot.ab.utils.IOutil;

import java.io.File;
import java.util.HashMap;

/**
 * Created by maitian13 on 2016/1/31.
 * 聊天机器人主体函数，其brain是一个字典树（trie tree）
 */
public class Bot {
    String name="";
    String BotHome="";
    String propertyPath="";
    String AIMLPath="";
    String SetPath="";
    String MapPath="";
    String ConfigPath="";
    public HashMap<String,AIMLSet> sets=new HashMap<String,AIMLSet>();
    public HashMap<String,AIMLMap> maps=new HashMap<String,AIMLMap>();
    public GraphMaster brain=new GraphMaster();
    Properties properties=new Properties();

    /**
     * @param name 机器人的名字
     */
    Bot(String name)
    {
        this(name, MagicStrings.root_path);
    }

    /**
     * @param name 机器人的名字
     * @param path 机器人匹配文件放置的根目录
     *             初始化机器人，从文件中加载字典树，词汇列表等
     */
    Bot(String name,String path){
        this.name=name;
        setAllPathes(path);
        properties.getProperties(propertyPath);
        GetAIMLFile();
    }
    public String getName(){
        return this.name;
    }

    /**
     * 从aiml文件中加载字典树
     */
    private void GetAIMLFile(){
        File folder=new File(this.AIMLPath);
        if(!folder.exists()){
            System.out.println(this.AIMLPath+" not exist!");
            return;
        }
        File[] aimls= IOutil.getFiles(folder);
        for(File aiml : aimls){
            System.out.println("adding: "+aiml.getAbsolutePath());
            this.brain.addAIMLFile(aiml);
        }

    }

    /**
     * @param path 机器人根目录
     *             从机器人根目录中加载响应机器人的数据
     */
    private void setAllPathes(String path){
        this.BotHome=path+"/bots/"+this.name;
        this.ConfigPath=this.BotHome+"/config";
        this.AIMLPath=this.BotHome+"/aiml";
        this.MapPath=this.BotHome+"/maps";
        this.SetPath=this.BotHome+"/sets";
        this.propertyPath=this.ConfigPath+"/properties.txt";
    }
}
