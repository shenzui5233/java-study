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
public abstract class AbstractCourse {
    protected final void makeCourse() {
        this.makePpt();
        this.makeVideo();
        if (needWriteArticle()) {
            this.writeArticle();
        }
        this.packageCourse();
    }

    final void makePpt() {
        System.out.println("制作ppt");
    }

    final void makeVideo() {
        System.out.println("制作视频");
    }

    final void writeArticle() {
        System.out.println("编写手记");
    }

    // 钩子方法
    protected boolean needWriteArticle() {
        return false;
    }

    abstract void packageCourse();
}
