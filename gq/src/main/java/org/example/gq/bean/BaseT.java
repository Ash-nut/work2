package org.example.gq.bean;

public class BaseT<T,E,K,V> {
    private T t;
    private E e;
    private K k;
    private V v;
    @interface MyAnno{
        String value();
    }
    @MyAnno(value = "hello world")
    public void soutSomething(){
        System.out.println("nothing");
    }
}
