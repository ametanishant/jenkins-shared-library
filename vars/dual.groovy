def call1(body) {
    println "call1 was called with body: ${body}"
    // Add your logic here
}

def call2(body) {
    println "call2 was called with body: ${body}"
    // Add your logic here
}

def call(Closure body) {
    // Create a map to hold parameters
    def params = [:]

    // Evaluate the body closure to capture the parameters
    body.delegate = params
    body()

    // Use the parameters as needed
    if (params.service_type) {
        println "Service type is: ${params.service_type}"
    } else {
        println "No service type provided."
    }
}
