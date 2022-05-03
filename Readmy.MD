# Course topic: HR service project #

As the name suggest, 
this service is an online system for cooperation between HR managers 
who are currently active and hunting,
and candidates who are currently looking for a job

**Functionality:**
* Project has three essential models Candidates,Vacancies, Resume
* Currently, in this project we have:
  * auto inserting DB via postgre dialect data source
  * Swagger 2 for searching through the project
  * Config that includes scheduling,logging,caching etc.(need to turn on)
  * Validation(converter,formatter,validator)
  * Endpoints for Candidate essential model.
  * Services with functionality
  * Repositories with abstract methods that we need.