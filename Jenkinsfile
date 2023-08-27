pipeline {
    agent any


     tools {
        jdk 'java-1.8'
        gradle 'Gradle-7.5.0'
    }

    
     stage('descargar proyecto git') {
            steps {
                git branch: 'master',  url: 'https://github.com/sandoval1996/ApiRest.git'
            }
        }
        
       stage('Execute Tests') {
            steps {
                sh './gradlew clean test'
            }
        }
            post {                
                // If Gradle was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                      allowMissing: false, 
                      alwaysLinkToLastBuild: false, 
                      keepAll: false, 
                      reportDir: 'lib/target/site/serenity/', 
                      reportFiles: 'index.html', 
                      reportName: 'Serenity Report', 
                      reportTitles: '', 
                      useWrapperFileDirectly: true])
                }
            }
        }
    }
}
