<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>查看公告</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-fluid">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md1">

				</div>
				
				<div class="layui-col-md10 layui-text">
					<table class="layui-table" lay-data="">
						<thead>
							<tr>
								<th lay-data="{checkbox:true, fixed:'left'}" rowspan="2"></th>
								<th lay-data="{field:'ac_id',width: 80}" rowspan="2">公告id</th>
								<th lay-data="{field:'ac_content'}" rowspan="2">公告内容</th>
								<th lay-data="{field:'ac_time',width: 200}" rowspan="2">发布时间</th>
								<th lay-data="{field: 'operation',width: 100}" rowspan="2">操作</th>
							</tr>
						</thead>
						<tbody>
							<#if announcements??>
							    <#if (announcements?size>0)>
							        <#list announcements as ac>
							            <tr>
                                            <td></td>
                                            <td>${ac.id}</td>
                                            <td>${ac.content}</td>
                                            <td>${ac.time}</td>
                                            <td>
                                                <button class="layui-btn layui-btn-danger layui-btn-xs" onclick="del_ac('${ac.id}')">删除</button>
                                            </td>
                                        </tr>
							        </#list>
							    </#if>
							</#if>
						</tbody>
					</table>
				</div>
				<div class="layui-col-md1">

				</div>
			</div>
		</div>
		
		<script>
			var lyr;
			layui.use(['table', 'layer'], function() {
				var table = layui.table,
					layer=layui.layer;
					
				lyr = layer;
			});
			
			function del_ac(acid) {
				lyr.confirm('确认删除？', {
					btn: ['是', '否'] //按钮
				}, function() {
					$.post("/deleteacm.do",{acid:acid},function (data) {
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