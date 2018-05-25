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
<title>group_info</title>
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
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<section class="tabs2 cid-qSjkRbYSks" id="tabs2-10">
		<div class="container">
			<h2
				class="mbr-section-title align-center pb-5 mbr-fonts-style display-2">
				Вкладки</h2>
			<div class="media-container-row">
				<div class="col-12 col-md-8">
					<ul class="nav nav-tabs" role="tablist">
						<li class="nav-item"><a
							class="nav-link mbr-fonts-style active show display-7" role="tab"
							data-toggle="tab" href="#tabs2-10_tab0" aria-selected="true">
								Задания </a></li>
						<li class="nav-item"><a
							class="nav-link mbr-fonts-style active show display-7" role="tab"
							data-toggle="tab" href="#tabs2-10_tab1" aria-selected="true">
								Участники </a></li>
					</ul>
					<div class="tab-content">
						<div id="tab1" class="tab-pane in active" role="tabpanel">
							<div class="row">
								<div class="col-md-12">
									<p class="mbr-text py-5 mbr-fonts-style display-7">Список
										заданий</p>
								</div>
							</div>
							<div class="table-wrapper">
								<div class="row">
									<div class="container scroll">
										<table class="table isSearch" cellspacing="0">
											<thead>
												<tr class="table-heads ">
													<th class="head-item mbr-fonts-style display-7">ID</th>
													<th class="head-item mbr-fonts-style display-7">Questions</th>
													<th class="head-item mbr-fonts-style display-7">Действия</th>
												</tr>
											</thead>
											<c:forEach items="${tasks}" var="item">
												<tbody>
													<tr>
														<td class="body-item mbr-fonts-style display-7">${item.getId()}</td>
														<td class="body-item mbr-fonts-style display-7">${item.getTest().getQuestions().size()}</td>
														<td class="body-item mbr-fonts-style display-7"><form
																action="not_implemented" method="get">
																<input type="hidden" name="group_id"
																	value="${item.getId()}" />
																<button type="submit"
																	class="btn btn-sm btn-black-outline display-4">Меню
																	группы</button>
															</form></td>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div id="tab2" class="tab-pane" role="tabpanel">
							<div class="row">
								<div class="col-md-12">
									<p class="mbr-text py-5 mbr-fonts-style display-7">Список
										участников</p>
								</div>
							</div>
							<div class="row">
								<div class="table-wrapper">
									<div class="container scroll">
										<table class="table isSearch" cellspacing="0">
											<thead>
												<tr class="table-heads ">
													<th class="head-item mbr-fonts-style display-7">Login</th>
													<th class="head-item mbr-fonts-style display-7">Действия</th>
												</tr>
											</thead>
											<c:forEach items="${members}" var="item">
												<tbody>
													<tr>
														<td class="body-item mbr-fonts-style display-7">${item.getlogin()}</td>
														<td class="body-item mbr-fonts-style display-7"><form
																action="not_implemented" method="get">
																<input type="hidden" name="group_id"
																	value="${item.getId()}" />
																<button type="submit"
																	class="btn btn-sm btn-black-outline display-4">Меню
																	группы</button>
															</form></td>
													</tr>
												</tbody>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div id="tab3" class="tab-pane" role="tabpanel">
							<div class="row">
								<div class="col-md-12">
									<p class="mbr-text py-5 mbr-fonts-style display-7">Тут
										будут приглашения</p>
								</div>
							</div>
						</div>
						<div id="tab4" class="tab-pane" role="tabpanel">
							<div class="row">
								<div class="col-md-12">
									<p class="mbr-text py-5 mbr-fonts-style display-7">
										Mobirise дает Вам полную свободу действий в разработке
										веб-сайтов. Mobirise - Ваше идеальное начало!</p>
								</div>
							</div>
						</div>
						<div id="tab5" class="tab-pane" role="tabpanel">
							<div class="row">
								<div class="col-md-12">
									<p class="mbr-text py-5 mbr-fonts-style display-7">
										Экспортируйте Ваш сайт на свой компьютер, любые FTP-сервера,
										включая Amazon, Google Drive, GitHub и другие. Не
										ограничивайте себя в выборе хостинговой платформы!</p>
								</div>
							</div>
						</div>
						<div id="tab6" class="tab-pane" role="tabpanel">
							<div class="row">
								<div class="col-md-12">
									<p class="mbr-text py-5 mbr-fonts-style display-7">
										Mobirise является одним из самых понятных и логичных
										конструкторов - просто перетащите все необходимые элементы на
										страницу, напишите контент и измените стили так, как Вам
										захочется!</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section once="" class="cid-qSjkwZtqWl mbr-reveal" id="footer7-z">
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
	<script src="assets/mbr-tabs/mbr-tabs.js"></script>
	<script src="assets/theme/js/script.js"></script>
	<input name="animation" type="hidden">
</body>
</html>