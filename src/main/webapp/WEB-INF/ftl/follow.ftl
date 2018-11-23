<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的关注</title>
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
					<!--white-space: nowrap;overflow: hidden;text-overflow: ellipsis;-->
					<#if followList??>
						<#if (followList?size>0) >
							<#list followList as follow>
					        <div class="layui-inline layui-text" style="width: 150px;height: 200px;border: 1px solid lightgray;">
                                &emsp;&emsp;&emsp;
                                <#if follow.moderator.id??>
									<a href="/gotoCusDetail.do?cus_id=${follow.moderator.id}"><img src="${follow.moderator.img}" class="layui-nav-img" style="width: 60px;height: 60px;"></a>
								<#else >
									<a href="/gotoCusDetail.do?cus_id=${follow.moderator.id}"><img src="#" class="layui-nav-img" style="width: 60px;height: 60px;"></a>
								</#if>
                                <br />
                                <h3>昵称: <a href="/gotoCusDetail.do?cus_id=${follow.moderator.id}">
									<#if follow.moderator.name??>
										${follow.moderator.name}
									<#else >
										${follow.moderator.loginName}
									</#if>
                                </a></h3>
                                <br />
                                <h6 class="ellipsis">个性签名: <i>
									<#if follow.moderator.suggest??>
										${follow.moderator.suggest}
									</#if>
                                </i></h6>
                                <br />

                                <button class="layui-btn layui-btn-primary layui-btn-xs" type="button" onclick="unfollow('${follow.customer.id}','${follow.moderator.id}')">取消关注</button>
                            </div>
							</#list>
							<#else >
								亲爱的,坛友,貌似你还没有关注过版主...
						</#if>
						<#else >
							亲爱的,坛友,貌似你还没有关注过版主...
					</#if>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			var lyr;
            layui.use('layer', function() {
                var layer = layui.layer;
                lyr = layer;
			});

			$(".layui-text").each(function() {//遍历file_name中的每个子元素
				    
				var v = $(this).children('.ellipsis').text();    
				if(v.length > 20){
					// 用V的前20个字符+"......"+后15个字符代替V
					var new_value = v.substring(0, 11) + '...';
					$(this).children('.ellipsis').text(new_value); //设置新的text()
				}
			});

			function unfollow(cusid,bmid) {
				$.post("/delFollow.do",{cusid: cusid,bmid: bmid},function (data) {
				    if(data.length==0){
                        lyr.msg("取消关注成功");
					}
                });
            }
		</script>
	</body>

</html>