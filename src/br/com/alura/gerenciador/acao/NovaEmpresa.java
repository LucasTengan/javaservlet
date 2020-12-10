package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dataEmpresa = request.getParameter("data");
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	
		// atribui à variavel nomeEmpresa o valor recebido pelo parametro nome do formulario
		String nomeEmpresa = request.getParameter("nome");
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		// o navegador recebe a resposta. será para onde o navegador enviará a nova requisição
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
		
//		// chamar o JSP
//		request.setAttribute("empresa", empresa);	//informa o que enviara ao jsp
//		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");	// para qual endereço enviará
//		rd.forward(request, response);	//envia
	}	
}
