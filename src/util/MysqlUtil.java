// 
// Decompiled by Procyon v0.5.30
// 

package util;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class MysqlUtil
{
    public static void backup(final String mysqlPath, final String backupfile) throws IOException {
        final String commandFormat = "\"%s/bin/mysqldump.exe\" -u%s -p%s   -hlocalhost   -P%d %s -r \"%s\"";
        final String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.port, DBUtil.database, backupfile);
        Runtime.getRuntime().exec(command);
    }
    
    public static void recover(final String mysqlPath, final String recoverfile) {
        try {
            final String commandFormat = "\"%s/bin/mysql.exe\" -u%s -p%s   %s ";
            final String command = String.format(commandFormat, mysqlPath, DBUtil.loginName, DBUtil.password, DBUtil.database);
            final Process p = Runtime.getRuntime().exec(command);
            final OutputStream out = p.getOutputStream();
            final StringBuffer sb = new StringBuffer("");
            final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(recoverfile), "utf8"));
            String inStr;
            while ((inStr = br.readLine()) != null) {
                sb.append(String.valueOf(inStr) + "\r\n");
            }
            final String outStr = sb.toString();
            final OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
            writer.write(outStr);
            writer.flush();
            out.close();
            br.close();
            writer.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(final String[] args) throws IOException {
        final String mysqlPath = "D:/tools/MYSQL/mysql-5.1.57-win32";
        final String file = "C:/Documents and Settings/Administrator/My Documents/hutubill.sql";
        recover(mysqlPath, file);
    }
}
