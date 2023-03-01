/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.designpattern.structural.composite;

/**
 * 组合模式, 组件基类
 *
 * @author shenzui5233
 * @since 2023-03-01
 */
public abstract class CatalogComponent {
    public void add(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不支持添加操作");
    }

    public void remove(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不支持删除操作");
    }

    public String getName(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不支持获取名称操作");
    }

    public double getPrice(CatalogComponent catalogComponent) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不支持获取价格操作");
    }

    public void print() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("不支持打印操作");
    }
}
