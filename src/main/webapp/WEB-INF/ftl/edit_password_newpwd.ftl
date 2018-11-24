<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>填写密码</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md4">

				</div>
				<div class="layui-col-md5">
					<div class="layui-card" >
						<div class="layui-card-header">修改密码</div>
						<div class="layui-card-body">
							<form class="layui-form" action="">

								<div class="layui-form-item">
									<label class="layui-form-label">新密码</label>
									<div class="layui-input-inline">
										<input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
									</div>
									<!--<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>-->
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">确认新密码</label>
									<div class="layui-input-inline">
										<input type="password" name="newpwd" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
									</div>
									<!--<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>-->
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
										<button type="reset" class="layui-btn">重置</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

	</body>

</html>