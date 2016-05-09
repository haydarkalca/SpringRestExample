package com.restexample.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Retention(RetentionPolicy.RUNTIME)
public @interface ProdProfile {

}
