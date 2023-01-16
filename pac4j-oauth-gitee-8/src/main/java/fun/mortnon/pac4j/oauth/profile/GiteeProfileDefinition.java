package fun.mortnon.pac4j.oauth.profile;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.scribejava.core.model.Token;
import org.pac4j.core.profile.ProfileHelper;
import org.pac4j.core.profile.converter.Converters;
import org.pac4j.core.profile.converter.DateConverter;
import org.pac4j.oauth.config.OAuthConfiguration;
import org.pac4j.oauth.profile.JsonHelper;
import org.pac4j.oauth.profile.definition.OAuthProfileDefinition;

import java.util.Arrays;

import static org.pac4j.core.profile.AttributeLocation.PROFILE_ATTRIBUTE;

/**
 * Gitee Profile 属性定义类。
 *
 * @author dev2007
 */
public class GiteeProfileDefinition extends OAuthProfileDefinition {
    public static final String LOGIN = "login";
    public static final String NAME = "name";
    public static final String AVATAR_URL = "avatar_url";
    public static final String URL = "url";
    public static final String HTML_URL = "html_url";
    public static final String REMARK = "remark";
    public static final String FOLLOWERS_URL = "followers_url";
    public static final String FOLLOWING_URL = "following_url";
    public static final String GISTS_URL = "gists_url";
    public static final String STARRED_URL = "starred_url";
    public static final String SUBSCRIPTIONS_URL = "subscriptions_url";
    public static final String ORGANIZATIONS_URL = "organizations_url";
    public static final String REPOS_URL = "repos_url";
    public static final String EVENTS_URL = "events_url";
    public static final String RECEIVED_EVENTS_URL = "received_events_url";
    public static final String TYPE = "type";
    public static final String BLOG = "blog";
    public static final String WEIBO = "weibo";
    public static final String BIO = "bio";
    public static final String PUBLIC_REPOS = "public_repos";
    public static final String PUBLIC_GISTS = "public_gists";
    public static final String FOLLOWERS = "followers";
    public static final String FOLLOWING = "following";
    public static final String STARED = "stared";
    public static final String WATCHED = "watched";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";

    private final static String DATE_TZ_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
    private final static DateConverter DATE_CONVERTER = new DateConverter(DATE_TZ_FORMAT);

    public GiteeProfileDefinition() {
        super(x -> new GiteeProfile());

        Arrays.asList(new String[]{
                LOGIN, NAME, REMARK, TYPE, BIO, FOLLOWING_URL, GISTS_URL, STARRED_URL, EVENTS_URL
        }).forEach(a -> primary(a, Converters.STRING));

        Arrays.asList(new String[]{
                PUBLIC_REPOS, PUBLIC_GISTS, FOLLOWERS, FOLLOWING, STARED, WATCHED
        }).forEach(a -> primary(a, Converters.INTEGER));

        Arrays.asList(new String[]{
                AVATAR_URL, URL, HTML_URL, FOLLOWERS_URL, SUBSCRIPTIONS_URL,
                ORGANIZATIONS_URL, REPOS_URL, RECEIVED_EVENTS_URL, BLOG, WEIBO
        }).forEach(a -> primary(a, Converters.URL));

        primary(CREATED_AT, DATE_CONVERTER);
        primary(UPDATED_AT, DATE_CONVERTER);
    }

    @Override
    public String getProfileUrl(Token accessToken, OAuthConfiguration configuration) {
        return "https://gitee.com/api/v5/user";
    }

    @Override
    public GiteeProfile extractUserProfile(String body) {
        GiteeProfile profile = (GiteeProfile) newProfile();
        JsonNode json = JsonHelper.getFirstNode(body);
        if (json != null) {
            profile.setId((String) JsonHelper.getElement(json, "id"));
            getPrimaryAttributes().forEach(attribute -> {
                convertAndAdd(profile, PROFILE_ATTRIBUTE, (String) attribute, JsonHelper.getElement(json, (String) attribute));
            });
        } else {
            raiseProfileExtractionJsonError(body);
        }
        return profile;
    }
}
