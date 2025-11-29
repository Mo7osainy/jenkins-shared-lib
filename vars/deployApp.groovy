def call(Map config = [:]) {
    def imageName = config.image ?: 'mo7osainy/java-app'
    def tag       = config.tag ?: "${env.BUILD_NUMBER}"
    def port      = config.port ?: 8080

    echo "Deploying ${imageName}:${tag} on port ${port}"

    sh 'docker rm -f java-app || true'
    sh "docker run -d --name java-app -p ${port}:8080 ${imageName}:${tag}"
}

