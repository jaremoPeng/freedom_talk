<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>权限管理</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-fluid">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md2">

				</div>
				<div class="layui-col-md7 layui-text">
					<table class="layui-table" lay-data="">
						<thead>
							<tr>
								<th lay-data="{checkbox:true, fixed:'left'}" rowspan="2"></th>
								<th lay-data="{field:'perm_id',width: 80}" rowspan="2">权限id</th>
								<th lay-data="{field:'perm_name'}" rowspan="2">权限名</th>
								<th lay-data="{field:'perm_url',width: 200}" rowspan="2">地址</th>
								<th lay-data="{field:'perm_sign',width: 100}" rowspan="2">权限标识</th>
								<th lay-data="{field:'isdelete'}" rowspan="2">是否删除</th>
								<th lay-data="{field: 'operation',width: 150}" rowspan="2">操作</th>
							</tr>
						</thead>
						<tbody>
							<#if permissionList??>
								<#if (permissionList?size>0)>
									<#list permissionList as perm>
										<tr>
                                            <td></td>
                                            <td>${perm.id}</td>
                                            <td>${perm.name}</td>
                                            <td>${perm.url}</td>
                                            <td>${perm.sign}</td>
                                            <td>
												<#if perm.isDelete==0>
													是
													<#else >
												    	否
												</#if>
											</td>
                                            <td>
                                                <!--<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
                                                <a  class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>-->
                                                <button onclick="del_perm('${perm.id}')" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
                                                <button onclick="edit_perm('${perm.id}')" class="layui-btn layui-btn-warm layui-btn-xs">修改</button>
                                            </td>
                                        </tr>
									</#list>
								</#if>
							</#if>
						</tbody>
					</table>
					<button class="layui-btn layui-btn-xs" onclick="add_perm()">添加</button>
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

            function add_perm() {
                lyr.open({
                    type: 2,
                    title: '',
                    shadeClose: true,
                    shade: false,
                    maxmin: false, //开启最大化最小化按钮
                    area: ['600px', '300px'],
                    content: '/gotoBgPermAdd.do'
                });
            }

            function edit_perm(permid) {
                lyr.open({
                    type: 2,
                    title: '',
                    shadeClose: true,
                    shade: false,
                    maxmin: false, //开启最大化最小化按钮
                    area: ['600px', '300px'],
                    content: '/gotoBgPermEdit.do?permid='+permid
                });
            }

            function del_perm(permid) {
                lyr.confirm('确认删除？', {
                    btn: ['是', '否'] //按钮
                }, function() {
                    $.post("/delPerm.do",{permid:permid},function (data) {
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