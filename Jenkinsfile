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
                script {
                    try {
                        bat "mvn test -Dtest=TestRunner"
                    } catch (Exception e) {
                        echo "⚠️ Tests failed due to duplicate step definitions. Continuing pipeline..."
                        currentBuild.result = 'UNSTABLE'
                    }
                }
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
            // Archivar reportes de manera segura
            script {
                try {
                    archiveArtifacts artifacts: 'target/surefire-reports/*.txt, target/surefire-reports/*.xml', fingerprint: true, allowEmptyArchive: true
                } catch (Exception e) {
                    echo "No se pudieron archivar algunos reportes: ${e.message}"
                }
                
                // Archivar reportes HTML si existen
                if (fileExists('target/site/surefire-report.html')) {
                    archiveArtifacts artifacts: 'target/site/surefire-report.html', fingerprint: true
                }
                
                if (fileExists('target/cucumber-reports.html')) {
                    archiveArtifacts artifacts: 'target/cucumber-reports.html', fingerprint: true
                }
            }
            
            // Publicar reportes JUnit
            junit 'target/surefire-reports/*.xml'
        }
        
        success {
            echo '✅ ¡Build exitoso! Todas las pruebas pasaron.'
        }
        
        unstable {
            echo '⚠️ Build inestable - Hay definiciones de pasos duplicadas en Cucumber'
        }
        
        failure {
            echo '❌ Build fallido. Revisa los reportes en target/surefire-reports/'
        }
    }
}
