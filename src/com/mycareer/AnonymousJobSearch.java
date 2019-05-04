package com.mycareer;

public class AnonymousJobSearch {
    public static ProfileBuilder ProfileBuilder() {
        return profileBuilder;
    }

    public interface ProfileBuilder {
        ProfileBuilder withPlatform(final String platform);
        ProfileBuilder withExpectations(final String expectations);
        ProfileBuilder withExperience(final String experience);
        ProfileBuilder withSkills(final String skills);

        ConfidentialProfile build();
    }

    static private ProfileBuilder profileBuilder;
}
