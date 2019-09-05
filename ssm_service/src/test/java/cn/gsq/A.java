package cn.gsq;

import cn.gsq.domain.Product;
import cn.gsq.service.IProductService;

import java.util.List;

public class A  {

    public static void add3(Integer i) {

        int val = i.intValue();

        val += 3;

        i = new Integer(val);

    }


    public static void main(String args[]) {

        String a = new String("this is my test");

        for (int i = 0; i <a.length() ; i++) {
            char c = a.charAt(i);
            if ('t'==c) {

            }

        }


    }

}