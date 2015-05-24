//
// Built on Sat May 23 05:25:27 CEST 2015 by logback-translator
// For more information on configuration files in Groovy
// please see http://logback.qos.ch/manual/groovy.html

// For assistance related to this tool or configuration files
// in general, please contact the logback user mailing list at
//    http://qos.ch/mailman/listinfo/logback-user

// For professional support please see
//   http://www.qos.ch/shop/products/professionalSupport

import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy

import static ch.qos.logback.classic.Level.DEBUG

scan("1800 seconds")
def USER_HOME = "logs"
def FILE_NAME = "mybatis-logback"
def byDay = timestamp("yyyy-MM-dd")
appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n"
  }
}
appender("file", RollingFileAppender) {
  file = "${USER_HOME}/${FILE_NAME}.log"
  rollingPolicy(FixedWindowRollingPolicy) {
    fileNamePattern = "${USER_HOME}/${byDay}/${FILE_NAME}-${byDay}-%i.log.zip"
    minIndex = 1
    maxIndex = 10
  }
  triggeringPolicy(SizeBasedTriggeringPolicy) {
    maxFileSize = "5MB"
  }
  encoder(PatternLayoutEncoder) {
    pattern = "%-4relative [%thread] %-5level %logger{35} - %msg%n"
  }
}
logger("com.text.project", DEBUG, ["file"], true)
root(DEBUG, ["STDOUT"])