package com.zzl.pattern.factoryMethod;

import com.zzl.pattern.simpleFactory.ICourse;

/**
 * Description: 工厂模型
 * @author zzl
 */
public interface ICourseFactory {
    /**
     * 创建课程
     * @return ICourse
     */
    ICourse createCourse();
}
