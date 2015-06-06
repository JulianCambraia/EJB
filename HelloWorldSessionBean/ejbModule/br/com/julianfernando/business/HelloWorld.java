package br.com.julianfernando.business;

import javax.ejb.Remote;

@Remote
public interface HelloWorld {

	public abstract String sayHello();
}
