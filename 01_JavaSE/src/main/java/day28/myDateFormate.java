package day28;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    特别注意：在使用注解的使用一定要加上使用范围和使用时间，否则你的entity在使用注解的时候，运行时你的注解就消失了，并不会生效
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface myDateFormate {
    String value() default "yyyy-MM-dd";
}
