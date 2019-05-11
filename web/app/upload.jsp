<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >

	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">

		<title>file manager</title>

		<!-- Custom fonts for this template -->
		<link href="<%=request.getContextPath() %>/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
		<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="<%=request.getContextPath() %>/css/sb-admin-2.min.css" rel="stylesheet">

		<!-- Custom styles for this page -->
		<link href="<%=request.getContextPath() %>/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

		<script src="<%=request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$('input[id=lefile]').change(function() {
					$('#photoCover').val($(this).val());
					
				});

			});
		</script>
		<style type="text/css">
			.cqrow {
				margin: 2.3em 0;
			}
			
			.cqa {
				color: rgb(58, 97, 208) !important;
				width: 10em;
			}
			
			.cqa:hover {
				color: white !important;
			}
			
			.cqdiv1 {
				margin-bottom: 2em;
			}
			
			tr:hover {
				background: #fbfbfb;
				font-weight: bold;
			}
		</style>

	</head>

	<body id="page-top" style="background-color:#f8f9fc ;">

		<!-- Page Wrapper -->
		<div id="wrapper">

			<div id="content-wrapper" class="d-flex flex-column">

				<!-- Main Content -->
				<div id="content">

					<!-- Begin Page Content -->
					<div class="container">
						<font color="red">${message }</font>
						<br><br>
						
						<!-- DataTales Example -->
						<div class="card shadow mb-5">
							<div class="card-header py-3">
								<h6 class="m-0 font-weight-bold text-primary"><i class="fas fa-fw fa-table"></i>文件上传</h6>
							</div>
							<div class="card-body">
								<div class=" cqdiv1 ">
								<form action="<%= response.encodeURL(request.getContextPath()+"/FileUploadServlet")%>" method="post" enctype="multipart/form-data" id="upload">
									<div class="row ">
										<div class="offset-sm-1">
											<i class="fas fa-fw fa-folder" style="font-size: 3em;"></i>
										</div>
										<div class="col-sm-1 ">
											<p style="line-height: 3em;text-align: center;">文件上传</p>
										</div>
									</div>
									<div class="row cqdiv1">

										<div class="offset-sm-2 col-sm-7 ">
											<input name="file1" id="lefile" type="file" style="display:none">
											<input id="photoCover" class="form-control " type="text" />
										</div>
										<div class=" col-sm-1 ">
											<a class="btn btn-outline-primary cqa " onclick="$('input[id=lefile]').click();">浏览</a>
										</div>
									</div>
									<div class="row cqrow ">
										<div class="col-sm-7 offset-sm-2">
											<input class="form-control"  name="desc1" type="text" placeholder="实验描述">
										</div>
										<div class="col-sm-2 ">
											<a href="javascript:;" onclick="doucument:upload.submit()"class="btn btn-outline-primary cqa " >上传</a>
										</div>
									</div>
								</form>
								</div>
								<hr />
							</div>
						</div>

					</div>
					<!-- /.container-fluid -->

				</div>
				<!-- End of Main Content -->


			</div>
			<!-- End of Content Wrapper -->

		</div>
		<!-- End of Page Wrapper -->
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top">
			<i class="fas fa-angle-up"></i>
		</a>

		<!-- Bootstrap core JavaScript-->
		<script src="<%=request.getContextPath() %>/vendor/jquery/jquery.min.js"></script>
		<script src=<%=request.getContextPath() %>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

		<!-- Core plugin JavaScript-->
		<script src="<%=request.getContextPath() %>/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Custom scripts for all pages-->
		<script src="<%=request.getContextPath() %>/js/sb-admin-2.min.js"></script>

		<!-- Page level plugins -->
		<script src="<%=request.getContextPath() %>/vendor/datatables/jquery.dataTables.min.js"></script>
		<script src="<%=request.getContextPath() %>/vendor/datatables/dataTables.bootstrap4.min.js"></script>

		<!-- Page level custom scripts -->
		<script src="<%=request.getContextPath() %>/js/demo/datatables-demo.js"></script>

	</body>

</html>
