#!/bin/zsh
while true
do
    echo $(date)
    curl http://tanzu-java-web-app.developer.tap.gcp.csamp-tanzu.com/
    echo
    sleep 1
done