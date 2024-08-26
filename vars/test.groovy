def call(body) {
        
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()    
    def serviceType = config.service_type

    def jobName = env.JOB_NAME
    def buildURL = env.BUILD_URL
    def buildId = env.BUILD_ID


    node(){
    // Print the jobName
    stage("Print Variable") 
            
    echo "The Job Name is: ${jobName}"
    echo "The buildURL is: ${buildURL}"

    stage("Print Second Variable")
        
    echo "The JbuildId is: ${buildId}"
    echo "The serviceType is: ${serviceType}"
    }
    
}
