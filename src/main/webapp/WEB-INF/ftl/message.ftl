<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的消息</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>自由说论坛-我的消息</legend>
		</fieldset>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">

				</div>
				<div class="layui-col-md6">
					<div class="layui-card" style="border: 1px solid lightgray;">
						<div class="layui-card-header">系统通知消息: </div>
						<div class="layui-card-body">
							<#if messages??>
							    <#list messages as message>
							        <div>
										<#if message.isRead == 0>
										    <font color="red"><small>未读</small></font>
											<#else >
											 	<font color="limegreen"><small>已读</small></font>
										</#if>
                                        <br>
                                        <img id="msg${message.id}" src="../img/uugai.com_1542371006215.png" class="layui-nav-img" style="width: 40px;height: 40px;">
                                        <hr />
                                    </div>
							    </#list>
							</#if>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			var lyr;
            var cus_id;
			layui.use('layer', function() {
				var $ = layui.jquery,
					layer = layui.layer;

				lyr = layer;

				<#if messages ??>
					<#list messages as message>
					cus_id='${message.customer.id}';
			        lyr.tips('${message.content}', '#msg${message.id}', {
                        time: -1,
                        tips: [2, 'gray'],
                        tipsMore: true,
                        area: ["480px", ""]
                    });
					</#list>
				</#if>

				$.post("/editMsg.do",{cus_id: cus_id});
			});

            setInterval(function(){
                window.location.reload();
            },3000)
		</script>
	</body>

</html>