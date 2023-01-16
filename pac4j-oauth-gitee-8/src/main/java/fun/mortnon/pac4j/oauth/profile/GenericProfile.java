package fun.mortnon.pac4j.oauth.profile;

import org.pac4j.oauth.profile.OAuth20Profile;

public class GenericProfile extends OAuth20Profile {
    protected String getAttributeAsString(final String name) {
        final Object value = getAttribute(name);
        if (value != null) {
            return value.toString();
        } else {
            return null;
        }
    }

    protected <T> T getAttributeAsType(final String name, Class<T> clazz, T defaultValue) {
        final Object value = getAttribute(name);
        if (value != null && clazz.isAssignableFrom(value.getClass())) {
            return clazz.cast(value);
        } else {
            return defaultValue;
        }
    }
}
