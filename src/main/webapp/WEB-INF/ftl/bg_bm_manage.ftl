<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>版主管理</title>
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
				<div class="layui-col-md5 layui-text">
					版主搜索:
					<div class="layui-input-block">
						<!-- 此处搜索不应将普通用户搜索出来 修改用户类型-->
						<input type="text" name="cus_keyword" autocomplete="off" placeholder="请输入用户 (用户名或者邮箱) 进行搜索" class="layui-input">
						<br />
						<button class="layui-btn layui-btn-sm">搜索</button>
					</div>
					<br />

					<div class="layui-card" style="border: 1px solid lightgray;display: none;">
						<div class="layui-card-header">搜索结果: </div>
						<div class="layui-card-body">
							<a href="">
								<img src="../img/uugai.com_1542371006215.png" class="layui-nav-img" style="width: 60px;height: 60px;">
							</a>
							<a href="">Jaremo</a>
						</div>
						&emsp;&emsp;&emsp;&emsp;
						<button class="layui-btn layui-btn-danger layui-btn-sm">禁用此用户</button>
						<button class="layui-btn layui-btn-sm">取消该版主权限</button>
						<br />
						&emsp;&emsp;
					</div>
				</div>
				<div class="layui-col-md3">
					
				</div>
			</div>
		</div>
	</body>
</html>