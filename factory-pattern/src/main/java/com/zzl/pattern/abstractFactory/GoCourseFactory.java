package com.zzl.pattern.abstractFactory;

public class GoCourseFactory implements CourseFactory {
    @Override
    public INote createNote() {
        return new GoNote();
    }

    @Override
    public IVideo createVideo() {
        return new GoVideo();
    }
}
