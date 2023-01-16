package fun.mortnon.pac4j.oauth.api;

import com.github.scribejava.core.builder.api.DefaultApi20;
import com.github.scribejava.core.httpclient.HttpClient;
import com.github.scribejava.core.httpclient.HttpClientConfig;
import com.github.scribejava.core.oauth.OAuth20Service;
import fun.mortnon.pac4j.oauth.service.GiteeService;

import java.io.OutputStream;

public class GiteeApi extends DefaultApi20 {
    protected GiteeApi() {
    }

    private static class InstanceHolder {
        private static final GiteeApi INSTANCE = new GiteeApi();
    }

    public static GiteeApi instance() {
        return InstanceHolder.INSTANCE;
    }


    @Override
    public String getAccessTokenEndpoint() {
        return "https://gitee.com/oauth/token";
    }

    @Override
    public String getAuthorizationBaseUrl() {
        return "https://gitee.com/oauth/authorize";
    }

    @Override
    public OAuth20Service createService(String apiKey, String apiSecret, String callback, String defaultScope,
                                        String responseType, OutputStream debugStream, String userAgent, HttpClientConfig httpClientConfig,
                                        HttpClient httpClient) {
        return new GiteeService(this, apiKey, apiSecret, callback, defaultScope, responseType, userAgent, httpClientConfig, httpClient);
    }
}
