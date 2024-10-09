package org.example.gq.bean;

import javax.annotation.sql.DataSourceDefinition;

public class BaseClass {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void showName(){
        System.out.println(this.name+"基本类");
    }
}
