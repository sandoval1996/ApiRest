pipeline {
    agent any


    
     stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew clean build -x test'
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
