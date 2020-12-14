/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.common.annotation;

import java.lang.annotation.*;

/**
 * @author cwenao
 * @version $Id TimeComplexity.java, v 0.1 2017-07-24 8:08 cwenao Exp $$
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface TimeComplexity {
    String value() default "";
}

