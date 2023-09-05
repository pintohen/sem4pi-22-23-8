package org.ecourse;

import eapli.framework.util.Utility;

@Utility
public final class Application {
    /**
     * AppSettings instance.
     */
    private static final AppSettings SETTINGS = new AppSettings();

    private Application() {
    }

    /**
     * Get AppSettings.
     * @return AppSettings
     */
    public static AppSettings settings() {
        return SETTINGS;
    }
}
