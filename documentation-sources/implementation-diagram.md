```sequence
Note over Fleet Management Software: 10 vehicles maintained
Note right of Fleet Operator: 10 VRMs, Contract period 
Fleet Operator->Worksop: Send data to generate access key
Worksop-->Vehicle Worksop Software: Generate JWT Token
Worksop->Fleet Operator: send JTW token by secured channel
Fleet Operator-->Fleet Management Software: Save JWT Token
Note over Fleet Operator, Worksop: Cooperation
Fleet Management Software-->Vehicle Worksop Software: ask for avialble documents in period (JWT)
Vehicle Worksop Software-->Fleet Management Software: sending avialble document ids(JWT)
Fleet Management Software-->Vehicle Worksop Software: get avialble document by id(JWT)
Note over Fleet Management Software: Add document to vehicle record

```
