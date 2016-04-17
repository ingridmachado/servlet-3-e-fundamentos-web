package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

/*@WebServlet(urlPatterns="/novaEmpresa")*/
public class NovaEmpresa implements Tarefa{
	
	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		String nome = request.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		request.setAttribute("empresa", empresa);
		
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		
		Empresa empresa = new Empresa(nome);
		new EmpresaDAO().adiciona(empresa);
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Empresa " + empresa.getNome() + " adicionada com sucesso!</body></html>");
		
		req.setAttribute("empresa", empresa);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}*/
	
}