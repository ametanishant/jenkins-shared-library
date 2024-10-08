// vars/myLibrary.groovy

def jobOne() {
    echo 'Executing Job One...'
    // Add your logic for Job One here
    // For example, running a shell command
    sh 'echo Hello from Job One'
}

def jobTwo() {
    echo 'Executing Job Two...'
    // Add your logic for Job Two here
    // For example, building a Docker image
    sh 'echo Building Docker Image for Job Two'
}
