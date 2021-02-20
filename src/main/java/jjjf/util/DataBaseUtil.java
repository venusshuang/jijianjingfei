package jjjf.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBaseUtil {
    /*
     * @功能说明：数据库一键备份
     *
     */
    public static void backup() {
        String hostIP = "127.0.0.1";
        String userName = "root";
        String password = "123123";
        String savePath = "D:/userfiles/";
        String fileName = "jijianjingfei"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".sql";
        String databaseName = "jijianjingfei";
        File saveFile = new File(savePath);
    // 如果目录不存在
        if (!saveFile.exists()) {
            // 创建文件夹
            saveFile.mkdirs();
        }
        if(!savePath.endsWith(File.separator)){
            savePath = savePath + File.separator;
        }

        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savePath + fileName), "utf8"));
            Process process = Runtime.getRuntime().exec("cmd /c c:\\mysqldump -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
            //Process process = Runtime.getRuntime().exec("cmd /c c:\\\\mysqldump -hlocalhost -u root -p123123 --opt jijianjingfei>"+savePath + fileName);
            InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while((line = bufferedReader.readLine())!= null){
                printWriter.println(line);
            }
            printWriter.flush();
            //0 表示线程正常终止。
            if(process.waitFor() == 0){
               System.out.println("111");
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
