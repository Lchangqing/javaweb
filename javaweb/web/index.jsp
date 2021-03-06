<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Login</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
									</div>

									<%
										Object msg = request.getAttribute("message");
										if (msg != null) {
									%>
									<div class="card mb-2  ">
										<div class="px-3 py-1 bg-gradient-primary text-white"><%= msg %></div>
									</div>
									<%
										}
									%>
									<%
										Object msg2 = session.getAttribute("msg2");
										if (msg2 != null) {
									%>
									<div class="card mb-2  ">
										<div class="px-3 py-1 bg-gradient-primary text-white"><%= msg2 %></div>
									</div>
									<%
										}
									%>
									<% System.out.println("index.jsp:"+request.getSession().getId()); %>
									<form class="user" action="<%= response.encodeURL(request.getContextPath()+"/query.go")%>" method="post" id="log">
										<div class="form-group">
											<input type="text" name="name" class="form-control form-control-user"
												id="exampleInputEmail" aria-describedby="emailHelp"
												placeholder="user name:tomcat">
										</div>
										<div class="form-group">
											<input type="password" name="passwd" class="form-control form-control-user"
												id="exampleInputPassword" placeholder="Password:123456">
										</div>
										<div class="form-group">
											<input type="text" name="CHECK_CODE_PARAM_NAME" class="form-control form-control-user"
												id="exampleInputPassword" placeholder="please enter the verification code">
										</div>
										<img alt="" src="<%= response.encodeURL(request.getContextPath()+"/validateColorServlet")%>"> 
										<div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input type="checkbox" class="custom-control-input"
													id="customCheck"> <label
													class="custom-control-label" for="customCheck">Remember
													Me</label>
											</div>
										</div>
										<a href="javascript:;" onclick="doucument:log.submit()"
											class="btn btn-primary btn-user btn-block"> Login </a>
									</form>
									<hr>
									<div class="text-center">
										<a class="small" href="<%= response.encodeURL(request.getContextPath()+"/register.jsp")%>">Create an Account!</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

</body>

</html>