```sequence
Note over Fleet Management Software: 10 vehicles maintained
Fleet Operator-->Worksop: Send data to generate access key
Worksop->Vehicle Worksop Software: Generate JWT Token
Worksop-->Fleet Operator: send JTW token by secured channel
Fleet Operator->Fleet Management Software: Save JWT Token
Note over Fleet Operator, Worksop: Cooperation
Note over Vehicle Worksop Software: Generate safety inspection record
Vehicle Worksop Software->Fleet Management Software: get available documents in time period (JWT)
Vehicle Worksop Software->Fleet Management Software: get available document by id(JWT)
Note over Fleet Management Software: Add document to vehicle record

```
