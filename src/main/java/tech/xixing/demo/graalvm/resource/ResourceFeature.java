package tech.xixing.demo.graalvm.resource;

import com.oracle.svm.core.annotate.AutomaticFeature;
import com.oracle.svm.core.jdk.Resources;
import com.oracle.svm.util.ModuleSupport;
import org.graalvm.nativeimage.hosted.Feature;

import java.io.InputStream;
import java.security.Security;

/**
 *
 * 注册 resources
 * @author liuzhifei
 * @date 2022/10/18 5:28 下午
 */
@AutomaticFeature
public class ResourceFeature implements Feature {


    @Override
    public void afterRegistration(AfterRegistrationAccess access) {
        // ModuleSupport.accessModuleByClass(ModuleSupport.Access.OPEN, getClass(), Resources.class);
    }

    @Override
    public void beforeAnalysis(BeforeAnalysisAccess access) {
        var resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("myresource.txt");
        Resources.registerResource("myresource.txt",resourceAsStream);
    }
}
