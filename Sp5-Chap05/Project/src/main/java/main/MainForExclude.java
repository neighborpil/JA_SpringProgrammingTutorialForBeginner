package main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxWithExclude;

public class MainForExclude {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) throws IOException{
		
		ctx = new AnnotationConfigApplicationContext(AppCtxWithExclude.class);
	}
}
