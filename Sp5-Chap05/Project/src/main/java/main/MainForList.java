package main;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtxForList;

public class MainForList {

	private static ApplicationContext ctx = null;
	
	public static void main(String[] args) {
		ctx = new AnnotationConfigApplicationContext(AppCtxForList.class);
		
		String[] names = ctx.getBeanDefinitionNames();
		Arrays.stream(names).forEach(name -> System.out.println(name));

	}

}
