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
										<input id="loginName" type="text" name="loginName" lay-verify="loginname" placeholder="请输入用户名" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">登录密码</label>
									<div class="layui-input-block">
										<input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
									</div>
								</div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">确认密码</label>
                                    <div class="layui-input-block">
                                        <input type="password" name="repassword" lay-verify="repass" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
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
										<select name="question_id" lay-verify="question">
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
										<input type="text" name="answer" lay-verify="answer" placeholder="请输入问题答案" autocomplete="off" class="layui-input">
									</div>
								</div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">邮箱验证码</label>
                                    <div class="layui-inline">
                                        <input id="inputCode" type="text" name="inputCode" lay-verify="inputCode" placeholder="请输入验证码" class="layui-input">
                                    </div>
                                    <button id="sendCode" class="layui-btn" type="button">发送</button>
                                </div>

								<div class="layui-form-item">
									&emsp;&emsp;&emsp;&emsp;已有账号?<a href="/getAllQue.do?type=1">去登录</a>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button id="submit_form" class="layui-btn" lay-submit="" lay-filter="*">立即提交</button>
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
            var lyr;
			layui.use(['form', 'layedit'], function() {
				var form = layui.form,
					layer = layui.layer,
					layedit = layui.layedit,
					$ = layui.jquery;

				    lyr=layer;

				//自定义验证规则
                var password;
				form.verify({
					loginname: function(value) {
						if(value.length < 3 || value.length > 8) {
							return '用户名的长度为3-8位';
						}
					},
					pass: function(value) {
					    password = value;
                        if(value.length < 6 && value.length > 12) {
                            return '密码的长度为6-12位';
                        }
                    },
                    repass: function(value) {
                        if(value!=password) {
                            return '两次密码不一致';
                        }
                    },
					email: function(value) {
                        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
                        if(!reg.test(value)){
                            return '邮箱格式不正确';
                        }
					},
                    question: function(value) {
                        if(value.length==0) {
                            return '请选择问题';
                        }
                    },
                    answer: function(value) {
                        if(value.length==0) {
                            return '请输入问题答案';
                        }
                    },
                    inputCode: function(value) {
                        if(value.length==0) {
                            return '请输入验证码';
                        }
                    }
				});

			});

            var email_str = $("#email");
            email_str.blur(function () {
                if(email_str.val().length!=0){
                    $.post("/verifyMail.do",
							{email: email_str.val()},
                            function(data){
                                if(data.length!=0){
                                    lyr.msg('邮箱已被注册');
                                    $("#sendCode").attr("disabled","disabled");
                                    $("#sendCode").attr("class","layui-btn layui-btn-disabled");
								}else{
                                    $("#sendCode").attr("class","layui-btn");
                                    $("#sendCode").removeAttr("disabled");
								}
                            }
					);
                }
			});
            $("#sendCode").click(function () {
                if(email_str.val().length!=0){
                    $.post("/sendEmail.do",{email: email_str.val()});
                    lyr.msg('邮箱发送成功');
                    $("#sendCode").attr("disabled","disabled");
                    $("#sendCode").attr("class","layui-btn layui-btn-disabled");
                }
            });
            $("#inputCode").focus(function () {
                $("#sendCode").attr("class","layui-btn");
				$("#sendCode").removeAttr("disabled");
            });


            $("#loginName").blur(function () {
                if( $("#loginName").val().length!=0){
                    $.post("/verifyLoginName.do",
							{loginName: $("#loginName").val()},
                            function(data){
                                if(data.length!=0){
                                    lyr.msg('用户名已被注册');
                                    $("#submit_form").attr("disabled","disabled");
                                    $("#submit_form").attr("class","layui-btn layui-btn-disabled");
                                }else{
                                    $("#submit_form").attr("class","layui-btn");
                                    $("#submit_form").removeAttr("disabled");
                                }
                            }
					);
                }
            });
		</script>
	</body>

</html>