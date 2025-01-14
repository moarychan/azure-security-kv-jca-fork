//// Copyright (c) Microsoft Corporation. All rights reserved.
//// Licensed under the MIT License.
//
//package com.azure.security.keyvault.jca;
//
//import com.azure.security.keyvault.jca.implementation.KeyVaultClient;
//import jdk.security.jarsigner.JarSigner;
//
//import java.io.FileOutputStream;
//import java.security.Key;
//import java.security.KeyStore;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.Security;
//import java.security.cert.Certificate;
//import java.util.zip.ZipFile;
//
//public class JarSignerSample {
//
//    public static void main(String[] args) {
//        KeyVaultJcaProvider provider = new KeyVaultJcaProvider();
//        Security.addProvider(provider);
//
//        String tenantId = System.getenv("AZURE_TENANT_ID");
//        String keyVaultUrl = System.getenv("AZURE_KEYVAULT_URL");
//        String clientId = System.getenv("AZURE_CLIENT_ID");
//        String clientSecret = System.getenv("AZURE_CLIENT_SECRET");
//
//        KeyVaultClient keyVaultClient = new KeyVaultClient(keyVaultUrl, tenantId, clientId, clientSecret);
//
//        try {
//            signJar(keyVaultClient,
////                "leaf-bundle2" //engineInitSign() not supported which private key is not instance of KeyVaultPrivateKey
//                "1105-no-integrated-ca-no-expoertable-key-all-2048"
////                "self-signed"
//            );
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void signJar(KeyVaultClient keyVaultClient, String alias) throws NoSuchAlgorithmException {
//        Key privateKey = keyVaultClient.getKey(alias, null);
////        Certificate certificate = keyVaultClient.getCertificate(alias);
//        Certificate [] certificates = keyVaultClient.getCertificateChain(alias);
//
//        System.out.println(String.format("Alg for private key of %s is %s", alias, privateKey.getAlgorithm()));
//        System.out.println(String.format("Alg for public key of %s is %s.", alias, certificates[0].getPublicKey().getAlgorithm()));
//
//        JarSigner jarSigner = new JarSigner
//            .Builder(new KeyStore.PrivateKeyEntry((PrivateKey) privateKey, certificates))
//            .signatureAlgorithm("SHA512withRSA", new KeyVaultJcaProvider())
//            .build();
//
//        String inputFilePath = "D:\\java\\spring-cloud-azure-keyvault\\jca\\2024\\list-all-bouncycastle-classe-to-shade\\files\\demo-jar-signer-0.0.1-SNAPSHOT.jar";
//        String outputFilePath = "D:\\java\\spring-cloud-azure-keyvault\\jca\\2024\\list-all-bouncycastle-classe-to-shade\\files\\signerjar.jar";
//
//        try (ZipFile in = new ZipFile(inputFilePath);
//             FileOutputStream out = new FileOutputStream(outputFilePath)) {
//            jarSigner.sign(in, out);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
