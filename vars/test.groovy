def call(body) {
        
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()    
    def test = config.service_type

    def jobName = env.JOB_NAME
    def buildURL = env.BUILD_URL
    def buildId = env.BUILD_ID



    // Print the jobName
    echo "The Job Name is: ${jobName}"
    echo "The Job Name is: ${buildURL}"
    echo "The Job Name is: ${buildId}"
}
