# Commands

Following commands were used to build add-on templates

    atlas-create-jira-plugin -g com.milkneko.dev -a jira_1_custom_field -v 1.0.0-SNAPSHOT -p com.milkneko.dev.jira_1_custom_field --non-interactive

    atlas-create-jira-plugin -g com.milkneko.dev -a jira_2_custom_searcher -v 1.0.0-SNAPSHOT -p com.milkneko.dev.jira_2_custom_searcher --non-interactive

    atlas-create-jira-plugin -g com.milkneko.dev -a jira_3_rest_service -v 1.0.0-SNAPSHOT -p com.milkneko.dev.jira_3_rest_service --non-interactive

    atlas-create-jira-plugin -g com.milkneko.dev -a jira_4_servlet -v 1.0.0-SNAPSHOT -p com.milkneko.dev.jira_4_servlet --non-interactive



If you are using IntelliJ, you need to change Maven installation directory on project settings, and after maven depencies import finish you will need to restart IntelliJ

## Run development instance in usual way

    atlas-debug --server localhost

## Run integration tests locally

    atlas-integration-test


## Run another instance for running

We are going to change default http and ajp default ports

    atlas-run-standalone --product jira --server localhost -p 2992 -ajp 8011
    
    # If you require to run in debug mode; It will start it listening debug port 5002 
    atlas-run-standalone --product jira --server localhost -p 2992 -ajp 8011 --jvmargs "-DdisableJiraEmail=false -Xdebug -Xrunjdwp:transport=dt_socket,address=5002,server=y,suspend=n"

    # If you require a specific version (ex 7.13.6)
    atlas-run-standalone --product jira --version 7.13.6 --server localhost -p 2992 -ajp 8011 --jvmargs "-DdisableJiraEmail=false -Xdebug -Xrunjdwp:transport=dt_socket,address=5002,server=y,suspend=n"
  

## Run integration tests remotely

    atlas-remote-test --server localhost -p 2992 --context-path jira



