REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET ECOURSE_CP=shared.board.app\target\shared.board.app-0.1.0.jar;
shared.board.app\target\dependency\*;


REM call the java VM, e.g, 
java -cp %ECOURSE_CP% org.shared.board.app.Main ecourse.ddns.net