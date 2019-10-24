#  Vehicle Testing Report Exchange Standard
Current market offer a lot of software helping to manage vehicle workshops from another side you can find a lot of software to manage fleet
and this two sites need to talk to each another in terms of scheduling services like vehicle inspection, and they need to share documents between each other.

![Standard communication](img/standard-comunication.png)

Standard communication between fleet operator and vehicle workshop \
*FMS - Fleet Management Software*

## Problems to solve
- Scheduling vehicle inspections consume a lot of time for fleet manager.
- Maintaining documentation on both sides Fleet Operator and Vehicle Workshop consume time and can be done automatically.

## Our goal for this project

 - Build secure and simple to implement communication standard to allow share information automatically between fleet operators and vehicle workshops
 - Keep implementation lean and simple
 - Be able to communicate with between any vehicle workshop software and Fleet Management software certificated by "Fleet Software Exchange Standards"

## Communication and transportation channel
All communication need to be done via **https** protocol using **JSON** secured by **JWT** token
### Communication flow



## Certificate
LOGO \
when you see this logo it means product is compatible with "Fleet Software Exchange Standards" and software can exchange information between any other software where this logo appears. [To find out certificated software please visit this page ](./certificated-software/README.md)

 ## Certification Path
 Our certification path is very easy. To be able to display our "Fleet Software Exchange Standards" logo in your product you need to meet our acceptance criteria requirements and pass all postman tests.
 Acceptance criteria and tests are divided on two groups. First group is designed for fleet management software the second group is designed for vehicle workshops software. \
 If you need any help please contact our team and we will help you with this process. <team@techowls.co.uk>


 ### Acceptance criteria
 [Acceptance criteria for Fleet Management Software](./acceptance-criteria/fms.md) \
 [Acceptance criteria for Vehicle Workshops Software](./acceptance-criteria/vws.md)

 ### Postman test
