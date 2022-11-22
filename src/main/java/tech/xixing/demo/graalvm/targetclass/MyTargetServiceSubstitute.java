package tech.xixing.demo.graalvm.targetclass;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import com.oracle.svm.core.annotate.TargetElement;
import com.oracle.svm.core.jdk.JDK11OrEarlier;
import com.oracle.svm.core.jdk.JDK11OrLater;
import com.oracle.svm.core.jdk.JDK17OrLater;
import com.oracle.svm.core.jdk.JDK8OrEarlier;
import tech.xixing.demo.graalvm.feature.pojo.Student;

/**
 * @author liuzhifei
 * @date 2022/10/14 09:27 上午
 */
@TargetClass(MyTargetService.class)
@SuppressWarnings("unused")
final class MyTargetServiceSubstitute {

    @Alias
    private Student student;

    /**
     * 只在jdk11或者之前才替换方法
     */
    @Substitute
    @TargetElement(onlyWith = JDK11OrEarlier.class)
    @SuppressWarnings("unused")
    public void executeService(){
        System.out.println("MyTargetServiceSubstitute executeService execute");
        System.out.println(student==null?"stu":student.name());
    }

    /**
     * 只在jdk17或者之后才替换方法
     * @param name
     */
    @Substitute
    @TargetElement(onlyWith = JDK17OrLater.class)
    @SuppressWarnings("unused")
    public void executeService2(String name){
        System.out.println("MyTargetServiceSubstitute executeService2 execute");
        System.out.println(student==null?name:student.name());
    }
}
