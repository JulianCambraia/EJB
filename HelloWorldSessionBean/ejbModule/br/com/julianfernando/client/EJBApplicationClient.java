package br.com.julianfernando.client;

import javax.naming.Context;

import com.sun.tracing.dtrace.ModuleName;

import br.com.julianfernando.business.HelloWorld;
import br.com.julianfernando.businesslogic.HelloWorldBean;
import br.com.julianfernando.clientutility.ClientUtility;

public class EJBApplicationClient {

	public static void main(String[] args) {
		HelloWorld bean = doLookup();
		System.out.println(bean.sayHello());

	}

	private static HelloWorld doLookup() {
		Context context = null;
		HelloWorld bean = null;
		try {
			// 1. Obtemos o contexto
			context = ClientUtility.getInitialContext();
			// 2. Gerando o JNDI lookup Name
			String lookupName = getLookupName();
			
			bean = (HelloWorld) context.lookup(lookupName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupName() {
		// O Nome da aplicação é o nome do EAR que está sendo implantado pelo EJB sem o sufixo .ear
		// portanto este ficará armazenado em uma String vazia.
		String appName = "";
		
		// O nome do módulo é o nome do JAR gerado e implantado pelo EJB sem o sufixo .jar
		// É o nome da aplicação
		String moduleName = "HelloWorldSessionBean";
		
		// O nome da classe de implementação é o bean EJB
		String beanName = HelloWorldBean.class.getSimpleName();
		
		// 
		String distinctName = "";
		
		// Nome completo da Interface 
		final String interfaceName = HelloWorld.class.getName();
		
		// Criando e concatenando a String que gera o lookupName
		String name = "ejb:" +  appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		return name;
	}

}
