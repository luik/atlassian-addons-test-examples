# Commands

## Add servlet module

    atlas-create-jira-plugin-module 

    >> IssueCRUD
    >> com.example.plugins.tutorial.servlet
    >> N


For testing with integration test you would run them on a remote instance

## Run development instance in usual way, disable sync for editing confluence pages

    atlas-debug --server localhost
    #
    curl -X POST --user admin:admin --header "X-Atlassian-Token: no-check" http://localhost:1990/confluence/rest/synchrony-interop/disable


## Run another instance for running

    atlas-run-standalone --product confluence -p 1992
    # after it is running we need to disable a service used on online confluence page editing
    curl -X POST --user admin:admin --header "X-Atlassian-Token: no-check" http://localhost:1992/confluence/rest/synchrony-interop/disable

## Run integration test remotely

    atlas-remote-test --server localhost -p 1992 --context-path confluence

