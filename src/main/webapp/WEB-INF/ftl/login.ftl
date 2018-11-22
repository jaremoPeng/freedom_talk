<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>自由说-登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div style="height: 100px;">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
				<legend>自由说论坛-登录</legend>
			</fieldset>
		</div>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md8">
					<img src="/img/heizeiwang1.jpg" />
				</div>
				<div class="layui-col-md4 layui-text">
					<div class="layui-card" style="border: 1px solid gainsboro;">
						<div class="layui-card-header">
							<h3>用户登录</h3>
						</div>
						<div class="layui-card-body">
							<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
								<ul class="layui-tab-title">
									<li class="layui-this">用户名登录</li>
									<li>邮箱登录</li>
								</ul>
								<div class="layui-tab-content">
									<div class="layui-tab-item layui-show">
										<form class="layui-form layui-form-pane" action="/login.do" method="get">
                                            <input type="hidden" name="logintype" value="1">
											<div class="layui-form-item">
												<label class="layui-form-label">登录名: </label>
												<div class="layui-input-block">
													<input type="text" name="loginName" lay-verify="loginName" autocomplete="off" placeholder="请输入登录名" class="layui-input">
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">密码: </label>
												<div class="layui-input-block">
													<input type="password" name="password" lay-verify="pass1" autocomplete="off" placeholder="请输入登录密码" class="layui-input">
												</div>
											</div>
											<div class="layui-form-item">
												<div class="layui-inline">
													<label class="layui-form-label">问题验证: </label>
													<div class="layui-input-inline">
														<select name="question_id" lay-verify="question_id1">
															<option value="">请选择问题</option>
															<#if questionList?? >
															    <#list questionList as question>
															        <option value="${question.id}">${question.questionContent}</option>
															    </#list>
															</#if>
														</select>
													</div>
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">答案: </label>
												<div class="layui-input-block">
													<input type="text" name="answer" lay-verify="answer1" autocomplete="off" placeholder="请输入问题答案" class="layui-input">
												</div>
											</div>
											<div class="layui-form-item">
												没有账号?
												<a href="/getAllQue.do?type=2">去注册</a> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
												<a href="">忘记密码?</a>
											</div>
											<div class="layui-form-item">
												<button class="layui-btn" lay-submit="" lay-filter="*" type="submit">登录</button>
												<button class="layui-btn" type="reset">重置</button>
											</div>
										</form>
									</div>
									<div class="layui-tab-item">
										<form class="layui-form layui-form-pane" action="/login.do" method="get">
                                            <input type="hidden" name="logintype" value="2">
											<div class="layui-form-item">
												<label class="layui-form-label">邮箱地址: </label>
												<div class="layui-input-block">
													<input type="text" name="email" lay-verify="email" autocomplete="off" placeholder="请输入邮箱" class="layui-input">
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">密码: </label>
												<div class="layui-input-block">
													<input type="password" name="password" lay-verify="pass2" autocomplete="off" placeholder="请输入登录密码" class="layui-input">
												</div>
											</div>
											<div class="layui-form-item">
												<div class="layui-inline">
													<label class="layui-form-label">问题验证: </label>
													<div class="layui-input-inline">
                                                        <select name="question_id" lay-verify="question_id2">
                                                            <option value="">请选择问题</option>
															<#if questionList?? >
																<#list questionList as question>
															        <option value="${question.id}">${question.questionContent}</option>
																</#list>
															</#if>
                                                        </select>
													</div>
												</div>
											</div>
											<div class="layui-form-item">
												<label class="layui-form-label">答案: </label>
												<div class="layui-input-block">
													<input type="text" name="answer" lay-verify="answer2" autocomplete="off" placeholder="请输入问题答案" class="layui-input">
												</div>
											</div>
											<div class="layui-form-item">
												没有账号?
												<a href="/getAllQue.do?type=2">去注册</a> &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
												<a href="">忘记密码?</a>
											</div>
											<div class="layui-form-item">
												<button class="layui-btn" lay-submit="" lay-filter="*" type="submit">登录</button>
												<button class="layui-btn" type="reset">重置</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			
			layui.use(['form', 'layedit', 'laydate', 'element'], function() {
				var $ = layui.jquery,
					form = layui.form,
					layer = layui.layer,
					layedit = layui.layedit,
					laydate = layui.laydate,
					element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

                form.verify({
                    loginName: function(value) {
                        if(value.length==0) {
                            return '请输入用户名';
                        }
                    },
                    email: function(value) {
                        if(value.length==0) {
                            return '请输入邮箱';
                        }
                        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
                        if(!reg.test(value)){
                            return '邮箱格式不正确';
                        }
                    },
                    pass1: function(value) {
                        password = value;
                        if(value.length==0) {
                            return '请输入密码';
                        }
                    },
                    pass2: function(value) {
                        password = value;
                        if(value.length==0) {
                            return '请输入密码';
                        }
                    },
                    question_id1: function(value) {
                        if(value.length==0) {
                            return '请选择问题';
                        }
                    },
                    question_id2: function(value) {
                        if(value.length==0) {
                            return '请选择问题';
                        }
                    },
                    answer1: function(value) {
                        if(value.length==0) {
                            return '请输入问题答案';
                        }
                    },
                    answer2: function(value) {
                        if(value.length==0) {
                            return '请输入问题答案';
                        }
                    }
                });

				//触发事件
				var active = {
					tabChange: function() {
						//切换到指定Tab项
						element.tabChange('demo', '22'); //切换到：用户管理
					}
				};
			});
		</script>
	</body>

</html>