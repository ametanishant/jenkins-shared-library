def call(body) {
        
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    env.LC_ALL = "C.UTF-8"
    env.LANG = "C.UTF-8"

}
