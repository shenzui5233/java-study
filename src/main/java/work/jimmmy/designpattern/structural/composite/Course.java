/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.composite;

import lombok.AllArgsConstructor;

/**
 * 课程
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
@AllArgsConstructor
public class Course extends CatalogComponent {
    private String name;

    private double price;

    @Override
    public String getName(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        return this.name;
    }

    @Override
    public double getPrice(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        return this.price;
    }

    @Override
    public void print() throws UnsupportedOperationException {
        System.out.println("Course name: " + name + " Price: " + price);
    }
}
