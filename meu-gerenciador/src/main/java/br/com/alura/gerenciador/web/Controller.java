package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String tarefa = request.getParameter("tarefa");
		
		if(tarefa == null)
			throw new IllegalArgumentException("Você esqueceu de enviar o parâmetro \"tarefa\"! ");
		
		try {
			String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
			Class<?> type = Class.forName(nomeDaClasse);
			Tarefa instance = (Tarefa) type.newInstance();
			
			String pagina = instance.executa(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e); 
		}
		
	}

}
