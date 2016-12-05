package com.lagoru.forex.utils;

/**
 * Created by lagoru on 25.09.16.
 */
public class ListUtils {

    public static boolean equals(Object o, Object o1) {
        if ((o == null) ^ (o1 == null)) {
            return false;
        }
        if (o == null) {
            return true;
        }

        return o.equals(o1);
    }
}
