<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>评论回复</title>
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
				<div class="layui-col-md6">
					<div class="layui-card">
						<div class="layui-card-header">回复 -
							<#if toCustoemr.name??>
								${toCustoemr.name}
								<#else >
									${toCustoemr.loginName}
							</#if>
						</div>
						<div class="layui-card-body">
							<form class="layui-form" action="/lendvpr.do" method="post">
								<input type="hidden" name="fromid" value="${now_customer.id}">
                                <input type="hidden" name="toid" value="${toCustoemr.id}">
                                <input type="hidden" name="vpid" value="${viewPoint.id}">
								<div class="layui-form-item">
									<label class="layui-form-label">评论回复</label>
									<div class="layui-input-block">
										<textarea name="content" lay-verify="content" placeholder="请输入..." class="layui-textarea"></textarea>
									</div>
									<!--<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>-->
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit="" lay-filter="*">回复</button>
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

	<script>
        layui.use("form",function () {
            var form = layui.form;

            form.verify({
                content: function(value) {
                    if(value.length==0) {
                        return '请填写回复内容';
                    }
                }
            });
        });
	</script>
	</body>

</html>