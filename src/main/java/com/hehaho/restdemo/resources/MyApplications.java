/**
 * 
 */
package com.hehaho.restdemo.resources;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * @author Kevin
 *
 */
public class MyApplications extends ResourceConfig {

	public MyApplications() {
		register(RequestContextFilter.class);
		this.register(DemoResource.class);
//		System.out.println(MyApplications.class.getPackage().toString());
//		this.packages(MyApplications.class.getPackage().toString());
	}

}
