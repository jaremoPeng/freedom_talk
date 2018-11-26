<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>后台首页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body class="layui-layout-body">
		<!--页面地址: https://segmentfault.com/a/1190000014617129-->
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<div class="layui-logo">自由说论坛-后台</div>
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item">
						<a href="javascript:;">
							<img src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2309262615,3096530225&fm=200&gp=0.jpg" class="layui-nav-img"> ${now_customer.loginName}
						</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="">基本资料</a>
							</dd>
							<dd>
								<a href="">安全设置</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="/exit.do">退出</a>
					</li>
				</ul>
			</div>

			<div class="layui-side layui-bg-black">
				<div class="layui-side-scroll">
					<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
					<ul class="layui-nav layui-nav-tree" lay-filter="test">
						<li class="layui-nav-item">
							<a class="" href="javascript:;">用户管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-id="1" data-title="普通用户管理" data-url="/gotoBgCusManage.do"
										 class="site-demo-active" data-type="tabAdd">普通用户管理</a>
								</dd>
								<dd>
									<a href="javascript:;" data-id="2" data-title="版主管理"
										 data-url="/gotoBgBmManage.do" class="site-demo-active" data-type="tabAdd">版主管理</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">分类管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-id="4" data-title="添加分类" data-url="/gotoBgCategoryAdd.do"
								 class="site-demo-active" data-type="tabAdd">添加分类</a>
								</dd>
								<dd>
									<a href="javascript:;" data-id="5" data-title="查看分类" data-url="/gotoBgCategoryList.do"
								 class="site-demo-active" data-type="tabAdd">查看分类</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">公告管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-id="6" data-title="添加公告" data-url="/gotoBgACAdd.do"
								 class="site-demo-active" data-type="tabAdd">添加公告</a>
								</dd>
								<dd>
									<a href="javascript:;" data-id="7" data-title="查看公告" data-url="/gotoBgACList.do"
								 class="site-demo-active" data-type="tabAdd">查看公告</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">权限配置</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;" data-id="8" data-title="角色管理" data-url="/gotoBgRoleManage.do"
								 class="site-demo-active" data-type="tabAdd">角色管理</a>
								</dd>
								<dd>
									<a href="javascript:;" data-id="9" data-title="权限管理" data-url="/gotoBgPermManage.do"
								 class="site-demo-active" data-type="tabAdd">权限管理</a>
								</dd>
							</dl>
						</li>
						<!--<li class="layui-nav-item">
							<a href="">云市场</a>
						</li>-->
					</ul>
				</div>
			</div>

			<!--tab标签-->
			<div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
				<ul class="layui-tab-title"></ul>
				<div class="layui-tab-content"></div>
			</div>

			<div class="layui-footer" style="text-align:center;">
				<!-- 底部固定区域 -->
				© yj_Peng 宇宙最强
			</div>
		</div>

		<script>
			layui.use(['element', 'layer', 'jquery'], function() {
				var element = layui.element;
				// var layer = layui.layer;
				var $ = layui.$;
				// 配置tab实践在下面无法获取到菜单元素
				$('.site-demo-active').on('click', function() {
					var dataid = $(this);
					//这时会判断右侧.layui-tab-title属性下的有lay-id属性的li的数目，即已经打开的tab项数目
					if($(".layui-tab-title li[lay-id]").length <= 0) {
						//如果比零小，则直接打开新的tab项
						active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
					} else {
						//否则判断该tab项是否以及存在
						var isData = false; //初始化一个标志，为false说明未打开该tab项 为true则说明已有
						$.each($(".layui-tab-title li[lay-id]"), function() {
							//如果点击左侧菜单栏所传入的id 在右侧tab项中的lay-id属性可以找到，则说明该tab项已经打开
							if($(this).attr("lay-id") == dataid.attr("data-id")) {
								isData = true;
							}
						})
						if(isData == false) {
							//标志为false 新增一个tab项
							active.tabAdd(dataid.attr("data-url"), dataid.attr("data-id"), dataid.attr("data-title"));
						}
					}
					//最后不管是否新增tab，最后都转到要打开的选项页面上
					active.tabChange(dataid.attr("data-id"));
				});

				var active = {
					//在这里给active绑定几项事件，后面可通过active调用这些事件
					tabAdd: function(url, id, name) {
						//新增一个Tab项 传入三个参数，分别对应其标题，tab页面的地址，还有一个规定的id，是标签中data-id的属性值
						//关于tabAdd的方法所传入的参数可看layui的开发文档中基础方法部分
						element.tabAdd('demo', {
							title: name,
							content: '<iframe data-frameid="' + id + '" scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:99%;"></iframe>',
							id: id //规定好的id
						})
						FrameWH(); //计算ifram层的大小
					},
					tabChange: function(id) {
						//切换到指定Tab项
						element.tabChange('demo', id); //根据传入的id传入到指定的tab项
					},
					tabDelete: function(id) {
						element.tabDelete("demo", id); //删除
					}
				};

				function FrameWH() {
					var h = $(window).height();
					$("iframe").css("height", h + "px");
				}
			});
		</script>
	</body>

</html>