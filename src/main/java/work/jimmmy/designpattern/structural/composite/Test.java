/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.composite;

/**
 * 应用层
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("linux course", 11);
        CatalogComponent windowsCourse = new Course("windows course", 12);

        CatalogComponent javaCourseCatalog = new CourseCatalog("java course catalog");
        CatalogComponent mmallCourse1 = new Course("java mall 1", 20);
        CatalogComponent mmallCourse2 = new Course("java mall 2", 25);
        CatalogComponent designPattern = new Course("design patten", 30);
        javaCourseCatalog.add(mmallCourse1);
        javaCourseCatalog.add(mmallCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("immoc main catalog");
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);

        imoocMainCourseCatalog.print();
    }
}
