def checkc() {
    // Evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    env.LC_ALL = "C.UTF-8"
    env.LANG = "C.UTF-8"

    // 'buildName' is passed from the pipeline 
    def buildName = config.buildName
    def nodeName = config.nodeName


    def branchName
    if (buildName == 'B' || buildName == 'Bu') {
        branchName = 'ari'
    } else if (['Confi', 'Craf', 'darwi', 'release'].contains(buildName)) {
        branchName = 'vee'
    }
    println ${branchName}
}
    
