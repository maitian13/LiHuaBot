package org.LiHuaBot.ab;

import org.LiHuaBot.ab.utils.DOMutil;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by maitian13 on 2016/2/3.
 * 与AIML相关的工具函数，从AIML文件中抽出categoriy对象
 */
public class AIMLProcessor {
    public static ArrayList<Category> addCategoriesFromAIML(File file){
        try {
            ArrayList<Category> categories=new ArrayList<>();
            Node root= DOMutil.parseAIMLFile(file);
            if(root==null){
                System.out.println("aiml file is empty");
            }else{
                NodeList children=root.getChildNodes();
                for(int i=0;i<children.getLength();i++){
                    Node child=children.item(i);
                    if(child.getNodeName().equals("category")){
                        addCategory(categories,"*",child);
                    }else if(child.getNodeName().equals("topic")){

                    }
                }
            }
            return categories;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param list categories列表，用于存储aiml中的categories
     * @param t
     * @param node xml节点，从aiml文件解析出来的category节点
     */
    public static void addCategory(ArrayList<Category> list,String t,Node node){
        String pattern,topic,that,template;
        pattern="*";
        topic="*";
        that="*";
        template="";
        NodeList nodes=node.getChildNodes();
        for(int i=0;i<nodes.getLength();i++){
            Node node_t=nodes.item(i);
            String node_name=node_t.getNodeName();
            if(node_name.equals("pattern"))pattern=DOMutil.nodeToString(node_t);
            else if(node_name.equals("topic"))topic=DOMutil.nodeToString(node_t);
            else if(node_name.equals("that"))that=DOMutil.nodeToString(node_t);
            else if(node_name.equals("template"))template=DOMutil.nodeToString(node_t);
        }
        pattern=DOMutil.trimTag(pattern,"pattern");
        topic=DOMutil.trimTag(topic,"topic");
        that=DOMutil.trimTag(that, "that");
        pattern=DOMutil.patternClean(pattern);
        topic=DOMutil.patternClean(topic);
        that=DOMutil.patternClean(that);

        template=DOMutil.trimTag(template, "template");
        Category c=new Category(pattern,that,topic,template);
        list.add(c);
    }
}
