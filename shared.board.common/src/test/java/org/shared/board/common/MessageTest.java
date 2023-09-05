package org.shared.board.common;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void testMessageConstructorAndGetters() {
        int version = 1;
        int code = 200;
        int d_length_1 = 10;
        int d_length_2 = 20;
        byte[] data = new byte[]{1, 2, 3};

        Message message = new Message(version, code, d_length_1, d_length_2, data);

        assertEquals(version, message.version());
        assertEquals(code, message.code());
        assertEquals(d_length_1, message.d_length_1());
        assertEquals(d_length_2, message.d_length_2());
        assertArrayEquals(data, message.data());
    }

    @Test
    public void testMessageConstructorWithNullData() {
        int version = 1;
        int code = 200;
        int d_length_1 = 10;
        int d_length_2 = 20;

        Message message = new Message(version, code, d_length_1, d_length_2, null);

        assertEquals(version, message.version());
        assertEquals(code, message.code());
        assertEquals(d_length_1, message.d_length_1());
        assertEquals(d_length_2, message.d_length_2());
        assertNull(message.data());
    }
}
