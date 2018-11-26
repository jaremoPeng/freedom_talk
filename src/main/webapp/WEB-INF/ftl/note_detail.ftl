<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>帖子详情</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<div class="layui-fluid">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md2" style="padding-top: 100px;">
					&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;
					<div class="layui-inline layui-text" style="width: 150px;height: 250px;border: 1px solid lightgray;">
						&emsp;&emsp;&emsp;
						<a href="/gotoCusDetail.do?cus_id=${note.customer.id}"><img src="${note.customer.img}" class="layui-nav-img" style="width: 60px;height: 60px;"></a>
						<br />
						<br />
						<h3>&emsp;昵称: <a href="/gotoCusDetail.do?cus_id=${note.customer.id}">
							<#if note.customer.name??>
								${note.customer.name}
								<#else>
									${note.customer.loginName}
							</#if>
						</a></h3>
						<br />
						<h6 class="ellipsis">个性签名: <i>${note.customer.suggest}</i></h6>
						<br /> &emsp;&emsp;&emsp;&emsp;

						<button class="layui-btn layui-btn-primary layui-btn-xs" type="button" onclick="follow_bm('${note.customer.id}')">关注</button>
					</div>
				</div>
				<div class="layui-col-md10 layui-text">
					<div class="layui-card" style="border: 1px solid lightgray;">
						<div class="layui-card-header">
							&emsp;&emsp;&emsp;&emsp;
							<h2 class="layui-inline"><strong>${note.title}</strong></h2>
							<span>
								作者: <a href="/gotoCusDetail.do?cus_id=${note.customer.id}">
										<#if note.customer.name??>
											${note.customer.name}
										<#else>
											${note.customer.loginName}
										</#if>
									</a>
								&emsp;&emsp;
								<small>发帖时间: ${note.time}</small>
								&emsp;&emsp;
								<small>浏览数: <em>${note.browserNum}</em>&emsp;&emsp;&emsp; 评论数: <em>${note.commentNum}</em></small>
							</span>
						</div>
						<br />
						<div class="layui-card-body" style="width: 70%;">
							<h3>
								&emsp;&emsp;${note.content}
							</h3>
							&emsp;
							<br>
                            <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" onclick="show_vp('${note.id}','${now_customer.id}')">评论</button>
						</div>
					</div>
					<div class="layui-card" style="border: 1px solid lightgray;">
						<div class="layui-card-header">
							<h3>评论: </h3>
						</div>
						<br />
						<div class="layui-card-body">
							<#if viewPointList??>
							    <#if (viewPointList?size>0)>
									<#list viewPointList as viewPoint>
									    <div style="border: 1px solid lightgray;">
                                            <br /> &emsp;
                                            <a href="/gotoCusDetail.do?cus_id=${viewPoint.customer.id}">
                                                <img src="${viewPoint.customer.img}" class="layui-nav-img" style="width: 40px;height: 40px;">
                                            </a>
                                            <a href="/gotoCusDetail.do?cus_id=${viewPoint.customer.id}">
												<#if viewPoint.customer.name??>
													${viewPoint.customer.name}
													<#else>
														${viewPoint.customer.loginName}
												</#if>

											</a>
                                            <span>发表于(<small>时间: ${viewPoint.time} </small>): </span> &emsp;&emsp;
                                            <span><u>${viewPoint.content}</u></span>
                                            <br />
                                            <br /> &emsp;&emsp;&emsp;&emsp;
                                            <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" onclick="show_vpr('${viewPoint.id}','${now_customer.id}','${viewPoint.customer.id}')">回复</button>
                                            <br />
                                            <hr />

                                            <div class="layui-card" style="width: 80%;padding-left: 50px;">
                                                <div class="layui-card-header">以下是该评论的回复: </div>
                                                <div class="layui-card-body">
													<#if viewPoint.viewPointReplyList??>
													    <#if (viewPoint.viewPointReplyList?size>0)>
															<#list viewPoint.viewPointReplyList as vpr>
															    <br /> &emsp;
																<a href="/gotoCusDetail.do?cus_id=${vpr.fromCustomer.id}">
																	<img src="${vpr.fromCustomer.img}" class="layui-nav-img" style="width: 40px;height: 40px;">
																</a>
																<a href="/gotoCusDetail.do?cus_id=${vpr.fromCustomer.id}">
																	<#if vpr.fromCustomer.name??>
																		${vpr.fromCustomer.name}
																		<#else >
																			${vpr.fromCustomer.loginName}
																	</#if>
																</a>
																<span>回复 </span>
																<a href="/gotoCusDetail.do?cus_id=${vpr.toCustomer.id}">
																	<img src="${vpr.toCustomer.img}" class="layui-nav-img" style="width: 40px;height: 40px;">
																</a>
																<a href="/gotoCusDetail.do?cus_id=${vpr.toCustomer.id}">
																	<#if vpr.toCustomer.name??>
																		${vpr.toCustomer.name}
																	<#else >
																		${vpr.toCustomer.loginName}
																	</#if>
																</a>
																(<small>时间: ${vpr.time} </small>): &emsp;&emsp;
																<span><u>${vpr.content}</u></span>

																<br>&emsp;
																<button type="button" class="layui-btn layui-btn-primary layui-btn-xs" onclick="show_vpr('${viewPoint.id}','${now_customer.id}','${vpr.fromCustomer.id}')">回复</button>
																<hr>
																<br>
															</#list>
													        <#else >
																还没评论回复...
													    </#if>
														<#else >
															还没评论回复...
													</#if>
                                                </div>
                                            </div>
                                        </div>
									</#list>
							        <#else >
										该帖子,还没有没评论...
							    </#if>
								<#else >
									该帖子,还没有没评论...
							</#if>
						</div>
					</div>
				</div>
			</div>
		</div>

		<script>
			var lyr;
			layui.use(['form', 'layer'], function() {
				var form = layui.form,
					$ = layui.jquery,
					layer = layui.layer;

				lyr = layer;

				$(".layui-text").each(function() { //遍历file_name中的每个子元素
					    
					var v = $(this).children('.ellipsis').text();    
					if(v.length > 30) {
						// 用V的前20个字符+"......"+后15个字符代替V
						var new_value = v.substring(0, 12) + '...';
						$(this).children('.ellipsis').text(new_value); //设置新的text()
					}
				});
			});

            function show_vp(noteid,fromid) { // 发表观点
                lyr.open({
                    type: 2,
                    title: '填写评论',
                    shadeClose: true,
                    shade: false,
                    maxmin: false, //开启最大化最小化按钮
                    area: ['600px', '400px'],
                    content: '/gotoVp.do?noteid='+noteid+'&fromid='+fromid
                });
            }

			function show_vpr(vpid,fromid,toid) { // 发表观点回复
				lyr.open({
					type: 2,
					title: '填写回复',
					shadeClose: true,
					shade: false,
					maxmin: false, //开启最大化最小化按钮
					area: ['600px', '400px'],
					content: '/gotoVpR.do?vpid='+vpid+'&fromid='+fromid+'&toid='+toid
				});
            }
		</script>
	</body>

</html>