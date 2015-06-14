package br.com.julianfernando.controller;

import java.security.Principal;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "loginMBean")
public class LoginMBean {
	private String username;
	private String password;
	private Date currentDate = new Date();

	HttpServletRequest request = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			.getExternalContext().getSession(false);

	public LoginMBean() {
		if (session != null) {
			session.invalidate();
		}
	}

	public String login() {
		String message = "";
		String navigation = "";
		try {

			request.login(username, password);
			Principal principal = request.getUserPrincipal();

			if (request.isUserInRole("Administrator")) {
				message = "Usuário : "
						+ principal.getName()
						+ " Você é Administrador e tem direito a todos as funcionalidades!";
				navigation = "admin/adminPage";
			} else if (request.isUserInRole("Manager")) {
				message = "Usuário : "
						+ principal.getName()
						+ "Você é um Diretor e pode visualizar todos os relatórios gerenciais!";
				navigation = "manager/diretorPage";
			} else if (request.isUserInRole("Operator")) {
				message = "Usuário : " + principal.getName()
						+ "Você é um Operador, Por Favor Atenda bem o cliente!";
				navigation = "operador/usersPage";
			}

			FacesContext.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									message, null));

			return navigation;

		} catch (ServletException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu algum problema e o Login Falhou!", null));
			e.printStackTrace();
		}
		return "acesso-negado";
	}

	public String logout() {

		if (session != null) {
			session.invalidate();
		}
		return "logout";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
}
