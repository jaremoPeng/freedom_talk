<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的收藏</title>
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
					<#if collectList??>
						<#if (collectList?size>0)>
							<#list collectList as collect>
							    <div class="layui-card" style="border: 1px solid lightgray;">
                                    <div class="layui-card-header">
                                        <a class="ellipsis" href="">${collect.note.title}</a>
                                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                        <button class="layui-btn layui-btn-xs" type="button" onclick="unCollect('${collect.customer.id}','${collect.id}')">取消收藏</button>
                                    </div>
                                    <div class="layui-card-body layui-inline layui-text">
										${collect.note.content}
                                        <p align="right">作者: <a href="/gotoCusDetail.do?cus_id=${collect.customer.id}">${collect.customer.name}</a> 浏览数: <i>${collect.note.browserNum}</i> 评论数: <i>${collect.note.commentNum}</i></p>
										<br>
                                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
										<small>收藏时间: ${collect.time}</small>
                                    </div>
                                </div>
							</#list>
							<#else >
								抱歉,您还未收藏过帖子...
						</#if>
					    <#else >
							抱歉,您还未收藏过帖子...
					</#if>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>
		
		<script>
			var lyr;
			layui.use("layer",function () {
				var layer = layui.layer;
				lyr = layer;
            });
			$(".layui-card-header").each(function() {//遍历file_name中的每个子元素
				    
				var v = $(this).children('.ellipsis').text();    
				if(v.length > 10){
					// 用V的前指定个字符+"..."
					var new_value = v.substring(0, 9) + '...';
					$(this).children('.ellipsis').text(new_value); //设置新的text()
				}
			});

			function unCollect(cusid,colid) {
				$.post("/delCollect.do",{cusid: cusid,colid: colid},function (data) {
					if(data.length==0){
					    lyr.msg("取消收藏成功");
					}
                });
            }
		</script>
	</body>

</html>