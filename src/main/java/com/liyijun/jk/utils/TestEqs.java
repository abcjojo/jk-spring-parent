package com.liyijun.jk.utils;

import java.io.File;

/**
 * @Description:
 * @author: liyijun
 * @date: 2022年09月06日 15:48
 */

public class TestEqs {

    public boolean equals() {
        return true;
    }

    public boolean equals(int a, int b) {
        return true;
    }

    public boolean equals(int a, int b, int c) {
        return true;
    }

    public static void main(String[] args) {
        String path = "D:\\zz1\\zz2\\zz3";

        File file = new File(path);
        //如果路径不存在，新建
        if(!file.exists()&&!file.isDirectory()) {
            file.mkdirs();
        }
    }

}
