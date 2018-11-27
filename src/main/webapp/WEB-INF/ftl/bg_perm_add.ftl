<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>添加权限</title>
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
						<div class="layui-card-header">添加权限: </div>
						<div class="layui-card-body">
							
							<form class="layui-form" action="">
								<div class="layui-form-item">
									<label class="layui-form-label">权限名</label>
									<div class="layui-input-block">
										<input type="text" id="perm_name" autocomplete="off" placeholder="请输入权限名" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">权限路径</label>
									<div class="layui-input-block">
										<input type="text" id="perm_url" autocomplete="off" placeholder="请输入权限路径" class="layui-input">
									</div>
								</div>
								<div class="layui-form-item">
									<label class="layui-form-label">权限标识</label>
									<div class="layui-input-block">
										<input type="text" id="perm_sign" autocomplete="off" placeholder="请输入权限标识" class="layui-input">
									</div>
								</div>
								&emsp;&emsp;&emsp;&emsp;
								&emsp;&emsp;&emsp;&emsp;
								<button class="layui-btn layui-btn-sm" type="button" onclick="true_add()">确认</button>
							</form>
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
                        $ = layui.jquery,
                        layer = layui.layer;

                lyr = layer;
            });

            function true_add() {
                var permname = $("#perm_name").val();
                var permurl = $("#perm_url").val();
                var permsign = $("#perm_sign").val();

                if(permname.length==0 || permurl.length==0 || permsign==0){
                    lyr.msg("权限名未填写,或者权限地址未填写,或者权限标识未填写");
                }else{
                    $.post("/lendPerm.do",{permname:permname,permurl:permurl,permsign:permsign},function (data) {
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