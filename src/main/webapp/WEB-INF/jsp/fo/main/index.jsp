<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%@ include file="/WEB-INF/jsp/fo/common/header.jsp" %>
<script type="text/javascript"> 
$(function(){
	
	
})

function enquiryForm_submit(this_form, data) {
    $.ajax({
      type: "POST",
      url: "/insertEnquiry",
      data: data
    }).done( function(data){
    	
      if (data == 'SUCCESS') {
    	this_form.find('.loading').slideUp();
        this_form.find('.sent-message').slideDown();
        this_form.find("input:not(input[type=submit]), textarea").val('');
      } else {
    	  this_form.find('.loading').slideUp();
    	  
      }
    });
}
</script>
<body>
<%@ include file="/WEB-INF/jsp/fo/common/gnb.jsp" %>
 

  <!-- ======= Hero Section ======= -->
  <section id="hero">
    <div class="hero-container" data-aos="fade-up" data-aos-delay="150">
      <h1>기뻐하라. 기도하라. 감사하라.</h1>
      <h2>이는 그리스도 예수 안에서 너희를 향하신 하나님의 뜻이니라</h2>
      <h2>데살로니가전서 5장 16~18절</h2>
      <div class="d-flex">
        <a href="#about" class="btn-get-started scrollto">둘러보기</a>
        <a href="https://www.youtube.com/watch?v=udUG5nk8hFA" class="venobox btn-watch-video" data-vbtype="video" data-autoplay="true"> Watch Video <i class="icofont-play-alt-2"></i></a>
      </div>
    </div>
  </section>
  <!-- End Hero -->

  <main id="main">
    <!-- ======= 예배안내 ======= -->
    <section id="about" class="contact">
	    <div class="container" data-aos="fade-up">
	    	 <div class="section-title" style="padding-bottom: 0;">
		       <p style="text-align: center;">예배안내</p>
		     </div>
	    </div>
    </section>
    <!-- End 예배안내 -->

    <!-- ======= About Boxes Section ======= -->
    <section id="about-boxes" class="about-boxes">
      <div class="container" data-aos="fade-up">

        <div class="row">
          <div class="col-lg-3 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
            <div class="card">
              <img src="/resources/images/cross.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
                <i class="ri-home-heart-line"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="javascript:void(0)">주일 예배</a></h5>
                <p class="card-title">
                <br>
                1부 : 오전 10:00 ~ 11:00
                <br>
                <br>
                2부 : 오후 12:00 ~ 13:00
                </p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="200">
            <div class="card">
              <img src="/resources/images/cross.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
                <i class="ri-book-open-fill"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="javascript:void(0)">수요 예배</a></h5>
                <p class="card-title">
                <br>
                <br>
                            오전 10:30 ~ 12:00
                <br>
                <br>
                <br>
                </p>
              </div>
            </div>
          </div>
          <div class="col-lg-3 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="300">
            <div class="card">
              <img src="/resources/images/cross.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
               <i class="ri-hand-heart-fill"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="javascript:void(0)">금요 기도예배</a></h5>
                <p class="card-title">온라인 성경공부</P>
                 <br>
                <p class="card-title">
                1부 : 오전 11:00
                <br>
                2부 : 오후 12:00
                </p>
              </div>
            </div>
          </div>
           <div class="col-lg-3 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="300">
            <div class="card">
              <img src="/resources/images/cross.jpg" class="card-img-top" alt="...">
              <div class="card-icon">
                <i class="ri-heart-2-line"></i>
              </div>
              <div class="card-body">
                <h5 class="card-title"><a href="javascript:void(0)">Sunday 목장모임 </a></h5>
                <p class="card-title">교육부예배 (초,중,고)</P>
                <p class="card-title">
                <br>
                            오전 11:00 ~ 11:50
                <br>
                </p>
              </div>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End About Boxes Section -->

    <!-- ======= Features Section ======= -->
    <section id="features" class="features">
      <div class="container" data-aos="fade-up">

        <ul class="nav nav-tabs row d-flex">
          <li class="nav-item col-3">
            <a class="nav-link active show" data-toggle="tab" href="#tab-1">
              <i class="ri-gps-line"></i>
              <h4 class="d-none d-lg-block">메뉴 1</h4>
            </a>
          </li>
          <li class="nav-item col-3">
            <a class="nav-link" data-toggle="tab" href="#tab-2">
              <i class="ri-body-scan-line"></i>
              <h4 class="d-none d-lg-block">메뉴 2</h4>
            </a>
          </li>
          <li class="nav-item col-3">
            <a class="nav-link" data-toggle="tab" href="#tab-3">
              <i class="ri-sun-line"></i>
              <h4 class="d-none d-lg-block">메뉴 3</h4>
            </a>
          </li>
          <li class="nav-item col-3">
            <a class="nav-link" data-toggle="tab" href="#tab-4">
              <i class="ri-store-line"></i>
              <h4 class="d-none d-lg-block">메뉴 4</h4>
            </a>
          </li>
        </ul>

        <div class="tab-content">
          <div class="tab-pane active show" id="tab-1">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0">
                <h3>내용 1</h3>
                <p class="font-italic">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                  magna aliqua.
                </p>
                <ul>
                  <li><i class="ri-check-double-line"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="/resources/images/features-1.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>
          <div class="tab-pane" id="tab-2">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0">
                <h3>내용 2</h3>
                <p class="font-italic">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                  magna aliqua.
                </p>
                <ul>
                  <li><i class="ri-check-double-line"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="/resources/images/features-2.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>
          <div class="tab-pane" id="tab-3">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0">
                <h3>내용 3</h3>
                <p class="font-italic">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                  magna aliqua.
                </p>
                <ul>
                  <li><i class="ri-check-double-line"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="/resources/images/features-3.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>
          <div class="tab-pane" id="tab-4">
            <div class="row">
              <div class="col-lg-6 order-2 order-lg-1 mt-3 mt-lg-0">
                <h3>내용 4</h3>
                <p class="font-italic">
                  Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                  magna aliqua.
                </p>
                <ul>
                  <li><i class="ri-check-double-line"></i> Ullamco laboris nisi ut aliquip ex ea commodo consequat.</li>
                </ul>
              </div>
              <div class="col-lg-6 order-1 order-lg-2 text-center">
                <img src="/resources/images/features-4.png" alt="" class="img-fluid">
              </div>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End Features Section -->

    <!-- ======= Services Section ======= -->
    <section id="services" class="services section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>비전과 사명</h2>
          <p>이웃을 향한 열린 교회</p>
        </div>

        <div class="row" data-aos="fade-up" data-aos-delay="200">
          <div class="col-md-6">
            <div class="icon-box">
              <i class="icofont-computer"></i>
              <h4><a href="javascript:void(0)">일치</a></h4>
