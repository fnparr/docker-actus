# actus-rshiny-demo
This is the repository where we will gather source code for a docker image which is an containerized demo of ACTUS simulationof future cashflows for a portfolio of sample contracts under a selected sample risk scenario. The dmonstration will return plots of projected profit, income and value. 

Source code for  build01 of this container application is stored in branches main and ( soon also to be saved ) in main-v0.1. This version of the application includes a full function rshiny demo application running locally on port 3838 of the container - publishable to the host docker desktop environment.  The application uses the actus server at https://demo.actusfrf.org:8080 to simulate cash flows for comntracts.  The built image is pushed to public dockerhub registry fnparr/actus-rshiny-demo:0.1 

The build00 version of the application is just the architecture of the solution: a docker container with a sample RShiny Application  generating a histogram of some randomly generated values. R code to achive the target functions above will be added in a future build   
 
Source source for the build 00 version is saved in ( protected ) branch main-v0.0 and the image is pushed to a public dockerhub repository  fnparr/actus-rshiny-demo:0.0
