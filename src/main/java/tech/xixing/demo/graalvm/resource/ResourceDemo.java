package tech.xixing.demo.graalvm.resource;

import com.oracle.svm.core.jdk.Resources;

import java.io.IOException;

/**
 * @author liuzhifei
 * @date 2022/10/18 5:30 下午
 */
public class ResourceDemo {
    public static void main(String[] args) {
        try(var resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("myresource.txt")){

            var resoureByte = new byte[resourceAsStream.available()];
            resourceAsStream.read(resoureByte);
            System.out.println(new String(resoureByte));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
