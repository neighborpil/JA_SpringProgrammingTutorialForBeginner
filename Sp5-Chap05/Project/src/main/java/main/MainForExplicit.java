package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtxWithExplicit;

public class MainForExplicit {

	private static AbstractApplicationContext ctx = null;
	
	public static void main(String[] args) {

		ctx = new AnnotationConfigApplicationContext(AppCtxWithExplicit.class);
		ctx.close();
	}
}
