/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.behavioral.templatemethod;

/**
 * 前端课程
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class FeCourse extends AbstractCourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程的前端代码");
        System.out.println("提供课程的图片等多媒体素材");
    }
}
