<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的好友</title>
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
					<div class="layui-card layui-text" style="border: 1px solid lightgray;">
						<div class="layui-card-header">好友列表</div>
						<div class="layui-card-body">
							<div class="hf" style="border: 1px solid lightgray;">
								&emsp;&emsp;
								<a href="">
									<img src="../img/uugai.com_1542371006215.png" class="layui-nav-img" style="width: 40px;height: 40px;">
								</a>
								<sup><a href="">jaremo</a></sup> &emsp;
								<small class="hf_substr">数据福克斯设计费开始看风景看见空间看空间反倒是看见看见</small> &emsp;
								<button id="to_chat" class="layui-btn layui-btn-xs">与TA聊天</button>
								<button id="edit_remarks" class="layui-btn layui-btn-primary layui-btn-xs">修改备注</button>
								<button id="del_hf" class="layui-btn layui-btn-danger layui-btn-xs"> 删除好友</button>
							</div>
							<br />
							<div class="hf" style="border: 1px solid lightgray;">
								&emsp;&emsp;
								<a href="">
									<img src="../img/uugai.com_1542371006215.png" class="layui-nav-img" style="width: 40px;height: 40px;">
								</a>
								<sup><a href="">jaremo</a></sup> &emsp;
								<small class="hf_substr">数据福克斯设计费开始看风景看见空间看空间反倒是看见看见</small> &emsp;
								<button class="layui-btn layui-btn-xs">与TA聊天</button>
								<button class="layui-btn layui-btn-primary layui-btn-xs">修改备注</button>
								<button class="layui-btn layui-btn-danger layui-btn-xs"> 删除好友</button>
							</div>
							<br />
							<div class="hf" style="border: 1px solid lightgray;">
								&emsp;&emsp;
								<a href="">
									<img src="../img/uugai.com_1542371006215.png" class="layui-nav-img" style="width: 40px;height: 40px;">
								</a>
								<sup><a href="">jaremo</a></sup> &emsp;
								<small class="hf_substr">数据福克斯设计费开始看风景看见空间看空间反倒是看见看见</small> &emsp;
								<button class="layui-btn layui-btn-xs">与TA聊天</button>
								<button class="layui-btn layui-btn-primary layui-btn-xs">修改备注</button>
								<button class="layui-btn layui-btn-danger layui-btn-xs">删除好友</button>
							</div>
							<br />
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			layui.use('layer', function() {
				var $ = layui.jquery,
					layer = layui.layer;

				$(".hf").each(function() { //遍历file_name中的每个子元素
					    
					var v = $(this).children('.hf_substr').text();    
					if(v.length > 20) {
						// 用V的前20个字符+"......"+后15个字符代替V
						var new_value = v.substring(0, 9) + '...';
						$(this).children('.hf_substr').text(new_value); //设置新的text()
					}
				});

				$("#to_chat").on("click", function() {
					layer.open({
						type: 2,
						title: '与- 某某  聊天中...',
						shadeClose: true,
						shade: false,
						maxmin: true, //开启最大化最小化按钮
						area: ['600px', '400px'],
						content: '//127.0.0.1:8020/freedom_talk2/ftl/hf_chat.html'
					});
				});

				$("#edit_remarks").on("click", function() {
					layer.open({
						type: 2,
						title: '给好友- 某某  备注中...',
						shadeClose: true,
						shade: false,
						maxmin: false, //开启最大化最小化按钮
						area: ['400px', '200px'],
						content: '//127.0.0.1:8020/freedom_talk2/ftl/hf_remarks.html'
					});
				});

				$("#del_hf").on("click", function() {
					layer.confirm('你确定删除该好友？', {
						btn: ['确定', '取消'] //按钮
					}, function() {
						layer.msg('删除成功', {
							icon: 1
						});
//						layer.msg('删除失败', {
//							icon: 2
//						});
					}, function() {
						layer.msg('就是嘛,你怎么忍心!!', {
							time: 20000, //20s后自动关闭
							btn: ['懂我', '无聊']
						});
					});
				});
			});
		</script>
	</body>

</html>