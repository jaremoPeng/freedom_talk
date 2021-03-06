<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>添加公告</title>
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
						<div class="layui-card-header">添加公告: </div>

						<div class="layui-card-body">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">公告内容</label>
								<div class="layui-input-block">
									<textarea id="content" placeholder="请输入内容" class="layui-textarea"></textarea>
								</div>
							</div>
							&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
							<button class="layui-btn layui-btn-sm" type="button" onclick="add_ac()">添加</button>
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
                        layer=layui.layer;

                lyr = layer;
            });

            function add_ac() {
                var val = $("#content").val();
                if(val.length==0){
                    lyr.msg('请输入公告内容', {
                        icon: 2
                    });
				}else{
                    $.post("/lendacm.do",{content:val},function (data) {
                        if(data.length==0){
                            lyr.msg('添加成功', {
                                icon: 1
                            });
                        }else{
                            lyr.msg('添加失败', {
                                icon: 2
                            });
                        }
                    });
				}
            }
        </script>
	</body>

</html>