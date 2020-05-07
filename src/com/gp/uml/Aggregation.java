package com.gp.uml;

/**
 * @author gp
 * @create 2020/2/20 13:21
 */

import java.util.List;
import java.util.Stack;

/**
 * 聚合:
 *      标志的是整体和部分的关系,整体和部分可以分开
 *      关联关系的一种特例
 */
public class Aggregation {
    private List<Object> list;//可以与整体分开
    private Stack<Integer> stack;

    public List<Object> getList() {
        return list;
    }

    public Stack<Integer> getStack() {
        return stack;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public void setStack(Stack<Integer> stack) {
        this.stack = stack;
    }
}
