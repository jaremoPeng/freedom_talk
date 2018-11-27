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
                <#if now_customer??>
                    <a href="/freedom_talk/index.do?cus_id=${now_customer.id}"><img style="width: 50px;height: 30px;" src="/img/uugai.com_1542371006215.png"/></a>
                <#else >
                    <a href="#"><img style="width: 50px;height: 30px;" src="/img/uugai.com_1542371006215.png"/></a>
                </#if>

            </li>
            <li class="layui-nav-item">
                <#if now_customer??>
                    <a href="/freedom_talk/index.do?cus_id=${now_customer.id}"><strong>自由说论坛</strong></a>
                <#else >
                    <a href="#"><strong>自由说论坛</strong></a>
                </#if>
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
            <li class="layui-nav-item" id="my">
                <a href="javascript:;">我的</a>
                <dl class="layui-nav-child">
                    <dd>
                        <#if now_customer??>
                            <a href="/queryMsg.do?cus_id=${now_customer.id}">通知消息&nbsp;<font id="unread_count" color="red">0</font></a>
                            <#else >
                                <a href="#">通知消息&nbsp;<font id="unread_count" color="red">0</font></a>
                        </#if>
                    </dd>
                    <dd>
                        <#if now_customer??>
                            <a href="/gotoCenter.do?cus_id=${now_customer.id}">个人中心</a>
                        <#else >
                                <a href="#">个人中心</a>
                        </#if>
                    </dd>
                    <dd>
                        <#if now_customer??>
                            <a href="/gotoHailFellow.do?cus_id=${now_customer.id}">我的好友</a>
                        <#else >
                                <a href="#">我的好友</a>
                        </#if>
                    </dd>
                </dl>
            </li>
            <#if now_customer??>
                <li class="layui-nav-item">
                    <a href="/gotoCusDetail.do?cus_id=${now_customer.id}">
                        <#if now_customer.img??>
                            <img src="${now_customer.img}" class="layui-nav-img" />
                            <#else >
                                <img src="http://img4.imgtn.bdimg.com/it/u=2309262615,3096530225&fm=200&gp=0.jpg" class="layui-nav-img" />
                        </#if>
                        <#if now_customer.name??>
                            ${now_customer.name}
                            <#else>
                                ${now_customer.loginName}
                        </#if>
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
        var element = layui.element,
                $=layui.jquery;

        element.on('nav(demo)', function (elem) {
            layer.msg(elem.text());
        });

        $("#my").on("mouseover",function () {
            <#if now_customer??>
                var cus_id = '${now_customer.id}';
                $.post("/getUnreadMsg.do",{cus_id: cus_id},function (data){
                    $("#unread_count").text(data);
                });
            </#if>
        });

    });
</script>
</body>

</html>