<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>失败</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>
	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md4">
					<a href="#">页面 5 秒后(自动跳转回首页)...</a>
				</div>
				<div class="layui-col-md5 layui-text">
                    <table class="layui-table" lay-data="">
                        <thead>
							<tr>
								<th lay-data="{field:'reason'}" rowspan="2">失败的原因</th>
							</tr>
                        </thead>
                        <tbody>
							<#if errors??>
								<#list errors as error >
									<tr>
                                        <td>${error}</td>
                                    </tr>
								</#list>
							</#if>

                        </tbody>
                    </table>

				</div>
				<div class="layui-col-md3">
					
				</div>
			</div>
		</div>

	<script>
        layui.use(['table', 'layer'], function() {
            var table = layui.table,
					layer=layui.layer;
        });
        setTimeout("javascript:location.href='index'", 5000);
	</script>
	</body>
</html>
