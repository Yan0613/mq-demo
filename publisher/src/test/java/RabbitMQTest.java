import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

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

    @Test
    void testSendFanout(){
        String exchangeName = "hmall.fanout";
        String msg = "hello, everyone";
        rabbitTemplate.convertAndSend(exchangeName, null, msg);
    }

    @Test
    void testSendFirectOut(){
        String exchangeName  = "hall.directout";
        String msg = "hello, direct";
        rabbitTemplate.convertAndSend(exchangeName, "red", msg);
    }


}
