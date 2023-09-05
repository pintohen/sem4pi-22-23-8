package org.domain.model.examtemplate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SectionDescriptionTest {

    @Test
    void testCreateValidSectionDescription() {
        String description = "Section description";
        SectionDescription sectionDescription = SectionDescription.of(description);
        assertNotNull(sectionDescription);
        assertEquals(description, sectionDescription.toString());
    }

    @Test
    void ClassSectionDescriptionEquals() {
        String description = "Section description";
        SectionDescription sectionDescription = SectionDescription.of(description);
        SectionDescription sectionDescription2 = SectionDescription.of(description);
        SectionDescription sectionDescription3 = SectionDescription.of("Section description 2");
        assertEquals(sectionDescription, sectionDescription2);
        assertNotEquals(sectionDescription, sectionDescription3);
        assertNotEquals(sectionDescription, null);
        assertNotEquals(sectionDescription, new Object());
    }

}