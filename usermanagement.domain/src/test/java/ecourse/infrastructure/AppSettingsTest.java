package ecourse.infrastructure;

import org.ecourse.AppSettings;
import org.ecourse.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppSettingsTest {

    @Test
    void persistenceUnitNameFromPropertiesFile() {
        AppSettings appSettings = new AppSettings();

        String persistenceUnitName = appSettings.persistenceUnitName();

        assertNotNull(persistenceUnitName, "Persistence unit name should not be null");
        assertEquals(
                "DEMO_ORMPU",
                persistenceUnitName,
                "Persistence unit name should match the value from the properties file");
    }

    @Test
    void loadPropertiesFromApplicationPropertiesFile() {
        AppSettings appSettings = new AppSettings();
        String expectedPersistenceUnit = "DEMO_ORMPU";
        String expectedRepositoryFactory = "org.persistence.JpaRepositoryFactory";

        String actualPersistenceUnit = appSettings.persistenceUnitName();
        String actualRepositoryFactory = appSettings.repositoryFactory();

        assertEquals(
                expectedPersistenceUnit,
                actualPersistenceUnit,
                "Persistence unit should be loaded from the application.properties file");
        assertEquals(
                expectedRepositoryFactory,
                actualRepositoryFactory,
                "Repository factory should be loaded from the application.properties file");
    }
}