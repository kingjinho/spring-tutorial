package hello.core.xml;

import hello.core.member.IMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContextTest {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        IMemberService memberService = ac.getBean("memberService", IMemberService.class);
        assertThat(memberService).isInstanceOf(IMemberService.class);
    }
}
