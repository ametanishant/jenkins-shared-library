import groovy.json.JsonSlurper

// Shared library function
def call(body) {
    // Evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // Ensure execution within a node
    node {
        // Set environment variables
        env.LC_ALL = "C.UTF-8"
        env.LANG = "C.UTF-8"

        // 'buildName' is passed from the pipeline and will replace 'bighorn' in the file URL
        def buildName = config.buildName 

        // Define the file URL to download the tar.xz file, where 'buildName' is the variable part
        def fileUrl = "https://download.freedict.org/dictionaries/deu-eng/1.9-fd1/freedict-deu-eng-1.9-fd1.dictd.tar.xz"
        def outputFile = "freedict-deu-eng-1.9-fd1.dictd.tar.xz"

        try {
            echo "Entering Try Loop....."
            // Download the tar.xz file using 'wget'
            sh "export PATH=/opt/homebrew/bin:\$PATH && wget -O ${outputFile} ${fileUrl}"

            // Extract the tar.xz file
            sh "tar -xvf ${outputFile}"

            // If extraction is successful
            echo "Created tar file properly"
        } catch (Exception e) {
            // If the extraction or download fails, trigger the Jenkins job using 'curl'
            echo "Error in creating tar file, triggering Jenkins build..."

            // Build the Jenkins URL dynamically based on 'jenkinsJobName'
            def jenkinsJobName = config.jenkinsJobName ?: 'DefaultJob'
            def jenkinsUrl = "http://localhost:8080/job/${jenkinsJobName}/build"

            // Trigger the Jenkins build using 'curl'
            sh "curl -X POST ${jenkinsUrl}"
        }
    }
}
