def checkc(Closure body) {
    // Evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()  // Call the closure to populate config

    env.LC_ALL = "C.UTF-8"
    env.LANG = "C.UTF-8"

    // 'buildName' is passed from the pipeline 
    dev buildUrl = env.BUILD_URL
    println "${buildUrl}" 
    def buildName = config.buildName ?: ''  // Default to empty string if not set
    echo "buildName: ${buildName}"
    def nodeName = config.nodeName ?: ''    // Default to empty string if not set

    def branchName
    if (buildName == 'B' || buildName == 'Bu') {
        branchName = 'ari'
    } else if (['Confi', 'Craf', 'darwi', 'release'].contains(buildName)) {
        branchName = 'vee'
    }
    println "${branchName}"  // Use double quotes to evaluate the variable
}
