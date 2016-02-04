package org.LiHuaBot.ab;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by maitian13 on 2016/1/31.
 * 对NodeMapper的操作函数集合
 */
public class NodeMapperOperater {
    /**
     * @param node 字典树节点
     * @param key
     * @param value
     * 向字典树的某个节点插入新节点
     */
    public static void put(NodeMapper node,String key,NodeMapper value){
        if(node!=null){
            if(node.map!=null)
                node.map.put(key,value);
            else{
                node.key=key;
                node.value=value;
            }
        }else{
            System.out.println("节点不能为空");
        }
    }

    /**
     * @param node 字典树节点
     * @param key
     * @return 在该节点搜索特定关键字的子节点
     */
    public static NodeMapper get(NodeMapper node,String key){
        Set entry=node.map.entrySet();
        Iterator it=entry.iterator();
        while(it.hasNext()){
            Map.Entry word=(Map.Entry)it.next();
            if(key.equals(word.getKey().toString())){
                return (NodeMapper)word.getValue();
            }
        }
        return null;
    }
}
