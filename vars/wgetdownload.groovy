pipeline {
    agent any

    stages {
        stage('Check PATH') {
            steps {
                script {
                    // Print the PATH environment variable
                    sh 'echo $PATH'
                }
            }
        }

        stage('Download Dictionary File') {
            steps {
                script {
                    def url = 'https://download.freedict.org/dictionaries/deu-eng/1.9-fd1/freedict-deu-eng-1.9-fd1.dictd.tar.xz'
                    def outputFile = 'freedict-deu-eng-1.9-fd1.dictd.tar.xz'
                    sh "export PATH=/opt/homebrew/bin:$PATH && wget -O ${outputFile} ${url}"

                    // Download the file using wget
                    sh "wget -O ${outputFile} ${url}"
                }
            }
        }

        stage('Extract File') {
            steps {
                script {
                    // Extract the downloaded tar.xz file
                    sh "tar -xf freedict-deu-eng-1.9-fd1.dictd.tar.xz"
                }
            }
        }
    }
    
    post {
        success {
            echo 'Download and extraction completed successfully!'
        }
        failure {
            echo 'There was an error during the download or extraction.'
        }
    }
}
