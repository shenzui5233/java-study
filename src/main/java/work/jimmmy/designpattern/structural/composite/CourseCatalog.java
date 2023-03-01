/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程目录
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public class CourseCatalog extends CatalogComponent {
    private List<CatalogComponent> items = new ArrayList<>();

    private String name;

    public CourseCatalog(String name) {
        this.name = name;
    }

    @Override
    public void add(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        items.add(catalogComponent);
    }

    @Override
    public void remove(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        items.remove(catalogComponent);
    }

    @Override
    public String getName(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        return this.name;
    }

    @Override
    public void print() throws UnsupportedOperationException {
        System.out.println(name);
        for (CatalogComponent catalogComponent : items) {
            System.out.print("  ");
            catalogComponent.print();
        }
    }
}
