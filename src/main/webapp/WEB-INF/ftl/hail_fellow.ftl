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
							<#if hailFellows??>
								<#if (hailFellows?size>0)>
									<#list hailFellows as hailFellow>
									    <div class="hf" style="border: 1px solid lightgray;">
                                            &emsp;&emsp;
                                            <a href="/gotoCusDetail.do?cus_id=${hailFellow.toCustomer.id}">
                                                <img src="${hailFellow.toCustomer.img}" class="layui-nav-img" style="width: 40px;height: 40px;">
                                            </a>
                                            <sup><a href="/gotoCusDetail.do?cus_id=${hailFellow.toCustomer.id}">
												<#if hailFellow.remarks??>
													${hailFellow.remarks}
													<#else >
														<#if hailFellow.toCustomer.name??>
															${hailFellow.toCustomer.name}
															<#else>
																${hailFellow.toCustomer.loginName}
														</#if>
												</#if>
											</a></sup> &emsp;
                                            <small class="hf_substr">
												<#if hailFellow.toCustomer.suggest??>
													${hailFellow.toCustomer.suggest}
												</#if>
											</small> &emsp;
                                            <button id="to_chat" class="layui-btn layui-btn-xs" onclick="to_chat('${now_customer.id}','${hailFellow.toCustomer.id}','<#if hailFellow.remarks??>${hailFellow.remarks}<#else ><#if hailFellow.toCustomer.name??>${hailFellow.toCustomer.name}<#else>${hailFellow.toCustomer.loginName}</#if></#if>')">与TA聊天</button>
                                            <button id="edit_remarks" class="layui-btn layui-btn-primary layui-btn-xs" onclick="edit_remarks('${now_customer.id}','${hailFellow.toCustomer.id}','<#if hailFellow.remarks??>${hailFellow.remarks}<#else ><#if hailFellow.toCustomer.name??>${hailFellow.toCustomer.name}<#else>${hailFellow.toCustomer.loginName}</#if></#if>')">修改备注</button>
                                            <button id="del_hf" class="layui-btn layui-btn-danger layui-btn-xs" onclick="del_hf('${now_customer.id}','${hailFellow.toCustomer.id}')"> 删除好友</button>
                                        </div>
										<br />
									</#list>
									<#else>
										你还没有好友...
								</#if>
								<#else>
									你还没有好友...
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
			layui.use('layer', function() {
				var $ = layui.jquery,
					layer = layui.layer;

                lyr = layer;

				$(".hf").each(function() { //遍历file_name中的每个子元素
					    
					var v = $(this).children('.hf_substr').text();    
					if(v.length > 20) {
						// 用V的前20个字符+"......"+后15个字符代替V
						var new_value = v.substring(0, 9) + '...';
						$(this).children('.hf_substr').text(new_value); //设置新的text()
					}
				});

			});

			function edit_remarks(fromid,toid,name) {
                lyr.open({
                    type: 2,
                    title: '给好友- '+name+'  备注中...',
                    shadeClose: true,
                    shade: false,
                    maxmin: false, //开启最大化最小化按钮
                    area: ['400px', '200px'],
                    content: '/gotoHfremarks.do?fromid='+fromid+'&toid='+toid
                });
            }

			function del_hf(fromid,toid) {
                lyr.confirm('你确定删除该好友？', {
                    btn: ['确定', '取消'] //按钮
                }, function() {
                    $.post('/deleteHf.do',{fromid:fromid,toid:toid},function (data) {
						if(data.length==0){
                            lyr.msg('删除成功', {
                                icon: 1
                            });
                            return;
						}
                        lyr.msg('删除失败', {
                            icon: 2
                        });
                    });

                }, function() {
                    lyr.msg('取消成功', {
                        time: 20000, //20s后自动关闭
                        btn: ['知道了']
                    });
                });
            }

            function to_chat(fromid,toid,name) {
                lyr.open({
                    type: 2,
                    title: '与- '+name+'  聊天中...',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['600px', '400px'],
                    content: '/gotoHfchat.do?fromid='+fromid+'&toid='+toid
                });
            }
		</script>
	</body>

</html>