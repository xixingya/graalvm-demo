package tech.xixing.demo.graalvm.targetclass;

import tech.xixing.demo.graalvm.feature.pojo.Student;

/**
 * @author liuzhifei
 * @date 2022/10/14 09:22 上午
 */

public class MyTargetService {

    private Student student;

    public MyTargetService(Student student) {
        this.student = student;
    }

    public MyTargetService(){

    }

    public void executeService(){
        System.out.println("MyTargetService executeService execute");
        System.out.println(student==null?"stu":student.name());
    }

    public void executeService2(String name){
        System.out.println("MyTargetService executeService2 execute");
        System.out.println(student==null?name:student.name());
    }
}
