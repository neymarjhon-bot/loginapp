pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
                echo "Código descargado desde GitHub correctamente."
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

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.war, target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo '✅ Compilación completada con éxito.'
        }
        failure {
            echo '❌ Error en la compilación.'
        }
    }
}







