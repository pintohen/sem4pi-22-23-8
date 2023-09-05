package org.shared.board.server;

import com.google.gson.Gson;
import eapli.framework.domain.repositories.IntegrityViolationException;
import exceptions.NoPreviousElementException;
import org.shared.board.server.request_bodys.*;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;

public class HttpRequestThread extends Thread {
    String baseFolder;
    Socket sock;
    DataInputStream inS;
    DataOutputStream outS;
    HttpServerAjax httpServerAjax;
    Gson json;

    private static final String BOARD_HISTORY_BY_ID_REGEX = "\\Q/board_history?id=\\E\\d+";


    public HttpRequestThread(Socket httpCliSock, String folder, HttpServerAjax httpServerAjax) {
        this.baseFolder = folder;
        this.sock = httpCliSock;
        this.json = new Gson();
        this.httpServerAjax = httpServerAjax;
    }

    @Override
    public void run() {
        try {
            outS = new DataOutputStream(sock.getOutputStream());
            inS = new DataInputStream(sock.getInputStream());
        } catch (IOException ex){
            System.out.println("Thread error on data streams creation");
        }

        try {
            HTTPmessage request = new HTTPmessage(inS);
            HTTPmessage response = new HTTPmessage();
            System.out.println(request.getURI());

            String token = request.getAuthorization();

            if(request.getMethod().equals("GET")) {
                if(request.getURI().startsWith("/board/")) {
                    String fullname = baseFolder + "/board-view.html";

                    if(response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        fileNotFound(response);
                    }

                    response.send(outS);
                }

                if(request.getURI().startsWith("/get_board/")) {
                    String boardId = request.getURI().substring(11);

                    try{
                        response.setContentFromString(
                                httpServerAjax.getBoardById(boardId, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException | NoSuchElementException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("401 unauthorized");
                    }

                    response.send(outS);
                }

                if(request.getURI().startsWith("/post-its/board/")) {
                    String boardId = request.getURI().substring(16);

                    try{
                        response.setContentFromString(
                                httpServerAjax.getLastPostItsByBoard(boardId, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException | NoSuchElementException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("401 unauthorized");
                    }

                    response.send(outS);
                }

                if(request.getURI().equals("/myboards")) {
                    String fullname = baseFolder + "/myboards.html";

                    if(response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        fileNotFound(response);
                    }

                    response.send(outS);
                }

                if(request.getURI().equals("/all_my_boards")) {
                    try{
                        response.setContentFromString(
                                httpServerAjax.getUserAccessBoards(token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("401 unauthorized");
                    }

                    response.send(outS);
                }

                if(request.getURI().startsWith("/history/")) {
                    String fullname = baseFolder + "/history.html";

                    if(response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        fileNotFound(response);
                    }

                    response.send(outS);
                }

                if(request.getURI().matches("")){

                }
                if(request.getURI().matches(BOARD_HISTORY_BY_ID_REGEX)){
                    String id = request.getURI().split("\\?")[1];

                    Long value = Long.parseLong(id.split("=")[1]);

                    System.out.println(value);

                    try{
                        response.setContentFromString(
                                httpServerAjax.viewBoardHistory(value, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("401 unauthorized");
                    }

                    response.send(outS);
                }

                if(request.getURI().equals("/user")) {
                    try{
                        response.setContentFromString(
                                httpServerAjax.getAuthenticatedUser(token),
                                "text");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException | NullPointerException e){
                        response.setResponseStatus("401 unauthorized");
                    }

                } else {
                    String fullname = baseFolder + "/";

                    if(request.getURI().equals("/")){
                        fullname = fullname + "login.html";
                    } else {
                        fullname = fullname + request.getURI();
                    }

                    if(response.setContentFromFile(fullname)) {
                        response.setResponseStatus("200 Ok");
                    } else {
                        fileNotFound(response);
                    }
                }

                response.send(outS);
            }

            if(request.getMethod().equals("POST")){

                if(request.getURI().equals("/share_board")){
                    String requestBody = request.getContentAsString();

                    ShareBoardBody body = json.fromJson(requestBody, ShareBoardBody.class);

                    try{
                        response.setContentFromString(httpServerAjax.shareABoard(body),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    }catch (IllegalArgumentException | NullPointerException e){
                        response.setContentFromString(e.getMessage(),
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    }catch (NoSuchElementException e){
                        response.setContentFromString(
                                "This user does not exist!",
                                "text");
                        response.setResponseStatus("401 unauthorized");
                    }

                    response.send(outS);
                }

                if(request.getURI().equals("/create_board")){
                    createBoard(request, response, token);
                }

                if(request.getURI().equals("/create_post_it")){
                    String requestBody = request.getContentAsString();

                    PostItBody body = json.fromJson(requestBody, PostItBody.class);

                    try{
                        response.setContentFromString(
                                httpServerAjax.createPostIt(body, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    } catch (NoSuchElementException e){
                        response.setContentFromString(
                                "This board doesn't exist",
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    }

                    response.send(outS);
                }

                if(request.getURI().equals("/login")){
                    String requestBody = request.getContentAsString();

                    LoginBody body = json.fromJson(requestBody, LoginBody.class);

                    try{
                        response.setContentFromString(
                                httpServerAjax.login(body),
                                "text");
                        response.setResponseStatus("200 Ok");
                    } catch (Exception e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("401 Unauthorized");
                    }

                    response.send(outS);
                }
            }

            if(request.getMethod().equals("PUT")){
                if(request.getURI().equals("/update_post_it")){
                    String requestBody = request.getContentAsString();

                    PostItBody body = json.fromJson(requestBody, PostItBody.class);

                    try{
                        response.setContentFromString(
                                httpServerAjax.updatePostItContent(body, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    } catch (NoSuchElementException e){
                        response.setContentFromString(
                                "This board doesn't exist",
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    }

                    response.send(outS);;
                }

                if(request.getURI().equals("/update_post_it_position")){
                    String requestBody = request.getContentAsString();

                    PostItPositionBody body = json.fromJson(requestBody, PostItPositionBody.class);

                    try{
                        response.setContentFromString(
                                httpServerAjax.updatePostItPosition(body, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    } catch (NoSuchElementException e){
                        response.setContentFromString(
                                "This board doesn't exist",
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    }

                    response.send(outS);;
                }

                if(request.getURI().equals("/undo_post_it")) {
                    String requestBody = request.getContentAsString();

                    PostItBody body = json.fromJson(requestBody, PostItBody.class);

                    try {
                        response.setContentFromString(
                                httpServerAjax.undoPostIt(body, token),
                                "application/json");

                        response.setResponseStatus("200 Ok");
                    } catch(NoPreviousElementException | IllegalArgumentException n) {
                        response.setContentFromString(
                                n.getMessage(),
                                "text");

                        response.setResponseStatus("400 Bad Request");
                    }

                    response.send(outS);
                }
            }

            if(request.getMethod().equals("DELETE")){
                if(request.getURI().equals("/delete_post_it")){
                    String requestBody = request.getContentAsString();

                    PostItBody body = json.fromJson(requestBody, PostItBody.class);

                    try{
                        response.setContentFromString(
                                httpServerAjax.deletePostIt(body, token),
                                "application/json");
                        response.setResponseStatus("200 Ok");
                    } catch (IllegalArgumentException e){
                        response.setContentFromString(
                                e.getMessage(),
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    } catch (NoSuchElementException e){
                        response.setContentFromString(
                                "This board doesn't exist",
                                "text");
                        response.setResponseStatus("400 Bad Request");
                    }

                    response.send(outS);;
                }

                if(request.getURI().startsWith("/logout?token=")){
                    String param = request.getURI().split("\\?")[1];

                    String tokenValue = param.split("=")[1];
                    System.out.println("LOGOUT TOKEN: " + tokenValue);

                    try {

                        response.setContentFromString(
                                httpServerAjax.logout(tokenValue),
                                "text");

                        System.out.println("LOGGED OUT SUCCESSFULLY");
                        response.setResponseStatus("200 Ok");
                    } catch (Exception e) {
                        System.err.println("GOT ERROR LOGGING OUT");
                        response.setContentFromString(e.getMessage(), "text");

                        response.setResponseStatus("400 Bad Request");
                    }

                    response.send(outS);
                }
            }

        } catch(IOException ex) {
            System.out.println("Thread error when reading request");
        }

        try {
            sock.close();
        } catch(IOException ex) {
            System.out.println("CLOSE IOException");
        }
    }

    public void createBoard(HTTPmessage request, HTTPmessage response, String token){
        try {
            String requestBody = request.getContentAsString();

            BoardBody body = json.fromJson(requestBody, BoardBody.class);

            try{
                response.setContentFromString(
                        httpServerAjax.createBoard(body, token),
                        "application/json");
                response.setResponseStatus("200 Ok");
            } catch (IntegrityViolationException e){
                response.setContentFromString(
                        "A board with that title already exists",
                        "text");
                response.setResponseStatus("409 Conflict");
            } catch (NumberFormatException e){
                response.setContentFromString(
                        "Problem with request",
                        "text");
                response.setResponseStatus("400 Bad Request");
            } catch (IllegalArgumentException e){
                response.setContentFromString(
                        e.getMessage(),
                        "text");
                response.setResponseStatus("400 Bad Request");
            }

            response.send(outS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void fileNotFound(HTTPmessage response){
        response.setContentFromString(
                "<html><body><h1>404 File not found</h1></body></html>",
                "text/html");
        response.setResponseStatus("404 Not Found");
    }
}


