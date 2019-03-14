package com.zzl.pattern.factoryMethod;

import com.zzl.pattern.simpleFactory.ICourse;
import com.zzl.pattern.simpleFactory.JavaCourse;
/**
 * Description: java factory
 * @author zzl
 */
public class JavaCourseFactory implements ICourseFactory {
    /**
     * 创建课程
     *
     * @return ICourse
     */
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }
}
