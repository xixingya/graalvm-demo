package tech.xixing.demo.graalvm.dynamic;

import java.lang.reflect.Proxy;

/**
 * @author liuzhifei
 * @date 2022/10/14 07:12 下午
 */


public class JdkProxyTest {


    public static void main(String[] args) throws ClassNotFoundException {


        String className = args[0];
        Class clazz = Thread.currentThread().getContextClassLoader().loadClass(className);

        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{clazz}, new CustomInvocationHandler());
        if (proxyInstance instanceof UserMapper userMapper1) {
            userMapper1.queryStudent("qaq");
        }


        //  可以运行，因为静态分析的时候
        //  会走com.oracle.svm.hosted.snippets.SubstrateGraphBuilderPlugins.registerProxyPlugins
        // 把对应的class注册进去。
//        UserMapperImpl userMapper = new UserMapperImpl();
//
//        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class}, new CustomInvocationHandler(userMapper));
//        if(proxyInstance instanceof UserMapper userMapper1){
//            userMapper1.queryStudent("qaq");
//        }
    }
}
