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
							<#if categoryList??>
							    <#if (categoryList?size>0)>
							        <#list categoryList as category>
                                        <#if now_customer??>
                                            <a href="/gotoCategoryNoteList.do?cus_id=${now_customer.id}&cate_id=${category.id}">${category.name}</a><br>
                                            <#else >
                                                <a href="/gotoCategoryNoteList.do?cus_id=&cate_id=${category.id}">${category.name}</a><br>
                                        </#if>
							        </#list>
							    </#if>
							</#if>
						</div>
					</div>
					<div class="layui-card">
						<div class="layui-card-header"><h3>来口鸡汤补补!</h3></div>
						<div class="layui-card-body">
							再往前一点点,再努力一点点
							<img src="/img/960a304e251f95ca49a0bc89cc177f3e670952b3.jpg" style="width: 200px;height: 150px;">
						</div>
					</div>
				</div>
				<div class="layui-col-md6">
					<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
						<legend>热点</legend>
					</fieldset>
					<div class="layui-carousel" style="width: 500px;" id="test3" lay-filter="test4">
						<div carousel-item="">
							<div><img src="/img/kebi.jpg" /></div>
							<div><img src="/img/kebi.jpg" /></div>
							<div><img src="/img/heizeiwang2.jpg" /></div>
							<div><img src="/img/kebi.jpg" /></div>
							<div><img src="/img/heizeiwang1.jpg" /></div>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>热帖榜</h3></div>
						<div class="layui-card-body">
							<#if noteList??>
								<#if (noteList?size>0)>
									<#list noteList as note>
							            <a href="/gotoNoteDetail.do?note_id=${note.id}">${note.title}</a><br>
									</#list>
								</#if>
							</#if>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>昨日热帖</h3></div>
						<div class="layui-card-body">
							<#if ytNoteList??>
								<#if (ytNoteList?size>0)>
									<#list ytNoteList as note>
							            <a href="/gotoNoteDetail.do?note_id=${note.id}">${note.title}</a><br>
									</#list>
								</#if>
							</#if>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>今日新帖</h3></div>
						<div class="layui-card-body">
							<#if newNoteList??>
								<#if (newNoteList?size>0)>
									<#list newNoteList as note>
							            <a href="/gotoNoteDetail.do?note_id=${note.id}">${note.title}</a><br>
									</#list>
								</#if>
							</#if>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>常看分类</h3></div>
						<div class="layui-card-body">
							<#if categoryList??>
							    <#if (categoryList?size>0)>
									<#list categoryList as category>
							            <a href="">${category.name}</a>
									</#list>
								</#if>
							</#if>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>论坛公告</h3></div>
						<div class="layui-card-body">
							<#if announcements??>
							    <#if (announcements?size>0)>
									<#list announcements as ac>
										<small>${ac.content} &emsp;${ac.time}</small><br>
									</#list>
								</#if>
							</#if>
						</div>
					</div>
					<div class="layui-card layui-text">
						<div class="layui-card-header"><h3>热门版主</h3></div>
						<div class="layui-card-body">
							<#if customers??>
							    <#if (customers?size>0)>
									<#list customers as customer>
							            <a href="/gotoCusDetail.do?cus_id=${customer.id}">${customer.loginName}</a><br>
									</#list>
								</#if>
							</#if>
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