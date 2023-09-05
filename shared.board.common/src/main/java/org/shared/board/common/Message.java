package org.shared.board.common;

/**
 * The type Message.
 */
public class Message {
    /**
     * The version.
     */
    private int version;
    /**
     * The code.
     */
    private int code;
    /**
     * The first length.
     */
    private int d_length_1;
    /**
     * The second length.
     */
    private int d_length_2;
    /**
     * The data.
     */
    private byte[] data;


    /**
     * Instantiates a new Message.
     * @param versionp    the versionp
     * @param codep       the codep
     * @param d_length_1p the d length 1 p
     * @param d_length_2p the d length 2 p
     * @param datap       the datap
     */
    public Message(final int versionp, final int codep,
                   final int d_length_1p, final int d_length_2p,
                   final byte[] datap) {
        this.version = versionp;
        this.code = codep;
        this.d_length_1 = d_length_1p;
        this.d_length_2 = d_length_2p;
        this.data = datap;
    }

    /**
     * Version int.
     *
     * @return the int
     */
    public int version() {
        return version;
    }

    /**
     * Code int.
     *
     * @return the int
     */
    public int code() {
        return code;
    }

    /**
     * D length 1 int.
     *
     * @return the int
     */
    public int d_length_1() {
        return d_length_1;
    }

    /**
     * D length 2 int.
     *
     * @return the int
     */
    public int d_length_2() {
        return d_length_2;
    }

    /**
     * Data byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] data() {
        return data;
    }
}
