package me.andstudy;

import org.junit.Test;

public class StringTest {

    @Test
    public void test() {
        String text = new String();
        String result = text.concat("abc");
        System.out.println(result);

        final char array[] = {'1', '2'};
        array[0] = '3';
        System.out.println(array);
    }
}
