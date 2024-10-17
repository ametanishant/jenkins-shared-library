import com.nishant.BuildConfig

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    env.LC_ALL = "C.UTF-8"
    env.LANG = "C.UTF-8"

    buildConfig.git_repostory = env.GIT_REPO_URL
    buildConfig.repo  = sh(script: "echo $GIT_REPO_URL | rev |cut -d '/' -f1,2 |cut -d '.' -f2 | rev",returnStdout: true).trim()
    println "${buildConfig.repo}"  
    
    
    // Initialize build details and configuration
  

    // Extract variables from the config and environment
    def git_repo = env.GIT_REPO_URL  
    println "${git_repo}"  
    
  

}
