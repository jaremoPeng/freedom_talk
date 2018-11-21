<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>自由说-注册</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div style="height: 100px;">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
				<legend>自由说论坛-注册</legend>
			</fieldset>
		</div>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md7">
					<img src="/img/heizeiwang2.jpg" />
				</div>
				<div class="layui-col-md5 layui-text">
					<div class="layui-card" style="border: 1px solid gainsboro;">
						<div class="layui-card-header">
							<h3>用戶注册</h3></div>
						<div class="layui-card-body">
							<form class="layui-form" action="/regist.do" method="get">
								<div class="layui-form-item">
									<label class="layui-form-label">用户名</label>
									<div class="layui-input-block">
										<input type="text" name="loginName" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">登录密码</label>
									<div class="layui-input-block">
										<input type="text" name="password" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">邮箱</label>
									<div class="layui-input-block">
										<input id="email" type="text" name="email" lay-verify="email" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
									</div>
								</div>

								<!--<div class="layui-form-item">
									<label class="layui-form-label">自定义验证</label>
									<div class="layui-input-inline">
										<input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
									</div>
									<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>
								</div>-->

								<div class="layui-form-item">
									<label class="layui-form-label">验证问题</label>
									<div class="layui-input-inline">
										<select name="question_id">
											<option value="">请选择问题</option>
											<#if questionList?? >
												<#list questionList as question>
													<option value="${question.id}">${question.questionContent}</option>
												</#list>
											</#if>
										</select>
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">问题答案</label>
									<div class="layui-input-block">
										<input type="text" name="answer" placeholder="请输入问题答案" autocomplete="off" class="layui-input">
									</div>
								</div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">邮箱验证码</label>
                                    <div class="layui-inline">
                                        <input type="text" name="inputCode" placeholder="请输入验证码" class="layui-input">
                                    </div>
                                    <button id="sendCode" class="layui-btn" type="button">发送</button>
                                </div>

								<div class="layui-form-item">
									&emsp;&emsp;&emsp;&emsp;已有账号?<a href="/getAllQue.do?type=1">去登录</a>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" type="submit">立即提交</button>
										<button type="reset" class="layui-btn">重置</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script>
			layui.use(['form', 'layedit'], function() {
				var form = layui.form,
					layer = layui.layer,
					layedit = layui.layedit,
					$ = layui.jquery;

				//创建一个编辑器
				var editIndex = layedit.build('LAY_demo_editor');

				//自定义验证规则
				form.verify({
					title: function(value) {
						if(value.length < 5) {
							return '标题至少得5个字符啊';
						}
					},
					pass: [/(.+){6,12}$/, '密码必须6到12位'],
					content: function(value) {
						layedit.sync(editIndex);
					}
				});

                var email_str = $("#email").val();
                if(email_str!=null && email_str.length!=0){
                    $("#sendCode").click(function () {
                        $.post("/sendEmail.do",{email: email_str});
                    });
                }

			});
		</script>
	</body>

</html>