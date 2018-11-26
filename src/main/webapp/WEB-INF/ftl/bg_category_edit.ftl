<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>修改分类</title>
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
				<div class="layui-col-md5 layui-text">
					<div class="layui-card">
						<div class="layui-card-header">修改分类: </div>

						<div class="layui-card-body">
							<input type="hidden" id="category_id" value="${category.id}" autocomplete="off" class="layui-input">
							<div class="layui-form-item">
								<label class="layui-form-label">分类名</label>
								<div class="layui-input-block">
									<input type="text" id="category_name" autocomplete="off" placeholder="请输入分类名" class="layui-input">
								</div>
							</div>
							&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
							<button class="layui-btn layui-btn-sm" onclick="edit_cate()">修改</button>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

	<script>
		var lyr;
        layui.use(['table', 'layer'], function() {
            var table = layui.table,
                    layer = layui.layer;

            lyr = layer;
        });

        function edit_cate() {
            var id = $("#category_id").val();
            var cate_name = $("#category_name").val();

            if(cate_name.length==0){
                lyr.msg("请输入分类名");
			}else{
                $.post("/editCategory.do",{catename: cate_name,cateid:id},function (data) {
					if(data.length==0){
                        lyr.msg("修改成功");
					}else{
                        lyr.msg("修改失败");
					}
                });
			}
        }
	</script>
	</body>

</html>