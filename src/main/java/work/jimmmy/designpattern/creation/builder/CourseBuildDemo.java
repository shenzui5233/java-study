/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.creation.builder;

/**
 * 建造者模式示例代码
 *
 * @author shenzui5233
 * @since 2023-02-28
 */
public class CourseBuildDemo {
    public static void main(String[] args) {
        Course course = Course.builder()
            .courseQa("QA")
            .coursePpt("ppt")
            .courseName("courseName")
            .courseVideo("video")
            .courseArticle("article")
            .build();
        System.out.println(course);
    }
}