<!--               <p>은혜와 진리가 일치되는 삶</p> -->
              <h4>은혜와 진리가 일치되는 삶</h4>
            </div>
          </div>
          <div class="col-md-6 mt-4 mt-md-0">
            <div class="icon-box">
              <i class="icofont-chart-bar-graph"></i>
              <h4><a href="javascript:void(0)">나눔</a></h4>
<!--               <p>나눔으로 풍성해지는 삶</p> -->
              <h4>나눔으로 풍성해지는 삶</h4>
            </div>
          </div>
          <div class="col-md-6 mt-4 mt-md-0">
            <div class="icon-box">
              <i class="icofont-image"></i>
              <h4><a href="javascript:void(0)">교제</a></h4>
<!--               <p>함께 웃고, 함께 울고, 함께 감동하는 삶</p> -->
              <h4>함께 웃고, 함께 울고, 함께 감동하는 삶</h4>
            </div>
          </div>
          <div class="col-md-6 mt-4 mt-md-0">
            <div class="icon-box">
              <i class="icofont-settings"></i>
              <h4><a href="javascript:void(0)">기도</a></h4>
<!--               <p>바람을 타고 항해하는 삶</p> -->
              <h4>바람을 타고 항해하는 삶</h4>
            </div>
          </div>
          <div class="col-md-6 mt-4 mt-md-0">
            <div class="icon-box">
              <i class="icofont-earth"></i>
              <h4><a href="javascript:void(0)">사랑</a></h4>
