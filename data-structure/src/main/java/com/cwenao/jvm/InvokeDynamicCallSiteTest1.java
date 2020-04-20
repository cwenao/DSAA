/**
 * Company Copyright (C) 2014-2019 All Rights Reserved.
 */
package com.cwenao.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * TODO : Statement the class description
 * @author cwenao
 * @version $Id InvokeDynamicCallSiteTest1.java, v1.0.0 2019-11-25 13:48 cwenao Exp $$
 */
public class InvokeDynamicCallSiteTest1 {

    class GrandFather{
        void thinking(){
            System.out.println("I am grandfather");
        }
        void history(){
            System.out.println("Sleeping when talk the history");
        }
    }

    class Father extends  GrandFather{
        @Override
        void thinking(){
            System.out.println("I amd father");
        }
    }

    class Son extends  Father{
        @Override
        void thinking(){
            System.out.println("I am son");
            try {
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = MethodHandles.lookup()
                        .findSpecial(GrandFather.class, "thinking", mt, getClass());
                mh.invoke(this);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new InvokeDynamicCallSiteTest1().new Son()).thinking();
    }

}
