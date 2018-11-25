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
            <#if isStart??>
                <#if isStart==1>
                    <button class="layui-btn layui-btn-danger" onclick="operate('close')">关闭留言板</button>
                    <#else >
                        <button class="layui-btn" onclick="operate('open')">开启留言板</button>
                </#if>
            </#if>
		</div>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md3">
                    &emsp;
                    <br>
                    &emsp;
                    <br>
                    <div id="reply_page" class="layui-card" style="border: 1px solid lightgray;display: none;">
                        <div class="layui-card-header">
                            回复 - <font id="reply_name"></font> :
                        </div>
                        <div class="layui-card-body">
                            <textarea id="reply_content" placeholder="请输入..." class="layui-textarea"></textarea>
                            <input type="hidden" name="fromid">
                            <input type="hidden" name="toid">
                            <input type="hidden" name="lwid">
                            <button class="layui-btn" onclick="reply()">回复</button>
                            <button class="layui-btn layui-btn-danger" onclick="shut()">关闭</button>
                        </div>
                    </div>
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
                                        <button class="layui-btn layui-btn-primary layui-btn-xs" onclick="del_lw('${leaveWord.fromCustomer.id}','${leaveWord.toCustomer.id}','${leaveWord.id}')">删除留言</button>
                                        <button class="layui-btn layui-btn-primary layui-btn-xs" onclick="un_lw('${now_customer.id}','${leaveWord.fromCustomer.id}')">禁止留言</button>
                                    </div>
                                    <div class="layui-card-body">
                                        <h3>留言内容:</h3>
                                        <p>
                                            &emsp;&emsp;<u>${leaveWord.content}</u>
                                        </p>

                                        <small>时间: ${leaveWord.time}</small>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                        <button class="layui-btn layui-btn-primary layui-btn-xs"
                                                onclick="showpage('${now_customer.id}'
                                                        ,'${leaveWord.fromCustomer.id}'
                                                        ,'${leaveWord.id}'
                                                        ,'<#if leaveWord.fromCustomer.name??>${leaveWord.fromCustomer.name}<#else >${leaveWord.fromCustomer.loginName}</#if>')">回复</button>
                                        <br>&emsp;&emsp;<br>
                                        <#if leaveWord.leaveWordReplyList??>
                                        <div class="layui-card layui-text" style="border: 1px solid lightgray;">
                                            <div class="layui-card-header">
                                                回复内容:
                                            </div>
                                            <div class="layui-card-body">
                                                <#list leaveWord.leaveWordReplyList as lwr>
                                                    <div style="border: 1px solid lightgray;">
                                                        <a href="/gotoCusDetail.do?cus_id=${lwr.fromCustomer.id}">
                                                            <#if lwr.fromCustomer.name??>
                                                                ${lwr.fromCustomer.name}
                                                                <#else >
                                                                    ${lwr.fromCustomer.loginName}
                                                            </#if>
                                                        </a>
                                                         回复
                                                        <a href="/gotoCusDetail.do?cus_id=${lwr.toCustomer.id}">
                                                            <#if lwr.toCustomer.name??>
                                                                ${lwr.toCustomer.name}
                                                            <#else >
                                                                ${lwr.toCustomer.loginName}
                                                            </#if>
                                                        </a>
                                                        : <small>时间: ${lwr.replyTime}</small>
                                                        <br />
                                                        <p>&emsp;&emsp;<u>${lwr.replyContent}</u> </p>
                                                        <p>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                                                            <button class="layui-btn layui-btn-primary layui-btn-xs"
                                                                    onclick="showpage('${now_customer.id}'
                                                                    ,'${lwr.fromCustomer.id}'
                                                                    ,'${leaveWord.id}'
                                                                    ,'<#if lwr.fromCustomer.name??>${lwr.fromCustomer.name}<#else >${lwr.fromCustomer.loginName}</#if>')">回复</button>
                                                            <#if leaveWord.toCustomer.id==now_customer.id>
                                                                &emsp;<button class="layui-btn layui-btn-primary layui-btn-xs" onclick="del_lwr('${lwr.id}')">删除</button>
                                                            </#if>
                                                        </p>
                                                    </div>
                                                    <br />
                                                </#list>
                                            </div>
                                        </div>
                                        </#if>
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
                    <h3><strong>被禁止留言的用户:</strong></h3>
                    &emsp;
                    <br>
                    <ul class="layui-timeline">
                        <#if unLeaveWordList??>
                            <#if (unLeaveWordList?size>0)>
                                <#list unLeaveWordList as unLeaveWord>
                                    <li class="layui-timeline-item">
                                        <i class="layui-icon layui-timeline-axis"></i>
                                        <div class="layui-timeline-content layui-text">
                                            <h4 class="layui-timeline-title">
                                                <a href="/gotoCusDetail.do?cus_id=${unLeaveWord.toCustomer.id}">
                                                    <#if unLeaveWord.toCustomer.name??>
                                                        ${unLeaveWord.toCustomer.name}
                                                        <#else>
                                                            ${unLeaveWord.toCustomer.loginName}
                                                    </#if>
                                                </a>
                                                &emsp;&emsp;
                                                <button class="layui-btn layui-btn-primary layui-btn-xs">解除禁止留言</button>
                                            </h4>
                                        </div>
                                    </li>
                                </#list>
                            </#if>
                        </#if>
                    </ul>
                </div>
			</div>
		</div>

    <script>
        var lyr;
        layui.use('layer',function () {
           var layer=layui.layer;

           lyr = layer;
        });
        function showpage(fromid,toid,lwid,replyname) {
            $("input[name='fromid']").val(fromid);
            $("input[name='toid']").val(toid);
            $("input[name='lwid']").val(lwid);
            $("#reply_name").text(replyname);
            $("#reply_page").css("display","block");
        }

        function shut() {
            $("#reply_page").css("display","none");
        }

        function operate(type) {
            $.post("/editlwIsStart.do",{type:type , cus_id: '${now_customer.id}'},function (data) {
                if(type=='close'){
                    if(data.length==0){
                        lyr.msg("关闭留言板成功");
                        return;
                    }
                    lyr.msg("关闭留言板失败");
                    return;
                }
                if(type=='open'){
                    if(data.length==0){
                        lyr.msg("开启留言板成功");
                        return;
                    }
                    lyr.msg("开启留言板失败");
                    return;
                }
                lyr.msg("操作失败");
            });
        }

        function del_lw(fromid,toid,lwid) {
            $.post("/editlwIsDelete.do",{fromid:fromid ,toid: toid , lwid: lwid},function (data) {
                if(data.length==0){
                    lyr.msg("留言删除成功");
                    return;
                }
                lyr.msg("留言删除失败");
            });
        }

        function del_lwr(lwrid) {
            $.post("/delete_lwr.do",{lwrid: lwrid},function (data) {
                if(data.length==0){
                    lyr.msg("留言回复删除成功");
                    return;
                }
                lyr.msg("留言回复删除失败");
            });
        }

        function un_lw(fromid,toid) {
            $.post("/addUnLw.do",{fromid:fromid ,toid: toid},function (data) {
                if(data.length==0){
                    lyr.msg("禁言成功");
                    return;
                }
                lyr.msg("禁言失败");
            });
        }

        function reply() {
            var fromid = $("input[name='fromid']").val();
            var toid = $("input[name='toid']").val();
            var lwid = $("input[name='lwid']").val();

            var rcontent = $("#reply_content").val();
            if(rcontent.length!=0){
                $.post("/lend_lwr.do",{fromid:fromid ,toid: toid,lwid: lwid,content: rcontent},function (data) {
                    if(data.length==0){
                        lyr.msg("留言回复成功");
                        return;
                    }
                    lyr.msg("留言回复失败");
                });
            }else{
                lyr.msg("你还没有填写回复内容");
            }
        }
    </script>
	</body>

</html>