package com.lagoru.forex.data.utils;

/**
 * Created by lagoru on 29.11.16.
 */

public class ListUtils {

    public static boolean equals(Object s1, Object s2) {
        return s1 == null ? (s2 == null ? true : false) : s1.equals(s2);
    }
}
