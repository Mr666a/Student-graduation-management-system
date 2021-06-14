package com.hack.graduation_project_system.Utils;

import com.hack.graduation_project_system.pojo.ProgressInfo;

import java.io.*;

/**
 * txt 文件操作类
 * 包括读文件和写文件
 */
public class FileOperation {
    private static FileInputStream fis;
    private static FileOutputStream fos;
    public final static String UPLOAD_PATH_PREFIX = "progressFile\\";
    private final static String path = "src\\main\\resources\\" +UPLOAD_PATH_PREFIX;

    public static ProgressInfo readFile(String fileName){
        String filePath = path + "\\" + fileName + ".txt";
        File file = new File(filePath);
        ProgressInfo progressInfo = null;
        try{
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            progressInfo = (ProgressInfo) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return progressInfo;
    }
    public static void writeFile(String fileName, ProgressInfo progressInfo){
        String filePath = path + "\\" + fileName + ".txt";
        File file = new File(filePath);
        if (!file.exists()){
            try{
                file.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        try{
            fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(progressInfo);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
