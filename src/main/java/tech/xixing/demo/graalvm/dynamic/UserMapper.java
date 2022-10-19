package tech.xixing.demo.graalvm.dynamic;

import tech.xixing.demo.graalvm.feature.pojo.Student;

/**
 * @author liuzhifei
 * @date 2022/10/14 07:41 下午
 */
public interface UserMapper {

    @Select("select * from student where name =%s")
    Student queryStudent(String name);
}
