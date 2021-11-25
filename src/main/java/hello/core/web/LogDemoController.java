package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class LogDemoController {

//    private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger;
    private final LogDemoService logDemoService;

    @GetMapping("/log-demo")
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
//        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL);

        System.out.println("myLogger.getClass() = " + myLogger.getClass());

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
