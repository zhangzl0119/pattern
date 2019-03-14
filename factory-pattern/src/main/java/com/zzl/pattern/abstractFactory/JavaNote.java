package com.zzl.pattern.abstractFactory;

public class JavaNote implements INote {
    @Override
    public void edit() {
        System.out.println("编辑Java笔记");
    }
}
