package org.shared.board.server.util;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.security.cert.Certificate;
import java.util.Date;


import org.testcontainers.shaded.org.bouncycastle.asn1.x500.X500Name;
import org.testcontainers.shaded.org.bouncycastle.cert.X509CertificateHolder;
import org.testcontainers.shaded.org.bouncycastle.cert.X509v3CertificateBuilder;
import org.testcontainers.shaded.org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.testcontainers.shaded.org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.testcontainers.shaded.org.bouncycastle.operator.ContentSigner;
import org.testcontainers.shaded.org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.testcontainers.shaded.org.bouncycastle.jce.provider.BouncyCastleProvider;


public class CertificateGenerator {



    public static void main(String[] args) {
        try {
            // Generate key pair
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(4096);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Generate self-signed certificate
            X509Certificate certificate = generateSelfSignedCertificate(keyPair);

            // Print certificate details
            System.out.println("Certificate:");
            System.out.println("Subject: " + certificate.getSubjectDN());
            System.out.println("Issuer: " + certificate.getIssuerDN());
            System.out.println("Serial number: " + certificate.getSerialNumber());
            System.out.println("Valid from: " + certificate.getNotBefore());
            System.out.println("Valid to: " + certificate.getNotAfter());
            System.out.println("Public key: " + certificate.getPublicKey());

            // Store the certificate in a keystore file
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(null, null);
            keyStore.setKeyEntry("ecourse", keyPair.getPrivate(), "ecourse".toCharArray(), new Certificate[]{certificate});
            keyStore.store(new FileOutputStream("shared.board.server/src/main/resources/keystore/keystore.pfx"), "ecourse".toCharArray());
        } catch (Exception e) {
            System.out.println("here");
            e.printStackTrace();
        }
    }

    private static X509Certificate generateSelfSignedCertificate(KeyPair keyPair) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        X500Name issuerName = new X500Name("C=US, O=DigiCert Inc, OU=www.digicert.com, CN=DigiCert SHA2 High Assurance Server CA");
        X500Name subjectName = new X500Name("CN=ecourse.ddns.net, O=ecourse, C=PORTUGAL");

        Date startDate = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24); // Yesterday
        Date endDate = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 365); // Tomorrow next year

        BigInteger serialNumber = BigInteger.valueOf(System.currentTimeMillis());

        X509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                issuerName,
                serialNumber,
                startDate,
                endDate,
                subjectName,
                keyPair.getPublic()
        );

        ContentSigner contentSigner = new JcaContentSignerBuilder("SHA256withRSA").build(keyPair.getPrivate());

        X509CertificateHolder certHolder = certBuilder.build(contentSigner);

        return new JcaX509CertificateConverter().getCertificate(certHolder);
    }
}
