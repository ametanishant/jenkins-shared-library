package com.nishant

import java.text.SimpleDateFormat

def getBuildConfig() {
    BuildConfig buildConfig = new BuildConfig()
    buildConfig.branch = "main"
    return buildConfig
}
