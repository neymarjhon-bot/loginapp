pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'maven3'
    }

    stages {
        stage('Checkout code') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-token',
                    url: 'https://github.com/neymarjhon-bot/loginapp.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate Reports') {
            steps {
                sh 'mvn surefire-report:report'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/surefire-reports/*.html', fingerprint: true
        }
    }
}

