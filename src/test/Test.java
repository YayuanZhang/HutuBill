package test;

import java.io.IOException;
import java.net.URL;

public class Test
{
    public static void main( String[] args) throws IOException {
        URL u = ClassLoader.getSystemResource("img/restore.png");
       System.out.println(u.openStream().available());
    }
}
