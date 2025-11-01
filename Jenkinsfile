pipeline {
    agent any

    tools {
        jdk 'jdk21'          // Nombre del JDK configurado en Jenkins
        maven 'maven3'       // Nombre de tu instalación Maven
    }

    environment {
        ARTIFACTORY = 'jfrog-local'  // Credencial de JFrog configurada en Jenkins
        REPO = 'loginapp-repo'       // Repositorio en Artifactory
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/neymarjhon-bot/loginapp.git',
                    credentialsId: "${ARTIFACTORY}"
            }
        }

        stage('Compilar y Empaquetar') {
            steps {
                bat 'mvn clean package -DskipTests'
            }
        }

        stage('Subir JAR a JFrog') {
            steps {
                script {
                    def server = Artifactory.server("${ARTIFACTORY}")
                    def buildInfo = Artifactory.newBuildInfo()
                    def uploadSpec = """{
                        "files": [{
                            "pattern": "target/*.jar",
                            "target": "${REPO}/"
                        }]
                    }"""
                    echo "📦 Subiendo artefacto a JFrog Artifactory..."
                    server.upload(spec: uploadSpec)
                    server.publishBuildInfo(buildInfo)
                    echo "✅ JAR subido correctamente a ${REPO}"
                }
            }
        }
    }

    post {
        success {
            echo "🎉 Pipeline completado con éxito. JAR disponible en JFrog."
        }
        failure {
            echo "❌ Error durante la construcción o subida a JFrog."
        }
    }
}
