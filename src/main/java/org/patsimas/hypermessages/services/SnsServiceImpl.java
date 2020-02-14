package org.patsimas.hypermessages.services;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import lombok.extern.slf4j.Slf4j;
import org.patsimas.hypermessages.clients.AwsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@PropertySource({ "classpath:application.properties" })
@Service
@Slf4j
public class SnsServiceImpl implements SnsService {

    @Value("${aws.topicArn}")
    private String topicArn;

    @Autowired
    AwsClient awsClient;

    @Override
    public void sendMassiveMail(String subject, String text) {

        AmazonSNS snsClient = awsClient.snsClient();

        try {
            PublishRequest publishReq = new PublishRequest()
                    .withTopicArn(topicArn)
                    .withSubject(subject)
                    .withMessage(text);

            snsClient.publish(publishReq);

        } catch (Exception e) {
            log.info("Cannot send notification to SNS service");
        } finally {
            log.info("Webhook runner terminated");
        }
    }

    @Override
    public void addSubscriber(String email) {

        log.info("Add subscriber with email: {} process begins", email);

        AmazonSNS snsClient = awsClient.snsClient();

        SubscribeRequest subscribeRequest = new SubscribeRequest(topicArn, "email", email);
        snsClient.subscribe(subscribeRequest);

        log.info("Add subscriber process completed");
    }
}
