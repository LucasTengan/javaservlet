package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		Banco.lista.add(empresa);
		Banco.lista.add(empresa2);
	}

	public void adiciona(Empresa empresa) {
		Banco.lista.add(empresa);
		empresa.setId(Banco.chaveSequencial++);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {		
		Iterator<Empresa> it = lista.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) it.remove();
		}
		
		/*for (Empresa empresa : lista) { vai gerar um erro, pois n�o posso modificar e alterar a empresa que estou iterando
			if(empresa.getId() == id) lista.remove(empresa);
		}*/
	}

	public Empresa buscaEmpresa(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) return empresa;
		}
		return null;
	}

}