<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<%@ include file="/WEB-INF/jsp/bo/common/header.jsp" %>
<script type="text/javascript"> 
$(function(){
	
	$("#loginForm").submit(function(e) {
		e.preventDefault();
		
		console.log($(this).serialize())
		
		//로그인 정보 날리기
		$.ajax({
		      type: "POST",
		      url: "/submitLoginFrm",
		      data: $(this).serialize()
		}).done( function(data){
			if (data == 'SUCCESS') {
			  
			} else {
			  toastr.error('aaaa');
			}
		});
		
	})
	
	$(function () {
		  $('#loginForm').validate({
		    rules: {
			    id: {
			    	required: true
			    },
			    password: {
				    required: true
				}
		    },
		    messages: {
		    	id: {
				      required: "아이디를 입력하세요"
			    },
			    password: {
				      required: "비밀번호를 입력하세요"
			    }
		    },
		    errorElement: 'span',
		    errorPlacement: function (error, element) {
		      error.addClass('invalid-feedback');
		      element.closest('.form-group').append(error);
		    },
		    highlight: function (element, errorClass, validClass) {
		      $(element).addClass('is-invalid');
		    },
		    unhighlight: function (element, errorClass, validClass) {
		      $(element).removeClass('is-invalid');
		    }
		  });
		});
	
	
})

</script>
<body class="hold-transition login-page">

<div class="login-box">
  <!-- /.login-logo -->
  <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="../../index2.html" class="h1"><h5><b>TheNEW지구촌교회</b></h5></a>
    </div>
    <div class="card-body">

      <form id="loginForm" method="post" onsubmit="return false;">
      
        <div class="form-group">
          <input type="text" name="id" class="form-control" placeholder="사용자 이름 또는 이메일">
        </div>
        
        <div class="form-group">
          <input type="password" name="password" class="form-control" placeholder="비밀번호">
        </div>
        
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">Sign In</button>
          </div>
          <!-- /.col -->
        </div>
        
      </form>
<!-- 	  구글로그인 버튼 -->
      <!-- <div class="social-auth-links text-center mt-2 mb-3">
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google-plus mr-2"></i> Sign in using Google+
        </a>
      </div> -->
      <!-- /.social-auth-links -->

      <p class="mb-1">
        <a href="#">I forgot my password</a>
      </p>
      <p class="mb-0">
        <a href="#" class="text-center">Register</a>
      </p>
    </div>
    <!-- /.card-body -->
  </div>
  <!-- /.card -->
</div>
<!-- /.login-box -->

<%@ include file="/WEB-INF/jsp/bo/common/footer.jsp" %>
</body>
</html>
