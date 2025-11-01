pipeline {
    agent any

    tools {
        maven 'maven3' // Asegúrate que coincida con tu instalación en Jenkins
    }

    environment {
        // Nombre del servidor configurado en "Manage Jenkins → Configure System"
        ARTIFACTORY_SERVER = 'jfrog-local'
        // Nombre del repositorio creado en Artifactory
        TARGET_REPO = 'loginapp-repo'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
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

        stage('Upload Artifact to JFrog') {
            steps {
                script {
                    // Obtener la conexión configurada
                    def server = Artifactory.server("${ARTIFACTORY_SERVER}")

                    // Definir qué subir y a dónde
                    def uploadSpec = """{
                        "files": [{
                            "pattern": "target/*.war",
                            "target": "${TARGET_REPO}/"
                        }]
                    }"""

                    // Subir artefacto y registrar información del build
                    server.upload spec: uploadSpec
                    server.publishBuildInfo()
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build completado y artefacto subido correctamente a JFrog Artifactory.'
        }
        failure {
            echo '❌ Error durante la construcción o subida a JFrog.'
        }
    }
}






