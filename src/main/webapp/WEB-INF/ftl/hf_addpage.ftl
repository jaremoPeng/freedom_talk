<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>添加好友页面</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/layui.css" />
		<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="/js/layui.js"></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">

				</div>
				<div class="layui-col-md6 layui-text">
					<div class="layui-card">
						<div class="layui-card-header">请求添加 - ${toCustomer.loginName} 为好友</div>
						<div class="layui-card-body">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">请输入验证信息: </label>
								<div class="layui-input-block">
									<textarea name="verifymsg" placeholder="请输入验证信息" class="layui-textarea"></textarea>
								</div>
							</div>
							&emsp;&emsp;&emsp;&emsp;
							&emsp;&emsp;&emsp;&emsp;
							<button class="layui-btn" onclick="hf_add('${now_customer.id}','${toCustomer.id}')">确认</button>
      						<button type="reset" class="layui-btn layui-btn-primary">取消</button>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

        <script>
            var lyr;
            layui.use(["form","layer"],function () {
                var form = layui.form,
                        layer = layui.layer;
                lyr = layer;
            });

            function hf_add(fromid,toid) {
                $.post('/lendHf.do',{fromid:fromid,toid:toid},function (data) {
                    if(data.length==0){
                        lyr.msg("发送成功");
                    }else{
                        lyr.msg("发送失败");
                    }
                });
            }
		</script>
	</body>

</html>