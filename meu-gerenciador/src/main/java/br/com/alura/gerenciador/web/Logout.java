package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*@WebServlet(urlPatterns="/logout")*/
public class Logout implements Tarefa{
	
	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.removeAttribute("usuarioLogado");
		
		return "/WEB-INF/paginas/logout.html";
	}
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		
		if(cookie != null){
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		
		HttpSession session = req.getSession();
		session.removeAttribute("usuarioLogado");
		
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Usuário deslogado</body></html>");
		
		Redirecionamento no lado do cliente
		resp.sendRedirect("logout.html");
		
		Redirecionamento no lado do cliente
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
	}*/
	
}
