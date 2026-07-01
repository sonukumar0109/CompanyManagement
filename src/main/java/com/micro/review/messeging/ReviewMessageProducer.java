package com.micro.review.messeging;

import com.micro.review.dto.ReviewMessage;
import com.micro.review.review.Reviews;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(Reviews reviews){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(reviews.getId());
        reviewMessage.setGrade(reviews.getGrade());
        reviewMessage.setRemarks(reviews.getRemarks());
        reviewMessage.setStar(reviews.getStar());
        reviewMessage.setCompanyId(reviews.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessage);
    }
}
