package com.model.modulelib.utils.dagger2.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created tangxin
 * Time 2018/9/28 下午11:17
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME) //表示该annotation的具体实现可以在运行时用类反射来实现
public @interface PerActivity {
}