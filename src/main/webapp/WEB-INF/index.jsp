<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html >
<head>
  <!-- Данный сайт сделан с помощью конструктора Mobirise v4.6.5, https://mobiriz.store -->
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <title>Home</title>
  <link rel="stylesheet" href="assets/web/assets/mobirise-icons/mobirise-icons.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-grid.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap-reboot.min.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/animatecss/animate.min.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>
<section class="menu cid-qOgR2eKv8N" once="menu" id="menu1-0">

    

    <nav class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm bg-color transparent">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <div class="hamburger">
                <span></span>
                <span></span>
                <span></span>
                <span></span>
            </div>
        </button>
        <div class="menu-logo">
            <div class="navbar-brand">
                
                <span class="navbar-caption-wrap"><a class="navbar-caption text-white display-4" href="">TEST YOURSELF</a></span>
            </div>
        </div>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav nav-dropdown nav-right" data-app-modern-menu="true"><li class="nav-item">
                    <a class="nav-link link text-white display-4" href=""><span class="mbri-home mbr-iconfont mbr-iconfont-btn" style="color: rgb(255, 255, 255);"> Главная</span>
                        </a>
                </li><li class="nav-item"><a class="nav-link link text-white display-4" href=""><span class="mbri-search mbr-iconfont mbr-iconfont-btn" style="color: rgb(255, 255, 255);"> Тесты</span>
                        </a></li><li class="nav-item"><a class="nav-link link text-white display-4" href=""><span class="mbri-italic mbr-iconfont mbr-iconfont-btn" style="color: rgb(255, 255, 255);"> О проекте</span>
                        </a></li><li class="nav-item"><a class="nav-link link text-white display-4" href=""><span class="mbri-video mbr-iconfont mbr-iconfont-btn" style="color: rgb(255, 255, 255);"> Войти</span>
                        </a></li>
                <li class="nav-item">
                    <a class="nav-link link text-white display-4" href=""><span class="mbri-sites mbr-iconfont mbr-iconfont-btn" style="color: rgb(255, 255, 255);"> Регистрация</span>
                        </a>
                </li></ul>
            
        </div>
    </nav>
</section>

<section class="mbr-section article content10 cid-qOgStkHfc1" id="content10-6">
    
    <div class="container">
        <div class="inner-container" style="width: 83%;">
            <hr class="line" style="width: 27%;">
            <div class="section-text align-center mbr-white mbr-fonts-style display-5">
                    Текст о проекте бла-бла-бла
                </div>
            <hr class="line" style="width: 27%;">
        </div>
    </div>
</section>

<section class="cid-qOgRkNe2xq" id="pricing-tables1-3">
    <div class="container">
        <div class="media-container-row">


<c:forEach items="${list}" var="item">
            <div class="plan col-12 mx-2 my-2 justify-content-center col-lg-3">
                <div class="plan-header text-center pt-5">
                    <h3 class="plan-title mbr-fonts-style display-5">
                    ID теста<br>
                        ${item.getId()}
                    </h3>
                    <div class="plan-price">
                    <h3 class="plan-title mbr-fonts-style display-5">
                    Вопросов
                    </h3>
                        <span class="price-figure mbr-fonts-style display-1">
                              ${item.getQuestions().size()}</span>
                    </div>
                </div>
                <div class="plan-body pb-5">
                    <div class="plan-list align-center">
                        <ul class="list-group list-group-flush mbr-fonts-style display-7">
                        <li class="list-group-item">
                                Тема
                            </li>
                            <li class="list-group-item">
                                ${item.getTheme()}
                            </li>
                            
                        </ul>
                    </div>
                    <form action="MainServlet" method="get">
                    <div class="mbr-section-btn text-center pt-4"><a href="http://localhost:8080/testyourself/MainServlet?action=start_test&test_id=${item.getId()}" class="btn btn-black-outline display-4">Пройти тест</a></div>
                </form>
                </div>
            </div>
</c:forEach>
        </div>
    </div>
</section>

<section class="counters1 counters cid-qOgRnHk59K" id="counters1-4">
    <div class="container">
        <h2 class="mbr-section-title pb-3 align-center mbr-fonts-style display-2">
            Счетчики
        </h2>
        

        <div class="container pt-4 mt-2">
            <div class="media-container-row">
                <div class="card p-3 align-center col-12 col-md-6 col-lg-4">
                    <div class="panel-item p-3">
                        <div class="card-img pb-3">
                            <span class="mbr-iconfont mbri-users" style="color: rgb(35, 35, 35);"></span>
                        </div>

                        <div class="card-text">
                            <h3 class="count pt-3 pb-3 mbr-fonts-style display-2">
                                  100
                            </h3>
                            
                            <p class="mbr-content-text mbr-fonts-style display-7">
                                текст
                            </p>
                        </div>
                    </div>
                </div>


                <div class="card p-3 align-center col-12 col-md-6 col-lg-4">
                    <div class="panel-item p-3">
                        <div class="card-img pb-3">
                            <span class="mbr-iconfont mbri-question" style="color: rgb(35, 35, 35);"></span>
                        </div>
                        <div class="card-text">
                            <h3 class="count pt-3 pb-3 mbr-fonts-style display-2">
                                  ${question_count}
                            </h3>
                            
                            <p class="mbr-content-text mbr-fonts-style display-7">
                                    Вопросов
                            </p>
                        </div>
                    </div>
                </div>

                <div class="card p-3 align-center col-12 col-md-6 col-lg-4">
                    <div class="panel-item p-3">
                        <div class="card-img pb-3">
                            <span class="mbr-iconfont mbri-like" style="color: rgb(35, 35, 35);"></span>
                        </div>
                        <div class="card-text">
                            <h3 class="count pt-3 pb-3 mbr-fonts-style display-2">
                                  300
                            </h3>
                            
                            <p class="mbr-content-text mbr-fonts-style display-7">
                                    текст
                            </p>
                        </div>
                    </div>
                </div>


                
            </div>
        </div>
   </div>
</section>

<section once="" class="cid-qOgRxEXpQA mbr-reveal" id="footer7-5">
    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-copirayt">
                <p class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
                    © Copyright 2017 Mobirise - Все права защищены
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
  
  
  <input name="animation" type="hidden">
  </body>
</html>