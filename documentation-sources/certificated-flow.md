```sequence

Note over Fleet Management Software: MOT appear in FMS
Note over Vehicle Worksop Software: Maintain appointment calendar
Fleet Management Software->Vehicle Worksop Software: Get available appointments
Fleet Management Software->Vehicle Worksop Software: Send/update appointment
Note over Fleet Management Software,Vehicle Worksop Software: Scheduling appointment
Vehicle Worksop Software->Fleet Management Software: Send/update appointment
Fleet Management Software-->Vehicle Worksop Software: Vehicle for inspection
Note right of Vehicle Worksop Software: Vehicle inspection
Note over Vehicle Worksop Software: Documents generated
Vehicle Worksop Software-->Fleet Management Software: Vehicle back
Vehicle Worksop Software->Fleet Management Software: Receive report notification
Fleet Management Software->Vehicle Worksop Software: Get report (JSON format)
Fleet Management Software->Vehicle Worksop Software: Get report (binary format)
Note over Fleet Management Software: Add report to vehicle record

```
