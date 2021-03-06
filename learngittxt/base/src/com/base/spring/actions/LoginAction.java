package com.base.spring.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.base.hibernate.dao.UserDAO;
import com.base.spring.forms.LoginForm;



public class LoginAction extends SimpleFormController {
	
	UserDAO userDAO;	

    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	protected ModelAndView onSubmit(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception {
			LoginForm loginForm = (LoginForm) command;
			
			if(userDAO.isValid(loginForm.getUsername(), loginForm.getPassword())){
				System.out.println(loginForm.getUsername());
			}
			
            return new ModelAndView(getSuccessView());

    }


}
