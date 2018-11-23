<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>导航栏</title>
    <!--<meta name="viewport" content="width=device-width, initial-scale=1">-->
    <!--<link rel="stylesheet" href="../css/layui.css" />-->
    <!--<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>-->
    <!--<script type="text/javascript" src="../js/layui.js"></script>-->
    <style>
        #keyword {
            width: 300px;
        }
    </style>
</head>

<body>
<div class="layui-row">
    <div class="layui-col-xs4">
        <ul class="layui-nav layui-bg-green">
            <li class="layui-nav-item">
                <a href="index.ftl"><img style="width: 50px;height: 30px;" src="/img/uugai.com_1542371006215.png"/></a>
            </li>
            <li class="layui-nav-item">
                <font>自由说论坛</font>
            </li>
        </ul>
    </div>
    <div class="layui-col-xs4">
        <ul class="layui-nav layui-bg-green">
            <li class="layui-nav-item">
                <form class="layui-form" action="" method="">
                    <div class="layui-input-inline">
                        <input id="keyword" type="text" name="keyword" lay-verify="title" autocomplete="off"
                               placeholder="搜索" class="layui-input">
                    </div>
                    <button class="layui-btn layui-btn-primary" lay-submit="" lay-filter="demo1">搜索</button>
                </form>
            </li>
        </ul>
    </div>
    <div class="layui-col-xs4">
        <ul class="layui-nav layui-bg-green">
            <li class="layui-nav-item">
                <a href="javascript:;">我的</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="/queryMsg.do">通知消息</a>
                    </dd>
                    <dd>
                        <a href="center.ftl">个人中心</a>
                    </dd>
                    <dd>
                        <a href="hail_fellow.ftl">我的好友</a>
                    </dd>
                </dl>
            </li>
            <#if now_customer??>
                <li class="layui-nav-item">
                    <a href="customer_detail.ftl">
                        <img src="${now_customer.img}" class="layui-nav-img" />
                        ${now_customer.name ! now_customer.loginname}
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="/exit.do">退出</a>
                </li>

                <#else >
                    <li class="layui-nav-item">
                        <a href="/getAllQue.do?type=1">登录</a>
                    </li>
                    <li class="layui-nav-item">
                        <p>|</p>
                    </li>
                    <li class="layui-nav-item">
                        <a href="/getAllQue.do?type=2">注册</a>
                    </li>
            </#if>

        </ul>
    </div>
</div>

<script>
    layui.use('element', function () {
        var element = layui.element;

        element.on('nav(demo)', function (elem) {
            layer.msg(elem.text());
        });

    });
</script>
</body>

</html>