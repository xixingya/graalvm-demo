package tech.xixing.demo.graalvm.feature;


import tech.xixing.demo.graalvm.feature.pojo.Student;

/**
 * @author liuzhifei
 * @date 2022/10/13 7:11 下午
 */
public class FeatureDemo {

    public static void main(String[] args) {
        try{
            // load一个已经在feature中load的class，没问题,比如说Student
            var clazz = Class.forName(args[0]);
            System.out.println(clazz.getName());
            var constructor = clazz.getConstructor(String.class,String.class);
            var o = constructor.newInstance("aa","bb");
            if(o instanceof Student student){
                System.out.println(student.name());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
