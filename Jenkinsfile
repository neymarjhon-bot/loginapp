pipeline {
    agent any

    tools {
        jdk 'jdk21'        // Debe existir en Manage Jenkins → Global Tool Configuration
        maven 'maven3'     // Igual
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/neymarjhon-bot/loginapp.git'
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean install"
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test"
            }
        }

        stage('Generate Reports') {
            steps {
                bat "mvn surefire-report:report"
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/surefire-reports/*.html', fingerprint: true
        }
    }
}

