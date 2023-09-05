package org.shared.board.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The type Message format.
 */
public class MessageFormat {
    /**
     * The Sock.
     */
    private Socket sock;
    /**
     * The S out.
     */
    private DataOutputStream sOut;

    /**
     * The S in.
     */
    private DataInputStream sIn;

    /**
     * 1 byte in decimal.
     */
    private static final int BYTE = 256;

    /**
     * Instantiates a new Message format.
     *
     * @param sockp the sockp
     */
    public MessageFormat(final Socket sockp) {
        try {
            this.sock = sockp;
            this.sOut = new DataOutputStream(sockp.getOutputStream());
            this.sIn = new DataInputStream(sock.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Send message.
     *
     * @param version the version
     * @param code    the code
     * @param text    the text
     */
    public void sendMessage(final int version,
                            final int code,
                            final String text) {
        byte[] data = text.getBytes();
        int dataLength = data.length;

        int d_length_1 = dataLength % BYTE;
        int d_length_2 = dataLength / BYTE;

        try {
            sOut.writeByte(version);
            sOut.writeByte(code);
            sOut.writeByte(d_length_1);
            sOut.writeByte(d_length_2);
            sOut.write(data, 0, dataLength);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Read message message.
     *
     * @return the message
     */
    public Message readMessage() {
        try {
            int version = sIn.readUnsignedByte();
            int code = sIn.readUnsignedByte();
            int d_length_1 = sIn.readUnsignedByte();
            int d_length_2 = sIn.readUnsignedByte();

            // calculate data length
            int dataLength = d_length_1 + (d_length_2 * BYTE);

            byte[] data = new byte[dataLength];

            if (dataLength > 0) {
                sIn.readFully(data);
            }

            return new Message(version, code, d_length_1, d_length_2, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
