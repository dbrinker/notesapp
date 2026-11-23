# Note Sharing REST Service

This contains a rough model of a REST service for processing requests for Notes.  Due to not having AI set up for the problem, I was unable to complete the full service in the time available.

Missing features include:
* Unit and integration test drivers
* User ID processing via request header retrieval
* General validation of the service (transactions and persistence being the biggest question mark)
* Database schema scripts.  The original intention was to use Flyway to run these at startup

Decisions made include:
* Storing data in a JPA database (H2 by default).  With a little more time, I would have likely switched to MongoDB, as the records are largely annotated documents.
* Tracking users, and doing so via HTTP headers.  While the instructions didn't say to explicitly track users, a notetaking system that was truly anonymous seemed a bit lacking

Given more time, I would likely be implementing:
* A separate user service to be able to match IDs to user names (as the latter would be far more usable)
* Security.  In particular, 
** Leveraging Spring Security along with the user service described above would lock down access to known users
** Adding access controls would restrict modifications to the creating user
** Adding an admin user would allow someone beyond the creating user to manage the records
** Changing the IDs from integers to UUIDs, to reduce the predictability of the resources