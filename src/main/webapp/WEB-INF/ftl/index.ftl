<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>自由说论坛首页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../../css/layui.css" />
		<script type="text/javascript" src="../../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../../js/layui.js"></script>
	</head>

	<body>
		<div id="top">
			<#include "guide.ftl">
		</div>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>分类</h3></div>
						<div class="layui-card-body">
							<a href="">社会</a><br>
							<a href="">白色背景会</a><br>
							<a href="">常用于</a><br>
							<a href="">映衬</a><br>
							<a href="">边框投影</a><br>
							<a href="">社会</a><br>
							<a href="">社会</a><br>
						</div>
					</div>
					<div class="layui-card">
						<div class="layui-card-header"><h3>分类</h3></div>
						<div class="layui-card-body">
							卡片式面板面板通常用于非白色背景色的主体内<br> 从而映衬出边框投影
						</div>
					</div>
				</div>
				<div class="layui-col-md6">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
						<legend>热点</legend>
					</fieldset>
					<div class="layui-carousel" style="width: 500px;" id="test3" lay-filter="test4">
						<div carousel-item="">
							<div><img src="img/kebi.jpg" /></div>
							<div><img src="img/kebi.jpg" /></div>
							<div><img src="img/heizeiwang2.jpg" /></div>
							<div><img src="img/kebi.jpg" /></div>
							<div><img src="img/heizeiwang1.jpg" /></div>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>热帖榜</h3></div>
						<div class="layui-card-body">
							<a href="">关于用户私人转赠的风险提示</a><br>
							<a href="">黄兴：您为何甘当满清走狗，也不帮汉人恢复江山？李鸿章如此回答</a><br>
							<a href="">自由自在吃瓜楼（包容不同意见，但拒绝喷脏）</a><br>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>每日热帖</h3></div>
						<div class="layui-card-body">
							<a href="">关于用户私人转赠的风险提示</a><br>
							<a href="">黄兴：您为何甘当满清走狗，也不帮汉人恢复江山？李鸿章如此回答</a><br>
							<a href="">自由自在吃瓜楼（包容不同意见，但拒绝喷脏）</a><br>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>城市榜</h3></div>
						<div class="layui-card-body">
							卡片式面板面板通常用于非白色背景色的主体内<br> 从而映衬出边框投影
						</div>
					</div>
				</div>
				<div class="layui-col-md3">
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>常看分类</h3></div>
						<div class="layui-card-body">
							卡片式面板面板通常用于非白色背景色的主体内<br> 从而映衬出边框投影
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>论坛公告</h3></div>
						<div class="layui-card-body">
							卡片式面板面板通常用于非白色背景色的主体内<br> 从而映衬出边框投影
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>热门版主</h3></div>
						<div class="layui-card-body">
							卡片式面板面板通常用于非白色背景色的主体内<br> 从而映衬出边框投影
						</div>
					</div>
				</div>
			</div>
		</div>
		<div>
			<#include "down.ftl">
		</div>

		<script>
			layui.use(['carousel', 'form'], function() {
				var carousel = layui.carousel,
					form = layui.form;

				//设定各种参数
				var ins3 = carousel.render({
					elem: '#test3'
					, width: '500px'
				});

			});
		</script>
	</body>

</html>