<!--               <p>섭리적 관계를 이루어가는 삶</p> -->
              <h4>섭리적 관계를 이루어가는 삶</h4>
            </div>
          </div>
        </div>

      </div>
    </section><!-- End Services Section -->

    <!-- ======= Portfolio Section ======= -->
    <section id="portfolio" class="portfolio">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Community</h2>
          <p>우리교회 공동체</p>
        </div>

        <div class="row" data-aos="fade-up" data-aos-delay="100">
          <div class="col-lg-12 d-flex justify-content-center">
            <ul id="portfolio-flters">
              <li data-filter="*" class="filter-active">All</li>
              <li data-filter=".filter-pic1">pic1</li>
              <li data-filter=".filter-pic2">pic2</li>
              <li data-filter=".filter-pic3">pic3</li>
            </ul>
          </div>
        </div>

        <div class="row portfolio-container" data-aos="fade-up" data-aos-delay="200">

          <div class="col-lg-4 col-md-6 portfolio-item filter-pic1">
            <img src="/resources/images/portfolio/pic1.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>pic1</h4>
              <p>pic1</p>
              <a href="/resources/images/portfolio/pic1.jpg" data-gall="portfolioGallery" class="venobox preview-link" title="Pic 1"><i class="bx bx-plus"></i></a>
<!--               <a href="portfolio-details.html" class="details-link" title="More Details"><i class="bx bx-link"></i></a> -->
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-pic2">
            <img src="/resources/images/portfolio/pic2.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>pic2</h4>
              <p>pic2</p>
              <a href="/resources/images/portfolio/pic2.jpg" data-gall="portfolioGallery" class="venobox preview-link" title="Pic 2"><i class="bx bx-plus"></i></a>
<!--               <a href="portfolio-details.html" class="details-link" title="More Details"><i class="bx bx-link"></i></a> -->
            </div>
          </div>

          <div class="col-lg-4 col-md-6 portfolio-item filter-pic3">
            <img src="/resources/images/portfolio/pic3.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>pic3</h4>
              <p>pic3</p>
              <a href="/resources/images/portfolio/pic3.jpg" data-gall="portfolioGallery" class="venobox preview-link" title="Pic 3"><i class="bx bx-plus"></i></a>
<!--               <a href="portfolio-details.html" class="details-link" title="More Details"><i class="bx bx-link"></i></a> -->
            </div>
          </div>
          
          <div class="col-lg-4 col-md-6 portfolio-item filter-pic1">
            <img src="/resources/images/portfolio/pic4.jpg" class="img-fluid" alt="">
            <div class="portfolio-info">
              <h4>pic4</h4>
              <p>pic4</p>
              <a href="/resources/images/portfolio/pic4.jpg" data-gall="portfolioGallery" class="venobox preview-link" title="Pic 4"><i class="bx bx-plus"></i></a>
