package org.domain.model.postit;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class PostItContentTest {
    @Test
    public void createPostItContentWithValue() {
        String value = "Sample Post-It Content";
        PostItContent postItContent = PostItContent.of(value);

        assertEquals(value, postItContent.value());
    }

    @Test
    public void createPostItContentWithNullValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            PostItContent.of(null);
        });
    }

    @Test
    public void createPostItContentWithEmptyValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            PostItContent.of("");
        });
    }

    @Test
    public void createPostItContentWithInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            PostItContent.of("sho");
        });

        String value = "This is a very long content"
                + "that exceeds the maximum allowed length"
                + "that exceeds the maximum allowed length"
                + "that exceeds the maximum allowed length"
                + "that exceeds the maximum allowed length";

        assertThrows(IllegalArgumentException.class, () -> {
            PostItContent.of(value);
        });
    }

    @Test
    public void testEquality() {
        String value1 = "Sample Content";
        String value2 = "Another Content";
        PostItContent postItContent1 = PostItContent.of(value1);
        PostItContent postItContent2 = PostItContent.of(value1);
        PostItContent postItContent3 = PostItContent.of(value2);

        assertEquals(postItContent1, postItContent2);
        assertNotEquals(postItContent1, postItContent3);
        assertNotEquals(postItContent1, null);
        assertEquals(postItContent1, postItContent1);
    }
}
