/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.creation.factorymethod;

/**
 * 工厂方法
 *
 * @author shenzui5233
 * @since 2023-02-28
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        // VideoFactory factory = new JavaVideoFactory();
        VideoFactory factory = new PythonVideoFactory();
        Video video = factory.getVideo();
        video.produce();
    }
}

class JavaVideoFactory implements VideoFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }
}

class PythonVideoFactory implements VideoFactory {

    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}

interface VideoFactory {
    Video getVideo();
}

abstract class Video {
    abstract void produce();
}

class JavaVideo extends Video {

    @Override
    void produce() {
        System.out.println("录制java课程视频");
    }
}

class PythonVideo extends Video {

    @Override
    void produce() {
        System.out.println("录制python课程视频");
    }
}