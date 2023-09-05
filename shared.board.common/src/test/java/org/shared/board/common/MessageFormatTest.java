package org.shared.board.common;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MessageFormatTest {
    private static final int VERSION = 1;
    private static final int CODE = MessageCodes.AUTH;
    private static final String TEXT = "Hello, world!";
    private static final byte[] TEXT_BYTES = TEXT.getBytes();
    private static final int TEXT_LENGTH = TEXT_BYTES.length;

    @Test
    public void testSendMessage() throws IOException {
        final Socket socket = mock(Socket.class);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(byteArrayOutputStream);
        MessageFormat messageFormat = new MessageFormat(socket);


        messageFormat.sendMessage(VERSION, CODE, TEXT);

        byte[] capturedData = byteArrayOutputStream.toByteArray();

        assertEquals(VERSION, capturedData[0]);
        assertEquals(CODE, capturedData[1]);
        assertEquals(TEXT_LENGTH % 256, capturedData[2]);
        assertEquals(TEXT_LENGTH / 256, capturedData[3]);
        assertEquals(TEXT, new String(capturedData, 4, TEXT_LENGTH));

        verify(socket, times(1)).getOutputStream();
        verify(socket, times(1)).getInputStream();
    }

    @Test
    public void testReadMessageWithData() throws IOException {
        byte[] data = new byte[TEXT_LENGTH];

        Socket socket = mock(Socket.class);
        InputStream inputStream = new ByteArrayInputStream(data);
        when(socket.getInputStream()).thenReturn(inputStream);

        MessageFormat messageFormat = new MessageFormat(socket);

        Message result = messageFormat.readMessage();

        assertEquals(0, result.version());
        assertEquals(0, result.code());
        assertEquals(0, result.d_length_1());
        assertEquals(0, result.d_length_2());
        assertEquals(0, result.data().length);

        verify(socket, times(1)).getInputStream();
    }
}
