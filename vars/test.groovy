
def call(body) {
        
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()    
        
    def jobName = env.JOB_NAME
    def buildURL = env.BUILD_URL
    def buildId = env.BUILD_ID
    def SerName = config.service_type
        
    echo "The Job Name  is: ${jobName}"
    echo "The buildURL is: ${buildURL}"
    echo "The Service Name is : ${SerName}"
    
   
    
}
