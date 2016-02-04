package org.LiHuaBot.ab;

/**
 * Created by maitian13 on 2016/2/3.
 */
public class Path {
    public String word;
    public Path next;
    public int length=0;

    /**
     * @param strs
     * @return 将匹配字串转换成匹配列表，便于和字典树对应
     */
    public static Path ArrayToPath(String[] strs){
        Path head=null;
        Path tail=null;
        for(int i=strs.length-1;i>=0;i--){
            head=new Path();
            head.word=strs[i];
            head.next=tail;
            if(tail==null)head.length=1;
            else head.length=tail.length+1;
            tail=head;
        }
        return head;
    }
}
