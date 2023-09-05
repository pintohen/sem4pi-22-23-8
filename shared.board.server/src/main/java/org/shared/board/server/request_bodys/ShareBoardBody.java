package org.shared.board.server.request_bodys;

public class ShareBoardBody {

    private String boardId;

    private String email;

    private String permission;

    private String token;

    public String getBoardId(){ return boardId;}

    public String getUserEmail(){ return email;}

    public String getPermission(){ return permission;}

    public String getToken(){ return token;}
}
