<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Utilizando taglib core c do JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Utilizando tag jsp "include" - p/a incluir a página topo.jsp dentro desta página -->
<jsp:include flush="true" page="../partes/topo.jsp"></jsp:include>
<div id="search">
	<form action="lista-buscar" method="post">
		<input autocomplete="off" required="required" type="text" name="busca"
			placeholder="Pesquisar tipo Estabelecimentos...">

		<button type="submit" class="tip-	left">
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
					href="<c:url value="/tipoEstabelecimento/listar"/>"> Listar tipo de Estabelecimentos</a>
			</h4>
			${sucesso_adicionado}
		</div>
	</c:if>
	<!-- Fim sucesso no cadastro  -->

	<form id="tipoEstabelecimentoForm" action="adicionar" method="post"
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
									<input type="text" name="tipoEstabelecimento.nome" required="required"
										class="span20" placeholder="Ex: restaurante" />
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
	$('#tipoEstabelecimentoForm').validate({
		rules : {
			"tipoEstabelecimento.nome" : {
				required : true,
				minlength : 2
			}

		}
	});
</script>
