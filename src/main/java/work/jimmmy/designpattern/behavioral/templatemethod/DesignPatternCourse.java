/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.behavioral.templatemethod;

/**
 * 设计模式课程
 *
 * @author shenzui5233
 * @since 2023-03-02
 */
public class DesignPatternCourse extends AbstractCourse {
    @Override
    void packageCourse() {
        System.out.println("提供课程java源代码");
    }

    @Override
    protected boolean needWriteArticle() {
        return true;
    }
}
