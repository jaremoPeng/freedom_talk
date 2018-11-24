<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的留言</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<!--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>自由说论坛-留言板</legend>
		</fieldset>-->
		<div>
			&emsp;&emsp;&emsp;&emsp;
			<button class="layui-btn">开启留言板</button>
			&emsp;&emsp;&emsp;&emsp;
			<button class="layui-btn layui-btn-danger">关闭留言板</button>
		</div>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">

				</div>
				<div class="layui-col-md6 layui-text">
					<#if leaveWords??>
					    <#if (leaveWords?size>0)>
							<#list leaveWords as leaveWord>
							    <div class="layui-card" style="border: 1px solid lightgray;">
                                    <div class="layui-card-header">
                                        <a href="/gotoCusDetail.do?cus_id=${leaveWord.fromCustomer.id}"><img src="${leaveWord.fromCustomer.img}" class="layui-nav-img" style="width: 40px;height: 40px;"></a>
                                        <a href="/gotoCusDetail.do?cus_id=${leaveWord.fromCustomer.id}">
								<#if leaveWord.fromCustomer.name??>
									${leaveWord.fromCustomer.name}
								<#else >
									${leaveWord.fromCustomer.loginName}
								</#if>
                                        </a> : &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                        <button class="layui-btn layui-btn-primary layui-btn-xs">删除留言</button>
                                        <button class="layui-btn layui-btn-primary layui-btn-xs">禁止留言</button>
                                    </div>
                                    <div class="layui-card-body">
                                        <h3>留言内容:</h3>
                                        <p>
                                            &emsp;&emsp;${leaveWord.content}
                                        </p>

                                        <small>时间: ${leaveWord.time}</small>
                                        <div class="layui-card" style="border: 1px solid lightgray;">
                                            <div class="layui-card-header">
                                                回复 -
												<#if leaveWord.fromCustomer.name??>
													${leaveWord.fromCustomer.name}
												<#else >
													${leaveWord.fromCustomer.loginName}
												</#if>:
                                            </div>
                                            <div class="layui-card-body">
                                                <textarea placeholder="请输入..." class="layui-textarea"></textarea>
                                                <button class="layui-btn">回复</button>
                                            </div>
                                        </div>
										<#list leaveWordReplys.keySet() as lwrKey>
											<#if lwrKey==leaveWord.id>
												<#list leaveWordReplys[lwrKey] as lwrs>
													<#list lwrs as lwr>
													    <div class="layui-card" style="border: 1px solid lightgray;">
                                                            <div class="layui-card-header">
                                                                回复内容:
                                                            </div>
                                                            <div class="layui-card-body">
                                                                <div style="border: 1px solid lightgray;">
                                                                    ${lwr.fromCustomer.name} 回复 ${lwr.toCustomer.name}: <small>时间: ${lwr.replyTime}</small>
                                                                    <br />
                                                                    <p>&emsp;&emsp;${lwr.replyContent} </p>
                                                                </div>
                                                                <br />
                                                            </div>
                                                        </div>
													</#list>
												</#list>
											</#if>
										</#list>
                                    </div>
                                </div>
							</#list>
					        <#else>
							您还没有留言...
					    </#if>
						<#else >
						您还没有留言...
					</#if>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>
	</body>

</html>