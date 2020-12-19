package br.com.mbragariano.gobeautyapi.common.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Component
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Util {

	@AliasFor(annotation = Component.class)
	String value() default "";

}
