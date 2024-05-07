package com.skosana.bankaccount.configs;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;
import software.amazon.awssdk.services.sns.model.SnsException;

@Slf4j
public class Publish {

    private SnsClient snsClient;

    public Publish() {
        this.snsClient = SnsClient.builder()
                .region(Region.AF_SOUTH_1)
                .build();

    }

    public void publish(String topic, String message) {
        log.info("Publishing message: {}", message);
        try{
            String snsTopicArn = "arn:aws:sns:YOUR_REGION:YOUR_ACCOUNT_ID:"+topic;
            PublishRequest publishRequest = PublishRequest.builder()
                    .message(message)
                    .topicArn(snsTopicArn)
                    .build();

            PublishResponse publishResponse = snsClient.publish(publishRequest);

            log.info("Response Status "+publishResponse.sdkHttpResponse().statusCode());
        }catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
