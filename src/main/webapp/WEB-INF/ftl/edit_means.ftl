<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>修改资料</title>
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
					<div class="layui-card" style="border: 1px solid gainsboro;">
						<div class="layui-card-header">
							<h3>编辑</h3></div>
						<div class="layui-card-body">

							<form class="layui-form" action="/edit.do" method="post" enctype="multipart/form-data">
                                <#if now_customer??>
                                    <input type="hidden" name="id" value="${now_customer.id}">
                                </#if>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">选择头像</label>
                                    <div class="layui-input-block">
                                        <input id="file" type="file" name="file" class="layui-input">
                                        <div style="width: 100px;height: 120px;border: 1px solid lightgray;">
                                            <img style="width: 100px;height: 120px;" class="layui-upload-img" id="img">
                                        </div>
                                    </div>
                                </div>
								<div class="layui-form-item">
									<label class="layui-form-label">论坛昵称</label>
									<div class="layui-input-block">
										<input type="text" name="nickname" placeholder="请输入昵称" autocomplete="off" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">个性签名</label>
									<div class="layui-input-block">
										<input type="text" name="suggest" placeholder="请输入个性签名" autocomplete="off" class="layui-input">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">性别</label>
									<div class="layui-input-block">
										<input type="radio" name="sex" value="男" title="男" checked="">
										<input type="radio" name="sex" value="女" title="女">
									</div>
								</div>

								<div class="layui-form-item">
									<label class="layui-form-label">出生日期</label>
									<div class="layui-input-inline">
										<input type="text" name="birthdate" class="layui-input" id="birthdate" placeholder="yyyy-MM-dd">
									</div>
								</div>
								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit="">立即提交</button>
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
			layui.use(['form', 'laydate','upload'], function() {
				var form = layui.form,
					laydate = layui.laydate,
					upload = layui.upload;
					
				laydate.render({
					elem: '#birthdate'
				});

			});

            $("#file").change(function() {
                var objUrl = getObjectURL(this.files[0]);
                console.log("objUrl = " + objUrl);
                if(objUrl) {
                    $("#img").attr("src", objUrl);
                }
            });
            //建立一個可存取到該file的url
            function getObjectURL(file) {
                var url = null;
                if(window.createObjectURL != undefined) { // basic
                    url = window.createObjectURL(file);
                } else if(window.URL != undefined) { // mozilla(firefox)
                    url = window.URL.createObjectURL(file);
                } else if(window.webkitURL != undefined) { // webkit or chrome
                    url = window.webkitURL.createObjectURL(file);
                }
                return url;
            }
		</script>
	</body>

</html>