package live.xsg.authentication;

import live.xsg.authentication.auth.ApiRequest;
import live.xsg.authentication.exception.TokenInvalidException;
import live.xsg.authentication.utils.SecurityUtil;

/**
 * Created by xsg on 2019/12/4.
 */
public class Demo2 {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:8080/server";
        String password = "123456";
        DefaultApiAuthencator authencator = new DefaultApiAuthencator();
        String appId = "app1";
        long timeStamp = System.currentTimeMillis();
        String token = SecurityUtil.encrypt( baseUrl + appId + password + timeStamp);
        ApiRequest request = new ApiRequest(baseUrl, token, appId, timeStamp);
        try {
            authencator.auth(request);
            System.out.println("验证通过...");
        } catch (TokenInvalidException e) {
            System.out.println("验证失败，错误信息：" + e.getMessage());
        }
    }
}