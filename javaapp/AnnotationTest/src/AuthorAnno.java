import java.lang.annotation.*;

/**
 * Created by optima1 on 2016/8/11.
 */
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorAnno {
    String name();
    String website() default "github.com";
    int reversion() default 1;
}
