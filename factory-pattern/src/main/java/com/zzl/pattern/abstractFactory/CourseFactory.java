package com.zzl.pattern.abstractFactory;

public interface CourseFactory {

    INote createNote();

    IVideo createVideo();
}
