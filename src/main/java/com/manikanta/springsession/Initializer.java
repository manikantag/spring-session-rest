package com.manikanta.springsession;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class Initializer extends AbstractHttpSessionApplicationInitializer { 
	public Initializer() {
		super(AppConfig.class);
	}
}