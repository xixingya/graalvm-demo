package tech.xixing.demo.graalvm.dynamic;

import tech.xixing.demo.graalvm.feature.pojo.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author liuzhifei
 * @date 2022/10/14 4:42 下午
 */
public class CustomInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        boolean selectAnno = method.isAnnotationPresent(Select.class);
        if(selectAnno){
            Select select = method.getAnnotation(Select.class);
            String sql = select.value();
            sql = String.format(sql,args);
            System.out.println("sql ="+sql);
            return new Student("aa","bb");
        }
        return null;
    }
}
