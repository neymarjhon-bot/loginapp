pipeline {
    agent any

    tools {
        maven 'maven3' // debe coincidir con el nombre configurado en Jenkins → Global Tool Configuration
    }

    environment {
        // ID del servidor configurado en Jenkins → Configuración del sistema → JFrog Platform
        ARTIFACTORY_SERVER = 'jfrog-local'
        // Nombre del repositorio en JFrog
        ARTIFACTORY_REPO = 'loginapp-repo'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'jfrog-local', // o el ID de tu credencial de GitHub en Jenkins
                    url: 'https://github.com/neymarjhon-bot/loginapp.git'
            }
        }

        stage('Compilar con Maven') {
            steps {
                script {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Subir artefacto a JFrog') {
            steps {
                script {
                    // Conexión con JFrog configurado en Jenkins
                    def server = Artifactory.server(env.ARTIFACTORY_SERVER)

                    // Crear objeto con información de build
                    def buildInfo = Artifactory.newBuildInfo()
                    buildInfo.env.capture = true

                    // Definir qué subir (archivo WAR)
                    def uploadSpec = """{
                        "files": [{
                            "pattern": "target/*.war",
                            "target": "${env.ARTIFACTORY_REPO}/",
                            "props": "build.name=loginapp;build.number=${env.BUILD_NUMBER}"
                        }]
                    }"""

                    echo "📦 Subiendo artefacto a JFrog Artifactory..."
                    server.upload(spec: uploadSpec, buildInfo: buildInfo)

                    // Publicar la información del build
                    server.publishBuildInfo(buildInfo)
                    echo "✅ Artefacto subido correctamente a ${env.ARTIFACTORY_REPO}"
                }
            }
        }
    }

    post {
        success {
            echo "🎉 Pipeline completado exitosamente. WAR disponible en JFrog."
        }
        failure {
            echo "❌ Error durante la construcción o subida a JFrog."
        }
    }
}




