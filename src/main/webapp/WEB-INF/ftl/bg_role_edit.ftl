<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>角色修改</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="../css/layui.css" />
		<link rel="stylesheet" type="text/css" href="../css/formSelects-v4.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
		<script type="text/javascript" src="../js/formSelects-v4.js" ></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md4">

				</div>
				<div class="layui-col-md5 layui-text">
					<div class="layui-card">
						<div class="layui-card-header">修改角色: </div>

						<div class="layui-card-body">
							<input type="hidden" name="role_id" autocomplete="off" class="layui-input">
							<div class="layui-form-item">
								<label class="layui-form-label">角色名</label>
								<div class="layui-input-block">
									<input type="text" name="category_name" lay-verify="title" autocomplete="off" placeholder="请输入角色名" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">选择权限</label>
								<div class="layui-input-block">
									<!--disabled="disabled"禁选  有疑问? http://sun.faysunshine.com/layui/formSelects-v4/example/example_v4.html -->
									<select name="city" xm-select="selectId">
										<option value="1">北京</option>
										<option value="2">上海</option>
										<option value="3">广州</option>
										<option value="4">深圳</option>
										<option value="5">天津</option>
									</select>
								</div>
							</div>

							&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
							<button class="layui-btn layui-btn-sm">修改</button>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>
		<script type="text/javascript">
			var formSelects = layui.formSelects;
			formSelects.render('selectId');
		</script>
	</body>

</html>