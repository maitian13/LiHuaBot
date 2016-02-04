package org.LiHuaBot.ab;

/**
 * Created by maitian13 on 2016/2/3.
 * 策略类，用于保存匹配的patern，template等数据
 */
public class Category {
    public String pattern;
    public String that;
    public String topic;
    public String template;

    /**
     * @param pattern 模板，用于匹配
     * @param that 对话上一句
     * @param topic 对话话题
     * @param template 匹配的结果
     */
    Category(String pattern,String that,String topic,String template){
        this.pattern=pattern;
        this.that=that;
        this.topic=topic;
        this.template=template;
    }
}
