package com.UserManagementSystem.UserManagementSystem.intent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows explicit instructions for the various element types within this class.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.SOURCE)
public @interface IntentManageClass{
    /**
    * Override for the identifier for this class. 
    * Use this if you want Intent Architect to match this class to an output class, irrespective of its name.
    */
    String id() default "";
    /**
    * Sets the instruction for how to manage annotations on this class.
    */
    int annotations() default 0;
    /**
    * Sets the instruction for how to manage members in this class.
    */
    int members() default 0;
    /**
    * Sets the instruction for how to manage private fields in this class.
    */
    int privateFields() default 0;
    /**
    * Sets the instruction for how to manage private fields in this class.
    */
    int protectedFields() default 0;
    /**
    * Sets the instruction for how to manage protected fields in this class.
    */
    int publicFields() default 0;
    /**
    * Sets the instruction for how to manage public fields in this class.
    */
    int fields() default 0;
    /**
    * Sets the instruction for how to manage all fields in this class.
    */    
    int constructors() default 0;
    /**
    * Sets the instruction for how to manage constructors in this class.
    */
    int privateMethods() default 0;
    /**
    * Sets the instruction for how to manage private methods in this class.
    */
    int protectedMethods() default 0;
    /**
    * Sets the instruction for how to manage protected methods in this class.
    */
    int publicMethods() default 0;
    /**
    * Sets the instruction for how to manage public methods in this class.
    */
    int methods() default 0;
}