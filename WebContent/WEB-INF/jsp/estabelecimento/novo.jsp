<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Utilizando taglib core c do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Utilizando tag jsp "include" - p/a incluir a página topo.jsp dentro desta página -->
<jsp:include flush="true" page="../partes/topo.jsp"></jsp:include>
<div id="search">
	<form action="lista-buscar" method="post">
		<input autocomplete="off" required="required" type="text" name="busca" placeholder="Pesquisar estabelecimento...">
		
		<button type="submit" class="tip-left" >
			<i class="icon-search icon-white"></i>
		</button>
	</form>
</div>
<!-- Início conteúdo principal -->

<div id="content">
	<div id="content-header">
		<div id="breadcrumb">
			<a href="<c:url value="/"/>" 
				class="tip-bottom"><i class="icon-home"></i>Início</a><a href="#"
				class="current">${titulo}</a>
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
					<li>${error.message}</li>
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
					href="<c:url value="/estabelecimento/listar"/>"> Listar estabelecimento</a>
			</h4>
			${sucesso_adicionado}
		</div>
	</c:if>
	<!-- Fim sucesso no cadastro  -->

	<form id="clienteForm" action="adicionar" method="post" class="form-horizontal">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i>
							</span>
							<h5>Informações básicas</h5>
						</div>
						<div class="widget-content nopadding">
							<div class="control-group">
								<label class="control-label">Nome :</label>
								<div class="controls">
									<input type="text" name="estabelecimento.nome" class="span20"
										placeholder="Ex: casa da massa" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Nome Fantasia :</label>
								<div class="controls">
									<input type="text" name="estabelecimento.nomeFantasia" class="span20"
										placeholder="Ex: casa da massa fantasia" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">CNPJ:</label>
								<div class="controls">
									<input type="text" name="estabelecimento.cnpj" class="span5"
										placeholder="Ex: 123456789/0001-01" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Inscrição Estadual</label>
								<div class="controls">
									<input type="text" name="estabelecimento.inscricaoEstadual" class="span5"/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-align-justify"></i>
							</span>
							<h5>Endereço</h5>
						</div>
						<div class="widget-content nopadding">
							<div class="control-group">
								<label class="control-label">Rua :</label>
								<div class="controls">
									<input type="text" name="estabelecimento.endereco.rua" class="span6"
										placeholder="Ex: São josé" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Bairro :</label>
								<div class="controls">
									<input type="text" name="estabelecimento.endereco.bairro" class="span6"
										placeholder="Ex: Vila são matheus" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Número :</label>
								<div class="controls">
									<input name="estabelecimento.endereco.numero" type="text" class="span2"
										placeholder="Ex: 120-1" />
								</div>
							</div>


							<div class="control-group">
								<label class="control-label">Estado :</label>
								<div class="controls ">
									<select name="cod_estados" >
										<option value="1">São Paulo</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Cidade :</label>
								<div class="controls ">
									<select name="estabelecimento.endereco.cidadeId.Id">
										<option value="">-- Escolha um estado antes --</option>
										<c:forEach items="${cidades}" var="cidade">
											<option value="${cidade.id }">${cidade.nome}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-actions">
								<button type="submit" class="btn btn-success">Salvar</button>
							</div>
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
			"cliente.cliNome" : {
				required : true,
				minlength : 2
			},
			"cliente.cliRg" : {
				required : true,
				minlength : 2
			},
			"cliente.cliTelefoneFixo" : {
				required : true,
				minlength : 10
			},
			"cliente.cliTelefoneMovel" : {
				required : true,
				minlength : 10
			},
			"cliente.cliEmail" : {
				required : true,
				minlength : 2,
				email:true
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