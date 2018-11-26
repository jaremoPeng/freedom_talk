<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>角色修改</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="../css/layui.css" />
		<link rel="stylesheet" type="text/css" href="../css/formSelects-v4.css" />
		<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="../js/layui.js"></script>
		<script type="text/javascript" src="../js/formSelects-v4.js" ></script>
	</head>

	<body>
		<div class="layui-container">
			<div class="layui-row layui-col-space5">
				<div class="layui-col-md4">

				</div>
				<div class="layui-col-md5 layui-text">
					<div class="layui-card">
						<div class="layui-card-header">修改角色: </div>

						<div class="layui-card-body">
							<input type="hidden" id="role_id" value="${role.id}" autocomplete="off" class="layui-input">
							<div class="layui-form-item">
								<label class="layui-form-label">角色名</label>
								<div class="layui-input-block">
									<input type="text" id="role_name" lay-verify="title" autocomplete="off" placeholder="请输入角色名" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">选择权限</label>
								<div class="layui-input-block">
									<!--disabled="disabled"禁选  有疑问? http://sun.faysunshine.com/layui/formSelects-v4/example/example_v4.html -->
									<select id="perms" name="perms" xm-select="selectId">
                                        <option value="">请选择权限</option>
										<#if permissionList??>
										    <#if (permissionList?size>0)>
										        <#list permissionList as perm>
										            <option value="${perm.id}">${perm.name}</option>
										        </#list>
										    </#if>
										</#if>
									</select>
								</div>
							</div>

							&emsp;&emsp;&emsp;&emsp;&emsp; &emsp;&emsp;&emsp;&emsp;&emsp;
							<button class="layui-btn layui-btn-sm" onclick="role_edit()">修改</button>
						</div>
					</div>
				</div>
				<div class="layui-col-md3">

				</div>
			</div>
		</div>
		<script type="text/javascript">
			var formSelects = layui.formSelects;
			formSelects.render('selectId');

			var lyr;
			layui.use("layer",function () {
				var layer = layui.layer;

				lyr = layer;
            });

			function role_edit() {
			    var roleid = $("#role_id").val();
				var rolename = $("#role_name").val();
				var perms = formSelects.value('selectId','valStr');

				if(rolename.length==0 || perms.length==0){
				    lyr.msg("您还没选择权限,或者没有填写角色名");
				}else{
					$.post("/editRole.do",{roleid:roleid,rolename:rolename,perms:perms},function (data) {
						if(data.length==0){
                            lyr.msg("修改成功");
						}else{
                            lyr.msg("修改失败");
						}
                    });
				}
            }
		</script>
	</body>

</html>