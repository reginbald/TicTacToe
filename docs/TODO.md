TODO
============
- [x] The code base is stored in source control system on GitHub from early start of the project (the teacher should be able to track the history of the project from the creation of the very first file).
- [x] The system is setup with automatic build that must run all unit tests.
- [x] The output is a deployable or executable artifact, such as a jar/war or equivalent.
- [x] The build script has deploy/install target that deploys the executable outside of the working directory or on external server.
- [ ] The business logic should be coded using Test Driven Development.
- [ ] The code should be loosely coupled and follow good object oriented design practices.
- [ ] Code coverages
- [ ] Code inspection
- [ ] Integrate database
- [ ] Run focused integration or End-to-end tests (e.g. Selenium). It is necessary to run this on external staging server (e.g. Heroku). To run integration test the application needs to connect to external system e.g. database. To run end-to-end test the system needs to have GUI (e.g. webUI).
- [x] Use Automated Continuous Integration Server (e.g. Travis).

#Continuous Delivery. For each code change the CI server runs these steps:
- [ ] Run build script (all targets)
- [ ] Run unit and integration tests (if you have integration tests)
- [ ] Deploy on staging and run End-to-end tests.
- [ ] Deploy to production server.
- [ ] Only continue next step if previuous step is success
- [ ] Generate feedback to developer

- [ ] Something else ... Surprise me !!! 
 
