<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>角色管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-fluid">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md4">

				</div>
				<div class="layui-col-md5 layui-text">
					<table class="layui-table" lay-data="">
						<thead>
							<tr>
								<th lay-data="{checkbox:true, fixed:'left'}" rowspan="2"></th>
								<th lay-data="{field:'role_id',width: 80}" rowspan="2">角色id</th>
								<th lay-data="{field:'role_name'}" rowspan="2">角色名</th>
								<th lay-data="{field:'isdelte'}" rowspan="2">是否删除</th>
								<th lay-data="{field: 'operation'}" rowspan="2">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td></td>
								<td>1</td>
								<td>customer</td>
								<td>是</td>
								<td>
									<button onclick="del_name()" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
									<button onclick="edit_name()" class="layui-btn layui-btn-warm layui-btn-xs">修改</button>
								</td>
							</tr>
						</tbody>
					</table>
					<button id='role_add' class="layui-btn layui-btn-xs">添加</button>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			var lyr;
			layui.use(['table', 'layer'], function() {
				var table = layui.table,
					$ = layui.jquery,
					layer = layui.layer;

				lyr = layer;
				$("#role_add").on("click", function() {
					layer.open({
						type: 2,
						title: '',
						shadeClose: true,
						shade: false,
						maxmin: false, //开启最大化最小化按钮
						area: ['600px', '300px'],
						content: '//127.0.0.1:8020/freedom_talk2/ftl/bg_role_add.html'
					});
				});

			});

			function edit_name() {
				lyr.open({
					type: 2,
					title: '',
					shadeClose: true,
					shade: false,
					maxmin: false, //开启最大化最小化按钮
					area: ['600px', '300px'],
					content: '//127.0.0.1:8020/freedom_talk2/ftl/bg_role_edit.html'
				});
			}

			function del_name() {
				lyr.confirm('确认删除？', {
					btn: ['是', '否'] //按钮
				}, function() {
					layer.msg('删除成功', {
						icon: 1
					});
				}, function() {
					layer.msg('取消成功', {
						icon: 1
					});
				});
			}
		</script>
	</body>

</html>