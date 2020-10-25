# Introduction
The concept of Logging is probably as old as the application development. With logging frameworks like Apache Log4j and the extensions like Slf4j, it became highly configurable and independently managed. This blog is not about those. Even now, application logs it is most common for developers to look at the logs, when an issue is raised.

As part of cloud native concepts, file-based logging became irrelevant and streamed logs, log aggregators became necessary. But, finding logs associated to specific service, specific instance, specific request was nightmare unless a lot of information is logged in every log statement.

Then came the tracers and trace-aggregators. The trace libraries can automatically add request identifiers along with every log statement, which can be searched and filtered in aggregated logs. However, the configurations are usually set to sample certain percentage of requests and it is possible that the needed one may have been excluded. Setting sample size to 100% may work. However, it generates enormous amount of log.

## Why Request Logging?
All the above options are valuable source of information. But it is tedious to track down logs associated to processing of a specific request among so many concurrent activities and logs. Also, because of developers’ generosity in logging entire object content, the logs are enormous and finding information about a request may be like find a needle in the haystack.

What if the developers can add the logs associated to the processing of a request along with its response? What if the testers can include them as part of the evidence? Developers can help themselves by helping testers.

# Request Logger (Full)
This project is the setup of a restful web service along with request-logger implementation.
Please refer to base implementation at https://github.com/ajoshi66/request-logger-base to understand the key changes related to the implementation of logger.
