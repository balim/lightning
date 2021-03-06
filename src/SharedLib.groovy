
def cleanupWorkspaceAndCloneRepo() {
    cleanWs()
    git credentialsId: 'github-creds', url: 'git@github.com:deliverymind/lightning.git'
}

def purge() {
    sh 'rm -rf ~/.m2/repository/uk/co/deliverymind/*lightning*/'
}

def push() {
    sshagent(['github-creds']) {
        sh 'git push --set-upstream origin master; git push --tags'
    }
}