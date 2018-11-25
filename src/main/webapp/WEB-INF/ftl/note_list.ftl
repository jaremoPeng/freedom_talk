<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的帖子</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div>
			&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
			<button id="note_add" class="layui-btn">添加帖子</button>
		</div>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md4">

				</div>
				<div class="layui-col-md5">
					<#if noteList??>
					    <#if (noteList?size>0)>
							<#list noteList as note>
							    <div class="layui-card layui-text" style="border: 1px solid lightgray;">
                                    <div class="layui-card-header">
                                        <a href="/gotoNoteDetail.do?note_id=${note.id}">${note.title}</a>
                                        &emsp;&emsp;&emsp;&emsp;
                                        <button class="layui-btn layui-btn-primary layui-btn-xs" onclick="del_note('${note.id}')">删除帖子</button>
                                    </div>
                                    <div class="layui-card-body">
                                        <h6 class="note_substr">
                                            <span>${note.content}</span>
                                        </h6>
                                        <br />
                                        <small>发帖时间: ${note.time} &emsp;&emsp;评论数: <em>${note.commentNum}</em> &emsp;&emsp;浏览数: <em>${note.browserNum}</em></small>
                                    </div>
                                </div>
							</#list>
							<#else>
								你还没发表过帖子...
					    </#if>
						<#else>
							你还没发表过帖子...
					</#if>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			var lyr;
			layui.use('layer', function() {
				var $ = layui.jquery,
					layer = layui.layer;
				lyr = layer;

                var foo= $("h6[class='note_substr']");
                $(foo).each(function() {
                    var vari = $(this).children("span");
                    var valu = vari.text();
                    if(valu.length>80){
                        var new_val = valu.substr(0,50)+'...';
                        vari.text(new_val);
					}
                });

				$("#note_add").on("click", function() {
					layer.open({
						type: 2,
						title: '增加帖子',
						shadeClose: true,
						shade: false,
						maxmin: false, //开启最大化最小化按钮
						area: ['600px', '400px'],
						content: '/gotoNoteAdd.do?cus_id=${now_customer.id}'
					});
				});

			});

			function del_note(noteid) {
				$.post("/delNote.do",{noteid: noteid},function (data) {
					if(data.length==0){
					    lyr.msg("删除帖子成功");
					}else{
                        lyr.msg("删除帖子失败");
					}
                });
            }
		</script>
	</body>

</html>