# Commands

For testing with integration test you would run them on a remote instance

## Run development instance in usual way, disable sync for editing confluence pages

    atlas-debug --server localhost
    curl -X POST --user admin:admin --header "X-Atlassian-Token: no-check" http://localhost:1990/confluence/rest/synchrony-interop/disable


## Run another instance for running

    atlas-run-standalone --product confluence -p 1992
    # after it is running we need to disable a service using on online confluence page editing
    curl -X POST --user admin:admin --header "X-Atlassian-Token: no-check" http://localhost:1992/confluence/rest/synchrony-interop/disable

## Run integration test remotely

    atlas-remote-test --server localhost -p 1992 --context-path confluence

## Testing REST

    GET /confluence/rest/test-rest/1.0/record HTTP/1.1
    Host: localhost:1990
    cache-control: no-cache
    Postman-Token: 03aede53-fea2-41ea-99f5-5989c7fac5c6
    
.

    POST /confluence/rest/test-rest/1.0/record HTTP/1.1
    Host: localhost:1990
    Content-Type: application/json
    cache-control: no-cache
    Postman-Token: b0f584bb-4519-42fa-bf86-4434e553c29b
    {
    	"id" : 10,
    	"value": "a value 2"
    }------WebKitFormBoundary7MA4YWxkTrZu0gW--
    