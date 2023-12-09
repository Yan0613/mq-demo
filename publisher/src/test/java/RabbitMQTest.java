import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Timer;

@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage(){
        String quename = "simple.queue";
        String msg = "hello, mq1";
        rabbitTemplate.convertAndSend(quename, msg);
    }

    //模拟发50条消息
    @Test
    void testWorkQueue(){
        String quequeName = "work.queue";
        for (int i = 0; i < 50; i++) {
            String msg = "hello , worker , message" + i;
            rabbitTemplate.convertAndSend(quequeName, msg);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
