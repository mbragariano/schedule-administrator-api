package br.com.mbragariano.gobeautyapi.common.annotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Controller
@ResponseBody
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestEndPoint {

	@AliasFor(annotation = Controller.class)
	String value() default "";

}
