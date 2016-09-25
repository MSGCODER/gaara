<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script src="/js/lib/jquery-3.1.1.js"></script>
    <script src="/js/gaara-utils.js"></script>
    <title>用户授权</title>
</head>
<body>
    <div class="oauth_main">
        <form name="authZForm" action="/oauth2/authorize" method="post">
            <div class="oauth_content">
                <p class="oauth_main_info">使用你的认证帐号登录</p>

                <!-- 登录 -->
                <div class="oauth_login">
                    <input type="hidden" name="scope" value="">
                    <input type="hidden" name="action" value="login">
                    <input type="hidden" name="response_type" value="code">
                    <input type="hidden" name="redirect_url" value="${redirect_url}">
                    <input type="hidden" name="client_id" value="${client_id}">
                    <input type="hidden" name="state" value="">

                    <div class="oauth_login_form">
                        <p class="oauth_login_01">
                            <label class="oauth_input_label">帐号：</label>
                            <input type="text" class="oauth_form_input" id="username" name="username" placeholder="请输入帐号" autocomplete="off" tabindex="1" />
                        </p>
                        <p>
                            <label class="oauth_input_label">密码：</label>
                            <input type="password" class="oauth_form_input" id="password" name="password" placeholder="请输入密码" autocomplete="off" tabindex="2" />
                        </p>
                    </div>
                    <input type="submit" value="登录">
                </div>
            </div>
        </form>
    </div>
</body>
</html>