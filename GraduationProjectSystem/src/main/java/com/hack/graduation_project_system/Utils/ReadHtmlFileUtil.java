package com.hack.graduation_project_system.Utils;

import java.io.*;

public class ReadHtmlFileUtil {
    private static FileInputStream fip;
    public static String readFile(String fileName){
        String path = new String("src\\main\\resources\\static\\");
        String filePath = path + "\\" + fileName;
        File file = new File(filePath);
        String html = "";
        try{
            fip = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(fip);
            BufferedReader br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null){
                html = line + "\n" +html;
            }
            br.close();
            reader.close();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fip != null){
                try {
                    fip.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return html;
    }
}
