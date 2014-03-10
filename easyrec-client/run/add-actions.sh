#!/bin/bash

while read line
do
    OIFS=$IFS
    IFS=','
    read userId itemId actionName <<< "$line"
    IFS=$OIFS

    if [ "$userId" != "" ]; then
        java -jar ../target/easyrec-client-0.99-SNAPSHOT.one-jar.jar userId=$userId itemId=$itemId action=$actionName itemUrl=http://easyrec.org/recipes/$itemId description=None2 url=http://localhost:8080/easyrec-web tenant=EASYREC_DEMO login=easyrec password=easyrec apiKey=8ab9dc3ffcdac576d0f298043a60517a
    fi
done < $1
