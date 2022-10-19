package tech.xixing.demo.graalvm.dynamic;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.jdk.proxy.DynamicProxyRegistry;
import com.oracle.svm.reflect.proxy.hosted.DynamicProxyFeature;
import org.graalvm.nativeimage.ImageSingletons;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/**
 * @author liuzhifei
 * @date 2022/10/14 5:42 下午
 */
@AutomaticFeature
@SuppressWarnings("unused")
public class ProxyFeature implements Feature {

    /**
     * 这样子把动态的代理注入进去才能使用。目前该方式已经不能使用！！！！
     * 因为java 模块化，我们对下面的dynamicProxyRegistry不可见，所以需要在启动参数上加上
     * --add-exports=org.graalvm.nativeimage.builder/com.oracle.svm.core.jdk.proxy=ALL-UNNAMED
     */
    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {

        var dynamicProxyRegistry = ImageSingletons.lookup(DynamicProxyRegistry.class);
        dynamicProxyRegistry.addProxyClass(UserMapper.class);
        RuntimeReflection.register(UserMapper.class);
    }
}
