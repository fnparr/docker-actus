# actus-rshiny-demo
This repository contains source code needed to build docker images for components of an ACTUS demonstration.  

## Container images currently provided  
  *  actus-rshiny-demo:  – R language rshiny app with a demo doing contact and portfolio simulations with a selected interest rate risk factor
  *  actus-server :  a java,mvn,gradle  server component with an actus-webapp Version 1.1 server which uses the actus-core librar

## The actus-rshiny-demo can be configured to operate :
  * EITHER  with  the Version 1.0 actus-webapp  public server at <https://demo.actusfrf.org:8080>
  * OR with any other accessible actus-webapp server 
  * OR as a standalone workstation demo using a (Version 1.1 ) actus-webapp container server

The dockerfiles and source code for each  docker image build are stored in this docker-actus repository. The source code for actus-rshiny-demo and actus-server images are in separate subdirectories. 

## Organization of the repository
  * Subdirectories with source dockerfiles and code  for the two docker images  
  * Source code in docker-actus/actus-server/app/actus-core/src  is removed 
    * To build the server container – one must be authorized with access to this source code by ACTUS Financial Research Foundation 
    * Obtain the code from <https://github.com/actusfrf/actus-core> 
    * copy the contents of <https://github.com/actusfrf/actus-core/src> into a local clone of repo docker-actus/actus-server/app/actus-core/src before building the docker container 
    * This ensures that dockerfiles and non actus-core source are all in open public containers but that the actus-core source code can only be copied in by actusfrf approved parties 
  * Already built docker images for actus-rshiny-demo  and actus-server can be downloaded from the public dockerhub registries at
    * dockerhub.io/fnparr/actus-rshiny-demo
    * dockerhub.io/fnparr/actus-server
    
## Documentation:
  * Explanation of the steps to build and use  actus-webapp V1.0 is available in the README file in <https://github.com/actusfrf/actus-webapp>
  * Guidance on using and building Actus-webapp V1.1 ( the containerized server ) is  available in <https://github.com/actusfrf/ACTUS-Userguides>
  * The rshiny app in actus-rshiny-demo is largely self documenting – point any browser at the exported port of the actus-rshiny-app container

