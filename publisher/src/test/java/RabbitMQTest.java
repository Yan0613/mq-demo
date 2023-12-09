import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
