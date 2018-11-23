<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的粉丝</title>
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
					<#if fansList??>
						<#if (fansList?size>0) >
							<#list fansList as fans>
					        <div class="layui-inline layui-text" style="width: 150px;height: 200px;border: 1px solid lightgray;">
                                &emsp;&emsp;
                                <#if fans.customer.img??>
									<a href="/gotoCusDetail.do?cus_id=${fans.customer.id}"><img src="${fans.customer.img}" class="layui-nav-img" style="width: 60px;height: 60px;"></a>
                                    <#else >
									<a href="/gotoCusDetail.do?cus_id=${fans.customer.id}"><img src="#" class="layui-nav-img" style="width: 60px;height: 60px;"></a>
                                </#if>
                                <br />
                                <h3>昵称: <a href="/gotoCusDetail.do?cus_id=${fans.customer.id}">
									<#if fans.customer.name??>
										${fans.customer.name}
									<#else >
										${fans.customer.loginName}
									</#if>
                                </a></h3>
                                <br />
                                <h6 class="ellipsis">个性签名: <i>
									<#if fans.customer.suggest??>
										${fans.customer.suggest}
									</#if>
                                </i></h6>
                                <br />

                            </div>
							</#list>
						<#else >
								亲爱的,版主,貌似你还没有没有粉丝,多多发帖,积累粉丝吧...
						</#if>
					<#else >
							亲爱的,版主,貌似你还没有没有粉丝,多多发帖,积累粉丝吧...
					</#if>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>

		<script>
			$(".layui-text").each(function() {//遍历file_name中的每个子元素
				    
				var v = $(this).children('.ellipsis').text();    
				if(v.length > 20){
					// 用V的前20个字符+"......"+后15个字符代替V
					var new_value = v.substring(0, 11) + '...';
					$(this).children('.ellipsis').text(new_value); //设置新的text()
				}
			});
		</script>
	</body>

</html>