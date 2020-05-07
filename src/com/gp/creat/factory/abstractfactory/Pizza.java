package com.gp.creat.factory.abstractfactory;

public abstract class Pizza {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    protected abstract void prepare();
    void bake(){
        System.out.println(name + "披萨正在烘烤...");
    }
    void cut(){
        System.out.println(name + "披萨正在制作...");
    }
    void pack(){
        System.out.println(name + "披萨正在打包...");
    }
}
