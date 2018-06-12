<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- Данный сайт сделан с помощью конструктора Mobirise v4.6.5, https://mobiriz.store -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Бесплатный конструктор сайтов Mobirise">
<title><spring:message code="create_question" /></title>
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
	<c:import url="header.jsp"></c:import>
	<section class="mbr-section form1 cid-qRmFQ9BvrB" id="form1-w">




		<div class="container">
			<div class="row justify-content-center">
				<div class="title col-12 col-lg-8">
					<h2
						class="mbr-section-title align-center pb-3 mbr-fonts-style display-2">
						<spring:message code="create_your_question" />
					</h2>
					<h3
						class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">
						<spring:message code="create_your_question_msg" />
					</h3>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row justify-content-center">
				<div class="media-container-column col-lg-8">
					<form class="mbr-form" action="sujest_question" method="post">
						<div class="row row-sm-offset">
							<div class="col-md-4 multi-horizontal">
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7"><spring:message
											code="theme" /></label> <select class="form-control input-sm"
										name="theme">
										<c:forEach items="${themes}" var="theme">
											<option>${theme}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-md-4 multi-horizontal">
								<div class="form-group">
									<label class="form-control-label mbr-fonts-style display-7"><spring:message
											code="lvl" /></label> <select class="form-control input-sm"
										name="lvl">
										<option>1</option>
										<option>2</option>
										<option>3</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<h3
								class="mbr-section-subtitle align-center mbr-light pb-3 mbr-fonts-style display-5">
								<spring:message code="link1" /> <a
									target="_blank" href="http://ipic.su/"><spring:message code="link2" /></a><spring:message code="link3" />
							</h3>
							<input type="text" class="form-control" name="image">
						</div>
						<div class="form-group">
							<label class="form-control-label mbr-fonts-style display-7"><spring:message
									code="question_text" /></label>
							<textarea type="text" class="form-control" name="text" rows="7"></textarea>
						</div>
						<div class="row row-sm-offset">
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"><spring:message
										code="correct_answer" /></label> <input type="text"
									class="form-control" name="correct_answer" required="">
							</div>
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"><spring:message
										code="another_answer" /></label> <input type="text"
									class="form-control" name="answer1" required="">
							</div>
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"><spring:message
										code="another_answer" /></label> <input type="text"
									class="form-control" name="answer2" required="">
							</div>
							<div class="form-group">
								<label class="form-control-label mbr-fonts-style display-7"><spring:message
										code="another_answer" /></label> <input type="text"
									class="form-control" name="answer3" required="">
							</div>
						</div>
						<span class="input-group-btn">
							<button type="submit"
								class="btn btn-form btn-black-outline display-4"><spring:message code="sujest_question" /></button>
						</span>
					</form>
				</div>
			</div>
		</div>
	</section>

	<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
		<div class="container">
			<div class="media-container-row align-center mbr-white">
				<div class="row row-copirayt">
					<p>
						<a href="?lang=en">EN </a><a href="?lang=ru_RU"> RU</a>
					</p>
					<p
						class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
						<spring:message code="mobirise" />
					</p>
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
	<script src="assets/formoid/formoid.min.js"></script>


	<input name="animation" type="hidden">
</body>
</html>