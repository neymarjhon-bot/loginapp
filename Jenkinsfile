pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'maven3'
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
                bat "mvn clean compile"
            }
        }

        stage('Run Tests') {
            steps {
                bat """
                    mvn test -Dtest=TestRunner
                """
            }
        }

        stage('Generate Reports') {
            steps {
                bat """
                    mvn surefire-report:report
                    echo "Reportes generados en target/site/surefire-report.html"
                """
            }
        }
    }

    post {
        always {
            // Archivar reportes de pruebas
            archiveArtifacts artifacts: '**/target/surefire-reports/*.html, **/target/site/*.html', fingerprint: true
            
            // Archivar también los reportes de Cucumber si se generan
            archiveArtifacts artifacts: '**/target/*.html', fingerprint: true
        }
        
        success {
            echo '✅ ¡Build exitoso! Todas las pruebas pasaron.'
        }
        
        failure {
            echo '❌ Build fallido. Revisa los reportes en target/surefire-reports/'
        }
    }
}

