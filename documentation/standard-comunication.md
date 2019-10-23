```sequence
Note left of Fleet operator: Information about vehicle inspection appear in fleet management software  
Fleet operator-->Vehicle Workshop: Hi I need to book an appointment for vehicle inspection (MOT)... 
Note right of Vehicle Workshop: scheduling appointment
Vehicle Workshop-->Fleet operator: Yes we can do it ...

Fleet operator->Vehicle Workshop: Send vehicle
Note right of Vehicle Workshop: Doing vehicle inspection
Vehicle Workshop->Fleet operator: Vehicle back 
Vehicle Workshop-->Fleet operator: Send inspection documents 
Note left of Fleet operator: Update fleet management record


```