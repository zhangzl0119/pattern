package com.zzl.pattern.factoryMethod;

import com.zzl.pattern.simpleFactory.GoCourse;
import com.zzl.pattern.simpleFactory.ICourse;
/**
 * Description: go factory
 * @author zzl
 */
public class GoCourseFactory implements ICourseFactory {
    /**
     * 创建课程
     *
     * @return ICourse
     */
    @Override
    public ICourse createCourse() {
        return new GoCourse();
    }
}
