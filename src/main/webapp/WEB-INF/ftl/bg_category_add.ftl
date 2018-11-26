<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>添加分类</title>
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
					<div class="layui-card" style="border: 1px solid lightgray;">
						<div class="layui-card-header">添加分类: </div>

						<div class="layui-card-body">
							<div class="layui-form-item">
								<label class="layui-form-label">分类名</label>
								<div class="layui-input-block">
									<input type="text" id="category_name" lay-verify="title" autocomplete="off" placeholder="请输入分类名" class="layui-input">
								</div>
							</div>
							&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
							<button class="layui-btn layui-btn-sm" onclick="addcate()">添加</button>
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

            function addcate() {
                var cate_name = $("#category_name").val();

                if(cate_name.length==0){
                    lyr.msg("请输入分类名");
                }else{
                    $.post("/lendCategory.do",{catename: cate_name},function (data) {
                        if(data.length==0){
                            lyr.msg("添加成功");
                        }else{
                            lyr.msg("添加失败");
                        }
                    });
                }
            }
        </script>
	</body>

</html>