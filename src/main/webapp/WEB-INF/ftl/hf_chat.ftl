<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>聊天</title>
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
				<div class="layui-col-md6" style="height: 700px;">
					<div class="layui-card" style="width: 100%;height: 90%;border: 1px solid lightgray;">
						<div class="layui-card-body" style="height: 100%;padding-left: 50px;">
							<div style="height: 70%;width: 90%;border: 1px solid lightgray;overflow:auto;">
								<#if chats??>
									<#if (chats?size>0)>
										<#list chats as chat>
										    <div>
                                                &emsp;
                                                <a href="/gotoCusDetail.do?cus_id=${chat.fromCustomer.id}">
                                                    <img src="${chat.fromCustomer.img}" class="layui-nav-img" style="width: 30px;height: 30px;">
                                                </a>
                                                <a href="/gotoCusDetail.do?cus_id=${chat.fromCustomer.id}">
													<#if chat.fromCustomer.name??>
                                                        ${chat.fromCustomer.name}
														<#else >
															${chat.fromCustomer.loginName}
													</#if>
												</a>
                                                <span>(<small>时间: ${chat.time} </small>)&emsp;说: </span>
                                                <br /> &emsp;&emsp;&emsp;&emsp;
                                                <span><u>${chat.content}</u></span>
                                            </div>
										</#list>
									</#if>
								</#if>
							</div>
							
							<br />
							<div class="layui-input-inline" style="width: 80%;">
								<textarea id="content" name="content" placeholder="请输入内容" class="layui-textarea"></textarea>
							</div>
							<button class="layui-btn layui-btn-sm" type="button" onclick="send_msg('${now_customer.id}','${toCustomer.id}')">确认</button>
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
            form.verify({
                content: function(value) {
                    if(value.length==0) {
                        return '请填写内容';
                    }
                }
            });
        });

        function send_msg(fromid,toid) {
            var content=$("#content").val();
            if(content.length==0){
                lyr.msg("请键入消息");
            }else{
                $.post('/lendChat.do',{content:content,fromid: fromid,toid:toid},function (data) {
                    if(data.length==0){
                        $("#content").val('');
                        lyr.msg("发送成功");
                    }else{
                        lyr.msg("发送失败");
                    }
                });
            }
        }
	</script>
	</body>

</html>