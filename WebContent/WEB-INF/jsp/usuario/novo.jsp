<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Utilizando taglib core c do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Utilizando tag jsp "include" - p/a incluir a página topo.jsp dentro desta página -->
<jsp:include flush="true" page="../partes/topo.jsp"></jsp:include>
<div id="search">
	<form action="lista-buscar" method="post">
		<input autocomplete="off" required="required" type="text" name="busca"
			placeholder="Pesquisar usuario...">

		<button type="submit" class="tip-left">
			<i class="icon-search icon-white"></i>
		</button>
	</form>
</div>
<!-- Início conteúdo principal -->

<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="<c:url value="/"/>" class="tip-bottom"><i
				class="icon-home"></i>Início</a><a href="#" class="current">${titulo}</a>
		</div>
		<h1>${titulo}</h1>
	</div>

	<!-- Alerta de erro  -->
	<c:if test="${errors != null}">
		<div class="alert alert-error alert-block">
			<a class="close" data-dismiss="alert" href="#">×</a>
			<h4 class="alert-heading">Error!</h4>
			<ul>
				<c:forEach items="${errors}" var="error">
					<li>${error}</li>
				</c:forEach>
			</ul>
		</div>
	</c:if>
	<!-- Fim alerta de erro -->

	<!-- Alerta de sucesso no cadastro -->
	<c:if test="${sucesso_adicionado != null}">
		<div class="alert alert-success alert-block">
			<a class="close" data-dismiss="alert" href="#">×</a>
			<h4 class="alert-heading">
				Sucesso! <a class="btn btn-success btn-mini"
					href="<c:url value="/usuario/listar"/>"> Listar Usuários</a>
			</h4>
			${sucesso_adicionado}
		</div>
	</c:if>
	<!-- Fim sucesso no cadastro  -->

	<form id="usuarioForm" action="adicionar" method="post"
		class="form-horizontal">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i>
							</span>
							<h5>Cadastro básico</h5>
						</div>
						<div class="widget-content nopadding">
							<div class="control-group">
								<label class="control-label">Nome :</label>
								<div class="controls">
									<input type="text" name="usuario.nome" required="required"
										class="span20" placeholder="Ex: Marcos" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">senha:</label>
								<div class="controls">
									<input type="password" name="usuario.senha" class="span5"
										required="required" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">E-mail:</label>
								<div class="controls">
									<input type="email" name="usuario.email" required="required"
										class="span5" placeholder="joao@foodzone.com.br" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo :</label>
								<div class="controls ">
									<select name="usuario.tipo" required="required">
										<option value="">-- Escolha o tipo --</option>
										<option value="0">Admintrador</option>
										<option value="1">Usuário</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Tipo Pergunta Secreta:</label>
								<div class="controls ">
									<select name="usuario.tipoPergunta" required="required">
										<option value="">-- Escolha um pergunta antes --</option>
										<option value="1">Nome do time de futebol</option>
										<option value="2">Nome do animal de estimação</option>
										<option value="3">Nome da mãe</option>
										<option value="4">Nome do pai</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Resposta secreta :</label>
								<div class="controls">
									<input type="text" name="usuario.pergunta" required="required"
										class="span5" placeholder="Ex: Marcos" />
								</div>
							</div>
						</div>
						<div class="form-actions">
							<button type="submit" class="btn btn-success">Salvar</button>
						</div>
					</div>


				</div>
			</div>

		</div>
	</form>
</div>
<!-- Fim conteúdo principal -->
<%-- <script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.3.2.js"></script> --%>
<!-- Utilizando tag jsp "include" - p/a incluir a página rodape.jsp dentro desta página -->
<jsp:include page="../partes/rodape.jsp" flush="true"></jsp:include>

<!-- validação dos campos -->
<script type="text/javascript">
	$('#clienteForm').validate({
		rules : {
			"usuario.cliNome" : {
				required : true,
				minlength : 2
			},
			"usuario.cliRg" : {
				required : true,
				minlength : 2
			},
			"usuario.cliTelefoneFixo" : {
				required : true,
				minlength : 10

			},
			"usuario.cliTelefoneMovel" : {
				required : true,
				minlength : 10
			},
			"usuario.cliEmail" : {
				required : true,
				minlength : 2,
				email : true

			},
			"endereco.endRua" : {
				required : true,
				minlength : 2

			},
			"endereco.endNumero" : {
				required : true,
				minlength : 2

			},
			"endereco.endBairro" : {
				required : true,
				minlength : 2
			},
			"endereco.cidadeCidId.cidId" : {
				required : true

			}

		}
	});
	$(".telefones").mask("(99)9999-9999");
</script>
