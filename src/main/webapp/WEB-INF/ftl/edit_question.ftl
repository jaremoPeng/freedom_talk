<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>修改验证问题</title>
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
						<legend>自由说论坛-修改验证问题</legend>
					</fieldset>
					<div id="old_div" class="layui-card" style="border: 1px solid gainsboro;">
						<div class="layui-card-header">
							<h3>问题修改</h3></div>
						<div class="layui-card-body">
							<form class="layui-form" action="" method="">
								<div class="layui-form-item">
									<label class="layui-form-label">选择<font color="red">旧</font>问题</label>
									<div class="layui-input-inline">
                                        <select name="old_question_id" lay-verify="old_question_id">
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
									<label class="layui-form-label"><font color="red">旧</font>问题答案</label>
									<div class="layui-input-block">
										<input type="text" name="old_answer" lay-verify="old_answer" autocomplete="off" placeholder="请输入答案" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button id="old_edit" type="button" class="layui-btn" lay-filter="*">确认</button>
										<button type="reset" class="layui-btn">重置</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					
					<div id="new_div" class="layui-card" style="border: 1px solid gainsboro;display: none;">
						<div class="layui-card-header">
							<h3>问题修改</h3></div>
						<div class="layui-card-body">
							<form class="layui-form" action="/editNewQue.do" method="post">
                                <input type="hidden" name="id" value="${now_customer.id}">
								<div class="layui-form-item">
									<label class="layui-form-label">选择<font color="green">新</font>问题</label>
									<div class="layui-input-inline">
                                        <select name="question_id" lay-verify="new_question_id">
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
									<label class="layui-form-label"><font color="green">新</font>问题答案</label>
									<div class="layui-input-block">
										<input type="text" name="answer" lay-verify="new_answer" autocomplete="off" placeholder="请输入答案" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button id="new_edit" lay-submit="" lay-filter="*" class="layui-btn">确认</button>
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
			layui.use(['form', 'layer'], function() {
				var form = layui.form,
					$ = layui.jquery,
					layer = layui.layer;

				form.verify({
                    old_question_id: function(value) {
                        if(value.length==0) {
                            return '请选择问题';
                        }
                    },
                    old_answer: function(value) {
                        if(value.length==0) {
                            return '请输入问题答案';
                        }
                    },
                    new_question_id: function(value) {
                        if(value.length==0) {
                            return '请选择问题';
                        }
                    },
                    new_answer: function(value) {
                        if(value.length==0) {
                            return '请输入问题答案';
                        }
                    }
				});

				$('#old_edit').on('click', function() {
                    var old_q = $("select[name='old_question_id']");
                    var old_a = $("input[name='old_answer']");
                    <#if now_customer??>
                        if(old_q.val()=='${now_customer.question.id}' && old_a.val()=='${now_customer.answer}'){
                            var old_div = $("#old_div");
                            var new_div = $("#new_div");
                            old_div.css("display","none");
                            new_div.css("display","block");
						}else{
                            layer.msg("抱歉,您选择问题或者输入的答案不匹配");
						}
                    </#if>
				});
			});
		</script>
	</body>

</html>