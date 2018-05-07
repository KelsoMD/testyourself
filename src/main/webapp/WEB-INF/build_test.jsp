<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<!-- Данный сайт сделан с помощью конструктора Mobirise v4.6.5, https://mobiriz.store -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>search</title>
<link rel="stylesheet"
	href="assets/web/assets/mobirise-icons/mobirise-icons.css">
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/socicon/css/styles.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet"
	href="assets/datatables/data-tables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<section class="menu cid-qPBrzxK6qz" once="menu" id="menu1-j">
		<nav
			class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm bg-color transparent">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<div class="hamburger">
					<span></span> <span></span> <span></span> <span></span>
				</div>
			</button>
			<div class="menu-logo">
				<div class="navbar-brand">

					<span class="navbar-caption-wrap"><a
						class="navbar-caption text-white display-4">TEST YOURSELF</a></span>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-home mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> Главная</span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="http://localhost:8080/testyourself/MainServlet?action=switch_search_page"><span
							class="mbri-search mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> Тесты</span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-italic mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> О проекте</span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-growing-chart mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> Статистика</span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"><span
							class="mbri-users mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> Группы</span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="https://mobirise.com"> </a></li>
				</ul>
			</div>
		</nav>
	</section>
	<section class="section-table cid-qR017JJDq7" id="table1-t">



		<div class="container container-table">

			<h3
				class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
				Собранные вопросы</h3>
			<div class="table-wrapper">
				<form action="MainServlet" method="post">
					<div class="container scroll">
						<table class="table isSearch" cellspacing="0">
							<thead>
								<tr class="table-heads ">
									<th class="head-item mbr-fonts-style display-7">ID</th>
									<th class="head-item mbr-fonts-style display-7">Текст</th>
									<th class="head-item mbr-fonts-style display-7">Автор</th>
									<th class="head-item mbr-fonts-style display-7">Действия</th>
								</tr>
							</thead>
							<c:forEach items="${recentTestQuestions}" var="recentQuestion">
								<tbody>
									<tr>
										<td class="body-item mbr-fonts-style display-7">${recentQuestion.getId()}</td>
										<td class="body-item mbr-fonts-style display-7">${recentQuestion.getText()}</td>
										<td class="body-item mbr-fonts-style display-7">${recentQuestion.getAuthor().getLogin()}</td>
										<td class="body-item mbr-fonts-style display-7"><a
											href="http://localhost:8080/testyourself/MainServlet?action=delete_question&question_id=${recentQuestion.getId()}"
											class="btn btn-black-outline display-4">Удалить</a></td>
									</tr>
								</tbody>
							</c:forEach>
						</table>
					</div>
					<div class="mbr-section-btn text-center pt-4">
							<input type="hidden" name="action" value="create_test" />
							<button type="submit"
								class="btn btn-sm btn-black-outline display-4">Создать</button>
						</div>
				</form>
			</div>
		</div>
	</section>
	<section class="section-table cid-qR017JJDq7" id="table1-t">
		<div class="container container-table">

			<h3
				class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
				Вопросы</h3>
			<div class="table-wrapper">
				<div class="container scroll">
					<table class="table isSearch" cellspacing="0">
						<thead>
							<tr class="table-heads ">
								<th class="head-item mbr-fonts-style display-7">ID</th>
								<th class="head-item mbr-fonts-style display-7">Текст</th>
								<th class="head-item mbr-fonts-style display-7">Автор</th>
								<th class="head-item mbr-fonts-style display-7">Действия</th>
							</tr>
						</thead>
						<c:forEach items="${testQuestionsToChoose}" var="question">
							<tbody>
								<tr>
									<td class="body-item mbr-fonts-style display-7">${question.getId()}</td>
									<td class="body-item mbr-fonts-style display-7">${question.getText()}</td>
									<td class="body-item mbr-fonts-style display-7">${question.getAuthor().getLogin()}</td>
									<td class="body-item mbr-fonts-style display-7"><a
										href="http://localhost:8080/testyourself/MainServlet?action=add_question&question_id=${question.getId()}"
										class="btn btn-black-outline display-4">Добавить</a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</section>
	<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
		<div class="container">
			<div class="media-container-row align-center mbr-white">
				<div class="row row-copirayt">
					<p
						class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
						© Copyright 2017 Mobirise - Все права защищены</p>
				</div>
			</div>
		</div>
	</section>
	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/datatables/jquery.data-tables.min.js"></script>
	<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
	<script src="assets/theme/js/script.js"></script>
	<input name="animation" type="hidden">
</body>
</html>