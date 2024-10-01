import groovy.json.JsonSlurper

// Shared library function
def call(body) {
    // Evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // Set environment variables
    env.LC_ALL = "C.UTF-8"
    env.LANG = "C.UTF-8"

    // 'buildName' is passed from the pipeline and will replace 'bighorn' in the file URL
    def buildName = config.buildName ?: 'bighorn' // Default to 'bighorn' if not provided


    // Define the file URL to download the tar.gz file, where 'buildName' is the variable part
    def fileUrl = "https://download.freedict.org/dictionaries/deu-eng/1.9-fd1/freedict-deu-eng-1.9-fd1.dictd.tar.xz"

    try {
        // Download the tar.gz file using 'wget'
        sh "export PATH=$PATH:/opt/homebrew/bin/wget"
        sh "wget ${fileUrl}"

        // Extract the tar.gz file
        sh "tar -xvf freedict-deu-eng-1.9-fd1.dictd.tar.xz"

        // If extraction is successful
        echo "Created tar file properly"
    } catch (Exception e) {
        // If the extraction or download fails, trigger the Jenkins job using 'curl'
        echo "Error in creating tar file, triggering Jenkins build..."

        // Build the Jenkins URL dynamically based on 'jenkinsJobName'
        def jenkinsUrl = ""

      
      
    }

}


    
