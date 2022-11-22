package tech.xixing.demo.graalvm.targetclass;

import org.junit.jupiter.api.Test;
import tech.xixing.demo.graalvm.feature.pojo.Student;

/**
 * @author liuzhifei
 * @date 2022/10/26 7:13 下午
 */
public class TargetClassTest01 {

    @Test
    public void testTargetClass(){
        var myTargetService = new MyTargetService(new Student("zhangsan","11"));
        myTargetService.executeService();
        myTargetService.executeService2("qaq");
    }
}
