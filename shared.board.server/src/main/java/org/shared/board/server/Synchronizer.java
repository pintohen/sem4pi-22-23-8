package org.shared.board.server;

import org.shared.board.server.request_bodys.PostItBody;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Synchronizer.
 */
public class Synchronizer {
    /**
     * The Lock objects.
     */
    Map<String, Object> lockObjects = new HashMap<>();
    private static Synchronizer instance = null;

    private Synchronizer(){

    }

    /**
     * Get instance synchronizer.
     *
     * @return the synchronizer
     */
    public static Synchronizer getInstance(){
        if(instance == null){
            instance = new Synchronizer();
        }

        return instance;
    }

    /**
     * Generate String based on row column and board id.
     *
     * @param requestBody post-it
     * @return String string
     */
    public String generateLockKey(PostItBody requestBody) {
        return requestBody.row() + requestBody.column() + requestBody.boardId();
    }


    /**
     * Generate lock key.
     * @param row     the row
     * @param column  the column
     * @param boardId the board id
     * @return the string
     */
    public String generateLockKey(String row, String column, String boardId) {
        return row + column + boardId;
    }

    /**
     * Get object corresponding to String.
     * Or create a new one if that string doesn't exist.
     *
     * @param lockKey string base on post-it
     * @return Object or create lock object
     */
    public synchronized Object getOrCreateLockObject(String lockKey) {
        return lockObjects.computeIfAbsent(lockKey, k -> new Object());
    }
}
