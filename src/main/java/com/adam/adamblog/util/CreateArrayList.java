package com.adam.adamblog.util;

import java.util.ArrayList;

/**
 * @author adam
 * 创建于 2018-03-03 11:11.
 */
public class CreateArrayList {

    public static ArrayList<String> withStringValues(String... values) {
        ArrayList<String> arrayList = new ArrayList<>();
        for(String value:values) {
            arrayList.add(value);
        }
        return arrayList;
    }

}
