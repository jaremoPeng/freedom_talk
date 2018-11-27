<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>分类下的帖子</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/layui.css" />
		<script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="/js/layui.js"></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">

				</div>
				<div class="layui-col-md6 layui-text">
					<div class="layui-card">
						<div class="layui-card-header">该分类下的帖子:</div>
						<div class="layui-card-body">
							<#if noteList??>
							    <#if (noteList?size>0)>
							        <#list noteList as note>
							            <a href="/gotoNoteDetail.do?note_id=${note.id}">${note.title}</a>&emsp;&emsp;&emsp;&emsp;作者:<a href="/gotoCusDetail.do?cus_id=${note.customer.id}">${note.customer.loginName}</a><br>
							        </#list>
							    </#if>
							</#if>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>
	</body>

</html>