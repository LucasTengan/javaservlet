package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//oi
// Tomcat serve como "main" ele instancia o Servlet, serve como um container
// Inversão de controle, meu main nao instancia nada, e sim o Tomcat
@WebServlet(urlPatterns="/oi")
public class OiMundoServlet extends HttpServlet {
	
	//é um middleware, apenas instancia um objeto de cada Servlet
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("oi mundo, parabens vc escreveu o primeiro servlets.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
