<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>普通用户管理</title>
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
					搜索:
					<div class="layui-input-block">
						<!-- 此处搜索不应将版主搜索出来 修改用户类型-->
						<input type="text" id="cus_keyword" autocomplete="off" placeholder="请输入用户 (用户名或者邮箱) 进行搜索" class="layui-input">
						<br />
						<button class="layui-btn layui-btn-sm" onclick="search()">搜索</button>
					</div>
					<br />

					<div id="result" class="layui-card" style="border: 1px solid lightgray;display: none;">
						<div class="layui-card-header">搜索结果: </div>
						<div class="layui-card-body">
							<a id="url">
								<img id="img" class="layui-nav-img" style="width: 60px;height: 60px;">
                                <span id="name"></span>
							</a>
						</div>
                        <input type="hidden" id="cusid">
						&emsp;&emsp;&emsp;&emsp;
						<button class="layui-btn layui-btn-danger layui-btn-sm" onclick="unuse()">禁用此用户</button>
						<button class="layui-btn layui-btn-sm" onclick="uplevel()">晋升为版主</button>
						<br />
						&emsp;&emsp;
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

	<script>
		var lyr;
		layui.use('layer',function () {
			var layer=layui.layer;

			lyr=layer;
        });

		function search() {
            var ck = $('#cus_keyword');
            if(ck.val().length==0){
                lyr.msg("请输入用户名");
            }else{
                $.post("/searchCus.do",{cuskw: ck.val()},function (data) {
					if(data.length==0){
                        lyr.msg("该用户不存在");
					}else{
					    $("#result").css("display","block");
					    var obj = $.parseJSON(data);
					    $("#url").attr("href","/gotoCusDetail.do?cus_id="+obj.id);
                        $("#img").attr("src",obj.img);
                        $("#name").text(obj.loginName);
                        $("#cusid").val(obj.id);
					}
                });
			}
        }

        function unuse() {
		    var val = $("#cusid").val();
            if(val.length==0){
                lyr.msg("操作失败");
            }else{
                $.post("/editCusUnuse.do",{cusid: val},function (data) {
                    if(data.length==0){
                        lyr.msg("操作成功");
                    }
                });
            }
        }

        function uplevel() {
            var val = $("#cusid").val();
            if(val.length==0){
                lyr.msg("操作失败");
            }else{
                $.post("/editCusBm.do",{cusid: val},function (data) {
                    if(data.length==0){
                        lyr.msg("操作成功");
                    }
                });
            }
        }
	</script>
	</body>

</html>