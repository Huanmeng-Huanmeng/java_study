package com.interview;
public class FinalDemo {
    public static void main(String[] args) {
        // final
        FinalDemo finalDemo = new FinalDemo();
        Integer ss = 123;
        finalDemo.firstFinal(ss);
        finalDemo.example();


        // Error:(7, 9) java: 非法的表达式开始
/*        static int size = 0;
        System.out.println(size);*/
        // Error:(11, 9) java: 非法的表达式开始
/*        private String size = "";*/
    }
    public void example() {
        People people = new People(5, 5) {
        };
        System.out.println("第一个引用指向对象的属性age：" + people.getAge());

        People student = people;
        System.out.println("第二个引用指向对象的属性age：" + student.getAge());

        student.setAge(3);
        System.out.println("通过第二个引用，修改实例对象的属性age后：第一个引用指向对象的属性age：" + people.getAge());
        System.out.println("通过第二个引用，修改实例对象的属性age后：第二个引用指向对象的属性age：" + student.getAge());
    }

    public void firstFinal(final int ss) {
        System.out.println(ss);
        // 1.1 基本类型变量
        // 则其数值一旦在初始化之后便不能更改
        // 报错： Error:(6, 9) java: 无法为最终变量unChangedInt分配值
/*        final int unChangedInt = 3;
        unChangedInt = 5;
        System.out.println(unChangedInt);*/

        // 1.2 引用类型的变量
        // 则在对其初始化之后便不能再让其指向另一个对象。
        // 报错： Error:(25, 9) java: 无法为最终变量student分配值
/*        final People people = new People(5, 5);
        System.out.println("初始值：" + people.toString());
        people.setAge(3);
        System.out.println("只修改属性后的值" + people.toString());
        people = new People(6, 6);
        System.out.println("更改指向对象后的值" + people.toString());*/
    }

    public void secondFinal() {

    }

    abstract class People {
        private int age;
        private int code;

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", code=" + code +
                    '}';
        }

        public People() {
        }

        public People(int age, int code) {
            this.age = age;
            this.code = code;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }

    // 2.final 修饰一个类时，表明这个类不能被继承，final 类中的所有成员方法都会被隐式地指定为 final 方法。
    // 报错：Error:(71, 27) java: 无法从最终com.interview.FinalDemo.People进行继承
/*    class Student extends People {
    }*/


    interface JieKou {
/*        int size = 0;
        int getSize();
        default void setSize(int size) {
            this.size = size;
        }*/
    }
}
