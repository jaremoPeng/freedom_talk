<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>好友备注</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				&emsp;
				<br>
				<div class="layui-col-md3">

				</div>
				<div class="layui-col-md6">
					<div class="layui-form-item">
						<label class="layui-form-label">备注</label>
						<div class="layui-input-inline">
							<input id="remarks" type="text" name="remarks" autocomplete="off" placeholder="请输入备注名" class="layui-input">
							<br />
							<button class="layui-btn layui-btn-sm" type="button" onclick="edit_remarks('${now_customer.id}','${toCustomer.id}')">确认</button>
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

		function edit_remarks(fromid,toid) {
			var remarks = $("#remarks").val();
			if(remarks.length!=0){
			    $.post("/editHf.do",{remarks:remarks,fromid:fromid,toid:toid},function (data) {
					if(data.length==0){
                        $("#remarks").val('');
                        lyr.msg("修改成功");
					}else{
                        lyr.msg("修改失败");
					}
                });
			}else{
			    lyr.msg("请输入备注名")
			}
        }
	</script>
	</body>

</html>