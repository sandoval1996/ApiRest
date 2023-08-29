pipeline {
    agent any

    tools {
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
                bat './gradlew.bat clean -x build'
            }
        }
        
        stage('Execute Tests') {
            steps {
                bat './gradlew.bat clean test --tests *ExecutionPruebas'
            }
        }
    }
    
    post {
        always {
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'Web Report', reportTitles: 'Serenity Report'])
            cleanWs()
        }
    }
}
