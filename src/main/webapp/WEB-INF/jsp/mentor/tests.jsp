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
	<c:import url="header.jsp"></c:import>
	<section class="section-table cid-qR017JJDq7" id="table1-t">
		<div class="container container-table">
			<h3
				class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
				<div class="mbr-section-btn text-center pt-4">
					<form action="MainServlet" method="get">
						<button type="submit"
							class="btn btn-sm btn-black-outline display-4" name="action"
							value="switch_create_test">Создать тест</button>
						<button type="submit"
							class="btn btn-sm btn-black-outline display-4" name="action"
							value="switch_create_question">Создать вопрос</button>
						<button type="submit"
							class="btn btn-sm btn-black-outline display-4" name="action"
							value="switch_sujest_theme">Предложить тему</button>
					</form>
				</div>
			</h3>
			<div class="table-wrapper">
				<div class="container">
					<div class="row search">
						<div class="col-md-6"></div>
						<div class="col-md-6">
							<form action="MainServlet" method="get">
								<div class="dataTables_filter">
									<label class="searchInfo mbr-fonts-style display-7">Тема:</label>
									<select class="form-control input-sm" name="theme">
										<c:forEach items="${themes}" var="theme">
											<option>${theme}</option>
										</c:forEach>
									</select> <label class="searchInfo mbr-fonts-style display-7">Уровень:</label>
									<select class="form-control input-sm" name="lvl">
										<option>1</option>
										<option>2</option>
										<option>3</option>
									</select>
									<div class="mbr-section-btn text-center pt-4">
										<button type="submit"
											class="btn btn-sm btn-black-outline display-4" name="action"
											value="search_test">Искать</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

				<div class="container scroll">
					<table class="table isSearch" cellspacing="0">
						<thead>
							<tr class="table-heads ">
								<th class="head-item mbr-fonts-style display-7">ID</th>
								<th class="head-item mbr-fonts-style display-7">Тема</th>
								<th class="head-item mbr-fonts-style display-7">Уровень</th>
								<th class="head-item mbr-fonts-style display-7">Количество
									вопросов</th>
								<th class="head-item mbr-fonts-style display-7">Действия</th>
							</tr>
						</thead>
						<c:forEach items="${tests}" var="test">
							<tbody>
								<tr>
									<td class="body-item mbr-fonts-style display-7">${test.getId()}</td>
									<td class="body-item mbr-fonts-style display-7">${test.getTheme()}</td>
									<td class="body-item mbr-fonts-style display-7">${test.getLvl()}</td>
									<td class="body-item mbr-fonts-style display-7">${test.getQuestions().size()}</td>
									<td class="body-item mbr-fonts-style display-7"><form
											action="MainServlet" method="get">
											<input type="hidden" name="test_id" value="${test.getId()}" />
											<button type="submit"
												class="btn btn-sm btn-black-outline display-4" name="action"
												value="start_test">Пройти</button>
										</form></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
	</section>
	<c:import url="footer.jsp"></c:import>
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