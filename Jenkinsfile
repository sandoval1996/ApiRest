pipeline {
    agent any

     tools {
         jdk 'java-1.8'
        gradle 'Gradle-7.5.0'
    }
    
    stages {
        stage('Descargar Proyecto Git') {
          steps {
                git branch: 'master', url: 'https://github.com/sandoval1996/ApiRest.git'
            }
        }
         stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew clean build'
            }
        }
        
        stage('Execute Tests') {
            steps {
                sh './gradlew clean test --tests *ExecutionPruebas'
            }
        }
          
    }
    post {
        always{
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: ' Web Report', reportTitles: 'serenity Report'])
            cleanWs()
        }
    }
}
