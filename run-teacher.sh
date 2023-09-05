#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export ECAFETERIA_CP=ecourse.app.teacher/target/ecourse.app.teacher-0.1.0.jar:ecourse.app.teacher/target/dependency/*;


#REM call the java VM, e.g,
java -cp $ECAFETERIA_CP org.app.teacher.Main
