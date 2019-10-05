# DefectDojo Java Client Library
This repository uses OWASP SecureCodeBox library for API calls against OWASP DefectDojo. It is especially useful for Jenkins builds in the Jenkinsfile.



# Jenkins integration
Call
```
                script {
                  def gitHubRepo = (env.GIT_URL =~ /\/([^\/]*\/[^\/]*)\.git$/)[0][1]

                  sh """
                    # TODO: Better use API Key
                    export DD_BRANCHES_TO_KEEP="\$(curl https://${USERNAME}:${PASSWORD}@api.github.com/repos/${gitHubRepo}/branches | jq '.[].name' | tr '\n' ' ')"
                    if [ "\$DD_BRANCHES_TO_KEEP" == "" ]; then
                      echo "Could not get branches to keep, exit"
                      exit 1;
                    fi
                    CURRENT_PATH=\$(pwd)
                    export DD_REPORT_PATH="\$CURRENT_PATH/report/dependency-check-report.xml"
                    cd /code
                    /usr/groovy/groovy-2.5.8/bin/groovy /code/defectdojo.groovy
                  """
                }

```

# Development

* `defectdojo.groovy` simulates Jenkins, all parameters (e.g. token) needs to be adjusted here
* Build libs in SecureCodeBox engine folder
`/copyLibs.bash && groovy defectdojo.groovy`


# Credits
This project is based on https://github.com/secureCodeBox/engine

# Sponsors for the DefectDojo Java Client
[![Timo-Pagel](https://raw.githubusercontent.com/DefectDojo/Documentation/master/doc/img/timo-pagel-logo.png )](https://pagel.pro/)
[![SDA-SE](https://raw.githubusercontent.com/DefectDojo/Documentation/master/doc/img/sda-se-logo.png)](https://sda-se.com/)
