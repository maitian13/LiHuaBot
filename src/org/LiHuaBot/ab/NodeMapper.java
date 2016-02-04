package org.LiHuaBot.ab;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by maitian13 on 2016/1/31.
 * 字典树的节点，为了减少内存开销，节点不带方法，其方法都在NodeMapperOperator里
 */
public class NodeMapper {
    public HashMap<String,NodeMapper> map=new HashMap<>();
    String key=null;
    NodeMapper value=null;
    Category category=null;
    ArrayList<String> set=new ArrayList<>();
}
