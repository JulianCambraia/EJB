package br.com.julianfernando.businesslogic;

import br.com.julianfernando.business.HelloWorld;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless
public class HelloWorldBean implements HelloWorld {

    /**
     * Default constructor. 
     */
    public HelloWorldBean() {
        
    }

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "Alô Mundo EJB 3.1";
	}
    
    

}
