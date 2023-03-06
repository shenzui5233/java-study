/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.behavioral.templatemethod;

/**
 * 功能描述
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("后端设计模式课程start");
        AbstractCourse designPatternCourse = new DesignPatternCourse();
        designPatternCourse.makeCourse();
        System.out.println("后端设计模式课程end");

        System.out.println("前端设计模式课程start");
        AbstractCourse feCourse = new FeCourse();
        feCourse.makeCourse();
        System.out.println("前端设计模式课程end");
    }
}
