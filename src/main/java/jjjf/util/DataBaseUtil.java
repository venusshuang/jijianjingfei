package jjjf.util;

import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataBaseUtil {

    @Value("${command}")
    private String command;

    /*
     * @功能说明：数据库一键备份
     *
     */
    public static void backup(HttpServletResponse response) {
        String hostIP = "127.0.0.1";
        String userName = "root";
        String password = "123456";
        String hostPort = "3306";
        String savePath = "D:/userfiles/jjjf/";
        //String savePath="src/main/resources/static/backup/";
        String fileName = "jjjf"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".sql";
        String databaseName = "jjjf";
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

            //String cmd ="cmd /c c:\\mysqldump -h" + hostIP +" -u" + userName +" -P" + hostPort +" -p" + password +" " + databaseName;

           // Process process = Runtime.getRuntime().exec(cmd);
            Process process = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin\\mysqldump --opt -h" + hostIP + " -u" + userName + " -p" + password + " --set-charset=UTF8 " + databaseName);
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

            /** 将文件名称进行编码 */
             response.setHeader("content-disposition","attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
             response.setContentType("content-type:octet-stream");
             File file = new File(savePath + fileName);
             BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));
             OutputStream outputStream = response.getOutputStream();
             byte[] buffer = new byte[1024];
             int len;
             while ((len = inputStream.read(buffer)) != -1){ /** 将流中内容写出去 .*/
                     outputStream.write(buffer ,0 , len);
                 }
             inputStream.close();
             outputStream.close();



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
