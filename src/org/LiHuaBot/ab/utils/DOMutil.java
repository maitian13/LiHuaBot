package org.LiHuaBot.ab.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by maitian13 on 2016/2/3.
 * 用于处理xml文档的工具类
 */
public class DOMutil {

    /**
     * @param file 需要转换的aiml文件
     * @return 返回xml文档的根节点，由于SAX是逐行方式解析，不用返回整个document
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static Node parseAIMLFile(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory= DocumentBuilderFactory.newInstance();
        DocumentBuilder dbBuilder=dbFactory.newDocumentBuilder();
        Document document=dbBuilder.parse(file);
        document.getDocumentElement().normalize();
        return document.getDocumentElement();
    }

    /**
     * @param node 待转换节点
     * @return 将节点转换成string
     */
    public static String nodeToString(Node node) {
        //MagicBooleans.trace("nodeToString(node: " + node + ")");
        StringWriter sw = new StringWriter();
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            t.setOutputProperty(OutputKeys.INDENT, "no");
            t.transform(new DOMSource(node), new StreamResult(sw));
        } catch (TransformerException te) {
            System.out.println("nodeToString Transformer Exception");
        }
        String result = sw.toString();
        //MagicBooleans.trace("nodeToString() returning: " + result);
        return result;
    }

    /**
     * @param s 待转换字符串
     * @param tag 需要去掉的标签
     * @return 返回去掉标签之后的字符串
     */
    public static String trimTag(String s,String tag){
        String stag="<"+tag+">";
        String etag="</"+tag+">";
        if(s.startsWith(stag)&&s.endsWith(etag)){
            s=s.substring(stag.length());
            s=s.substring(0,s.length()-etag.length());
        }
        return s.trim();
    }

    /**
     * @param s 需要清除格式的字符串
     * @return
     */
    public static String patternClean(String s){
        s=s.replace("(\n\r|\r\n|\n|\r)"," ");
        s=s.replace("  "," ");
        return s;
    }
}