<!--               <a href="portfolio-details.html" class="details-link" title="More Details"><i class="bx bx-link"></i></a> -->
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Portfolio Section -->

    <!-- ======= Team Section ======= -->
    <section id="team" class="team section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Team</h2>
          <p>our team</p>
        </div>

        <div class="row">

          <div class="col-lg-4 col-md-6">
            <div class="member" data-aos="fade-up" data-aos-delay="100">
              <div class="pic"><img src="/resources/images/team/black.jpg" class="img-fluid" alt=""></div>
              <div class="member-info">
                <h4>안철준 담임목사</h4>
                <span>더 뉴 지구촌교회 담임</span>
                <!-- <div class="social">
                  <a href=""><i class="icofont-twitter"></i></a>
                  <a href=""><i class="icofont-facebook"></i></a>
                  <a href=""><i class="icofont-instagram"></i></a>
                  <a href=""><i class="icofont-linkedin"></i></a>
                </div> -->
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6" data-aos="fade-up" data-aos-delay="200">
            <div class="member">
              <div class="pic"><img src="/resources/images/team/black.jpg" class="img-fluid" alt=""></div>
              <div class="member-info">
                <h4>제흥남 담임목사</h4>
                <span>더 뉴 지구촌교회 담임</span>
              </div>
            </div>
          </div>

          <div class="col-lg-4 col-md-6" data-aos="fade-up" data-aos-delay="300">
            <div class="member">
              <div class="pic"><img src="/resources/images/team/black.jpg" class="img-fluid" alt=""></div>
              <div class="member-info">
                <h4>제승준 전도사</h4>
                <span>파트 전도사</span>
              </div>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Team Section -->

    <!-- ======= Contact Section ======= -->
    <section id="contact" class="contact">
      <div class="container" data-aos="fade-up"">

    <div class=" section-title">
        <h2>궁금한 점을 문의주시면, 이메일로 답변드립니다</h2>
        <p>Contact Us</p>
      </div>

      <div class="row">

        <div class="col-lg-6">

          <div class="row">
            <div class="col-md-12">
              <div class="info-box">
                <i class="bx bx-map"></i>
                <h3>오시는 길</h3>
                <p>서울특별시 송파구 오금로 432 (가락동, 삼환상가 3층)</p>
              </div>
            </div>
            <div class="col-md-6">
              <div class="info-box mt-4">
                <i class="bx bx-envelope"></i>
                <h3>Email Us</h3>
                <p>info@thenewjiguchon.com</p>
              </div>
            </div>
            <div class="col-md-6">
              <div class="info-box mt-4">
                <i class="bx bx-phone-call"></i>
                <h3>Call Us</h3>
                <p>02-431-6459</p>
              </div>
            </div>
          </div>

        </div>

        <div class="col-lg-6 mt-4 mt-lg-0">
          <form class="php-email-form" >
            <div class="form-row">
              <div class="col-md-6 form-group">
                <input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="required" data-msg="이름을 입력해 주세요" />
                <div class="validate"></div>
              </div>
              <div class="col-md-6 form-group">
                <input type="email" class="form-control" name="emailAddr" id="email" placeholder="Your Email" data-rule="email" data-msg="이메일 주소를 입력해 주세요" />
                <div class="validate"></div>
              </div>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="required" data-msg="제목을 입력해 주세요" />
              <div class="validate"></div>
            </div>
            <div class="form-group">
              <textarea class="form-control" name="contents" rows="5" data-rule="required" data-msg="내용을 입력해 주세요" placeholder="Message"></textarea>
              <div class="validate"></div>
            </div>
            <div class="mb-3">
              <div class="loading">Loading</div>
              <div class="error-message"></div>
              <div class="sent-message">Your message has been sent. Thank you!</div>
            </div>
            <div class="text-center"><button type="submit" ID="submit">궁금한것 물어보기</button></div>
          </form>
        </div>

      </div>

      </div>
    </section><!-- End Contact Section -->

  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <footer id="footer">

    <div class="container">
      <div class="copyright">
      	서울특별시 송파구 오금로 432 (가락동,  삼환상가 3층) <br/>
      	Tel. +82-02-431-6458| Email. info@thenewjiguchon.com <br>
        &copy; Copyright <strong><span>더 뉴 지구촌교회</span></strong>. All Rights Reserved
      </div>
      <div class="credits">
        <!-- All the links in the footer should remain intact. -->
        <!-- You can delete the links only if you purchased the pro version. -->
        <!-- Licensing information: https://bootstrapmade.com/license/ -->
        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/dewi-free-multi-purpose-html-template/ -->
        Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
      </div>
    </div>
  </footer><!-- End Footer -->

	<%@ include file="/WEB-INF/jsp/fo/common/footer.jsp" %>
</body>

</html>
