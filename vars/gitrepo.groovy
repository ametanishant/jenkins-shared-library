def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    env.LC_ALL = "C.UTF-8"
    env.LANG = "C.UTF-8"
    
    // Initialize build details and configuration
  

    // Extract variables from the config and environment
    def git_repo = config.GIT_REPO_URL  
    println "${git_repo}"  
    
  

}
