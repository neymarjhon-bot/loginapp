pipeline {
    agent any

    tools {
        maven 'Maven '
    }

    stages {
        stage('Checkout') {
            steps {3.6.3'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    if (isUnix()) {
                        sh 'mvn clean package -DskipTests'
                    } else {
                        bat 'mvn clean package -DskipTests'
                    }
                }
            }
        }

        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'target/*.war, target/*.jar', fingerprint: true
            }
        }
    }
}






