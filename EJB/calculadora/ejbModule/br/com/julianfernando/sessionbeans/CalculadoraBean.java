/**
 * 
 */
package br.com.julianfernando.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Classe que implementa os SLSB
 * @author julian fernando
 *
 */
@Stateless
@Local(CalculadoraIf.class)
public class CalculadoraBean implements CalculadoraIf {

	/* (non-Javadoc)
	 * @see br.com.julianfernando.sessionbeans.CalculadoraIf#soma(double, double)
	 */
	@Override
	public double soma(double a, double b) {
		// TODO Auto-generated method stub
		return a + b;
	}

}
