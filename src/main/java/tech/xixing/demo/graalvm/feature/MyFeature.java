package tech.xixing.demo.graalvm.feature;

import com.oracle.svm.core.annotate.AutomaticFeature;
import org.graalvm.nativeimage.hosted.Feature;
import org.graalvm.nativeimage.hosted.RuntimeReflection;

/**
 * 会在编译的时候运行
 * @author liuzhifei
 * @date 2022/10/13 7:12 下午
 */
@AutomaticFeature
public class MyFeature implements Feature {

    /**
     *
     * 在分析之前会执行下列代码
     * @param access access
     */
    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        var classLoader = getClass().getClassLoader();
        try {
            var aClass = classLoader.loadClass("tech.xixing.demo.graalvm.feature.pojo.Student");
            RuntimeReflection.register(aClass);
            RuntimeReflection.register(aClass.getConstructor(String.class,String.class));
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
