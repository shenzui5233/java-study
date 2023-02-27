/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.creation;

/**
 * 简单工厂模式
 * 需要扩展时，修改工厂代码进行扩展
 *
 * @author shenzui5233
 * @since 2023-02-27
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        Video javaVideo = new JavaVideo();
        javaVideo.produce();

        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        if (video != null) {
            video.produce();
        }
    }
}

class VideoFactory {
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        } else {
            return null;
        }
    }
}

abstract class Video {
    public abstract void produce();
}

class JavaVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制java课程视频");
    }
}

class PythonVideo extends Video {

    @Override
    public void produce() {
        System.out.println("录制python课程视频");
    }
}
