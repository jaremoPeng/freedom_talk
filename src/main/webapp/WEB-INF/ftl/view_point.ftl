<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>评论</title>
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
						<div class="layui-card-body">
							<form class="layui-form" action="/lendvp.do" method="post">

								<div class="layui-form-item">
									<input type="hidden" name="note_id" value="${note.id}">
                                    <input type="hidden" name="cus_id" value="${now_customer.id}">
									<label class="layui-form-label">评论</label>
									<div class="layui-input-block">
										<textarea name="content" placeholder="请输入..." lay-verify="content" class="layui-textarea"></textarea>
									</div>
									<!--<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>-->
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit="" lay-filter="*">发表评论</button>
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
                        return '请填写内容';
                    }
                }
			});
        });
	</script>
	</body>

</html>