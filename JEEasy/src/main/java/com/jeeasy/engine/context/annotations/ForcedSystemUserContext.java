package com.jeeasy.engine.context.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@Inherited
@InterceptorBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
/**
 * Note: DON'T use injected attributes while using this interceptor.
 * Injected attributes instances will not have this interceptor operation applied.
 *
 */
public @interface ForcedSystemUserContext {

}
