package com.zzl.pattern.abstractFactory;

public class GoNote implements INote {
    @Override
    public void edit() {
        System.out.println("编辑Go笔记");
    }
}
