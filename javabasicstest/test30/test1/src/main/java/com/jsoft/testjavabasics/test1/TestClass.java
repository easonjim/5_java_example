package com.jsoft.testjavabasics.test1;

/**
 * This is Description
 *
 * @author jim
 * @date 2017/11/25
 */
public class TestClass {

    private void add(int i, int j) {
        i += 1;
        j += 1;
    }

    private void add(Integer a, Integer b) {
        a += 1;
        b += 1;
    }

    private int add(int i) {
        return ++i;
    }

    private Integer add(Integer a) {
        return ++a;
    }

    private void add(Integer[] integers) {
        integers[0] = 2;
        integers[1] = 2;
    }

    public void run() {

        int i = 1;
        int j = 1;

        add(i, j);

        System.out.println("add method:i:" + i + " j:" + j);
        // out:add method:i:1 j:1

        Integer a = 1;
        Integer b = 1;

        add(a, b);

        System.out.println("add method:a:" + a + " b:" + b);
        // out:add method:a:1 b:1

        i = add(i);

        System.out.println("add method:i:" + i);
        // out:add method:i:2

        a = add(a);

        System.out.println("add method:a:" + a);
        // out:add method:a:2


        Integer[] integers = new Integer[2];
        integers[0] = 1;
        integers[1] = 1;
        add(integers);

        System.out.println("add method:integers[0]:" + integers[0] + " integers[1]:" + integers[1]);
        // out:add method:integers[0]:2 integers[1]:2


    }


}
