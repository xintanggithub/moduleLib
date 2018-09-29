package com.model.modulelib.utils.dagger2.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created tangxin
 * Time 2018/9/28 下午11:21
 */
@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApplication {
}
