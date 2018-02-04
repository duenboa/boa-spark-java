package com.boa.java8;

import java.util.ArrayList;

/**
 * @author DuenBoa
 * @date 2018/2/4
 */
public class MapReductTest {

    public static void main(String[] args) {
        ArrayList<Dash> dashs = new ArrayList<Dash>() {{
            add(new Dash("a", 12));
            add(new Dash("b", 14));
            add(new Dash("c", 17));
            add(new Dash("d", 22));
        }};


        int count1 = dashs.stream().map(dash -> 1).reduce(0, (i, j) -> i + j).intValue();
        long count2 = dashs.stream().count();
         System.out.println(count1 + " ==== " + count2);
    }
}
