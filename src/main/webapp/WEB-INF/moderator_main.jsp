<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>user_main</title>
<link rel="stylesheet"
	href="assets/web/assets/mobirise-icons/mobirise-icons.css">
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/socicon/css/styles.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
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
	<section class="mbr-section article content10 cid-qPBrzx6fTJ"
		id="content10-i">



		<div class="container">
			<div class="inner-container" style="width: 83%;">
				<hr class="line" style="width: 27%;">
				<div
					class="section-text align-center mbr-white mbr-fonts-style display-5">
					Какой-нибудь текст</div>
				<hr class="line" style="width: 27%;">
			</div>
		</div>
	</section>
	<section class="cid-qPBrzyztHT" id="pricing-tables1-k">
		<div class="container">
			<div class="media-container-row">
			
				<div class="plan col-12 mx-2 my-2 justify-content-center col-lg-3">
					<div class="plan-header text-center pt-5">
						<h3 class="plan-title mbr-fonts-style display-5">
							Новые вопросы
						</h3>
						<div class="plan-price">
							<span class="price-figure mbr-fonts-style display-1">
								${new_questions}</span>
						</div>
					</div>
					<div class="plan-body pb-5">
						<form action="MainServlet" method="get">
							<div class="mbr-section-btn text-center pt-4">
								<a
									href="http://localhost:8080/testyourself/MainServlet?action=moderate_questions"
									class="btn btn-black-outline display-4">Перейти</a>
							</div>
						</form>
					</div>
				</div>
				
				<div class="plan col-12 mx-2 my-2 justify-content-center col-lg-3">
					<div class="plan-header text-center pt-5">
						<h3 class="plan-title mbr-fonts-style display-5">
							Новые тесты
						</h3>
						<div class="plan-price">
							<span class="price-figure mbr-fonts-style display-1">
								${new_tests}</span>
						</div>
					</div>
					<div class="plan-body pb-5">
						<form action="MainServlet" method="get">
							<div class="mbr-section-btn text-center pt-4">
								<a
									href="http://localhost:8080/testyourself/MainServlet?action=moderate_tests"
									class="btn btn-black-outline display-4">Перейти</a>
							</div>
						</form>
					</div>
				</div>
				
				<div class="plan col-12 mx-2 my-2 justify-content-center col-lg-3">
					<div class="plan-header text-center pt-5">
						<h3 class="plan-title mbr-fonts-style display-5">
							Новые темы
						</h3>
						<div class="plan-price">
							<span class="price-figure mbr-fonts-style display-1">
								${new_theme}</span>
						</div>
					</div>
					<div class="plan-body pb-5">
						<form action="MainServlet" method="get">
							<div class="mbr-section-btn text-center pt-4">
								<a
									href="http://localhost:8080/testyourself/MainServlet?action=moderate_theme"
									class="btn btn-black-outline display-4">Перейти</a>
							</div>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<section once="" class="cid-qPBrzBKwj8 mbr-reveal" id="footer7-m">
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
	<script src="assets/theme/js/script.js"></script>


	<input name="animation" type="hidden">
</body>
</html>