package fun.mortnon.pac4j.oauth.client;

import fun.mortnon.pac4j.oauth.api.GiteeApi;
import fun.mortnon.pac4j.oauth.profile.GiteeProfileDefinition;
import org.apache.commons.lang3.StringUtils;
import org.pac4j.core.util.HttpActionHelper;
import org.pac4j.oauth.client.OAuth20Client;

import java.util.Optional;

/**
 * 用于认证 Gitee 用户的 OAuth2.0 客户端。
 * 默认权限范围为：user_info
 * @author dev2007
 */
public class GiteeClient extends OAuth20Client {
    public static final String DEFAULT_SCOPE = "user_info";

    public GiteeClient() {
        setScope(DEFAULT_SCOPE);
    }

    public GiteeClient(String key, String secret) {
        setScope(DEFAULT_SCOPE);
        setKey(key);
        setSecret(secret);
    }

    public GiteeClient(String key, String secret, String scope) {
        setScope(DEFAULT_SCOPE);
        setKey(key);
        setSecret(secret);
        setScope(scope);
    }

    @Override
    protected void internalInit(boolean forceReinit) {
        configuration.setApi(GiteeApi.instance());
        configuration.setProfileDefinition(new GiteeProfileDefinition());
        configuration.setTokenAsHeader(true);
        defaultLogoutActionBuilder((ctx, session, profile, targetUrl) ->
                Optional.of(HttpActionHelper.buildRedirectUrlAction(ctx, "https://gitee.com/logout")));

        super.internalInit(forceReinit);
    }

    public String getScope() {
        return getConfiguration().getScope();
    }

    public void setScope(String scope) {
        getConfiguration().setScope(StringUtils.isNoneEmpty(scope) ? scope : DEFAULT_SCOPE);
    }
}
