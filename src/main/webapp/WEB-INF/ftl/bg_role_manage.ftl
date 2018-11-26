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
						<#if roles??>
						    <#if (roles?size>0)>
						        <#list roles as role>
						            <tr>
                                        <td></td>
                                        <td>${role.id}</td>
                                        <td>${role.name}</td>
                                        <td><#if role.isDelete==0>
                                            是
											<#else>
											否
                                        </#if></td>
                                        <td>
                                            <button onclick="del_role('${role.id}')" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
                                            <button onclick="edit_role('${role.id}')" class="layui-btn layui-btn-warm layui-btn-xs">修改</button>
                                        </td>
                                    </tr>
						        </#list>
						    </#if>
						</#if>
						</tbody>
					</table>
					<button class="layui-btn layui-btn-xs" onclick="add_role()">添加</button>
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
			});

            function add_role() {
                lyr.open({
                    type: 2,
                    title: '',
                    shadeClose: true,
                    shade: false,
                    maxmin: false, //开启最大化最小化按钮
                    area: ['600px', '300px'],
                    content: '/gotoBgRoleAdd.do'
                });
            }

			function edit_role(roleid) {
				lyr.open({
					type: 2,
					title: '',
					shadeClose: true,
					shade: false,
					maxmin: false, //开启最大化最小化按钮
					area: ['600px', '300px'],
					content: '/gotoBgRoleEdit.do?roleid='+roleid
				});
			}

			function del_role(roleid) {
				lyr.confirm('确认删除？', {
					btn: ['是', '否'] //按钮
				}, function() {
				    $.post("/delRole.do",{roleid:roleid},function (data) {
						if(data.length==0){
                            lyr.msg('删除成功', {
                                icon: 1
                            });
						}else{
                            lyr.msg('删除失败', {
                                icon: 2
                            });
						}
                    });
				}, function() {
                    lyr.msg('取消成功', {
						icon: 1
					});
				});
			}
		</script>
	</body>

</html>