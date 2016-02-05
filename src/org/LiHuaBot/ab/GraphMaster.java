package org.LiHuaBot.ab;

import org.LiHuaBot.ab.utils.DOMutil;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by maitian13 on 2016/1/31.
 * 机器人的brain类，主要维护字典树
 */
public class GraphMaster {
    public NodeMapper root=new NodeMapper();

    /**
     * @param file aiml文件
     *             从aiml文件中向字典树添加策略
     */
    public void addAIMLFile(File file){
        ArrayList<Category> list=AIMLProcessor.addCategoriesFromAIML(file);
        for(Category c:list){
            String inputthattopic=inputThatTopic(c.pattern,c.that,c.topic);
            Path p=Path.ArrayToPath(inputthattopic.split(" "));
            addCategory(root,p,c);
        }
    }

    /**
     * @param node 字典树节点
     * @param path 匹配路径
     * @param category 策略
     *                 将匹配添加到字典树
     */
    private void addCategory(NodeMapper node,Path path,Category category){

        if(path!=null){
            if(path.word.startsWith("<SET>")){
                String set= DOMutil.trimTag(path.word,"SET");
                node.set.add(set);
            }
            NodeMapper next=NodeMapperOperater.get(node,path.word);
            if(path.next==null)
                node.category=category;
            if(next!=null){
                addCategory(next,path.next,category);
            }else{
                next=new NodeMapper();
                node.map.put(path.word,next);
                addCategory(next, path.next, category);
            }
        }

    }

    /**
     * @param input 也就是pattern
     * @param that 对话的上一句
     * @param topic 对话的话题
     * @return 将上诉输入的参数共同构成一个字典树匹配的路径字串
     */
    private String inputThatTopic(String input,String that,String topic){
        return input.trim()+" <THAT> "+that+" <TOPIC> "+topic;
    }
    public NodeMapper match(String input,String that,String topic){
        String inputthattopic=inputThatTopic(input,that,topic);
        Path path=Path.ArrayToPath(inputthattopic.split(" "));
        return find(path,root);
    }
    public NodeMapper find(Path path,NodeMapper node){
        if(path==null)return null;
        NodeMapper next=NodeMapperOperater.get(node, path.word);
        if(next==null)return null;
        if(path.next==null)return node;
        else return find(path.next,next);
    }
}
