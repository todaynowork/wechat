# wechat
spring , wechat backend service, test purpose

# server url
https://todaynowork.group/we_chat-0.0.1-SNAPSHOT/

# service url
Test Json
https://todaynowork.group/we_chat-0.0.1-SNAPSHOT/json
return : {"msg":"hello"}

# how to contribute 
 http://kbroman.org/github_tutorial/pages/fork.html


# spring boot + mybatis sample
https://github.ibm.com/TssCloudTM/esoloution_v2

# spring profiles - production
when you want to enable security test, please 
option 1:
application.properties
spring.profiles.active=production

option 2: add -Dspring.profiles.active=production to JAVA_OPS 

https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-profiles.html
# add log instead of System.out

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private static Logger logger = LoggerFactory.getLogger(WechatApplication.class);


logger.info(" start from command line");

