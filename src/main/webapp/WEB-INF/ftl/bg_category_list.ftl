<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>查看分类</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">

				</div>
				<div class="layui-col-md6 layui-text">
					<table class="layui-table" lay-data="{width:600}">
						<thead>
							<tr>
								<th lay-data="{checkbox:true, fixed:'left'}" rowspan="2"></th>
								<th lay-data="{field:'category_id', width:100}" rowspan="2">分类id</th>
								<th lay-data="{field:'category_name', width:120}" rowspan="2">名称</th>
								<th lay-data="{field:'isdelete'}" rowspan="2">是否删除</th>
								<th lay-data="{field: 'operation'}" rowspan="2">操作</th>
							</tr>
						</thead>
						<tbody>
							<#if categoryList??>
							    <#if (categoryList?size>0)>
							        <#list categoryList as category>
							            <tr>
                                            <td></td>
                                            <td>${category.id}</td>
                                            <td>${category.name}</td>
                                            <td>
												<#if category.isDelete==1>
												    否
													<#else >
														是
												</#if>
											</td>
                                            <td>
                                                <button onclick="del_category('${category.id}')" class="layui-btn layui-btn-danger layui-btn-xs">删除</button>
                                                <button onclick="find_back('${category.id}')" class="layui-btn layui-btn-normal layui-btn-xs">找回</button>
                                                <button onclick="edit_category('${category.id}')" class="layui-btn layui-btn-warm layui-btn-xs">修改</button>
                                            </td>
                                        </tr>
							        </#list>
							    </#if>
							</#if>
						</tbody>
					</table>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			var lyr;
			layui.use(['table', 'layer'], function() {
				var table = layui.table,
					layer = layui.layer;

				lyr = layer;
			});

			function del_category(categoryid) {
				lyr.confirm('确认删除？', {
					btn: ['是', '否'] //按钮
				}, function() {
				    $.post('/delCategory.do',{cateid:categoryid},function (data) {
                        if(data.length==0){
                            layer.msg('删除成功', {
                                icon: 1
                            });
						}else{
                            layer.msg('删除失败', {
                                icon: 2
                            });
						}
                    });
				}, function() {
					layer.msg('取消成功', {
						icon: 1
					});
				});
			}

			function find_back(categoryid) {
				lyr.confirm('是否找回？', {
					btn: ['是', '否'] //按钮
				}, function() {
                    $.post('/editCate.do',{cateid:categoryid},function (data) {
                        if(data.length==0){
                            layer.msg('找回成功', {
                                icon: 1
                            });
                        }else{
                            layer.msg('找回失败', {
                                icon: 2
                            });
                        }
                    });
				}, function() {
					layer.msg('取消成功', {
						icon: 1
					});
				});
			}

			function edit_category(categoryid) {
				lyr.open({
					type: 2,
					title: '',
					shadeClose: true,
					shade: false,
					maxmin: false, //开启最大化最小化按钮
					area: ['600px', '300px'],
					content: '/gotoBgCategoryEdit.do?categoryid='+categoryid
				});
			}
		</script>
	</body>

</html>