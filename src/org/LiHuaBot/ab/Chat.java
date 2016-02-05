package org.LiHuaBot.ab;

import org.LiHuaBot.ab.utils.IKAnalyzer;

import java.util.Scanner;

/**
 * Created by maitian13 on 2016/2/4.
 */
public class Chat {
    Bot bot;
    int seesion_id=0;
    Person person;
    Chat(Bot bot,int id){
        this.bot=bot;
        this.seesion_id=id;
    }
    public void chat(){
        String input;
        Scanner scanner=new Scanner(System.in);
        while(!(input=scanner.nextLine()).equals("quit")){
            System.out.println(singleSentenceResponse(input));
        }
    }
    private String singleSentenceResponse(String input){
        return AIMLProcessor.response(IKAnalyzer.Segment(input),"*","*",this);
    }
}
