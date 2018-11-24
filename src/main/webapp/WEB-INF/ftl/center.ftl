<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>个人中心</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-layout layui-layout-admin">
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
				<legend>自由说论坛-个人中心</legend>
			</fieldset>

			<div class="layui-side layui-bg-gray custom-admin">
				<div class="layui-side-scroll">
					<ul class="layui-nav layui-nav-tree" style="background-color: lightseagreen;" lay-filter="test">
						<li class="layui-nav-item layui-nav-itemed">
							<a href="#" data-url="/gotoMeans.do?cus_id=${now_customer.id}" data-title="修改资料" data-id="442" class="site-demo-active" data-type="tabAdd">修改资料</a>
						</li>
						<li class="layui-nav-item">
							<a href="#" data-url="/gotoFollow.do?cus_id=${now_customer.id}" data-title="我的关注" data-id="443" class="site-demo-active" data-type="tabAdd">我的关注</a>
						</li>
						<li class="layui-nav-item">
							<#if now_customer.type==2>
                                <a href="#" data-url="/gotoFans.do?cus_id=${now_customer.id}" data-title="我的粉丝" data-id="444" class="site-demo-active" data-type="tabAdd">我的粉丝</a>
								<#else >
								<a href="#">我的粉丝</a>
							</#if>
						</li>
						<li class="layui-nav-item">
							<a href="#" data-url="/gotoCollect.do?cus_id=${now_customer.id}" data-title="我的收藏" data-id="445" class="site-demo-active" data-type="tabAdd">我的收藏</a>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">账户安全</a>
							<dl class="layui-nav-child">
								<dd>
									<a data-url="/gotoEditPass.do?cus_id=${now_customer.id}" data-id="11" data-title="修改密码" href="#" class="site-demo-active" data-type="tabAdd">修改密码</a>
								</dd>
								<dd>
									<a href="#" data-url="/gotoEditQue.do?cus_id=${now_customer.id}" data-title="修改验证问题" data-id="22" class="site-demo-active" data-type="tabAdd">修改验证问题</a>
								</dd>
							</dl>
						</li>
						<li class="layui-nav-item">
							<a href="javascript:;">功能管理</a>
							<dl class="layui-nav-child">
								<dd>
									<a data-url="/gotoLeaveWorld.do?cus_id=${now_customer.id}" data-id="23" data-title="留言管理" href="#" class="site-demo-active" data-type="tabAdd">留言管理</a>
								</dd>
								<dd>
                                    <#if now_customer.type==2>
                                        <a href="#" data-url="/gotoNoteList.do?cus_id=${now_customer.id}" data-title="帖子管理" data-id="24" class="site-demo-active" data-type="tabAdd">帖子管理</a>
                                    <#else >
								        <a href="#">帖子管理</a>
                                    </#if>
								</dd>
							</dl>
						</li>
                        <li class="layui-nav-item">
                            <a href="/index.do?cus_id=${now_customer.id}">返回首页</a>
                        </li>
					</ul>
				</div>
			</div>

			<div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
				<ul class="layui-tab-title">
				</ul>
				<ul class="rightmenu" style="display: none;position: absolute;">
					<li data-type="closethis">关闭当前</li>
					<li data-type="closeall">关闭所有</li>
				</ul>
				<div class="layui-tab-content">
				</div>
			</div>
		</div>
		
		<script>
			layui.use('element', function() {
				var $ = layui.jquery;
				var element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

				//触发事件
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
						CustomRightClick(id); //给tab绑定右击事件
						FrameWH(); //计算ifram层的大小
					},
					tabChange: function(id) {
						//切换到指定Tab项
						element.tabChange('demo', id); //根据传入的id传入到指定的tab项
					},
					tabDelete: function(id) {
						element.tabDelete("demo", id); //删除
					},
					tabDeleteAll: function(ids) { //删除所有
						$.each(ids, function(i, item) {
							element.tabDelete("demo", item); //ids是一个数组，里面存放了多个id，调用tabDelete方法分别删除
						})
					}
				};

				//当点击有site-demo-active属性的标签时，即左侧菜单栏中内容 ，触发点击事件
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

				function CustomRightClick(id) {
					//取消右键  rightmenu属性开始是隐藏的 ，当右击的时候显示，左击的时候隐藏
					$('.layui-tab-title li').on('contextmenu', function() {
						return false;
					})
					$('.layui-tab-title,.layui-tab-title li').click(function() {
						$('.rightmenu').hide();
					});
					//桌面点击右击 
					$('.layui-tab-title li').on('contextmenu', function(e) {
						var popupmenu = $(".rightmenu");
						popupmenu.find("li").attr("data-id", id); //在右键菜单中的标签绑定id属性

						//判断右侧菜单的位置 
						l = ($(document).width() - e.clientX) < popupmenu.width() ? (e.clientX - popupmenu.width()) : e.clientX;
						t = ($(document).height() - e.clientY) < popupmenu.height() ? (e.clientY - popupmenu.height()) : e.clientY;
						popupmenu.css({
							left: l,
							top: t
						}).show(); //进行绝对定位
						//alert("右键菜单")
						return false;
					});
				}

				$(".rightmenu li").click(function() {

					//右键菜单中的选项被点击之后，判断type的类型，决定关闭所有还是关闭当前。
					if($(this).attr("data-type") == "closethis") {
						//如果关闭当前，即根据显示右键菜单时所绑定的id，执行tabDelete
						active.tabDelete($(this).attr("data-id"))
					} else if($(this).attr("data-type") == "closeall") {
						var tabtitle = $(".layui-tab-title li");
						var ids = new Array();
						$.each(tabtitle, function(i) {
							ids[i] = $(this).attr("lay-id");
						})
						//如果关闭所有 ，即将所有的lay-id放进数组，执行tabDeleteAll
						active.tabDeleteAll(ids);
					}

					$('.rightmenu').hide(); //最后再隐藏右键菜单
				})

				function FrameWH() {
					var h = $(window).height() - 41 - 10 - 60 - 10 - 44 - 10;
					$("iframe").css("height", h + "px");
				}

				$(window).resize(function() {
					FrameWH();
				})
			});
		</script>
	</body>

</html>