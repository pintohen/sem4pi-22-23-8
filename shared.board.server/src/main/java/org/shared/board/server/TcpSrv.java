package org.shared.board.server;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.model.ECoursePasswordPolicy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.*;
import java.security.cert.CertificateException;
import javax.net.ssl.*;

/**
 * The type Tcp srv.
 */
class TcpSrv {
    /**
     * The tcp Sock.
     */
    private static ServerSocket tcpSock;

    /**
     * The tcp PORT.
     */
    private static final int TCP_PORT = 9999;


    /**
     * The http Sock.
     */
    private static ServerSocket httpSock;

    /**
     * The http PORT.
     */
    private static final int HTTP_PORT = 8000;

    /**
     * Base folder with myboards.html
     */
    private static final String BASE_FOLDER = "shared.board.server/src/main/java/org/shared/board/server/www";

    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(final String args[]) throws Exception {
        Socket tpcCliSock;

        try {
            tcpSock = new ServerSocket(TCP_PORT);
            httpSock = new ServerSocket(HTTP_PORT);
            /*httpSock = initializeSSLServerSocket(HTTP_PORT,
                    "shared.board.server/src/main/resources/keystore/keystore.pfx",
                    "ecourse",
                    "ecourse");*/

            System.out.println("Server is listening");
        } catch (IOException ex) {
            System.out.println("Failed to open server socket");
            System.exit(1);
        }

        AuthzRegistry.configure(
                PersistenceContext.repositories().users(),
                new PlainTextEncoder(),
                new ECoursePasswordPolicy()
        );

        HttpServerAjax httpServerAjax = new HttpServerAjax();

        new Thread(() -> {
            while (true) {
                try {
                    Socket httpCliSock = httpSock.accept();

                    new Thread(new HttpRequestThread(httpCliSock,
                            BASE_FOLDER, httpServerAjax)).start();
                } catch (IOException e) {
                    System.out.println("Failed to accept connection");
                }
            }
        }).start();

        while (true) {
            AuthzRegistry.configure(
                    PersistenceContext.repositories().users(),
                    new PlainTextEncoder(),
                    new ECoursePasswordPolicy()
            );

            tpcCliSock = tcpSock.accept();

            new Thread(new TcpSrvThread(tpcCliSock, AuthzRegistry.authorizationService())).start();
        }
    }

    private static ServerSocket initializeSSLServerSocket(int port, String keystorePath, String keystorePassword, String keyPassword)
            throws IOException, NoSuchAlgorithmException, KeyManagementException,
            UnrecoverableKeyException, KeyStoreException, CertificateException, IllegalArgumentException {
        // Load the keystore
        KeyStore keystore = KeyStore.getInstance("JKS");

        File file = new File(keystorePath);

        if(!file.exists())
            System.out.println("Keystore file not found");

        try (InputStream keystoreInputStream = new FileInputStream(keystorePath)) {
            keystore.load(keystoreInputStream, keystorePassword.toCharArray());
        }

        // Create the key manager factory
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keystore, keyPassword.toCharArray());

        // Create the SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

        // Create the SSL server socket factory
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

        // Create and return the SSL server socket
        return sslServerSocketFactory.createServerSocket(port);
    }
}
