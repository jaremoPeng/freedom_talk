<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>用户资料</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/layui.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
	</head>

	<body>
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
			<legend>自由说论坛-用户资料</legend>
		</fieldset>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md2">

				</div>
				<div class="layui-col-md6">
					<div class="layui-card">
						<#if now_customer??>
                            <div class="layui-card-body">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">用户名</label>
                                    <div class="layui-input-block">
										<#if now_customer.loginName??>
                                            <input type="text" readonly="readonly" value="${now_customer.loginName}" autocomplete="off" class="layui-input">
										<#else >
											<input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">昵称</label>
                                    <div class="layui-input-block">
										<#if now_customer.name??>
                                            <input type="text" readonly="readonly" value="${now_customer.name}" autocomplete="off" class="layui-input">
										<#else >
											<input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">个性签名</label>
                                    <div class="layui-input-block">
										<#if now_customer.suggest??>
                                            <input type="text" readonly="readonly" value="${now_customer.suggest}" autocomplete="off" class="layui-input">
										<#else >
											<input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">邮箱</label>
                                    <div class="layui-input-block">
										<#if now_customer.email??>
                                            <input type="text" readonly="readonly" value="${now_customer.email}" autocomplete="off" class="layui-input">
										<#else >
											<input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">性别</label>
                                    <div class="layui-input-block">
										<#if now_customer.sex??>
                                            <input type="text" readonly="readonly" value="${now_customer.sex}" autocomplete="off" class="layui-input">
										<#else >
											 <input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">出生年月</label>
                                    <div class="layui-input-block">
										<#if now_customer.birthdate??>
                                            <input type="text" readonly="readonly" value="${now_customer.birthdate}" autocomplete="off" class="layui-input">
											<#else >
											<input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">年龄</label>
                                    <div class="layui-input-block">
										<#if now_customer.age??>
                                            <input type="text" readonly="readonly" value="${now_customer.age}" autocomplete="off" class="layui-input">
											<#else >
											<input type="text" readonly="readonly" autocomplete="off" class="layui-input">
										</#if>
                                    </div>
                                </div>
                            </div>
						</#if>
					</div>
				</div>
				<div class="layui-col-md4">
					&emsp;&emsp;&emsp;&emsp;
					用户头像: 
					&emsp;&emsp;
					<#if now_customer??>
						<#if now_customer.img??>
						    <img src="${now_customer.img}" class="layui-nav-img" style="width: 100px;height: 100px;">
						<#else >
							<img src="#" class="layui-nav-img" style="width: 100px;height: 100px;">
						</#if>
					</#if>
				</div>
			</div>
		</div>
	</body>

</html>