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
        stage ('ejecutar pruebas') {
            steps {
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    sh 'gradle clean clearReports test --tests  *ExecutionPruebas -i'
                }
            }
        }
          
    }
    post {
        always{
            zip zipFile: 'reporte.zip', archive: false, dir: 'target/site/serenity'
            archiveArtifacts artifacts: 'reporte.zip', fingerprint: true
            publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/site/serenity', reportFiles: 'index.html', reportName: 'Web Report', reportTitles: 'Report'])
            
        }
    }
}
