package fun.mortnon.pac4j.oauth.profile;

import org.pac4j.oauth.profile.OAuth20Profile;

import java.net.URI;
import java.util.Date;

public class GiteeProfile extends OAuth20Profile {

    @Override
    public String getUsername() {
        return (String) getAttribute(GiteeProfileDefinition.LOGIN);
    }

    @Override
    public String getDisplayName() {
        return getAttributeAsString(GiteeProfileDefinition.NAME);
    }

    @Override
    public URI getPictureUrl() {
        return getAttributeAsType(GiteeProfileDefinition.AVATAR_URL, URI.class, null);
    }

    @Override
    public URI getProfileUrl() {
        return getAttributeAsType(GiteeProfileDefinition.HTML_URL, URI.class, null);
    }

    public String getRemark() {
        return getAttributeAsString(GiteeProfileDefinition.REMARK);
    }

    public URI getFollowersUrl() {
        return getAttributeAsType(GiteeProfileDefinition.FOLLOWERS_URL, URI.class, null);
    }

    public String getFollowingUrl() {
        return getAttributeAsString(GiteeProfileDefinition.FOLLOWING_URL);
    }

    public String getGistsUrl() {
        return getAttributeAsString(GiteeProfileDefinition.GISTS_URL);
    }

    public String getStarredUrl() {
        return getAttributeAsString(GiteeProfileDefinition.STARRED_URL);
    }

    public URI getSubscriptionsUrl() {
        return getAttributeAsType(GiteeProfileDefinition.SUBSCRIPTIONS_URL, URI.class, null);
    }

    public URI getOrganizationsUrl() {
        return getAttributeAsType(GiteeProfileDefinition.ORGANIZATIONS_URL, URI.class, null);
    }

    public URI getReposUrl() {
        return getAttributeAsType(GiteeProfileDefinition.REPOS_URL, URI.class, null);
    }

    public String getEventsUrl() {
        return getAttributeAsString(GiteeProfileDefinition.EVENTS_URL);
    }

    public URI getReceivedEventsUrl() {
        return getAttributeAsType(GiteeProfileDefinition.RECEIVED_EVENTS_URL, URI.class, null);
    }

    public String getType() {
        return getAttributeAsString(GiteeProfileDefinition.TYPE);
    }

    public URI getBlog() {
        return getAttributeAsType(GiteeProfileDefinition.BLOG, URI.class, null);
    }

    public URI getWeibo() {
        return getAttributeAsType(GiteeProfileDefinition.WEIBO, URI.class, null);
    }

    public String getBio() {
        return getAttributeAsString(GiteeProfileDefinition.BIO);
    }

    public Integer getPublicRepos() {
        return (Integer) getAttribute(GiteeProfileDefinition.PUBLIC_REPOS);
    }

    public Integer getPublicGists() {
        return (Integer) getAttribute(GiteeProfileDefinition.PUBLIC_GISTS);
    }

    public Integer getFollowers() {
        return (Integer) getAttribute(GiteeProfileDefinition.FOLLOWERS);
    }

    public Integer getFollowing() {
        return (Integer) getAttribute(GiteeProfileDefinition.FOLLOWING);
    }

    public Integer getStared() {
        return (Integer) getAttribute(GiteeProfileDefinition.STARED);
    }

    public Integer getWatched() {
        return (Integer) getAttribute(GiteeProfileDefinition.WATCHED);
    }

    public Date getCreatedAt() {
        return (Date) getAttribute(GiteeProfileDefinition.CREATED_AT);
    }

    public Date getUpdatedAt() {
        return (Date) getAttribute(GiteeProfileDefinition.UPDATED_AT);
    }
}
