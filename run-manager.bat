REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ECOURSE_CP=ecourse.app.manager\target\ecourse.app.manager-0.1.0.jar;
ecourse.app.manager\target\dependency\*;


REM call the java VM, e.g, 
java -cp %ECOURSE_CP% org.app.manager.Main