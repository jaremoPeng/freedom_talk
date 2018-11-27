<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>搜索结果</title>
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
						<div class="layui-card-header">搜素结果</div>
						<div class="layui-card-body">
							<#if categoryList??>
							    <div class="layui-card" style="border: 1px solid lightgray;">
                                    <div class="layui-card-header">分类:</div>
                                    <div class="layui-card-body">
										<#if (categoryList?size>0)>
										    <#list categoryList as category>
										        <a href="/gotoCategoryNoteList.do?cus_id=&cate_id=${category.id}">${category.name}</a><br>
										    </#list>
										</#if>
                                    </div>
                                </div>
							</#if>
							<#if noteList??>
							    <div class="layui-card" style="border: 1px solid lightgray;">
                                    <div class="layui-card-header">帖子:</div>
                                    <div class="layui-card-body">
										<#if (noteList?size>0)>
										    <#list noteList as note>
										        <a href="/gotoNoteDetail.do?note_id=${note.id}">${note.title}</a><br>
										    </#list>
										</#if>
                                    </div>
                                </div>
							</#if>
							<#if query_customer??>
							    <div class="layui-card" style="border: 1px solid lightgray;">
                                    <div class="layui-card-header">用户:</div>
                                    <div class="layui-card-body">
                                        <a href="/gotoCusDetail.do?cus_id=${query_customer.id}">${query_customer.loginName}</a>
                                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                        <button class="layui-btn layui-btn-primary layui-btn-xs" onclick="hf_add('${now_customer.id}','${query_customer.id}')">+加好友</button>
                                        <button class="layui-btn layui-btn-primary layui-btn-xs" onclick="lw_add('${now_customer.id}','${query_customer.id}')">留言</button>
                                        <br>
                                    </div>
                                </div>
							</#if>
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

        function lw_add(fromid,id) {
            lyr.open({
                type: 2,
                title: '',
                shadeClose: true,
                shade: false,
                maxmin: false, //开启最大化最小化按钮
                area: ['600px', '300px'],
                content: '/gotoLeaveWordAdd.do?toid='+id+'&fromid='+fromid
            });
        }

        function hf_add(fromid,id) {
            lyr.open({
                type: 2,
                title: '',
                shadeClose: true,
                shade: false,
                maxmin: false, //开启最大化最小化按钮
                area: ['600px', '300px'],
                content: '/gotoHailFellowAdd.do?toid='+id+'&fromid='+fromid
            });
        }
	</script>
	</body>

</html>