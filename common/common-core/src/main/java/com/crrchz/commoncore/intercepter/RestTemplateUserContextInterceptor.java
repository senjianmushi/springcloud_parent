package com.crrchz.commoncore.intercepter;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import com.crrchz.commoncore.vo.UserVo;

/**
 * @author lhj
 * @Description:
 * @Date: 2019/1/16 1:23
 */
public class RestTemplateUserContextInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        UserVo user = UserContextHolder.currentUser();
        request.getHeaders().add("x-user-id",user.getUserId());
        request.getHeaders().add("x-user-name",user.getUserName());
        request.getHeaders().add("x-user-serviceName",request.getURI().getHost());
        return execution.execute(request, body);
    }
}
