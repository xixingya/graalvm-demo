package tech.xixing.demo.graalvm.targetclass;

import tech.xixing.demo.graalvm.feature.pojo.Student;

/**
 * @author liuzhifei
 * @date 2022/10/14 09:21 上午
 */

public class TargetClassTest {

    public static void main(String[] args) {
        var myTargetService = new MyTargetService(new Student("zhangsan","11"));
        myTargetService.executeService();
        myTargetService.executeService2("qaq");
    }
}
