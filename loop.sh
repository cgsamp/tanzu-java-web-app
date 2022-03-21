#!/bin/zsh
while true
do
    echo $(date)
    curl http://csamp-tanzu-java-web-app.default.apps.tap.sampsoftware.io/
    echo
    sleep 1
done