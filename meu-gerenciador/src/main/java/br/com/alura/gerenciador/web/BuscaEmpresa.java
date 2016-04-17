package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa implements Tarefa{
	
	public BuscaEmpresa() {
		System.out.println("Instanciando uma Servlet do tipo BuscaEmpresa " + this);
	}
	
	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		String filtro = request.getParameter("filtro");
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		request.setAttribute("empresas", empresas);
		
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}
	
	/*@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a Servlet " + this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Dentruindo a Servlet " + this);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("Resultado da busca:<br/>");
		
		String filtro = req.getParameter("filtro");
		
		try{
			Thread.sleep(10000);
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		writer.println("<ul>");
		
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		
		writer.println("</ul>");
		
		writer.println("</body>");
		writer.println("</html>");
		
		req.setAttribute("empresas", empresas);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}*/
	
}