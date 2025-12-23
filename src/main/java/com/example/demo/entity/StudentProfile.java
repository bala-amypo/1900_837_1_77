coder@01f0c9ee4072:~/Workspace/demo$ mvn clean install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:3.3.2:clean (default-clean) @ demo ---
[INFO] Deleting /home/coder/Workspace/demo/target
[INFO] 
[INFO] --- maven-resources-plugin:3.3.1:resources (default-resources) @ demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] 
[INFO] --- maven-compiler-plugin:3.11.0:compile (default-compile) @ demo ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 20 source files with javac [debug release 17] to target/classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/StudentProfile.java:[11,8] class StudentProfileController is public, should be declared in a file named StudentProfileController.java
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[3,31] cannot access com.example.demo.entity.StudentProfile
  bad source file: /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/StudentProfile.java
    file does not contain class com.example.demo.entity.StudentProfile
    Please remove or make sure it appears in the correct subdirectory of the sourcepath.
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[18,47] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.controller.StudentProfileController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[18,12] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.controller.StudentProfileController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[8,27] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[8,5] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[9,10] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[10,5] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[11,36] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[11,5] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/StudentProfileRepository.java:[8,65] cannot find symbol
  symbol: class StudentProfile
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[20,34] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[20,12] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[25,17] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[30,12] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[35,43] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[35,12] cannot find symbol
  symbol:   class StudentProfile
  location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/StudentProfileRepository.java:[10,14] cannot find symbol
  symbol:   class StudentProfile
  location: interface com.example.demo.repository.StudentProfileRepository
[INFO] 18 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  22.607 s
[INFO] Finished at: 2025-12-23T08:20:26Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/StudentProfile.java:[11,8] class StudentProfileController is public, should be declared in a file named StudentProfileController.java
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[3,31] cannot access com.example.demo.entity.StudentProfile
[ERROR]   bad source file: /home/coder/Workspace/demo/src/main/java/com/example/demo/entity/StudentProfile.java
[ERROR]     file does not contain class com.example.demo.entity.StudentProfile
[ERROR]     Please remove or make sure it appears in the correct subdirectory of the sourcepath.
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[18,47] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.controller.StudentProfileController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/StudentProfileController.java:[18,12] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.controller.StudentProfileController
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[8,27] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[8,5] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[9,10] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[10,5] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[11,36] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/StudentProfileService.java:[11,5] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.service.StudentProfileService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/StudentProfileRepository.java:[8,65] cannot find symbol
[ERROR]   symbol: class StudentProfile
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[20,34] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[20,12] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[25,17] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[30,12] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[35,43] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/serviceimpl/StudentProfileServiceImpl.java:[35,12] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: class com.example.demo.serviceimpl.StudentProfileServiceImpl
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/repository/StudentProfileRepository.java:[10,14] cannot find symbol
[ERROR]   symbol:   class StudentProfile
[ERROR]   location: interface com.example.demo.repository.StudentProfileRepository
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
coder@01f0c9ee4072:~/Workspace/demo$ 