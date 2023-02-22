/*
 * Copyright (c) shenzui5233 2023-2023. All right reserved.
 */

package work.jimmmy.algs.sort;

import java.util.List;

/**
 * 将形参排序后使用新对象返回(不在原来的数据结构修改，生成新的对象保存新结果)
 *
 * @author shenzui5233
 * @since 2023-02-21
 */
public interface ImmutableSorter extends Sorter {
    List<Integer> sort(List<Integer> nums);
}
