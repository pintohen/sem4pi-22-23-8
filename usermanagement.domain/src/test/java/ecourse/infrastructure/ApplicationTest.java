package ecourse.infrastructure;

import org.ecourse.AppSettings;
import org.ecourse.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class ApplicationTest {

    @Test
    void settingsReturnsSameAppSettingsInstance() {
        AppSettings expectedAppSettings = Application.settings();

        AppSettings actualAppSettings = Application.settings();

        assertSame(
                expectedAppSettings,
                actualAppSettings,
                "The AppSettings instance should be the same on multiple calls");
    }
}