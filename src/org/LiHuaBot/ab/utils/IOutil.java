package org.LiHuaBot.ab.utils;

import java.io.File;

/**
 * Created by maitian13 on 2016/2/3.
 */
public class IOutil {
    /**
     * @param folder 文件路径
     * @return 路劲下所有文件
     */
    public static File[] getFiles(File folder){
        return folder.listFiles();
    }
}
