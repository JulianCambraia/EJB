package br.com.julianfernando.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import br.com.julianfernando.business.IProject;
import br.com.julianfernando.businesslogic.ProjectBean;
import br.com.julianfernando.clientutility.JNDILookupClass;

import com.br.julianfernando.entities.Project;

public class EJBApplicationClient {

	public static void main(String[] args) {
		IProject bean = doLookup();

		Project p1 = new Project();
		p1.setPname("Banking App");
		p1.setPlocation("Town City");
		p1.setDeptoNo(1);

		Project p2 = new Project();
		p2.setPname("Office Automation");
		p2.setPlocation("Downtown");
		p2.setDeptoNo(1);

		// chamada ao métodos de negócio
		bean.saveProject(p1);
		bean.saveProject(p2);

		// encontrando um Project
		p1.setPnumber(1);
		Project p3 = bean.findProject(p1);
		System.out.println(p3);

		// Retornando uma lista de Projetos
		System.out.println("Lista de Projetos");
		List<Project> projects = bean.retrieveAllProjects();
		for (Project project : projects) {
			System.out.println(project);
		}

	}

	private static IProject doLookup() {
		Context context = null;
		IProject bean = null;
		try {
			// 1. Obtendo o Contexto
			context = JNDILookupClass.getInitialContext();
			// 2. Gerando o JNDI
			String lookupName = getLookupName();
			bean = (IProject) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

	private static String getLookupName() {

		// TODO Auto-generated method stub
		String appName = "";

		String moduleName = "FirstJPAProject";

		String distinctName = "";

		String beanName = ProjectBean.class.getSimpleName();

		final String interfaceName = IProject.class.getName();

		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName
				+ "/" + beanName + "!" + interfaceName;

		return name;
	}

}
