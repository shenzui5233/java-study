/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.linkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * list测试用例
 *
 * @author shenzui5233
 * @since 2023-02-24
 */
public class ListTest {
    @Test
    public void test_insert() {
        List<Integer> list = new List<>();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        List.Node<Integer> p = list.head;
        for (Integer i = 3; p != null ; i--) {
            Assert.assertEquals(i, p.data);
            p = p.next;
        }
    }

    @Test
    public void test_find() {
        List<String> list = new List<>();
        list.insert("C++");
        list.insert("Java");
        list.insert("C");
        list.insert("C#");
        list.insert("Python");

        List.Node<String> node1 = list.find(x -> Objects.equals(x, "Java"));
        Assert.assertEquals("Java", node1.data);

        List.Node<String> node2 = list.find(x -> Objects.equals(x, "Ruby"));
        Assert.assertNull(node2);
    }

    @Test
    public void test_remove() {
        List<String> list = new List<>();
        list.insert("C++");
        list.insert("Java");
        list.insert("C");
        list.insert("C#");
        list.insert("Python");

        List.Node<String> node1 = list.find(x -> Objects.equals(x, "Java"));
        Assert.assertEquals("Java", node1.data);

        list.remove(node1);
        List.Node<String> node2 = list.find(x -> Objects.equals(x, "Java"));
        Assert.assertNull(node2);

        list.remove(node1);
    }
}
