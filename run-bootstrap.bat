REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ECOURSE_CP=ecourse.app.bootstrap\target\ecourse.app.bootstrap-0.1.0.jar;
ecourse.app.bootstrap\target\dependency\*;


REM call the java VM, e.g, 
java -cp %ECOURSE_CP% org.bootstrap.ECourseBootstrap