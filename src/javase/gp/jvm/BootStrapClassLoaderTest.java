package javase.gp.jvm;

import com.sun.net.ssl.internal.ssl.Provider;
import sun.misc.Launcher;
import sun.security.provider.Sun;

import javax.servlet.http.HttpSession;
import java.net.URL;

/**
 * @author gp
 * @create 2020/2/26 11:55
 */
public class BootStrapClassLoaderTest {
    public static void main(String[] args) {
        //获取启动类加载器主要加载哪些内容
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/resources.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/rt.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/sunrsasign.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/jsse.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/jce.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/charsets.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/lib/jfr.jar
//        file:/C:/Program%20Files/Java/jdk1.8.0_211/jre/classes
//        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
//        for (URL urL : urLs) {
//            System.out.println(urL.toExternalForm());
//        }
        //获取当前类的类加载器,只要为null,则为引导类加载器
//        ClassLoader classLoader = Provider.class.getClassLoader();
//        System.out.println(classLoader);

        //获取扩展类加载记载的内容
//        C:\Program Files\Java\jdk1.8.0_211\jre\lib\ext
//        C:\WINDOWS\Sun\Java\lib\ext
//        String property = System.getProperty("java.ext.dirs");
//        for (String s : property.split(";")) {
//            System.out.println(s);
//        }
//        System.out.println(HttpSession.class.getClassLoader());

        //获取系统类加载器

    }
}
