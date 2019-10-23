```sequence
Note left of Fleet operator: MOT appear in FMS
Fleet operator-->Vehicle Workshop: Hi I need to book MOT...
Note right of Vehicle Workshop: scheduling appointment
Vehicle Workshop-->Fleet operator: Yes we can do it ...

Fleet operator->Vehicle Workshop: Send vehicle
Note right of Vehicle Workshop: Doing vehicle inspection
Vehicle Workshop->Fleet operator: Vehicle back 
Vehicle Workshop-->Fleet operator: Documents sent 
Note left of Fleet operator: Update vehcie record in FMS


```