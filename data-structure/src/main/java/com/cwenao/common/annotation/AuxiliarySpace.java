/*
 * Company
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
package com.cwenao.common.annotation;

import java.lang.annotation.*;

/**
 * @author cwenao
 * @version $Id AuxiliarySpace.java, v 0.1 2017-07-24 8:11 cwenao Exp $$
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface AuxiliarySpace {
    String value() default "";
}

