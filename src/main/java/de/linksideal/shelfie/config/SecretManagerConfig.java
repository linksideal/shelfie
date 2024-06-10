package de.linksideal.shelfie.config;

import com.google.cloud.secretmanager.v1.AccessSecretVersionRequest;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class SecretManagerConfig {

    @PostConstruct
    public void init() {
        try (SecretManagerServiceClient client = SecretManagerServiceClient.create()) {
            String projectId = "shelfie-425209";
            String secretId = "shelfie-postgres-pw";
            String versionId = "latest";

            SecretVersionName secretVersionName = SecretVersionName.of(projectId, secretId, versionId);
            AccessSecretVersionRequest request = AccessSecretVersionRequest.newBuilder()
                    .setName(secretVersionName.toString())
                    .build();
            String secret = client.accessSecretVersion(request).getPayload().getData().toStringUtf8();

            System.setProperty("DB_PASSWORD", secret);
        } catch (Exception e) {
            throw new RuntimeException("Failed to access secret from Secret Manager", e);
        }
    }
}
