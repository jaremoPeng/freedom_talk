<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>修改密码</title>
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
				<div class="layui-col-md5">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
						<legend>自由说论坛-修改密码</legend>
					</fieldset>
					<div class="layui-card" style="border: 1px solid gainsboro;">
						<div class="layui-card-header">
							<h3>密码修改</h3></div>
						<div class="layui-card-body">
							<#if now_customer??>
								<input id="email" type="hidden" name="email" value="${now_customer.email}" class="layui-input">
								<#else>
								<div class="layui-form-item">
									<label class="layui-form-label">邮箱</label>
									<div class="layui-input-inline">
										<input id="email" type="text" name="email" placeholder="请输入邮箱" lay-verify="email" autocomplete="off" class="layui-input">
									</div>
								</div>
							</#if>
							<div class="layui-form-item">
								<label class="layui-form-label">验证码</label>
								<div class="layui-input-block">
									<input id="email_code" type="text" name="email_code" style="width: 150px;float: left;" placeholder="请输入邮箱验证码" autocomplete="off" class="layui-input">
									<button id="require" type="button" class="layui-btn">发送验证码</button>
								</div>
							</div>

							<div class="layui-form-item">
								<div class="layui-input-block">
									<button id="verify" type="button" class="layui-btn">确认</button>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			layui.use(['form', 'layer'], function() {
				var form = layui.form,
					$ = layui.jquery,
					layer = layui.layer;

                var mail_url;
				$('#require').on('click', function() {
                    mail_url = $("#email").val();
					if(mail_url.length!=0){
                        $('#require').attr("class","layui-btn layui-btn-disabled");
                        $('#require').attr("disabled","disabled");

                        $.post("/sendEmail.do",{email: mail_url});
                        layer.msg('亲爱的用户,已向你所注册的邮箱发送了验证码,赶快去接收吧!', {
                            time: 20000, //20s后自动关闭
                            btn: ['知道了']
                        });
                    }else {
                        layer.msg('亲爱的用户,您还未填写邮箱', {
                            time: 20000, //20s后自动关闭
                            btn: ['知道了']
                        });
                    }
				});

				$("#verify").on("focus",function () {
                    $('#require').attr("class","layui-btn");
                    $('#require').removeAttr("disabled");
                });

				$('#verify').on('click', function() {
					var email_code = $("#email_code");
					if(email_code.val().length == 0) {
						layer.msg('你还没填写验证码', {
							time: 5000, //5s后自动关闭
							btn: ['知道了']
						});
					} else if(email_code.val().length != 6) {
						email_code.val("");
						layer.msg('验证码长度不正确', {
							time: 5000, //5s后自动关闭
							btn: ['知道了']
						});
					} else {
                        $.post("/editPass.do",{email: mail_url,email_code: email_code.val()},function (data) {
                            if(data.length==0){
                                layer.open({
                                    type: 2,
                                    title: '填写新密码',
                                    shadeClose: true,
                                    shade: false,
                                    maxmin: false, //开启最大化最小化按钮
                                    area: ['600px', '400px'],
                                    content: '/gotoNewPass.do?email='+mail_url
                                });
                            }else{
                                layer.msg("修改失败");
                            }
                        });

					}
				});
			});
		</script>
	</body>

</html>