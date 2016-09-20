package br.com.foodzone.intercepts;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.com.foodzone.controller.UsuarioController;
import br.com.foodzone.model.UsuarioWeb;

// interceptar requisições executando
// algo antes e/ou depois da sua lógica
@Intercepts
public class AutorizacaoLiberado implements Interceptor {

	private final UsuarioWeb usuario;// usuário da Sessão
	private final Result result; // mostra resultados

	// inicializando
	public AutorizacaoLiberado(UsuarioWeb usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}// fim construtor

	// decide se vai ou não interceptar a requisição atual
	public boolean accepts(ResourceMethod method) {

		// condição (true) para poder ir para o método intercept abaixo
		// não logado e anotado como @Liberado
		return !usuario.isLogado() && method.containsAnnotation(Liberado.class);

	}// fim accepts()

	// executa de fato a lógica de negócios
	public void intercept(InterceptorStack stack, ResourceMethod method,
			Object resourceInstance) throws InterceptionException {

		// para usuário não logado
		if (!usuario.isLogado()) {
			// redireciona para a página de login
			result.redirectTo(UsuarioController.class).loginForm();

		} else {

			// continuar a execução normal da requisição
			stack.next(method, resourceInstance);
			
		}// fim if

	}// fim intercept()

}// fim class AutorizacaoLiberado

