<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>增加帖子</title>
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
						<div class="layui-card-header">添加帖子</div>
						<div class="layui-card-body">
							<form class="layui-form" action="/lendNote.do" method="post">
								<input name="cusid" type="hidden" value="${now_customer.id}">
								<div class="layui-form-item">
									<div class="layui-form-item">
										<label class="layui-form-label">帖子标题</label>
										<div class="layui-input-block">
											<input type="text" name="title" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
										</div>
									</div>
								</div>
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <label class="layui-form-label">选择分类: </label>
                                        <div class="layui-input-inline">
                                            <select name="category_id" lay-verify="category">
                                                <option value="">选择分类</option>
													<#if categoryList?? >
														<#list categoryList as category>
															<option value="${category.id}">${category.name}</option>
														</#list>
													</#if>
                                            </select>
                                        </div>
                                    </div>
                                </div>
								<div class="layui-form-item">
									<label class="layui-form-label">帖子内容</label>
									<div class="layui-input-block">
										<textarea name="content" lay-verify="content" placeholder="请输入..." class="layui-textarea"></textarea>
									</div>
									<!--<div class="layui-form-mid layui-word-aux">请填写6到12位密码</div>-->
								</div>
								<div class="layui-upload">
									<button type="button" class="layui-btn" id="pic_upload">图片上传</button>
									<blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 10px;">
										预览：
										<div class="layui-upload-list" id="first_show"></div>
									</blockquote>
								</div>

								<div class="layui-form-item">
									<div class="layui-input-block">
										<button class="layui-btn" lay-submit="" lay-filter="*">立即提交</button>
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
			layui.use(['form','upload'], function() {
				var form = layui.form,
					$ = layui.jquery,
					upload = layui.upload;

				form.verify({
                    title: function(value) {
                        if(value.length==0) {
                            return '请输入帖子标题';
                        }
                    },
                    category: function(value) {
                        if(value.length==0) {
                            return '请选择帖子分类';
                        }
                    },
                    content: function(value) {
                        if(value.length==0) {
                            return '请输入帖子内容';
                        }
                    }
				});

				upload.render({
					elem: '#pic_upload',
					url: '/upload/',
					multiple: true,
					before: function(obj) {
						//预读本地文件示例，不支持ie8
						obj.preview(function(index, file, result) {
							$('#first_show').append('<img style="width: 120px;height: 130px;" src="' + result + '" alt="' + file.name + '" class="layui-upload-img">')
						});
					},
					done: function(res) {
						//上传完毕
					}
				});
			});
		</script>
	</body>

</html>