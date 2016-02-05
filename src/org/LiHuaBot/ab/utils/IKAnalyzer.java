package org.LiHuaBot.ab.utils;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by maitian13 on 2016/2/4.
 */
public class IKAnalyzer {
    public static String Segment(String s){
        try {
        StringReader input=new StringReader(s);
        IKSegmenter segmenter=new IKSegmenter(input,true);
        ArrayList<String> words=new ArrayList<>();
        Lexeme word;
        while((word=segmenter.next())!=null){
            words.add(word.getLexemeText());
        }
            String ans="";
        for(String str:words){
            ans+=str+" ";
        }
            return ans;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
