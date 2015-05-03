/**
 * 
 */
package br.com.julianfernando.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.julianfernando.sessionbeans.CalculadoraIf;

/**
 * @author julian fernando
 *
 */

@ManagedBean
public class CalculadoraMB {

	private double a;
	
	private double b;
	
	private double resultado;
	
	@EJB
	private CalculadoraIf calculadora;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public void soma() {
		this.resultado = this.calculadora.soma(a, b);
	}
}
