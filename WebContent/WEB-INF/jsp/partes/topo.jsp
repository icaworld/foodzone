<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Utilizando taglib fmt fmt do JSTL para datas-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titulo}</title>

<!-- importes padrões css -->
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/maruti-style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/maruti-media.css"
	class="skin-color" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />


<!-- importantes -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />


</head>
<body>
	<!-- Início topo -->

	<!--Header-part-->
	<div id="header">
		<span style="margin-left: 3%;"><img
			src="${pageContext.request.contextPath}/img/logo.png" width="90"
			height="90" /></span>

	</div>
	<!--close-Header-part-->

	<!-- obtendo o objeto data -->
	<jsp:useBean id="data" class="java.util.Date" />

	<!--top-Header-menu-->
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav">


			<li class=""><a title="" href="#"> <span class="text">Hoje:
						<fmt:formatDate type="time" value="${data}" pattern="dd-MM-yyyy" />
				</span></a></li>

			<c:if test="${usuarioWeb.logado}">
				<li class=""><a title="" href="<c:url value="/logout"/>"><i
						class="icon icon-share-alt"></i> <span class="text">Sair</span></a></li>
			</c:if>

		</ul>
	</div>

	<!--close-top-Header-menu-->

	<div id="sidebar">
		<a href="#" class="visible-phone"><i class="icon icon-home"></i>
			Menu de controle</a>
		<ul>
			<li class="active"><a href="<c:url value="/"/>"><i
					class="icon icon-home"></i> <span>Painel principal</span></a></li>

			<li class="submenu"><a href="#"><i class="icon icon-th"></i>

					<span>Listar</span></a>
				<ul>
					<%-- 					<li><a href="<c:url value="/usuario/listar"/>">Usuário</a></li> --%>
				</ul></li>

			<li class="submenu"><a href="#"><i class="icon icon-th-list"></i>
					<span>Adicionar</span></a>
				<ul>
					<li><a href="<c:url value="/usuario/novo"/>">Usuário</a></li>
					<li><a href="<c:url value="/tipoEstabelecimento/novo"/>">Tipo Estabelecimento</a></li>
					<li><a href="<c:url value="/indicador/novo"/>">Indicador</a></li>
					<li><a href="<c:url value="/estabelecimento/novo"/>">Estabelecimento</a></li>
				</ul></li>
		</ul>
	</div>

	<!-- Fim topo -->