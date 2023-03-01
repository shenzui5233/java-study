/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.creation.builder;

import lombok.Builder;
import lombok.ToString;

/**
 * 课程类
 *
 * @author shenzui5233
 * @since 2023-02-28
 */
@Builder
@ToString
public class Course {
    private String courseName;
    private String coursePpt;
    private String courseVideo;
    private String courseArticle;
    private String courseQa;
}
