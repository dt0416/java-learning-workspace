package ln.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 自行撰寫Annotation，注意@Retention
 * 
 * @author Ian Chen
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    
    /**
     * value是預設的屬性，使用時可以不用寫value=""
     * 可直接MyAnnotation("str")即代表MyAnnotation(value="str")
     * 但假如要指定2個以上就必須皆要給屬性名稱
     * 例：MyAnnotation(value="str", pro1="str")，無法寫成MyAnnotation("str", pro1="str")
     */
    String value() default "";
    
    /**
     * 無預設值的屬性
     * 使用方式:@MyAnnotation(pro1="str")
     */
    String pro1();
    
    /**
     * 有預設值的屬性
     */
    String pro2() default "";
}
