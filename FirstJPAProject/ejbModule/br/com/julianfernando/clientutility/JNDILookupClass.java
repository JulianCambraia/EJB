package br.com.julianfernando.clientutility;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDILookupClass {
	
	private static InitialContext context;
	
	private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
	
	public static Context getInitialContext() throws NamingException {
		
		if (context == null) {
			
			Properties properties = new Properties();
			
			properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
			
			context = new InitialContext(properties);
		}
		
		return context;
	}
}
